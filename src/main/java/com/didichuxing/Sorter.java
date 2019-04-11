package com.didichuxing;

/**
 * 各种排序算法实现
 */
public class Sorter {
  /**
   * 逆序度计算使用到了分治思想， 原始计算需要O（n`2）的时间复杂度
   * 分治：把一个大字符串分割成2半，则总逆序度= pair1逆序度+ pair2逆序度 + （pair1+pair2合并的逆序度）
   * 分治思想一个大问题折半拆成若干小问题
   *
   */
  private int reverseDegree;

  public Sorter() {
  }

  /**
   * 冒泡排序的精髓，元素22左右比较，最大元素会右移动，一轮结束后最右边的就是最大值
   * 所谓冒泡就是最大值飘到最右边， 每次比较完只需要比较剩余的n-1
   * 最大比较次数就是最差时间复杂度即严格的从大到小排列则每个元素都需要移动到最右边，一共需要比较n次
   *
   * @param intArray
   */
  private void bubblingSort(int[] intArray, int n) {
    if (n <= 0) {
      return;
    }
    for (int i = 0; i < n; i++) {
      boolean isswap = false;
      for (int j = 0; j < n - i - 1; j++) {
        int jVal = intArray[j];
        int jnextVal = intArray[j + 1];
        if (jnextVal < jVal) {
          isswap = true;
          intArray[j] = jnextVal;
          intArray[j + 1] = jVal;
        }
      }
      if (!isswap) {
        break;
      }
    }
  }


  /**
   * 插入排序
   *
   * @param intArray
   * @param n
   */
  private void insertSort(int[] intArray, int n) {
    if (n <= 1) {
      return;
    }
    for (int i = 1; i < n; i++) {
      int j = i - 1;
      int ival = intArray[i];
      for (; j >= 0; j--) {
        if (ival < intArray[j]) {
          intArray[j + 1] = intArray[j];//大的元素后移
        } else {
          break;//不满足移动条件，j 代表空元素之前的位置   j+1 代表要插入元素的位置
        }
      }
      intArray[j + 1] = ival;//元素插入合适的位置
    }
  }


