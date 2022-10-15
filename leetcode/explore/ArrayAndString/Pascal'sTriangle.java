class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    sub.add(1);
                    continue;
                }
                List<Integer> parrent = result.get(i-1);
                sub.add(parrent.get(j) + parrent.get(j-1));
            }
            result.add(sub);
        }
        return result;
    }
}