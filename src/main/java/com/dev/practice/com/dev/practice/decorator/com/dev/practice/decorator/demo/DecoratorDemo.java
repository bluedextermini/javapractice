package com.dev.practice.com.dev.practice.decorator.com.dev.practice.decorator.demo;

public class DecoratorDemo {

    public static void main(String[] args) {
        INotifier notifier = new Notifier();
        FacebookNotifier facebookNotifier = new FacebookNotifier(notifier);
        TwitterNotifier twitterNotifier = new TwitterNotifier(facebookNotifier);
          twitterNotifier.sendMessage("my message");


    }
}
interface INotifier {
    void sendMessage(String msg);
}

class Notifier implements INotifier{

    public void sendMessage(String msg) {
        System.out.println("Component: message: " + msg);
    }
}

class BaseNotifierDecorator implements INotifier{
  INotifier notifier;
  public BaseNotifierDecorator(INotifier inotifier) {
        this.notifier = inotifier;
    }

    public void sendMessage(String msg) {
        notifier.sendMessage(msg);
    }
}

class FacebookNotifier extends BaseNotifierDecorator {

    public FacebookNotifier(INotifier notifier) {
      super(notifier);
    }

    @Override
    public void sendMessage(String msg) {
        super.sendMessage(msg);
        System.out.println("Facebook: message: " + msg);
    }
}

class TwitterNotifier extends BaseNotifierDecorator {

    public TwitterNotifier(INotifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String msg) {
        super.sendMessage(msg);
        System.out.println("Twitter: message: " + msg);
    }
}

class SmsNotifier extends BaseNotifierDecorator {
    public SmsNotifier(INotifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String msg) {
        super.sendMessage(msg);
        System.out.println("SMS: message: " + msg);
    }
}




