import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] s;
    static boolean[] check;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;
            String [] input = str.split(" ");
            k = Integer.parseInt(input[0]);
            s = new int[k];
            check = new boolean[k];
            
            for(int i=0; i<k; i++) {
                s[i] = Integer.parseInt(input[i+1]);
            } 

            dfs(0,0);
            System.out.println();
        }
    }

    public static void dfs(int depth,int start) {
        if(depth == 6) {
            for(int i=0; i<k; i++) {
                if(check[i]){
                    System.out.print(s[i] + " ");
                }
            }
            System.out.println();
        }
        for(int i=start; i<k; i++) {
            check[i] = true;
            dfs(depth+1, i+1);
            check[i] = false;
        }
    }
}