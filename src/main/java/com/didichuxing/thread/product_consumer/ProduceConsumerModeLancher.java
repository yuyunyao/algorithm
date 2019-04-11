package com.didichuxing.thread.product_consumer;

public class ProduceConsumerModeLancher {
  public static void main(String[] args) {
    AbstractModule module = new ProduceConsumerBuffer();
    ProduceThread produce1 = new ProduceThread("produce1", module);
    ProduceThread produce2 = new ProduceThread("produce2", module);
    ProduceThread produce3 = new ProduceThread("produce3", module);
    ProduceThread produce4 = new ProduceThread("produce4", module);
    ProduceThread produce5 = new ProduceThread("produce5", module);
    produce1.setNum(10);
    produce2.setNum(11);
    produce3.setNum(50);
    produce4.setNum(60);
    produce5.setNum(33);

    produce1.start();
    produce2.start();
    produce3.start();
    produce4.start();
    produce5.start();

    ConsumerThread consumer1 = new ConsumerThread("consumer1", module);
    ConsumerThread consumer2 = new ConsumerThread("consumer2", module);
    ConsumerThread consumer3 = new ConsumerThread("consumer3", module);
    consumer1.setNum(80);
    consumer2.setNum(44);
    consumer3.setNum(66);

    consumer1.start();
    consumer2.start();
    consumer3.start();
  }
}
