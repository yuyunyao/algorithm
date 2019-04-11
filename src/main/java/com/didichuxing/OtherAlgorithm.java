package com.didichuxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 其他算法，贪心
 */
public class OtherAlgorithm {
  private SectionPair[] pairs;

  public OtherAlgorithm() {
    this.pairs = new SectionPair[6];
  }

  private void buildSection() {
    this.pairs[0] = new SectionPair(6, 8);
    this.pairs[1] = new SectionPair(2, 4);
    this.pairs[2] = new SectionPair(3, 5);
    this.pairs[3] = new SectionPair(1, 5);
    this.pairs[4] = new SectionPair(5, 9);
    this.pairs[5] = new SectionPair(8, 10);
  }

  private void sortAsc() {
    for (int j = 1; j <pairs.length; j++) {
      int i = j - 1;
      SectionPair jSectionPair = pairs[j];
      int jval = jSectionPair.getRight();
      for (; i >=0; i--) {
        if (jval<pairs[i].getRight()) {
          pairs[i + 1] = pairs[i];
        }else{
          break;
        }
      }
      pairs[i + 1] = jSectionPair;
    }
  }


  /**
   * 上述区间中选择一个最大覆盖区间数的解决方案
   * 每次选择右边最小的，这样右半区间能容纳最大，下次选择的区间前缀不能和之前选择的区间重合
   * 贪婪算法：抽象出临界值和最大期望值，在临界值的情况下求最大期望值
   */
  private List<SectionPair> greedMaxSection() {
    List<SectionPair> result = new ArrayList<>();
    for (SectionPair pair : pairs) {
      if (result.isEmpty() || (pair.getLeft()>=result.get(result.size()-1).getRight())) {
        result.add(pair);
      }
    }
    return result;
  }


  //回溯问题， 八皇后
  /*
  八皇后棋盘存储的是棋盘中每行应该在那列落子
   */
  private int[] queueChessboard = new int[8];

  /**
   * 八皇后下棋先从第一行开始
   * @param row
   */
  private void playChess8Queue(int row) {
    if (row>=8) {
      printChess8Queue();
      //此处很关键，return是从上次最后一个终止条件的下一个for column继续；每次打印的其实是当前棋盘的快照，随着迭代回溯继续会更新棋盘直到再满足终止条件，再次打印棋盘；可以使用树表达式进行解析
      return;
    }
    for (int column = 0; column < 8; column++) {
      if (isValidBoard(row, column)) {
        queueChessboard[row] = column;
        playChess8Queue(row+1);
      }
    }
  }

  private boolean isValidBoard(int row,int column) {
    int leftColumn = column - 1;
    int rightColumn = column + 1;
    for (int i = row-1; i >=0 ; i--) {
      if (queueChessboard[i] == column) {
        return false;
      }
      if (leftColumn>=0 && queueChessboard[i]==leftColumn) {
        return false;
      }
      if (rightColumn<8 && queueChessboard[i]==rightColumn) {
        return false;
      }
      leftColumn--;
      rightColumn++;
    }
    return true;
  }

  private void printChess8Queue() {
    for (int i = 0; i < queueChessboard.length; i++) {
      for (int j = 0; j < 8; j++) {
        if (queueChessboard[i] == j) {
          System.out.print("queue");
        } else {
          System.out.print("*");
        }
      }
      System.out.println();
    }
    System.out.println("end queue print");
  }

  public static void main(String[] args) {
    OtherAlgorithm otherAlgorithm = new OtherAlgorithm();
//    otherAlgorithm.buildSection();
//    otherAlgorithm.sortAsc();
//    List<SectionPair> sectionPairs = otherAlgorithm.greedMaxSection();
//    for (SectionPair sectionPair : sectionPairs) {
//      System.out.println(sectionPair);
//    }
    otherAlgorithm.playChess8Queue(0);
  }
}


class SectionPair {
  private int left;
  private int right;

  public SectionPair(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public int getLeft() {
    return left;
  }

  public void setLeft(int left) {
    this.left = left;
  }

  public int getRight() {
    return right;
  }

  public void setRight(int right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "left:"+this.getLeft()+"right:"+this.getRight();
  }
}
