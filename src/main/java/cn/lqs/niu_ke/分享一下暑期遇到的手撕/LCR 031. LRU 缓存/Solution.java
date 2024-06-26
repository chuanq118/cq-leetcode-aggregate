class LRUCache {
    final Node head;
    final int cap;
    final Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new Node();
        this.map = new HashMap<>(this.cap);
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {

    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */