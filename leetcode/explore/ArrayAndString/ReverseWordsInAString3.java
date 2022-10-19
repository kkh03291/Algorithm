class Solution {
    public String reverseWords(String s) {
        s.trim();
        int index = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, index));
                sb.append(" ");
                index = i;
            }
        }
        sb.append(s.substring(0, index));
        return sb.reverse().toString();
    }
}