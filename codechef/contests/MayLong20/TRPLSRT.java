import java.util.ArrayList;
import java.util.Scanner;

public class TRPLSRT {
    public static Scanner scn = new Scanner(System.in);
    public static void inversion(int[] arr , int i , int j ){
        // swap method
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void shiftOperation(int[] arr  ,int i , int j , int k, ArrayList<Integer> ar){
        inversion(arr ,i,j);
        inversion(arr,i,k);
        ar.add(i) ; ar.add(j) ; ar.add(k);
    }
    public static int swapCycle(int[] arr , int i , int par, ArrayList<Integer> list , boolean[] used ){
        if(arr[i]==par){
            used[i]=true;
            list.add(i);
            return 0;
        }
     
        used[i]=true;
        list.add(i);
        int count = swapCycle(arr, arr[i], par,list, used);
        return count+1;
    }
    public static  void triplesort(int[] arr, int total){
        int n = arr.length;
        ArrayList<ArrayList<Integer>> al= new ArrayList<>();
        ArrayList<ArrayList<Integer>> oddal= new ArrayList<>();
        int totalswaps=0;
    
        boolean[] used = new boolean[n];
        for(int i=1;i<n;i++){
            if(arr[i]!=i && used[i]==false){
              
                ArrayList<Integer> list = new ArrayList<>();
                int count =swapCycle(arr, i, i,list , used);
                totalswaps+=count;
                if(list.size()%2==1)
                 al.add(list);
                 else oddal.add(list); // making odd list to add all odd in last
        }
    }
    for(ArrayList<Integer> itr :oddal) al.add(itr);
    if(totalswaps%2==1) {System.out.println(-1);  // odd inversion in total return -1
        return;
    }
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    int lp =-1 , lq=-1;
    for(int i=0;i<al.size();i++){ // list of cycles
        ArrayList<Integer> ar = new ArrayList<>();
        if(al.get(i).size()%2 ==1){ // even list
            // p q r 
            for(int j=0;j<al.get(i).size()-2;j=j+3){
                int p = al.get(i).get(0);
                int q = al.get(i).get(j+1);
                int r = al.get(i).get(j+2);
                shiftOperation(arr, p, q, r,ar);
            }
            ans.add(ar);
        }
        else{
                int lj=0;
                if(lp!=-1 && lq!=-1){
                    shiftOperation(arr, lp, lp,  al.get(i).get(0),ar);
                    shiftOperation(arr,  al.get(i).get(0),  al.get(i).get(1), lp,ar);
                    lj=1;
                }
                if(al.get(i).size()>2)
                for(int j=lj;j<al.get(i).size()-2;j=j+3){
                    int p = al.get(i).get(0);
                    int q = al.get(i).get(j+1);
                    int r = al.get(i).get(j+2);
                    shiftOperation(arr, p, q, r,ar);
                }
                lp =  al.get(i).get(0);
                lq =  al.get(i).get( al.get(i).size()-1);
                ans.add(ar);
        }
     

    }
    if(ans.size()>total){
        System.out.println(-1);
    }
    else{
        for(ArrayList<Integer> itr : ans){
            for(Integer i: itr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
 
}
    public static void main(String[] args){
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[n+1];
            for(int i=1;i<n+1;i++){
                arr[i]= scn.nextInt();
            }
            triplesort(arr,k);
        }
    }
}