import java.util.*;

class Solution{
    // https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int gap = 0;
        int noMatch = 1;
        
        for(int i=0; i<cards.length; i++){
            if(hm.containsKey(cards[i])){
                noMatch = 0;
                gap = i - hm.get(cards[i]) + 1;
                if(gap < min)
                    min = gap;
            }
            hm.put(cards[i], i);
        }
        if(noMatch == 1) return -1; else return min;
     }

     // https://leetcode.com/problems/k-divisible-elements-subarrays/description/
     public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> st = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            int count = 0;
            StringBuilder sub = new StringBuilder();

            for(int j=i; j<n; j++){
                if(nums[j]%p == 0)
                    count++;
                if(count>k)
                    break;
                sub.append(nums[j] + " ");
                st.add(sub.toString());
            }
        }

        return st.size();
    }
}