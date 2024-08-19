class LRUCache {

    final int cap;
    final Map<Integer, Node> map;
    final Node head;
    final Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            delNode(curNode);
            insertHead(curNode);
            return curNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            get(key);
            this.map.get(key).val = value;
            return;
        }
        if (this.map.size() == this.cap) {
            int removedKey = this.tail.prev.key;
            delNode(this.tail.prev);
            this.map.remove(removedKey);
        }
        Node newNode = new Node(key, value);
        insertHead(newNode);
        this.map.put(key, newNode);
    }

    private void delNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertHead(Node node) {
        Node preFirNode = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        preFirNode.prev = node;
        node.next = preFirNode;
    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
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