package com.didichuxing;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
  private static Map<Integer, Integer> hasSolvedMap = new HashMap<>();
  public static void main(String[] args) {
    System.out.println(runStep(10));
  }

  //走台阶 f(n) = f(n-1) + f(n-2) 第一步走一步 第二步走二步
  //终止条件 f(1) =1 f(2) = 2 走完n步的台阶多少种走法，只能走一步或者走2步
  //避免重复计算
  private static int runStep(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (hasSolvedMap.containsKey(n)) return hasSolvedMap.get(n);
    int result = runStep(n - 1) + runStep(n - 2);
    hasSolvedMap.put(n, result);
    return result;
  }





}
