package cn.lqs.leetcode;

import javafx.util.Pair;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        // System.out.println("a" * 3);
        // Queue<Integer> q = new LinkedList<>();
        // q.offer()
        // q.poll()
        // q.size()
        // Stack<Integer> stack = new Stack<>();
        // stack.push();
        // stack.pop();
        // StringBuilder sb = new StringBuilder();
        // sb.reverse();
        List<Integer> list = new ArrayList<>();
        // list.contains();
        // list.clear();
        // list.set();
        Arrays.sort(list.toArray());
        Integer[] sortedArr = list.toArray(new Integer[0]);
        // Pair
        // Math.sqrt();
        // long l = 1, r = 1L * ranks[0] * cars * cars;
        PriorityQueue<int[]> pq = new PriorityQueue<>((prev, next)->{
            return next[0] - prev[0];
        });
        // pq.remove()
        // pq.element();
        // pq.peek()
        // pq.poll()
        // pq.offer();
        // pq.size()
        
        // HashSet<Integer> hashSet = new HashSet<>();
        // hashSet.toArray(new Integer[0]);
        // ArrayList[] edges = new ArrayList[2];
        String s = "aaAA.,,ACD asdmcx ;;";
        System.out.println(s.toLowerCase());

        HashSet<Integer> set = new HashSet<>();
        // set.stream()
        // set.contains()
        // set.remove()
        // set.
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.containsKey()
        // map.size()
        
        LinkedList<Integer> ll = new LinkedList<>();
        
        ll.iterator();
        
    }
}
