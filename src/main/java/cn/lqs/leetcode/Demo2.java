package cn.lqs.leetcode;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        // Queue
        // deque.offer()
        // deque.poll()
        deque.peek();

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer>[] hashSets = new HashSet[10];
        // stack.push()
        // stack.pop()
        // stack.peek()
        StringBuilder sb = new StringBuilder();
        // sb.substring()
        // sb.reverse().toString()
        // sb.append();
        sb.insert(0, 'a');
        // sb.delete();

        HashSet<Integer> set = new HashSet<>();
        // set.clear();
        set.add(1);
        set.add(2);
        // set.addAll(set)
        for (Integer i : set) {
            set.add(i);
        }


        // set.add()d
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {

        }
        for (String value : map.values()) {

        }
        ArrayList<Integer> list = new ArrayList<>();
        // list.remove()
        // list.add();
        // set.addAll(list)
        // set.removeAll()
        // list.get()
        // map.size()

    }
}
