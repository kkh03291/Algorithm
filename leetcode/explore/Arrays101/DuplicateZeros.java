class Solution {
    public void duplicateZeros(int[] arr) {
        int lastIndex = arr.length - 1;
        int matchCount = 0;
        for (int i = 0; i <= lastIndex - matchCount; i++) {
            if (arr[i] == 0){
                if (i == lastIndex - matchCount) {
                    arr[lastIndex] = 0;
                    lastIndex --;
                    break;
                }
                matchCount++;
            }
        }
        lastIndex -= matchCount;
        for (int i = lastIndex; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + matchCount] = 0;
                matchCount --;
                arr[i + matchCount] = 0;
            } else {
                arr[i + matchCount] = arr[i];
            }
        }
    }
}