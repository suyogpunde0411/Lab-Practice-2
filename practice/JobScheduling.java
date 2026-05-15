import java.util.*;
class Job{
    char Id;
    int deadline;
    int profit;
    Job(char Id, int deadline,int profit){
        this.Id=Id;
        this.deadline=deadline;
        this.profit=profit;
    }
}

public class JobScheduling {
    public static void main(String[] args) {
        Job[] jobs={
            new Job('A', 2, 100),
             new Job('B', 1, 19),
                new Job('C', 2, 27),
                new Job('D', 1, 25),
                new Job('E', 3, 15)  
        };

        int n = jobs.length;
        int totalProfit = 0;
        char[] results = new char[n];
        boolean[] slot = new boolean[n];
        Arrays.sort(jobs,(a,b)->b.profit-a.profit); //descending order

        for(int i=0;i<n;i++){
            for(int j=Math.min(n,jobs[i].deadline)-1;j>=0;j--){
                if(!slot[j]){
                    slot[j]=true;
                    results[j]=jobs[i].Id;
                    totalProfit +=jobs[j].profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled jobs are :");
        for(int i=0;i<n;i++){
            if(slot[i]){
                System.out.print(results[i]+" ");
            }
        }
        System.out.println();
        System.out.println("Total profit :"+totalProfit);
    }
    
}