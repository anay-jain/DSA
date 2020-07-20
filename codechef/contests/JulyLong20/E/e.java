import java.util.Scanner;

public class e {
    public class node{
        int data;
        int index;
        node(int data, int index){
            this.data = data;
            this.index= index;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            node[] arr1 = new node[9];
            node[] arr2 = new node[9];
            for(int i =0;i<n;i++){
                int a = scn.nextInt();
                int b = scn.nextInt();
        
            }
            for(int i=0;i<9;i++){
                if(arr1[i]>arr2[i]){
                    // move it in 2
                    
                }
            }
        }
    }
}