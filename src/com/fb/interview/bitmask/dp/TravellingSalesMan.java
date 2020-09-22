package com.fb.interview.bitmask.dp;

public class TravellingSalesMan {

    public static int calculateDistance(int start, int mask, int currentCity, int n, int[][] distance, int[][] dp){

        if(currentCity == n){
            return distance[start][0];
        }

        if(dp[start][mask]>0){
            return dp[start][mask];
        }
        int totalDistance = Integer.MAX_VALUE;

        for(int i=2;i<=n;i++){
            if((1<<(i-1)&mask) == 0){
                totalDistance = Math.min(totalDistance, distance[start][i-1] + calculateDistance(i-1, 1<<(i-1)^mask, currentCity+1,n, distance, dp));
            }
        }
        dp[start][mask] = totalDistance;
        return totalDistance;
    }

    public static void main(String[] args) {

        int[][] distance =   { { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 } };

        int start =0;
        int[][] dp = new int[distance.length][1<<distance.length];

        int totalMinDistance = calculateDistance(start, 0,1,distance.length,distance,dp );
        System.out.println(totalMinDistance);
    }
}
