class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1, 1);
        }

        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= rowIndex; i++) {
            int[] lvl = new int[i + 1];
            lvl[0] = 1;
            lvl[i] = 1;
            for (int j = 1; j < i; j++) {
                lvl[j] = res[j - 1] + res[j];
            }
            res = lvl;
        }
        ArrayList<Integer> l = new ArrayList<>();
        for (int el : res) {
            l.add(el);
        }

        return l;
    }
}