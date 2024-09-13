import java.util.*;


class ArrayProblems{

	// Reverse the elements of an array
	// Inplace
	public static int[] reverseArray(int[] inputArray){
		int n = inputArray.length;
		int i,j, temp;
		for(i=0, j=n-1; i < n/2; i++, j--){
			temp = inputArray[i];
			inputArray[i] = inputArray[j];
			inputArray[j] = temp;
		}
		return inputArray;
	}
	
	// Rotate the elements of an array left by k steps
	public static int[] rotateArray(int[] inputArray, int k){
		int n = inputArray.length;
		int i, j, temp;
		for(i=0; i<k; i++){
			temp = inputArray[0];
			for(j=0; j<n-1; j++){
				inputArray[j] = inputArray[j+1];
			}
			inputArray[j] = temp;
		}
		return inputArray;
	}

    // Squares of a sorted array
    public static int[] sortedSquares(int[] nums) {
        for(int i=0; i< nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }


    // Brute force - O(n^3)
    public static String longestPalindrome1(String s) {
        int max = -9999;
        String longest, sub;
        longest="";
        int len = s.length();
        int p, e, i, j, isPalindrome;
        
        for(p=0; p<len; p++){
            for(e=p; e<len; e++){
                isPalindrome = 1;
                sub = "";
                for(i=p, j=e; i<=e; i++, j--){
                    if(s.charAt(i) == s.charAt(j)){
                        sub += s.charAt(i);
			            System.out.println(sub);
                    }
                    else{
                        isPalindrome = 0;
                    }
                }
                if(isPalindrome == 1 && e-p > max ){
                    longest = sub;
                    max = e-p;
                }
            }
        }
        return longest;
    }

    // Expand in the middle - O(n^2)
    public String longestPalindrome2(String s) {
        String res = "";
        int resLen = 0;
        int i, l, r;
        for(i=0; i< s.length(); i++){
            // odd length
            l = i; r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > resLen){
                    resLen = r-l+1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            // even length
            l = i; r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > resLen){
                    resLen = r-l+1;
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }

    // isPalindrome
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int l, r;
        for(l=0, r=s.length()-1; l<s.length()/2; l++, r--){
            if(s.charAt(l) != s.charAt(r))
                return false;
        }
        return true;
    }

    // https://leetcode.com/problems/next-permutation/description/
    public void nextPermutation(int[] nums) {
        int[] A = nums;
        int i = nums.length - 2;
        while(i >= 0 && A[i] >= A[i+1]) i--;
        if(i>=0){
            int j = nums.length - 1;
            while(A[j] <= A[i]) j--;
            swap(A, i, j);
        }
        reverse(A, i+1, A.length-1);
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void reverse(int[] A, int i, int j){
        while(i < j) swap(A, i++, j--);
    }
    


	// https://leetcode.com/problems/two-sum/description/
	public static int[] twoSum(int[] inputArray, int target){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] result = new int[2];

		for(int i=0; i<inputArray.length; i++){
			if (hm.containsKey(inputArray[i])){
				result[0] = hm.get(inputArray[i]);
				result[1] = i;
			}
			else{
				hm.put(target-inputArray[i], i);
			}
		}
		return result;
	}

    // https://leetcode.com/problems/contains-duplicate/description/
	// Method 1 Using HashMap
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int x: nums){
            if(hm.containsKey(x)){
                hm.replace(x, hm.get(x)+1);
            }
            else{
                hm.put(x, 1);
            }
        }

