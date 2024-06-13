package cn.lqs.leetcode;

import javafx.util.Pair;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        // "aa".endsWith()
        // System.out.println("a" * 3);
        Queue<Integer> Q = new LinkedList<>();
        double sum = 0d;
        // Q.size()
        // q.offer()
        // q.poll()
        // q.size()
        // Stack<Integer> stack = new Stack<>();
        // stack.push();
        // stack.pop();
        StringBuilder sb = new StringBuilder();
        // sb.toString()
        // sb.reverse();
        // sb.charAt()
        // sb.deleteCharAt()
        List<Integer> list = new ArrayList<>();
        list.sort((prev, next)->{
            return next - prev;
        });
        String s = "abc";
        // s.substring()
        // s.substring()
        // list.set()
        // list.set()
        // list.get()
        // list.contains();
        // list.clear();
        // list.set();
        Arrays.sort(list.toArray());
        Integer[] sortedArr = list.toArray(new Integer[0]);
        // Pair
        // Math.sqrt();
        // long l = 1, r = 1L * ranks[0] * cars * cars;
        PriorityQueue<int[]> pq = new PriorityQueue<>((prev, next)-> next[0] - prev[0]);
        // pq.remove()
        // pq.element();
        // pq.peek()
        // pq.poll()
        // pq.offer();
        // pq.size()
        // pq.isEmpty()
        
        // HashSet<Integer> hashSet = new HashSet<>();
        // hashSet.toArray(new Integer[0]);
        // ArrayList[] edges = new ArrayList[2];
        String s1 = "aaAA.,,ACD asdmcx ;;";
        System.out.println(s.toLowerCase());

        HashSet<Integer> set = new HashSet<>();
        // set.stream()
        // set.contains()
        // set.remove()
        // set.
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.keySet()
        // map.containsKey()
        // map.size()
        Integer[] array = map.values().toArray(new Integer[0]);
        Arrays.sort(array);

        LinkedList<Integer> ll = new LinkedList<>();
        
        ll.iterator();

        Random ran = new Random();
        ran.nextInt(10);
        
        
    }
}
