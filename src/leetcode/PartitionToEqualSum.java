package leetcode;

import java.util.Arrays;

public class PartitionToEqualSum {

	public PartitionToEqualSum() {
		// TODO Auto-generated constructor stub
	}
	public boolean canThreePartsEqualSum(int[] A) {
		int sum = 0;
        //calculate overall sum
        for (int n : A)
            sum += n;
        //check if it's divisible by 3
        if (sum % 3 != 0)
            return false;
        //exact sum of each segment
        sum /= 3;

        int curSum = 0;
        int numOfSegments = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            //check if we can form a segment
            if (curSum == sum && numOfSegments <= 1) {
                numOfSegments++;
                curSum = 0;
            }
        }
        //if we have 2 segments formed greedily and sum of leftover is also 1/3 of overall sum 
        return (numOfSegments == 2 && curSum == sum);
    }
}
