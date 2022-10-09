class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int items: arr) {
            if(items % 2 ==0) {
                if (map.containsKey(items/2)){
                    return true;
                }
            }
            if(map.containsKey(2*items)){
                return true;
            }
            map.put(items,items);
        }
        return false;
    }
}