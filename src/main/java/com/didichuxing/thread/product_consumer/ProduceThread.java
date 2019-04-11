package com.didichuxing.thread.product_consumer;

public class ProduceThread extends Thread {
  private AbstractModule abstractModule;
  private int num;

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public ProduceThread(String name, AbstractModule abstractModule) {
    super(name);
    this.abstractModule = abstractModule;
  }
  private void produce() {
    abstractModule.produce(num);
  }

  @Override
  public void run() {
    super.run();
    produce();
  }
}
