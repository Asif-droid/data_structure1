package offlinr_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DynamicProgramming {
    static int[][] dp;
    static long [][] dp2;
    static int []Arrfaces;
    static long mod=1000000007;

    static int noofWays(int n,int sum){     //O(n*s*s)

        if(sum==0 && n==0){
            return 1;
        }
        else if(sum<0 || n==0){
            return 0;
        }
        if(dp[n][sum]!=-1){
            return dp[n][sum];
        }

        int ans=0;
        for(int i=1;i<=Arrfaces[n];i++){
            ans+=noofWays(n-1,sum-i)%mod;
        }
        return dp[n][sum]=ans;
    }
    static long noofWays2(int n,int s){          //O(n*s)
        for(int i=1;i<=n;i++){
            for(int j=i;j<=s;j++){
                ///if(j<=Arrfaces[i])
                dp2[i][j]=  ((dp2[i][j-1]+dp2[i-1][j-1])%mod);

                if(j>Arrfaces[i]){
                    dp2[i][j]-=dp2[i-1][j-Arrfaces[i]-1];
                    if(dp2[i][j]<0){
                        dp2[i][j]+=mod;
                    }
                }
            }
        }
        return dp2[n][s];

    }


    public static void main(String[] args) {
        File file=new File("src\\offlinr_10\\input.txt");

        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n=scanner.nextInt();
        int sum=scanner.nextInt();
        dp=new int[n+1][sum+1];
        dp2 = new long[n+1][sum+1];
        Arrfaces=new int[n+1];
        Arrfaces[0]=-1;
        for(int i=1;i<=n;i++){
            int faces=scanner.nextInt();
            Arrfaces[i]=faces;

        }

        for (int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=-1;
                dp2[i][j]=0;
            }
        }
        dp2[0][0]=1;

        System.out.println(noofWays2(n,sum));
        //System.out.println(noofWays(n,sum));

    }
}
