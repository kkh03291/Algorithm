class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));

        HashSet<String> visit = new HashSet<>();
        visit.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String poll = queue.poll();
                // System.out.println(poll);

                if (dead.contains(poll)) {
                    size--;
                    continue;
                }

                if (poll.equals(target)) {
                    return level;
                }

                StringBuilder sb = new StringBuilder(poll);
                for (int i = 0; i < 4; i++) {
                    char position = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (position == '9' ? 0 : position -'0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (position == '0' ? 9 : position -'0' - 1) + sb.substring(i + 1);

                    if (!dead.contains(s1) && !visit.contains(s1)) {
                        queue.offer(s1);
                        visit.add(s1);
                    }

                    if (!dead.contains(s2) && !visit.contains(s2)) {
                        queue.offer(s2);
                        visit.add(s2);
                    }
                }

                size --;
            }
            level++;
        }

        return -1;
    }
}