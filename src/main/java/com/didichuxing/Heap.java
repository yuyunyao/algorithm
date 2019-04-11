package com.didichuxing;

/**
 * 堆
 */
public class Heap {
  private int[] heap;
  private int insertPointer = 0;//已插入元素的指针，0空出来，insertIndex>=capacity 堆满
  private int capacity;//堆的容量

  public Heap(int capacity) {
    this.capacity = capacity;
    this.heap = new int[capacity+1];
    this.insertPointer = 1;
//    fillMaxHeap();
  }

  private  void insertHeap(int param) {
    if (this.insertPointer >= this.heap.length) {
      return;
    }
    int localInsertPointer = this.insertPointer++;
    heap[localInsertPointer] = param;
    while (heap[localInsertPointer]>heap[localInsertPointer/2] && localInsertPointer/2>0) {
      //swap
      swap(localInsertPointer/2, localInsertPointer);
      localInsertPointer = localInsertPointer / 2;
    }
  }

  private boolean validHeapIndex(int index) {
    return index < this.heap.length && heap[index]>0;

  }
  /**
   * 删除堆顶元素
   */
  private void deleteHeapTopElement() {
    if (insertPointer<=1) {//空堆
      return;
    }
    int heapTopPointer = 1;
    this.heap[heapTopPointer] = heap[this.insertPointer - 1];//最后一个元素移到堆顶
    this.insertPointer--;
//    heap[heapLastElementPointer] = 0; insert指针已经偏移，不用再置0
    //swap  util heap  top is  the max
    heapify(heapTopPointer,this.insertPointer-1);
  }

  /**
   * 大顶堆，从小到大排序
   * 堆顶元素移动到末尾
   */
  private void  ascSort() {
    int k = this.insertPointer - 1;
    while (k > 1) {
      swap(1,k);
      k--;
      heapify(1,k);
    }
  }

  /**
   * 自上而下堆化
   * @param heapTopPointer  堆顶指针
   * @param lastEleIndex 堆中最后一个元素指针
   */
  private void heapify(int heapTopPointer,int  lastEleIndex) {
    while (true) {
      int maxTopPointer = heapTopPointer;//当前最大元素指针指向堆顶
      //堆顶节点和左右子节点对比，确认最大节点指针
      if (2*heapTopPointer<=lastEleIndex && this.heap[maxTopPointer]<this.heap[2*heapTopPointer]) {
        maxTopPointer = 2 * heapTopPointer;//最大元素指针指向左子节点
      }
      if (2*heapTopPointer+1<=lastEleIndex && this.heap[maxTopPointer]<this.heap[2*heapTopPointer+1]) {
        maxTopPointer = 2 * heapTopPointer + 1;
      }
      if (maxTopPointer == heapTopPointer) {//当前就是最大
        break;
      }
      swap(heapTopPointer, maxTopPointer);
      heapTopPointer = maxTopPointer;
    }
  }

  private void swap(int i, int j) {
    int tmp = this.heap[i];
    this.heap[i] = this.heap[j];
    this.heap[j] = tmp;
  }

  private void fillMaxHeap() {
    this.heap[1] = 33;
    this.heap[2] = 27;
    this.heap[3] = 21;
    this.heap[4] = 16;
    this.heap[5] = 13;
    this.heap[6] = 15;
    this.heap[7] = 9;
    this.heap[8] = 5;
    this.heap[9] = 6;
    this.heap[10] = 7;
    this.heap[11] = 8;
    this.heap[12] = 1;
    this.heap[13] = 2;
  }

  private void expansion(){
      int[] newArray = new int[heap.length*2];
      System.arraycopy(this.heap,0,newArray,0,heap.length);
      this.heap = newArray;
  }

  public static void main(String[] args) {
    Heap heap = new Heap(4);
    heap.insertHeap(22);
    heap.insertHeap(23);
    heap.insertHeap(24);
    heap.insertHeap(25);
    heap.insertHeap(26);
    heap.deleteHeapTopElement();
    heap.ascSort();
    System.out.println(heap.heap);
    String str = "中华人民共和国";
    System.out.println(str.getBytes().length);
  }

}
