/*1 Activity selection 
 * You are given n activities with their start and end times. Select the maximum number of activities that can be 
 * performed by a single person, assuming that a person can only work on a single activity at a time. 
 * ## Activities are sorted according to end time.
*/

// import java.util.*;
// public class Greedy_algo {

//     public static void main(String[] args) {
//         int start[] = {1, 3, 0, 5, 8, 5};
//         int end[] = {2, 4, 6, 7, 9, 9};    

//         //end time basis sorted
//         int maxAct = 0 ;
//         ArrayList<Integer> ans = new ArrayList<>();

//         maxAct = 1;
//         ans.add(0);

//         int lastEnd = end[0];

//         for(int i=0; i<end.length; i++){
//             if(start[i] >= lastEnd){
//                 maxAct++;
//                 ans.add(i);
//                 lastEnd = end[i];
//             }
//         }
//         System.out.println("max activities = "+ maxAct);
//         for(int i=0; i<ans.size(); i++){
//             System.out.print("A"+ans.get(i)+" ");
//         }
//         System.out.println();
//     }
// }

/*2 Fractional Knapsack
 * Given the weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * value = [60, 100, 120]
 * weight = [10, 20, 30]
 * ans = 240
 * W = 50 
*/

import java.util.*;
public class Greedy_algo {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};

        int w = 50;

        double ratio[][] = new double[val.length][2];
        //0th col => index , 1st col => ratio
        
        for(int i=0; i<val.length; i++){
            ratio[i][0] = i; 
            ratio[i][1] = val[i]/ (double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalVal = 0;

        for(int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalVal += val[idx];
                capacity -= weight[idx];
            }else{
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("final value = " + finalVal);
    }
}