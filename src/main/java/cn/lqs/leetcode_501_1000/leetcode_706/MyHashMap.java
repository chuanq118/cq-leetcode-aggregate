package cn.lqs.leetcode_1_1000.leetcode_706;

class MyHashMap {

    private final Node[] nodeArr;
    private final int cap;

    public MyHashMap() {
        this.cap = (1 << 12);
        this.nodeArr = new Node[this.cap];
    }

    public void put(int key, int value) {
        int ti = (this.cap - 1) & key;
        if (this.nodeArr[ti] == null) {
            this.nodeArr[ti] = new Node(key, value, null);
            return;
        }
        Node cur = this.nodeArr[ti];
        if (cur.key == key) {
            cur.val = value;
            return;
        }
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new Node(key, value, null);
    }

    public int get(int key) {
        int idx = (this.cap - 1) & key;
        if (this.nodeArr[idx] == null) {
            return -1;
        }
        Node cur = this.nodeArr[idx];
        if (cur.key == key) {
            return cur.val;
        }
        while (cur.next != null) {
            if (cur.next.key == key) {
                return cur.next.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = (this.cap - 1) & key;
        if (this.nodeArr[idx] == null) {
            return;
        }
        if (this.nodeArr[idx].key == key) {
            this.nodeArr[idx] = this.nodeArr[idx].next;
            return;
        }
        Node prev = this.nodeArr[idx];
        Node cur = this.nodeArr[idx].next;
        while (cur != null) {
            if (cur.key == key) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */