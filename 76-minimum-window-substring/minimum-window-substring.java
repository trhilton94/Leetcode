class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        } // for

        int left = 0;
        int need = needMap.size();
        int have = 0;
        int minLength = Integer.MAX_VALUE;
        String minWindow = "";
        char rightChar;
        char leftChar;

        for (int right = 0; right < s.length(); right++) {
            rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
            if (needMap.containsKey(rightChar) &&
                windowMap.get(rightChar).equals(needMap.get(rightChar))) have++;
            while (left <= right && have == need) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minWindow = s.substring(left, right + 1);
                    if (minLength == t.length()) return s.substring(left, right + 1);
                } // if
                leftChar = s.charAt(left);
                if (needMap.containsKey(leftChar) &&
                    windowMap.get(leftChar).equals(needMap.get(leftChar))) have--;
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                left++;
            } // while
        } // for

        return minWindow;
    } // minWindow
} // Solution