/*
 * Task:- Given the amount of petrol in each petrol pump and the distance to the next petrol pump. Find the minimum index of the petrol pump we can start and then visit every petrol pump.

The petrol pumps are placed in circular format so we can visit index 0 after index (N-1).

Brute Force Approach:- We can start from each index and check whether we are able to complete the loop. If not we start again from the next index. We keep on doing this till we get the first index from which we start and are able to complete the whole loop.

The time complexity of this approach will be O(N²) as for each index we traverse at the most N elements.
 */

import java.util.List;

public class TruckTour {

    static int truckTour(List<List<Integer>> petrolpumps){
        
        int sum = 0;
        int index = 0;

        for (int i = 0; i < petrolpumps.size(); i++) {
            List<Integer> value = petrolpumps.get(i);
            sum += value.get(0) - value.get(1);
            if(sum < 0 ){
                index = i + 1;
                sum = 0;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        
    }
}