  /**
   * 选择排序
   * 每次右半区间选择一个最小值和左边节点交换
   * 时间复杂度永远是o(n`2)
   *
   * @param intArray
   * @param n
   */
  private void selectSort(int[] intArray, int n) {
    if (n <= 0) {
      return;
    }
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (intArray[j] < intArray[minIndex]) {
          minIndex = j;
        }
      }
      int ival = intArray[i];
      intArray[i] = intArray[minIndex];
      intArray[minIndex] = ival;
    }
  }

  /**
   * 快速排序
   * 不是稳定排序算法，元素相当顺序会变化
   *
   * @param arrayInt
   * @param n
   */
  private void quickSort(int[] arrayInt, int n) {
    quickSortC(arrayInt, 0, n - 1);
  }

  /**
   * 快排 自上而下， 先pivot再处理子排序
   *
   * @param arrayInt
   * @param head
   * @param tail
   */
  private void quickSortC(int[] arrayInt, int head, int tail) {
    if (head >= tail) {
      return;
    }
    //分区得到中心点
    int pivot = partition(arrayInt, head, tail, true);
    quickSortC(arrayInt, head, pivot - 1);
    quickSortC(arrayInt, pivot + 1, tail);
  }

  /**
   * 分区,数组移动时间复杂度大， 优先使用swap策略变更为O（1）时间复杂度
   *
   * @param arrayInt
   * @param head
   * @param tail
   * @param asc      true 升序 左边小，右边大  ；false降序， 左边大，右边小
   */
  private int partition(int[] arrayInt, int head, int tail, boolean asc) {
    int pivotVal = arrayInt[tail];
    int leftIndex = head;//要插入swap的指针
    for (int i = head; i < tail; i++) {// i 代表迭代指针
      if (asc) {
        // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
        if (arrayInt[i] <= pivotVal) {
          swap(arrayInt, leftIndex, i);
          leftIndex++;
        }
      } else {
        if (arrayInt[i] >= pivotVal) {
          swap(arrayInt, leftIndex, i);
          leftIndex++;
        }
      }
    }
    //swap pivot and left index
    swap(arrayInt, leftIndex, tail);
    return leftIndex;
  }

  /**
   * @param arrayInt
   * @param leftIndex 下一次要插入的指针
   * @param i         遍历的指针
   * @return
   */
  private void swap(int[] arrayInt, int leftIndex, int i) {
    if (i == leftIndex) {
      return;
    } else {
      int tmp = arrayInt[leftIndex];
      arrayInt[leftIndex] = arrayInt[i];
      arrayInt[i] = tmp;
    }
  }

  /**
   * 查找第K大的元素，时间复杂度要O（n）
   * 原理选择pivot从大到小排序，如果pivot + 1 ==K 则 pivot就是，否则
   * K > pivot+1 , 在右半部分继续查找； K < pivot+1 在左半部分继续查找
   * 时间复杂度=n + n/2 + ... + 1 = O(n)
   *
   * @param arrayInt
   * @param k
   * @return
   */
  private int findK(int[] arrayInt, int k, int n) {
    if (k > n) {
      return -1;
    }
    int partition = partition(arrayInt, 0, n - 1, false);
    while (partition + 1 != k) {
      if (partition + 1 < k) {
        partition = partition(arrayInt, partition + 1, n - 1, false);
      } else {
        partition = partition(arrayInt, 0, partition - 1, false);
      }
    }
    return arrayInt[partition];
  }


  /**
   * 归并排序
   * 稳定非本地排序算法
   *
   * @param arrayInt
   * @param n
   */
  private void mergeSort(int[] arrayInt, int n) {
    mergeSortC(arrayInt, 0, n - 1);
  }

  /**
   * 归并排序子函数
   * 递归实现的本质就是默认子函数已经实现好了，干就行， 剩下就是标识终结条件
   * 分治思想先把小问题解决了， 大问题自然就解决了， 技术使用到的是递归
   * 归并自下而上，先处理子问题再合并
   *
   * @param arrayInt
   * @param head     头部指针
   * @param tail     尾部指针
   */
  private void mergeSortC(int[] arrayInt, int head, int tail) {
    if (head >= tail) {
      return;
    }
    int middle = head + (tail - head) / 2;
    mergeSortC(arrayInt, head, middle);
    mergeSortC(arrayInt, middle + 1, tail);
    merge(arrayInt, head, middle, tail);
  }

  /**
   * 合并子排序已经排序好的结果
   */
  private void merge(int[] arrayInt, int head, int middle, int tail) {
    //2个指针 i j  把2个子数组按序存入tmp
    int i = head;
    int j = middle + 1;
    int[] tmp = new int[tail - head + 1];
    int k = 0;//下一次要存入tmp的index
    while (i <= middle && j <= tail) {
      if (arrayInt[i] <= arrayInt[j]) {
        tmp[k++] = arrayInt[i++];
      } else {
        reverseDegree += (middle - i + 1);
        tmp[k++] = arrayInt[j++];
      }
    }
    int start = i;
    int end = middle;
    if (j <= tail) {
      start = j;
      end = tail;
    }
    for (int l = start; l <= end; l++) {
      tmp[k++] = arrayInt[l];
    }
    //tmp  导入array
    for (int l = 0; l < tmp.length; l++) {
      arrayInt[head + l] = tmp[l];
    }
  }

  /**
   * 查找第一个值等于给定值的元素
   * 3，4，5，5，6，7，8 find  5
   *
   * @param arrayInt
   * @param n
   * @param tmp
   * @return
   */
  private int binarySearch(int[] arrayInt, int n, int tmp) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int middle = low + ((high - low) >> 1);
      if (tmp > arrayInt[middle]) {
        low = middle + 1;
      } else if (tmp < arrayInt[middle]) {
        high = middle - 1;
      } else {//重复元素二分查找解决方案
//        查找第一个值等于给定值的元素
//        if (middle==0 ||arrayInt[middle-1]!=tmp ) {
//          return middle;
//        }else{
//          high = middle - 1;
//        }
        //查找最后一个等于给定值的元素
        if (middle == n - 1 || arrayInt[middle + 1] != tmp) {
          return middle;
        } else {
          low = middle + 1;
        }
        //查找第一个大于等于给定值的元素
      }
    }
    return -1;
  }

  /**
   * 查找第一个大于等于给定值的元素
   *
   * @param arrayInt
   * @param n
   * @param tmp
   * @return
   */
  private int bSearchFirstGreaterEqual(int[] arrayInt, int n, int tmp) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int middle = low + ((high - low) >> 1);
      if (arrayInt[middle] >= tmp) {
        if (middle == 0 || arrayInt[middle - 1] < tmp) {
          return middle;
        } else {
          high = middle - 1;
        }
      } else {
        low = middle + 1;
      }
    }
    return -1;
  }

  /**
   * 查找最后一个小于等于给定值的元素
   * @param arrayInt
   * @param n
   * @param tmp
   * @return
   */
  private int bSearchLastLessEqual(int[] arrayInt, int n, int tmp) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int middle = low + ((high - low) >> 1);
      if (arrayInt[middle] <= tmp) {
        if (middle == n-1 || arrayInt[middle + 1] > tmp) {
          return middle;
        } else {
          low = middle + 1;
        }
      } else {
        high = middle - 1;
      }
    }
    return -1;
  }

  private int binarySearchRecursion(int[] arrayInt, int n, int tmp) {
    return binarySearchRecursionC(arrayInt, 0, n - 1, tmp);
  }

  private int binarySearchRecursionC(int[] arrayInt, int head, int tail, int tmp) {
    if (head > tail) {
      return -1;
    }
    int middle = head + ((tail - head) >> 1);
    if (tmp == arrayInt[middle]) {
      return middle;
    } else if (tmp > arrayInt[middle]) {
      return binarySearchRecursionC(arrayInt, middle + 1, tail, tmp);
    } else {
      return binarySearchRecursionC(arrayInt, head, middle - 1, tmp);
    }
  }

  public static void main(String[] args) {
    Sorter sorter = new Sorter();
//    int[] ints = new int[]{1, 33, 55, 3333, 55, 8, 9, 5, 6, 2, 0, -22};
    int[] ints = new int[]{11, 10, 9};
//    sorter.bubblingSort(ints,ints.length);
//    sorter.insertSort(ints,ints.length);
//    sorter.selectSort(ints,ints.length);
    sorter.mergeSort(ints,ints.length);
    System.out.println(sorter.reverseDegree);
//    sorter.quickSort(ints, ints.length);
//    for (int anInt : ints) {
//      System.out.println(anInt);
//    }
//    System.out.println(sorter.findK(ints,3,ints.length));
//    ints = new int[]{3, 4, 5, 5, 6, 7, 8};
//    ints = new int[]{3, 4, 6, 7, 10};
//    System.out.println(sorter.bSearchFirstGreaterEqual(ints, ints.length, 5));
//    System.out.println(sorter.bSearchLastLessEqual(ints, ints.length, 5));
//    System.out.println(sorter.binarySearchRecursion(ints, ints.length, 5));

  }
}
