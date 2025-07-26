import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Map to store required characters and their frequencies from t
        Map<Character, Integer> requiredMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredMap.put(c, requiredMap.getOrDefault(c, 0) + 1);
        }

        // Number of characters from t that we need to match in s
        int required = t.length();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        char[] chS = s.toCharArray();

        while (right < chS.length) {
            char currentChar = chS[right];

            // If current character is needed, decrease its count in map and required count
            if (requiredMap.containsKey(currentChar)) {
                if (requiredMap.get(currentChar) > 0) {
                    required--;
                }
                requiredMap.put(currentChar, requiredMap.get(currentChar) - 1);
            }

            right++; // Move window forward

            // Try to shrink the window when all characters are matched
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char charAtLeft = chS[left];

                if (requiredMap.containsKey(charAtLeft)) {
                    requiredMap.put(charAtLeft, requiredMap.get(charAtLeft) + 1);

                    // If we need this character again, increase required
                    if (requiredMap.get(charAtLeft) > 0) {
                        required++;
                    }
                }

                left++; // Shrink window from the left
            }
        }

        // Return result based on whether we found a valid window
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return new String(chS, minStart, minLen);
    }
}
