package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_433;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> hBank = new HashSet<>(bank.length);
        hBank.addAll(Arrays.asList(bank));
        // add the start gene to avoid extra if condition.
        hBank.add(startGene);
        char[] geneChars = new char[]{'A', 'C', 'G', 'T'};
        HashSet<String> visited = new HashSet<>();
        Queue<String> Q = new LinkedList<>();
        Q.offer(startGene);
        visited.add(startGene);
        StringBuilder sb = new StringBuilder();
        int times = -1;
        boolean ok = false;
        while (!ok && !Q.isEmpty()) {
            int len = Q.size();
            for (int k = 0; k < len; k++) {
                String gene = Q.poll();
                if (endGene.equals(gene)) {
                    ok = true;
                    break;
                }
                sb.setLength(0);
                sb.append(gene);
                for (int i = 0; i < 8; i++) {
                    char sourceChar = sb.charAt(i);
                    for (char geneChar : geneChars) {
                        if (geneChar != sourceChar) {
                            sb.setCharAt(i, geneChar);
                            String mutatedGene = sb.toString();
                            if (hBank.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                                Q.offer(mutatedGene);
                                visited.add(mutatedGene);
                            }
                        }
                    }
                    sb.setCharAt(i, sourceChar);
                }
            }
            times++;
        }
        return ok ? times : -1;
    }

    public static void main(String[] args) {
        // new Solution().minMutation("AACCGGTT", "AACCGGTA",
        //         new String[]{"AACCGGTA"});
        int minnedMutation = new Solution().minMutation("AACCGGTT", "AAACGGTA",
                new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println("minnedMutation = " + minnedMutation);
    }

}