        for(int x: hm.keySet()){
            if(hm.get(x) > 1)
                return true;
        }
        return false;
    }

    // Method 2 Sorting
    public static boolean containsDuplicate2(int[] nums){
    	Arrays.sort(nums);
    	
    	int prev = nums[0];
    	for(int i=1; i< nums.length; i++){
    		if(nums[i] == prev)
    			return true;
    		else{
    			prev = nums[i];
    		}
    	}
    	return false;
    }


 	// https://leetcode.com/problems/valid-anagram/description/
    public static boolean isAnagram1(String s, String t){
    	if(s.length() != t.length()) return false;
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	Character s_char, t_char;

    	for(int i=0; i<s.length(); i++){
    		s_char = s.charAt(i);
    		t_char = t.charAt(i);

    		if(hm.containsKey(s_char)){
    			hm.replace(s_char, hm.get(s_char)+1);
    		}
    		else{
    			hm.put(s_char, 1);
    		}

    		if(hm.containsKey(t_char)){
    			hm.replace(t_char, hm.get(t_char)-1);
    		}
    		else{
    			hm.put(t_char, -1);
    		}
    	}

    	for(Character x: hm.keySet()){
    		if(hm.get(x) != 0)
    			return false;
    	}
    	return true;
    }

    public static boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        for (int val : count.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }
	
    
	// Pascal's Triangle. Find element at (r, c)
	public static long nCr(int n, int r){
		long res = 1;
		for(int i=0; i<r; i++){
			res = res * (n-i);
			res = res/(i+1);
		}

		return res;
	}

	public static long pascalTriangle1(int r, int c){
		long element = nCr(r-1, c-1);
		return element;
	}

	// Pascal's Triangle. Given row number n, find the n-th row
	public static long[] pascalTriangle2(int n){
		ArrayList<Long> resList = new ArrayList<>();
		long res = 1;
		resList.add(res);

		// current_element = prev_element * (rowNumber - colIndex)/colIndex
		for(int i=1; i<n; i++){
			res = res * (n-i);
			res = res / i;
			resList.add(res);
		}
		long[] result = new long[resList.size()];
		for(int i=0; i<resList.size(); i++){
			result[i] = resList.get(i);
		}
		return result;
	}

	// https://leetcode.com/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            result.add(generateRow(i));
        }
        return result;
    }

    public List<Integer> generateRow(int n){
        List<Integer> row = new ArrayList<>();
        int res = 1;
        row.add(res);

        for(int col=1; col<n; col++){
            res = res * (n-col);
            res = res / col;
            row.add(res);
        }
        return row;
    }

	// https://leetcode.com/problems/maximum-subarray/
	// O(n)
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(curSum < 0)
                curSum = 0;
            curSum += nums[i];
            if(curSum > max)
                max = curSum;
        }
        return max;
    }

	// Is Palindrome?
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Ba-z0-9]", "");
        s = s.toLowerCase();
        int i, n;
        n = s.length();
        for(i=0; i<n; i++){
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return true;
    }

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int res = 0;
        int lowest = prices[0];
        int n = prices.length;
        
        for(int i=1; i<n; i++){
            if(prices[i] < lowest)
                lowest = prices[i];
            res = Math.max(res, prices[i] - lowest);
        }
        return res;
    }
	// Sliding window approach
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

	// Transpose of a matrix
	// Brute force
	public static int[][] transposeMatrix(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int temp[][] = new int[n][m];
		for(int i = 0; i<m; i++){
			for(int j=0; j<n; j++){
				temp[i][j] = matrix[j][i];
			}
		}

		return temp;
	}

	// Transpose of a matrix
	// In place
	public static void transposeMatrix_(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int temp = 0;
		for(int i = 0; i<m; i++){
			for(int j=i+1; j<n; j++){
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	// Rotate an nxn matrix
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp = 0;

        //transposing the matrix
        for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse all the rows of the matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

	// https://leetcode.com/problems/merge-intervals/
	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		int n = intervals.length;
		int start, end;

		Arrays.sort(intervals, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return a[0] - b[0];
			}
		});

		for(int i=0; i<n; i++){
			start = intervals[i][0];
			end = intervals[i][1];
			if(!res.isEmpty() && res.get(res.size()-1)[1] >= start){
				start = res.get(res.size()-1)[0];
				end = Math.max(end, res.get(res.size()-1)[1]);
				res.remove(res.size() - 1);
			}
			int[] next = new int[2];
			next[0] = start;
			next[1] = end;
			res.add(next);
		}

		return res.toArray(new int[res.size()][]);
	}

	// https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                i++;
            }
            else{
                for(int k=nums1.length-1; k>i; k--){
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
                m++;
            }
        }
        while(j<n){
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }

	// https://leetcode.com/problems/find-the-duplicate-number/
    public int findDuplicate(int[] nums) {
        int currIndex = 0;
        int prevIndex = 0;
        while(nums[currIndex] != -1){
            prevIndex = currIndex;
            currIndex = nums[currIndex];
            nums[prevIndex] = -1;
        }
        return currIndex;
    }


	public static void main(String[] args){
		int[][] matrix = {{1,2,3}, {4,5,6}};
		transposeMatrix_(matrix);

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		
	}	
}