class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int[] answer = new int[n];

        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currTemp = temperatures[currDay];
            if (currTemp >= hottest) {
                hottest = currTemp;
                continue;
            }

            int days = 1;
            while(temperatures[currDay + days] <= currTemp) {
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }

        return answer;
    }
}