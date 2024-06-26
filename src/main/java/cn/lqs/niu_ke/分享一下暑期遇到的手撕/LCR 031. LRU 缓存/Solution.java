class LRUCache {
    final Node head;
    final Node tail;
    final int cap;
    final Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>(this.cap);
    }
    
    public int get(int key) {
        if(!this.map.containsKey(key)){
            return -1;
        }
        Node cNode = this.map.get(key);
        cNode.prev.next = cNode.next;
        cNode.next.prev = cNode.prev;
        cNode.next =  this.head.next;
        cNode.prev = this.head;
        this.head.next = cNode;
        cNode.next.prev = cNode;
        return cNode.val;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            this.map.get(key).val = value;
            this.get(key);
            return;
        }
        if(this.map.size() == this.cap){
            Node lNode = this.tail.prev;
            this.tail.prev = lNode.prev;
            lNode.prev.next = this.tail;
            this.map.remove(lNode.key);
        }
        Node nNode = new Node();
        nNode.key = key;
        nNode.val = value;
        nNode.prev = this.head;
        nNode.next = this.head.next;
        this.head.next = nNode;
        nNode.next.prev = nNode;
        this.map.put(key, nNode);
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