class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();

        for(char ch : list){
            sb.append(String.valueOf(ch).repeat(map.get(ch)));
        }

        return sb.toString();
    }
}