package com.didichuxing.thread.product_consumer;

/**
 * 手撕生产者消费者接口
 */
public interface AbstractModule {
  /**
   * 往容器塞num个元素
   * @param num
   */
  void produce(int num);

  /**
   * 从容器消费num个元素
   * @param num
   */
  void consumer(int num);
}
