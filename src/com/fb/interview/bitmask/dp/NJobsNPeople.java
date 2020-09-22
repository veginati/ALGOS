package com.fb.interview.bitmask.dp;

/*Problem Statement

        Let there be N workers and N jobs. Any worker can be assigned to perform any job, incurring some cost that may vary depending on the work-job assignment. It is required to perform all jobs by assigning exactly one worker to each job and exactly one job to each agent in such a way that the total cost of the assignment is minimized.

        Input Format
        Number of workers and job: N
        Cost matrix C with dimension N*N where C(i,j) is the cost incurred on assigning ith Person to jth Job.

        Sample Input
        4

        [
        9 2 7 8
        6 4 3 7
        5 8 1 8
        7 6 9 4
        ]

        Sample Output
        13

        Constraints
        N <= 20
*/

public class NJobsNPeople {

    public static int calcualteCost(int job, int people, int n, int[][] cost, int[][] dp){

        if(job == n){
            return 0;
        }
        if(dp[job][people] >0){
            return dp[job][people];
        }

        int total = Integer.MAX_VALUE;
        for(int j=1;j<=n;j++){
            // if a person is available assign a job
            if( (1<<(j-1)&people) == 0) {
                total = Math.min(total, cost[job][j-1] + calcualteCost(job + 1, (1 << (j - 1) ^ people), n, cost,dp));
            }
        }
        dp[job][people] = total;
        return dp[job][people];
    }

    public static void main(String[] args) {

        int n=4;
        int[][] cost ={{9,2,7,8},{6,4,3,7},{5,8,1,8},{7,6,9,4}};
        int[][] dp = new int[n][1<<n];
        int output = calcualteCost(0,0,n,cost,dp);
        System.out.println(output);
    }
}
