package com.didichuxing;

import java.util.ArrayList;
import java.util.List;

/**
 * trie 字符串关联搜索
 */
public class Trie {
  private TrieNode rootTrieNode = new TrieNode('/');


  private void insertTriedNode(char[]chars) {
    TrieNode trieNodePointer = rootTrieNode;
    for (char aChar : chars) {
      int index = aChar - 'a';
      if (trieNodePointer.getTrieNodes()[index]==null) {
        //该字符不存在
        trieNodePointer.getTrieNodes()[index] = new TrieNode(aChar);
      }
      trieNodePointer = trieNodePointer.getTrieNodes()[index];
    }
    trieNodePointer.setEndChar(true);
  }


  private boolean findFullString(char[]chars) {
    TrieNode trieNodePointer = rootTrieNode;
    for (char aChar : chars) {
      int index = aChar - 'a';
      if (trieNodePointer.getTrieNodes()[index] == null) {
        return false;
      }
      trieNodePointer = trieNodePointer.getTrieNodes()[index];
    }
    if (trieNodePointer.isEndChar()) {
      return true;
    } else {
      return false;
    }
  }

  private String[] searchEngine(char[]chars) {
    TrieNode trieNodePointer = rootTrieNode;
    for (char aChar : chars) {
      if (trieNodePointer.getTrieNodes()[aChar - 'a'] != null) {
        trieNodePointer = trieNodePointer.getTrieNodes()[aChar - 'a'];
      }else{
        return null;
      }
    }
    List<String> result = new ArrayList<>();
    TrieNode[] trieNodes = trieNodePointer.getTrieNodes();
    for (TrieNode trieNode : trieNodes) {
      if (trieNode==null) {
        continue;
      }
      if (trieNode.isEndChar()) {
        result.add(chars.toString() + trieNode.getCharNode());
      }
    }
    return null;
  }



  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insertTriedNode("hello".toCharArray());
    System.out.println(trie.findFullString("hello".toCharArray()));
  }
}

class TrieNode {
  private char charNode;
  private boolean isEndChar = false;
  private TrieNode[] trieNodes = new TrieNode[26];

  public char getCharNode() {
    return charNode;
  }

  public void setCharNode(char charNode) {
    this.charNode = charNode;
  }

  public boolean isEndChar() {
    return isEndChar;
  }

  public void setEndChar(boolean endChar) {
    isEndChar = endChar;
  }

  public TrieNode[] getTrieNodes() {
    return trieNodes;
  }

  public void setTrieNodes(TrieNode[] trieNodes) {
    this.trieNodes = trieNodes;
  }

  public TrieNode(char charNode) {
    this.charNode = charNode;
  }
}