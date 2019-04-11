package com.didichuxing;

/**
 * 字符串比较对象
 * BM算法：坏字符 ，好后缀
 * 坏字符需要根据怀字符取模式串中比较，扫描查的话时间复杂度O（n）要是模式串很大的话，性能会很低
 * 可以散列表查找：散列表本质是：散列函数(KEY)=> 数组下标；此处散列函数使用每个char对应的ascii码
 * 数据量不大，合适的散列函数，可以避免散列冲突，后续还要链表法支撑
 */
public class StringCmp {
  private int[] cmpArray;
  private static final int SIZE = 256;
  public StringCmp() {
    cmpArray = new int[SIZE];
  }

  private void buidBmCharHash(char[]patterns) {
    for (int i = 0; i < cmpArray.length; i++) {
      cmpArray[i]=-1;
    }
    for (int i = 0; i < patterns.length; i++) {
      int ascii = (int)patterns[i];
      cmpArray[ascii] = i;
    }
  }
  public static void main(String[] args) {
    StringCmp stringCmp = new StringCmp();
    stringCmp.buidBmCharHash("abcdef".toCharArray());
    System.out.println(111);

  }
}
