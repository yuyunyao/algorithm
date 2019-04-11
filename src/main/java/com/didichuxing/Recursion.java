package com.didichuxing;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归
 */
public class Recursion {
  private int depth = 0;
  private Map<Integer, Long> stepCache;

  public Recursion() {
    stepCache = new HashMap<>();
  }

  /**
   * 爬楼梯问题
   *
   * @param stepNum
   * @return
   */
  private long upStep(int stepNum) {
    depth++;
//    if (depth > 1000) {
//      throw new RuntimeException("step too depth");
//    }
    if (stepNum == 1) {
      return  1;
    } else if (stepNum == 2) {
      return  2;
    }
    if (stepCache.containsKey(stepNum)) {
      return stepCache.get(stepNum);
    }
    long result = upStep(stepNum - 2) + upStep(stepNum - 1);
    stepCache.put(stepNum, result);
    return result;
  }

  /**
   * 爬楼梯非递归实现
   * @param stepNum
   * @return
   */
  private long upStepNoRecursion(int stepNum) {
    if (stepNum == 1) {
      return  1;
    } else if (stepNum == 2) {
      return  2;
    }
    if (stepCache.containsKey(stepNum)) {
      return stepCache.get(stepNum);
    }
    long result = upStep(stepNum - 2) + upStep(stepNum - 1);
    stepCache.put(stepNum, result);
    return result;
  }

  private void recursionTest(int n) {
    if (n<=0) {
      return;
    }
    recursionTest(n-1);
    System.out.println(n);
  }

  /**
   * 我当前在第n排， 编号是多少
   * @param n
   */
  private int seatNum(int  n) {
    if (n == 1) {
      return 1;
    }
    return seatNum(n - 1) + 1;
  }

  private int seatNumNotRecursion(int  n) {
    int seatNum = 1;
    for (int i = 2; i <=n; i++) {
      seatNum += 1;
    }
    return seatNum;
  }

  public static void main(String[] args) {
    Recursion recursion = new Recursion();
//    System.out.println(recursion.upStep(10000));
//    recursion.recursionTest(10);
    System.out.println(recursion.seatNum(10));
    System.out.println(recursion.seatNumNotRecursion(10));

  }
}
