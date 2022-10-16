class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        for (String item : strs) {
            minLen = Math.min(minLen, item.length());
        }

        if (minLen == 0) return "";

        String result ="";
        int i = 1;

        loop:
        while(i <= minLen) {
            result = strs[0].substring(0,i);
            for (String item : strs) {
                if (result.length() > item.length()) break loop;
                if (item.indexOf(result) != 0) break loop;
            }
            i++;
        }
        result = strs[0].substring(0,--i);
        return result;
    }
}