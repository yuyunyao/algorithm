package com.didichuxing.thread.product_consumer;

import java.util.LinkedList;
import java.util.List;

public class ProduceConsumerBuffer implements AbstractModule {
  private int MAX_LENGTH = 100;
  private LinkedList list = new LinkedList<>();
  @Override
  public void produce(int num) {
    synchronized (list) {
      while (list.size()+num>MAX_LENGTH) {
        //仓满了wait
        System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:"+ list.size() + "\t暂时不能执行生产任务!");
        try {
          list.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"被唤醒了");
      }
      for (int i = 0; i < num; i++) {
        list.add(new Object());
      }
      System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
      list.notifyAll();
    }

  }

  @Override
  public void consumer(int num) {
    synchronized (list) {
      while (list.size()<num) {
        //仓不够要消费的元素
        System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"+ list.size() + "\t暂时不能执行消费任务!");
        try {
          list.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"被唤醒了");
      }
      for (int i = 0; i < num; i++) {
        System.out.println(Thread.currentThread().getName()+"消费了"+list.pop());
      }
      System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
      list.notifyAll();
    }
  }
}
