class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n];
        long currentLen = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                currentLen++;
            } else if (ch == '*') {
                if (currentLen > 0) currentLen--;
            } else if (ch == '#') {
                currentLen *= 2;
            } else if (ch == '%') {
               
            }
            lengths[i] = currentLen;
        }

        if (k >= currentLen || k < 0) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = (i == 0) ? 0 : lengths[i - 1];

            if (Character.isLetter(ch)) {
                
                if (k == prevLen) {
                    return ch;
                }
                currentLen--;
            } else if (ch == '*') {
                
                currentLen++;
            } else if (ch == '#') {
                
                if (k >= prevLen) {
                    k %= prevLen;
                }
                currentLen = prevLen;
            } else if (ch == '%') {
                
                k = currentLen - 1 - k;
            }
        }

        return '.';
    }
}