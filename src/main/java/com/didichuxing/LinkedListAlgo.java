package com.didichuxing;

public class LinkedListAlgo {

  private Node head;
  private Node tail;

  public LinkedListAlgo() {
    head = createNode(1);
    Node node2 = createNode(2);
    Node node3 = createNode(3);
    Node node4 = createNode(4);
    Node node5 = createNode(5);
    Node node6 = createNode(6);
    Node node7 = createNode(7);
    Node node8 = createNode(8);
    Node node9 = createNode(9);
    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next = node9;
    Node now = head;
    while (now.next != null) {
      this.tail = now.next;
      now = now.next;
    }
  }

  public  void push(int a) {
    if (this.head == null) {
      head = new Node(a, null);
    } else {
      tail.next = new Node(a, null);
      tail = tail.next;
    }
  }

  public  int poll() {
    if (head == null) {
      return -1;
    }
    int result = head.data;
    head = head.next;
    return result;
  }

  public static void main(String[] args) {
    LinkedListAlgo linkedListAlgo = new LinkedListAlgo();
    linkedListAlgo.push(111);
    linkedListAlgo.push(2423423);
    linkedListAlgo.push(54645);
    System.out.println(linkedListAlgo.poll());
    System.out.println(linkedListAlgo.poll());

  }
  // 单链表反转,本质上就是要找到head节点并返回
  public static Node reverse(Node list) {
    Node currentNode = list;
    Node previouNode = null;
    Node headNode = null;
    while (currentNode != null) {
      Node nextNode = currentNode.next;
      if (nextNode == null) {
        headNode = currentNode;
      }
      currentNode.next = previouNode;
      previouNode = currentNode;
      currentNode = nextNode;
    }
    return headNode;
  }


  public static void printAll(Node node) {
    Node currentNode = node;
    while (currentNode != null) {
      System.out.print(currentNode.data+":");
      currentNode = currentNode.next;
    }
    System.out.println();
  }

  public static Node createNode(int value) {
    return new Node(value, null);
  }


  public static class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    public int getData() {
      return data;
    }
  }
}
