class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) return true;

        HashSet<Integer> hasKeys = new HashSet<>();
        rooms.get(0).forEach(e -> hasKeys.add(e));

        Queue<Integer> queue = new LinkedList<>();
        rooms.get(0).forEach(e -> queue.offer(e));

        HashSet<Integer> visit = new HashSet<>();
        rooms.get(0).clear();
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            visit.add(idx);

            List<Integer> keys = rooms.get(idx);
            if (keys.isEmpty()) continue;

            for (Integer k : keys) {
                if (!visit.contains(k)) queue.offer(k);
                hasKeys.add(k);
            }
            rooms.get(idx).clear();
        }

        boolean result = true;

        for (List<Integer> e : rooms) {
            result = e.isEmpty() & result;
        }

        return result;
    }
}