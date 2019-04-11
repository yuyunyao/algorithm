package com.didichuxing;

public class ArrayQueue {
  private int n;//数组长度
  private int[] intArray = null;
  private int head = 0;//存储下一次要读取的元素index
  private int tail = 0;//存储下一次要插入的元素index

  public ArrayQueue(int n) {
    this.n = n;
    this.intArray = new int[n];
  }

  public boolean push(int param) {
    if (tail==n) {//full
      if (head==0) {//还没读取，已经full
        return false;
      }
      //复制数据到之前空闲部分
      for (int i = head;i<tail;i++) {
        intArray[i - head] = intArray[i];
      }
      tail = tail - head;
      head = 0;
    }
    intArray[tail] = param;
    tail++;
    return true;
  }


  public int  poll() {
    if (head==tail) {
      return -1;
    }
    int result = intArray[head];
    head++;
    return result;
  }

  public static void main(String[] args) {
    ArrayQueue arrayQueue = new ArrayQueue(10);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    arrayQueue.push(1);
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    arrayQueue.push(1);
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    arrayQueue.push(1);
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    arrayQueue.push(1);
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());
    System.out.println(arrayQueue.poll());

  }


}


