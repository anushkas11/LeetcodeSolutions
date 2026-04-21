import java.util.*;

class Solution {
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        
        UnionFind uf = new UnionFind(n);
        
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            map.putIfAbsent(parent, new HashMap<>());
            
            Map<Integer, Integer> freq = map.get(parent);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }
        
        int mismatch = 0;
        
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            Map<Integer, Integer> freq = map.get(parent);
            
            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                mismatch++;
            }
        }
        
        return mismatch;
    }
}

class UnionFind {
    int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }
    
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if (px != py) {
            parent[px] = py;
        }
    }
}