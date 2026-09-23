class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }
        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = 0;
        for (int count : need) {
            if (count > 0) {
                required++;
            }
        }

        int[] window = new int[128];

        int formed = 0;

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            window[c]++;

            if (need[c] > 0 && window[c] == need[c]) {
                formed++;
            }
            while (formed == required) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);
                window[remove]--;

                if (need[remove] > 0 &&
                    window[remove] < need[remove]) {

                    formed--;
                }

                left++;
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}