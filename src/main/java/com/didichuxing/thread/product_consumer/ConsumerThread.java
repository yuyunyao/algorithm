package com.didichuxing.thread.product_consumer;

public class ConsumerThread extends Thread {
  private AbstractModule abstractModule;
  private int num;

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public ConsumerThread(String name, AbstractModule abstractModule) {
    super(name);
    this.abstractModule = abstractModule;
  }
  private void consumer() {
    abstractModule.consumer(num);
  }

  @Override
  public void run() {
    super.run();
    consumer();
  }
}
