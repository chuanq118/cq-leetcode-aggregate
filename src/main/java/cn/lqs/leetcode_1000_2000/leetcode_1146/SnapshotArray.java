package cn.lqs.leetcode_1000_2000.leetcode_1146;

import java.util.ArrayList;

class SnapshotArray {

    int versionId;
    ArrayList<ArrayList<Node>> arr;

    public SnapshotArray(int length) {
        this.versionId = 0;
        this.arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            this.arr.add(new ArrayList<>());
        }
    }
    
    public void set(int index, int val) {
        ArrayList<Node> list = this.arr.get(index);
        if (list.size() > 0 && list.get(list.size() - 1).version == versionId) {
            list.get(list.size() - 1).val = val;
            return;
        }
        Node node = new Node();
        node.val = val;
        node.version = versionId;
        list.add(node);
    }
    
    public int snap() {
        int preVersion = this.versionId;
        this.versionId += 1;
        return preVersion;
    }
    
    public int get(int index, int snap_id) {
        ArrayList<Node> nodes = this.arr.get(index);
        for (int i = nodes.size() - 1; i > -1; i -= 1) {
            if (nodes.get(i).version <= snap_id) {
                return nodes.get(i).val;
            }
        }
        return 0;
    }

    static class Node {
        int val;
        int version;
    }
}

