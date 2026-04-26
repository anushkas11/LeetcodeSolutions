class Solution {
    static class Pair {
        int freq;
        char ch;
        public Pair (int f, char ch) {
            this.freq = f;
            this.ch = ch;
        }
    }
    public String sortVowels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> first = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.freq != b.freq) return Integer.compare(b.freq, a.freq);
            return first.get(a.ch) - first.get(b.ch);
        });

        Set<Character> set = Set.of('a', 'e', 'i','o', 'u');
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(!first.containsKey(ch)) {
                    first.put(ch, i);
                }
            }
        }

        for(char val:map.keySet()) {
            pq.add(new Pair(map.get(val), val));
        }

        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()) {
            if(set.contains(ch)) {
                if(!pq.isEmpty()) {
                    Pair p = pq.peek();
                    if(p.freq > 0) {
                        sb.append(p.ch);
                        p.freq--;
                    } else {
                        pq.poll();
                        sb.append(pq.peek().ch);
                        pq.peek().freq--;
                    }
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}