package com.didichuxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 树数据结构
 */
public class Tree {
  public static void main(String[] args) {
    Tree tree = new Tree();
    TreeNode treeNode = tree.buildLinkedTree();
//    System.out.println("--------pre iterator---------");
//    tree.preIterable(treeNode);
//    System.out.println("--------middle iterator---------");
//    tree.middleIterable(treeNode);
//    System.out.println("--------after iterator---------");
//    tree.afterIterable(treeNode);
//    TreeNode treeNode1 = tree.bsTreeSearchRecursion(treeNode, 19);
    tree.bsTreeInsert(treeNode, 55);
    tree.bsTreeInsert(treeNode, 55);
    tree.bsTreeInsert(treeNode, 55);
    tree.bsTreeInsert(treeNode, 55);
    List<TreeNode> treeNodes = tree.bsTreeSearch(treeNode, 55);
//    System.out.println("--------after iterator---------");
    for (TreeNode node : treeNodes) {
      System.out.println(node);
    }
  }

  /**
   * 二叉查找树，查询值等于指定值的节点，并返回
   * @param data
   * @return
   */
  private TreeNode bsTreeSearchRecursion(TreeNode bsTree, int data) {
    if (bsTree == null) {
      return null;
    }
    if (bsTree.getData()==data) {
      return bsTree;
    }else if (data >bsTree.getData() ) {//右子树查找
      return bsTreeSearchRecursion(bsTree.getRightNode(), data);
    }else{
      return bsTreeSearchRecursion(bsTree.getLeftNode(), data);
    }
  }

  /**
   * 查找元素，非递归实现版
   * @param bsTree
   * @param data
   * @return
   */
  private  List<TreeNode> bsTreeSearch(TreeNode bsTree, int data) {
    if (bsTree==null) {
      return null;
    }
    List<TreeNode> list = new ArrayList<>();
    while (bsTree!=null) {
      if (bsTree.getData()==data) {
        list.add(bsTree);
        bsTree = bsTree.getRightNode();
      }else if (data > bsTree.getData()) {
        bsTree = bsTree.getRightNode();
      } else {
        bsTree = bsTree.getLeftNode();
      }
    }
    return  list;
  }

  /**
   * 二叉查找树中插入一个元素， 考虑插入重复元素的场景
   * @param bsTree
   * @param data
   * @return
   */
  private void bsTreeInsert(TreeNode bsTree, int data) {
    if (bsTree == null) {
      bsTree = new TreeNode(data, null, null);
      return;
    }
    while (bsTree != null) {
      if (data>=bsTree.getData()) {
        if (bsTree.getRightNode() == null) {
          bsTree.setRightNode(new TreeNode(data, null, null));
          return;
        }
        bsTree = bsTree.getRightNode();
      } else if (data < bsTree.getData()) {
        if (bsTree.getLeftNode() == null) {
          bsTree.setLeftNode(new TreeNode(data, null, null));
          return;
        }
        bsTree = bsTree.getLeftNode();
      }
    }
  }

  /**
   * 链式构建树,  二叉查找树，左边子树的节点的值一定比根节点小， 右边子树的值一定比根节点大
   * @return
   */
  private TreeNode buildLinkedTree() {
    TreeNode treeNode10 = new TreeNode(19, null, null);
    TreeNode treeNode11 = new TreeNode(27, null, null);
    TreeNode treeNode9 = new TreeNode(25, treeNode10, treeNode11);
    TreeNode treeNode8 = new TreeNode(16, null, null);
    TreeNode treeNode4 = new TreeNode(13, null, treeNode8);
    TreeNode treeNode5 = new TreeNode(18, null, treeNode9);
    TreeNode treeNode2 = new TreeNode(17, treeNode4, treeNode5);
    TreeNode treeNode6 = new TreeNode(34, null, null);
    TreeNode treeNode12 = new TreeNode(51, null, null);
    TreeNode treeNode13 = new TreeNode(66, null, null);
    TreeNode treeNode7 = new TreeNode(58, treeNode12,  treeNode13);
    TreeNode treeNode3 = new TreeNode(50, treeNode6, treeNode7);
    TreeNode treeNode1 = new TreeNode(33, treeNode2, treeNode3);
    return treeNode1;
  }

  /**
   * 前序遍历，前中后代表当前节点被遍历的顺序
   * 递归的思想，解决问题A 默认问题 B C 已经实现了
   * @param treeNode
   */
  private void preIterable(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    System.out.println(treeNode.getData());
    preIterable(treeNode.getLeftNode());
    preIterable(treeNode.getRightNode());
  }

  /**
   * 中序遍历
   * @param treeNode
   */
  private void middleIterable(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    middleIterable(treeNode.getLeftNode());
    System.out.println(treeNode.getData());
    middleIterable(treeNode.getRightNode());
  }

  /**
   * 后序遍历
   * @param treeNode
   */
  private void afterIterable(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    afterIterable(treeNode.getLeftNode());
    afterIterable(treeNode.getRightNode());
    System.out.println(treeNode.getData());
  }

  /**
   * 适合存储完全二叉树，第一位空出来，根节点存储位置是i , 左子节点是2*i， 右子节点是2*i+1
   * @return
   */
  private int[] buildArrayTree(int n) {
    int[] treeArray = new int[n+1];
    treeArray[1] = 1;
    treeArray[2*1] = 2;
    treeArray[2*1+1] = 3;
    return treeArray;
  }
}

/**
 * 树节点数据结构
 */
class TreeNode{
  private int data;
  private TreeNode leftNode;
  private TreeNode rightNode;

  public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
    this.data = data;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public TreeNode getLeftNode() {
    return leftNode;
  }

  public void setLeftNode(TreeNode leftNode) {
    this.leftNode = leftNode;
  }

  public TreeNode getRightNode() {
    return rightNode;
  }

  public void setRightNode(TreeNode rightNode) {
    this.rightNode = rightNode;
  }

  @Override
  public String toString() {
    return String.format("cul val :%s  left val:%s  right val:%s",this.getData(),this.leftNode==null?0:this.leftNode.data,this.rightNode==null?0:this.rightNode.data);
  }
}