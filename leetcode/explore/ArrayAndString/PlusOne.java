class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            int tmp = (digits[i] + carry);
            if (tmp % 10 == 0 && tmp != 0) {
                carry = 1;
                digits[i] = 0;
            }else {
                carry = 0;
                digits[i] = tmp % 10;
            }
        }
        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            result[0] = carry;
            return result;
        }
        return digits;
    }
}