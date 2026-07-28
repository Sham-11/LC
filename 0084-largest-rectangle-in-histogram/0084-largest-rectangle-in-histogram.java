class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int element = stack.peek();
                stack.pop();

                int nse = i;
                int pse;

                if (stack.isEmpty()) {
                    pse = -1;
                } else {
                    pse = stack.peek();
                }

                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {

            int element = stack.peek();
            stack.pop();

            int nse = n;
            int pse;

            if (stack.isEmpty()) {
                pse = -1;
            }else{
                pse = stack.peek();
            }

            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }

        return maxArea;
    }
}