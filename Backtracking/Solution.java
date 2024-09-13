package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // https://neetcode.io/problems/subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;
    }

    public static void dfs(
        int[] nums, 
        int start, 
        List<List<Integer>> res, 
        List<Integer> subset
        )
    {
        if(start>=nums.length)
            // Do not use SHALLOW COPY here. Use DEEP COPY.
            // Shallow copy will add the reference to the subset list to the res list, and not a copy of the
            // current state of the subset list. Since the subset list is modified in subsequent recursive
            // calls, all references in res will point to the same list, leading to error.
            res.add(new ArrayList<>(subset));
        else{
            // add the element to the subset and start recursive call
            subset.add(nums[start]);
            dfs(nums, start+1, res, subset);
            //remove the element from the subset and start backtracking call
            subset.remove(subset.size()-1);
            dfs(nums, start+1, res, subset);
        }
    }

    // https://neetcode.io/problems/combination-target-sum
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int curSum = 0;
        dfs(nums, 0, res, list, target, curSum);
        return res;
    }

    public static void dfs(
        int[] nums,
        int start,
        List<List<Integer>> res,
        List<Integer> list,
        int target,
        int curSum
    )
    {   if(curSum == target)
            res.add(new ArrayList<>(list));
        else if(curSum > target || start >= nums.length)
            return;
        else{
            // add element to the list and start recursive call from same element
            list.add(nums[start]);
            curSum  += nums[start];
            dfs(nums, start, res, list, target, curSum);

            // remove element from the list and start backtracking call
            list.remove(list.size()-1);
            curSum -= nums[start];
            dfs(nums, start+1, res, list, target, curSum);
        }  
    }

    // https://neetcode.io/problems/permutations
    // T: O(n!)
    // S: O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, res, list);
        return res;
    }

    public static void dfs(
        int[] nums,
        List<List<Integer>> res,
        List<Integer> list
    )
    {
        if(list.size() == nums.length)
            res.add(new ArrayList<>(list));
        else{
            for(int i=0; i<nums.length; i++){
                if(!list.contains(nums[i])){
                    list.add(nums[i]);
                    dfs(nums, res, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    // https://neetcode.io/problems/search-for-word
    public boolean exist(char[][] board, String word) {
        int nrow, ncol;
        nrow = board.length;
        ncol = board[0].length;
        boolean[][] visited = new boolean[nrow][ncol];

        for(int i=0; i<nrow; i++){
            for(int j=0; j<ncol; j++){
                if(dfs(i, j, 0, board, word, visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(
        int r, int c, int i, 
        char[][] board, 
        String word, 
        boolean[][] visited
    ){
        if(i == word.length())
            return true;
        if(
            r<0 || c<0 ||
            r>=board.length || c>= board[0].length ||
            board[r][c] != word.charAt(i) ||
            visited[r][c]
        )
            return false;

        visited[r][c] = true;
        boolean check = (
            dfs(r+1, c, i+1, board, word, visited) ||
            dfs(r-1, c, i+1, board, word, visited) ||
            dfs(r, c+1, i+1, board, word, visited) ||
            dfs(r, c-1, i+1, board, word, visited)
        );
        visited[r][c] = false;
        
        return check;
    }

    // https://neetcode.io/problems/subsets-ii
    // T.C. = O(n.2^n)
    // S.C = O(n.2^n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curSubset = new ArrayList<>();
        dfs(0, nums, curSubset, result);
        return result;
    }

    public static void dfs(
        int i, 
        int[] nums, 
        List<Integer> curSubset, 
        List<List<Integer>> result
    ){
        if(i == nums.length){
            result.add(new ArrayList<>(curSubset));
        }
        else{
            // all subsets that includes nums[i]
            curSubset.add(nums[i]);
            dfs(i+1, nums, curSubset, result);
            curSubset.remove(curSubset.size() - 1);
            // all subsets that don't include nums[i]
            while(i+1<nums.length && nums[i] == nums[i+1])
                i++;
            dfs(i+1, nums, curSubset, result);
        }
    }

    // https://leetcode.com/problems/combination-sum-ii/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, candidates, target, list, res);
        return res;
    }

    public static void dfs(
        int start,
        int[] candidates,
        int target,
        List<Integer> list,
        List<List<Integer>> res
    )
    {
        if(target == 0)
            res.add(new ArrayList<>(list));
        else if(target < 0)
            return;
        else{
            int prev = -1;
            for(int i=start; i<candidates.length; i++){
                if(prev == candidates[i])
                    continue; // handling duplicates
                if(target < candidates[i])
                    break;
                list.add(candidates[i]);
                dfs(i+1, candidates, target - candidates[i], list, res);
                list.remove(list.size() - 1);
                prev = candidates[i];
            }
        }
    }

    // https://neetcode.io/problems/combinations-of-a-phone-number
    // T.C.: O(4^n)
    public static List<Character> getMapping(int num){
        switch(num){
            case 2:
                return Arrays.asList('a','b','c');
            case 3:
                return Arrays.asList('d','e','f');
            case 4:
                return Arrays.asList('g','h','i');
            case 5:
                return Arrays.asList('j','k','l');
            case 6:
                return Arrays.asList('m','n','o');
            case 7:
                return Arrays.asList('p','q','r', 's');

            case 8:
                return Arrays.asList('t','u','v');
            case 9:
                return Arrays.asList('w','x','y', 'z');
            default:
                return Arrays.asList();
        }
    }
    public static void dfs(int i, StringBuilder cur, String digits, List<String> res){
        if(cur.length() == digits.length()  && cur.length() != 0)
            res.add(cur.toString());
        else if(i >= digits.length())
            return;
        else{
            List<Character> charMaps = getMapping(digits.charAt(i) - '0');
            for(char x: charMaps){
                cur.append(x);
                dfs(i+1, cur, digits, res);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(0, cur, digits, res);
        return res;
    }

    // https://neetcode.io/problems/palindrome-partitioning
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(0, s, res, list);
        return res;
    }

    public static void dfs(
        int start, 
        String s,
        List<List<String>> res,
        List<String> list
    ){
        if(start == s.length()){
            res.add(new ArrayList<>(list));
        }
        else{
            for(int i=start; i<s.length(); i++){
                String sub  = s.substring(start, i+1);
                if(isPalindrome(sub)){
                    list.add(sub);
                    dfs(start+sub.length(), s, res, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}

