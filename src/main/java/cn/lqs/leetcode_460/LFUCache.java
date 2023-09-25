package cn.lqs.leetcode_460;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

    private final Map<Integer, DeLinkNode> dataMap;
    // 保存每一个频度的最后一个节点
    private final Map<Integer, DeLinkNode> frequencyMap;
    private final int capacity;
    private DeLinkNode head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>(capacity);
        this.frequencyMap = new HashMap<>();
        this.head = null;
    }

    public int get(int key) {
        if (!this.dataMap.containsKey(key)) {
            return -1;
        }
        int value = this.dataMap.get(key).value;
        updateNode(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (this.dataMap.containsKey(key)) {
            updateNode(key, value);
            return;
        }
        insertNode(key, value, 1, null);
    }

    private void insertNode(int key, int value, int frequency, DeLinkNode preFrequencyLastNode) {
        if (this.dataMap.size() >= capacity) {
            deleteNode(this.head.key);
        }
        DeLinkNode newNode = new DeLinkNode(key, value, frequency);
        if (this.frequencyMap.containsKey(newNode.frequency)) {
            DeLinkNode lastNode = this.frequencyMap.get(newNode.frequency);
            DeLinkNode lastNextNode = lastNode.next;
            if (lastNextNode != null) {
                lastNextNode.prev = newNode;
            }
            lastNode.next = newNode;
            newNode.next = lastNextNode;
            newNode.prev = lastNode;
        }else if (preFrequencyLastNode != null){
            DeLinkNode preFrequencyLastNextNode = preFrequencyLastNode.next;
            if (preFrequencyLastNextNode != null) {
                preFrequencyLastNextNode.prev = newNode;
            }
            preFrequencyLastNode.next = newNode;
            newNode.next = preFrequencyLastNextNode;
            newNode.prev = preFrequencyLastNode;
        }else if(this.head != null){
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }else {
            this.head = newNode;
        }
        this.dataMap.put(key, newNode);
        this.frequencyMap.put(newNode.frequency, newNode);
    }

    // 删除指定 key 的节点并返回到该节点频度的情况下链表中的最后节点
    private DeLinkNode deleteNode(int key) {
        DeLinkNode delNode = this.dataMap.get(key);
        DeLinkNode prevDelNode = delNode.prev;
        DeLinkNode nextDelNode = delNode.next;
        boolean onlyOneFrequencyNode = true;
        if (prevDelNode != null) {
            prevDelNode.next = nextDelNode;
            if (prevDelNode.frequency == delNode.frequency) {
                onlyOneFrequencyNode = false;
            }
        } else {
            this.head = nextDelNode;
        }
        if (nextDelNode != null) {
            nextDelNode.prev = prevDelNode;
            if (nextDelNode.frequency == delNode.frequency) {
                onlyOneFrequencyNode = false;
            }
        }
        if (onlyOneFrequencyNode) {
            this.frequencyMap.remove(delNode.frequency);
        } else if (this.frequencyMap.get(delNode.frequency) == delNode) {
            this.frequencyMap.put(delNode.frequency, prevDelNode);
        }
        this.dataMap.remove(delNode.key);
        return this.frequencyMap.getOrDefault(delNode.frequency, prevDelNode);
    }

    private void updateNode(int key, int value) {
        int newFrequency = this.dataMap.get(key).frequency + 1;
        DeLinkNode mostPreNode = deleteNode(key);
        insertNode(key, value, newFrequency, mostPreNode);
    }

    static class DeLinkNode {
        int key;
        int value;
        int frequency;
        DeLinkNode prev;
        DeLinkNode next;

        public DeLinkNode(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */