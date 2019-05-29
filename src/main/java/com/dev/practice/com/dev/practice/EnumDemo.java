package com.dev.practice.com.dev.practice;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;

enum VirtualAccountStatusEnum {

    ACTIVE("A"),
    BEING_CLOSED("BC"),
    CLOSED("C"),
    DELETED("D"),
    PREPARATORY("PR"),
    BLOCKED("B"),
    BLOCKED_FOR_BOTH("BB"),
    BLOCKED_FOR_CREDIT("CB"),
    BLOCKED_WITHDRAW("BW"),
    BLOCKED_DEPOSIT("BD"),
    BLOCKED_FOR_DEBIT("DB");


    String value;

    VirtualAccountStatusEnum(String status) {
        this.value = status;
    }

    public String getValue() {
        return value;
    }


    @Override
    public String toString() {
        return this.getValue();
    }
    private static  Map<String, VirtualAccountStatusEnum> strValueMap= new HashMap<String, VirtualAccountStatusEnum>();


    static {
          final Map<String, VirtualAccountStatusEnum> valueMap= new HashMap<String, VirtualAccountStatusEnum>();
          for (VirtualAccountStatusEnum e : VirtualAccountStatusEnum.values()) {
              valueMap.put(e.getValue(), e);
        }
        strValueMap = new HashMap(valueMap);
    }

    public VirtualAccountStatusEnum getEnum(String str){
        return strValueMap.get(str);
    }

    public static List<VirtualAccountStatusEnum> getEnumList(List<String> strList){
        List<VirtualAccountStatusEnum> list= new ArrayList<VirtualAccountStatusEnum>();
        for(String str: strList){
            if(strValueMap.get(str)!=null){
                list.add(strValueMap.get(str));
            }
        }
        return list;
    }

}

/*
enum CREDIT_DEBIT_INDICATOR{

    DEBIT("DBIT"), CREDIT("CRDT");
    CREDIT_DEBIT_INDICATOR


}
*/

public class EnumDemo {
    public static void main(String[] args) {

        /*for (VirtualAccountStatusEnum e : VirtualAccountStatusEnum.values()) {
            System.out.println(e);
        }

        System.out.println
                (VirtualAccountStatusEnum.ACTIVE.getStatusCode() == VirtualAccountStatusEnum.valueOf("A"));*/
        System.out.println();

        List<VirtualAccountStatusEnum> list=VirtualAccountStatusEnum.getEnumList(Arrays.asList("A", "BC", "BD", "D", "test"));

        System.out.print(list.contains(VirtualAccountStatusEnum.ACTIVE));
        System.out.println(Math.pow(10, 2));



    }
}
