class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        int totalSum = 0;
        while (totalSum > 0 || aLen >= 0 || bLen >= 0) {
            if (aLen >= 0) {
                totalSum += a.charAt(aLen) - '0';
                aLen--;
            }

            if (bLen >= 0) {
                totalSum += b.charAt(bLen) - '0';
                bLen--;
            }

            sb.append(totalSum % 2);
            totalSum /= 2;
        }
        return sb.reverse().toString();
    }
}