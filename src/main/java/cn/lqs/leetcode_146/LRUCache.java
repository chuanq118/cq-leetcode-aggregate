package cn.lqs.leetcode_146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private final Map<Integer, Node> map;
    private final int capacity;
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
      this.map = new HashMap<>(capacity);
      this.capacity = capacity;
      this.first = null;
      this.last = null;
    }
    
    public int get(int key) {
      if(!this.map.containsKey(key)){
        return -1;
      }
      int value = this.map.get(key).val;
      // 再次放入此元素，保证其在最后
      put(key, value);
      return value;
    }
    
    public void put(int key, int value) {
      if(this.map.containsKey(key)){
        Node existNode = this.map.get(key);
        if(this.last == existNode){
          this.last.val = value;
        } else{
          Node preExistNode = existNode.prev;
          Node nextExistNode = existNode.next;
          if(preExistNode != null){
            preExistNode.next = nextExistNode;
          }
          if (nextExistNode != null) {
            nextExistNode.prev = preExistNode;
          }
          if (this.first == existNode) {
            this.first = nextExistNode;
          }
          this.last.next = existNode;
          existNode.prev = this.last;
          existNode.next = null;
          existNode.val = value;
          this.last = existNode;
        }
        return;
      }
      if(this.map.size() >= this.capacity){
        int removedKey = this.first.key;
        this.map.remove(removedKey);
        Node nextNode = this.first.next;
        if (nextNode != null) {
          nextNode.prev = null;
          this.first = nextNode;
        }else {
          this.first = this.last = null;
        }
      }
      Node node = new Node(key, value);
      node.prev = this.last;
      if(this.last != null){
        this.last.next = node;
      }
      if(this.first == null){
        this.first = node;
      }
      this.last = node;
      this.map.put(key, node);
    }

    class Node{
      Node prev;
      Node next;
      int val;
      int key;
      public Node(int key, int val){
        this.val = val;
        this.key = key;
      }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */