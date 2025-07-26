class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Frequency map to store how many times each character appears in t
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;               // Left pointer of the window
        int right = 0;              // Right pointer of the window
        int count = t.length();     // Number of characters still needed to match t
        int minLen = Integer.MAX_VALUE; // Track the smallest window length
        int minStart = 0;               // Track the start index of the smallest window

        // Convert s to character array for faster access
        char[] chS = s.toCharArray();

        // Start sliding the window
        while (right < chS.length) {
            char currentChar = chS[right];

            // If this character is needed (still has positive count), decrease count
            if (map[currentChar] > 0) {
                count--;
            }

            // Always reduce the character count in map
            map[currentChar]--;

            right++; // Move the right pointer forward

            // If all characters are matched, try shrinking the window
            while (count == 0) {
                // Update minimum window if it's smaller than previously found
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char charAtLeft = chS[left];

                // Increase the character count in the map
                map[charAtLeft]++;

                // If that character was needed (i.e., count goes from 0 to 1), we now miss a required char
                if (map[charAtLeft] > 0) {
                    count++;
                }

                // Move the left pointer forward to try and shrink the window
                left++;
            }
        }

        // If we never updated minLen, no window was found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        // Return the substring from minStart with length minLen
        return new String(chS, minStart, minLen);
    }
}
