//https://leetcode.com/problems/daily-temperatures/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int [] warmer = new int[len];

        Stack<Integer> st = new Stack<>();
        st.push(len - 1);

        for(int i = len - 2; i >= 0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
            if(!st.isEmpty())
               warmer[i] = st.peek() - i;
            st.push(i);
        }
        return warmer;
    }
}