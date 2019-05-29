package com.dev.practice.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {

    final static public int MAX_POOL_SIZE = 10;
    private static BlockingQueue<Connection> conPoolQueue = new LinkedBlockingQueue<>();
    DriverManager dm;
    static{

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void createConnectionPool(String url, String user, String password) {
        for (int i = 0; i < 10; i++) {
            try {
                conPoolQueue.offer(createConnection(url, user, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws InterruptedException {
        return conPoolQueue.poll(50, TimeUnit.SECONDS);

    }

    public static boolean releaseConnection(Connection con) throws InterruptedException {
       return conPoolQueue.offer(con,50, TimeUnit.SECONDS );
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {

        ConnectionPool con= new ConnectionPool();
        con.createConnectionPool("test", "sdfdf", "password");
        List<Connection> connectionList = new ArrayList<>();

        Runnable taskGetConnection=new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 11; i++) {
                    try {
                        System.out.println("Getting Connection: "+ i);
                        connectionList.add(con.getConnection());
                        System.out.println("Got Connection: "+i);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        };

        Thread t = new Thread(taskGetConnection);
        t.start();

    }

}


