import java.util.*;

public class Movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of movies");
        int n = sc.nextInt();

        int start[] = new int[n];
        int end[] = new int[n];

        System.out.println("Enter the start and end time for each movies");

        for(int i=0;i<n;i++){
            System.out.print("Movies "+ (i+1)+ " start and end time: ");
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int screens = 0; // tracks the current overlapping screen
        int maxScreens = 0; // tracks the peak number of screen ever used.
        int i = 0, j = 0; // pointer i to iterate over start and j to iterate over the end

        while(i < n){
            if(start[i] < end[j]){
                screens++; // a new movie starts -> need one more screen
                maxScreens = Math.max(maxScreens, screens);
                i++;
            }else{
                screens--; // a movie has ended -> free one screen.
                j++;
            }
        }
        System.out.println("Minimum number of screens needed: "+ maxScreens);
    }
}