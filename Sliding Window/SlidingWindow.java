import java.util.*;

public class SlidingWindow {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    // Time: O(n) Space: O(n)
    // Variable Length Sliding Window Problem
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int res = 0;

        Set<Character> hs = new HashSet<>();
        while(r < n){
            while(hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    // Time: O(n) Space: O(1)
    public int maxProfit_(int[] prices) {
        int l = 0;
        int r =  0;
        int n = prices.length;
        int max = 0;

        while(l<n && r<n){
            if(prices[l]<=prices[r]){
                max = Math.max(max, prices[r] - prices[l]);
            }
            else
                l = r;
            r++;
        }
        return max;
    }

    // https://leetcode.com/problems/permutation-in-string/
    public static boolean isPermutation(String s1, String s2){
        // Permutations will have the same character frequency
        if(s1.length() != s2.length()) return false;
        Map<Character, Integer> hm = new HashMap<>();
        int n = s1.length();

        for(int i=0; i<n; i++)
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        
        for(int i=0; i<n; i++){
            if(hm.getOrDefault(s2.charAt(i), 0) == 0)
                return false;
            hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int l = 0;
        int r = s1.length()-1;

        while(r < s2.length()){
            String sub = s2.substring(l, r+1);
            if(isPermutation(s1, sub)) return true;
            l++;
            r++;
        }
        return false;
    }

    
    public static double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        int n = nums.length;
        double curSum = 0;

        for(int i=0; i<k; i++)
            curSum += nums[i];
        res = Math.max(res, curSum);
        
        for(int i=k; i<n; i++){
            curSum += nums[i];
            curSum -= nums[i-k];
            res = Math.max(res, curSum);
        }
        return res/k;
        
    }

    public static void main(String[] args){
        int[] nums = {-1};
        int k = 1;

        System.out.println(findMaxAverage(nums, k));
    }
}
