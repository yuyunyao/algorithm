package com.didichuxing;

/**
 * 循环队列对象, 特性滞留一个元素空间， 用于标识队列full check
 */
public class CircularQueue {
  private int head;//代表下一次要读取的index
  private int tail;//代表下一次要存储的index
  private int n;
  private int[] circularQueue;

  public CircularQueue(int n) {
    this.n = n;
    circularQueue = new int[n];
    head = 0;
    tail = 0;
  }

  private int indexCalculate(int index) {
//    index += 1;
//    if (index >= n) {
//      index = index - n;
//    }
    //% n 结果肯定比n小，
    return (index + 1)% n;
  }

  private boolean push(int param) {
    //full check
    if ((tail + 1) % n == head) {
      return false;
    }
    circularQueue[tail] = param;
    tail = (tail + 1)% n;
    return true;
  }

  /**
   * 弹出元素
   *
   * @return
   */
  private int pop() {
    if (head == tail) {
      //empty
      throw new RuntimeException("circular queue empty");
    }
    int i = circularQueue[head];
    head = (head + 1)% n;
    return i;
  }

  public static void main(String[] args) {
    CircularQueue circularQueue = new CircularQueue(10);
    circularQueue.push(1);
    circularQueue.push(2);
    circularQueue.push(3);
    circularQueue.push(4);
    circularQueue.push(5);
    circularQueue.push(6);
    circularQueue.push(7);
    circularQueue.push(8);
    circularQueue.push(9);
    circularQueue.push(10);
    circularQueue.push(11);
    circularQueue.push(12);
    circularQueue.push(13);
    circularQueue.push(14);
    circularQueue.push(15);
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
    System.out.println(circularQueue.pop());
  }

}
