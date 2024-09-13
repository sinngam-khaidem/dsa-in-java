public class TwoPointers {
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum(int[] numbers, int target) {
        int l, r, n, curSum;
        n = numbers.length;
        l = 0;
        r = n-1;
        int[] result = new int[2];

        while(l<r){
            curSum = numbers[l] + numbers[r];
            if(curSum == target){
                result[0] = l+1;
                result[1] = r+1;
                return result;
            }
            else if(curSum > target)
                r--;
            else
                l++;
        }
        return result;
    }

    // https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int maxArea = 0;
        int curArea = 0;
        int n = height.length;
        int l, r;
        l = 0; r = height.length-1;
        // Linear time solution: O(n)
        while(l < r){
            curArea = Math.min(height[l], height[r]) * (r-l);
            maxArea = Math.max(curArea, maxArea);
            if(height[l] >= height[r])
                r--;
            else
                l++;
        }
        return maxArea;
    }
}
