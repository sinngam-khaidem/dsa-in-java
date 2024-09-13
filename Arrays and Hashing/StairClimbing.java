class StairClimbing {
    static int num = 0;
    public static int climbStairs(int n) {
        counting(n);
        return num;
    }

    public static void counting(int n){
        if(n == 0){
            num += 1;
        }
        else if(n >= 1)
            counting(n%1);
        else if(n >= 2)
            counting(n%2);
    }
    public static void main(String[] args){
        System.out.println(climbStairs(4));
    }
}