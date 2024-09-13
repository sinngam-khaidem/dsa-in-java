public class BinarySearch {
    public static int binarySearchIterative(int[] A, int n,int data){
        int l,r,mid;
        l = 0; r = n-1;
        while(l<r){
            mid = (r-l)/2;
            if(A[mid] == data)
                return mid;
            else if(A[mid] > data)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    // Time: O(logn) Space: O(1)
    public static int binarySearchRecursive(int[] A, int low, int high, int data){
        int mid = low + (high-low)/2;
        if(low>high) return -1;
        if(A[mid] == data) return mid;
        else if(A[mid] > data) return binarySearchRecursive(A, low, mid-1, data);
        else return binarySearchRecursive(A, mid+1, high, data);
    }

    public static void main(String[] args){
        int[] nums = {23,56,72,90, 180};
        int target = 90;
        int result = binarySearchRecursive(nums, 0, nums.length-1, target);
        System.out.println("Element is found at index " + result);
    }
}
