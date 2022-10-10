class Solution {
    public int[] replaceElements(int[] arr) {
        int currentValue, maxValue = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            currentValue = arr[i];
            if (i == arr.length - 1) {
                arr[i] = -1;
            }else {
                arr[i] = maxValue;
            }

            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
        }
        return arr;
    }
}