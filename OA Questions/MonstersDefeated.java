import java.util.*;

public class MonstersDefeated {

    public static int monstersDefeated(int n, int initial_exp, int[] power, int[] bonus){
        int count = 0;
        int currExp = initial_exp;
        List<List<Integer>> stats = new ArrayList<>();
        for(int i =0; i<n; i++){
            List<Integer> x = new ArrayList<>();
            x.add(power[i]);
            x.add(bonus[i]);
            stats.add(x);
        }

        Collections.sort(stats, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b){
                return a.get(0).compareTo(b.get(0));
            }
        });

        for(int i=0; i<n; i++){
            if(stats.get(i).get(0) <= currExp){
                count++;
                currExp += stats.get(i).get(1);
            }
            else{
                break;
            }
        }
        
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int initial_exp = sc.nextInt();

        int[] power = new int[n];
        int[] bonus = new int[n];

        for(int i=0; i<n; i++){
            power[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            bonus[i] = sc.nextInt();
        }
        System.out.println("Number of monsters defeated: "+monstersDefeated(n, initial_exp, power, bonus));
    }    
}
