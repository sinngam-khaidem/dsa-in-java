public class Sorting {
    // O(n^2)
    public static void bubbleSort(int[] nums){
        int n = nums.length;
        int temp;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j] >= nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    

    public static void printArray(int[] nums){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 2, 8, 7, 6 };
        bubbleSort(nums);
        printArray(nums);
    }
}