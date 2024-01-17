package date17;

public class Solution {
    /**
     * 2744. 最大字符串配对数目
     */
    public int maximumNumberOfStringPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isFZ(words[i], words[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isFZ(String s1, String s2) {
        boolean result = true;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s2.charAt(j) != s1.charAt(i)) {
                    result = false;
                }
            }
        }
        return result;
    }
}
