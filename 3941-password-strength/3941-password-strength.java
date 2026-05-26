import java.util.HashSet;

class Solution {
    public int passwordStrength(String password) {
        int point = 0;
        HashSet<Character> set = new HashSet<>();
        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                
                if (Character.isLowerCase(ch)) {
                    point += 1;
                } else if (Character.isUpperCase(ch)) {
                    point += 2;
                } else if (Character.isDigit(ch)) {
                    point += 3;
                } else if (ch == '!' || ch == '@' || ch == '#' || ch == '$') {
                    point += 5; 
                }
            }
        }
        return point;
    }
}