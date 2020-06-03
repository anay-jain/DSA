import java.util.ArrayList;
import java.util.Scanner;

 class cc{
    public static void check(String a , String b , int n){
        ArrayList<Integer> arr = new ArrayList<>();
        boolean flag= false;
        for(int i=0;i<n;i++){
            if(b.charAt(i)>a.charAt(i)){
                System.out.println(-1);
                return;
            }
        }
        // int freq[] =  new int[26];
        //         for(int i=0;i<b.length();i++){
        //     int ch = (int)b.charAt(i)-'a';
        //     freq[ch]++;
        // }
        if()
        int counta =0 , countb =0;
        for(int i=0;i<n;i++){
            if(b.charAt(i)=='a'){
                if(a.charAt(i)=='b'){
                   countb++;
                }
                if(a.charAt(i)=='a'){
                    counta++;
                }
                arr.add(i);
            }

        }
        if(countb==0){
            System.out.println(0);
            return;
        }
        else if(counta >=1 && countb>0){
            System.out.print(arr.size()+" ");
            for(int j=0;j<arr.size();j++){
                System.out.print(arr.get(j)+" ");
            }
            System.out.println();
        }
        else{
            System.out.println(-1);
            return;
        }
       
    }

    // public static void check(String a , String b , int n){
    //     int freq[] =  new int[26];
    //     for(int i=0;i<b.length();i++){
    //         int ch = (int)b.charAt(i)-'a';
    //         freq[ch]++;
    //     }
    // for(int i =0;i<n;i++){
    //         ArrayList<Integer> arr = new ArrayList<>();
    //         boolean isvalid = false;
    //         for(int m =25;m>=0;m--){
    //             if(freq[m]!=0){

    //             }
    //         }
    //         if(a.charAt(i)-b.charAt(i)>=0){
    //             if(a.charAt(i) != b.charAt(i)){
    //                 isvalid = true;
    //             }
    //             arr.add(i+1);
    //         }
    //         if(arr.size()>2 && isvalid){
    //         {System.out.print(arr.size()+" ");
    //             for(int j=0;j<arr.size();j++){
    //                 System.out.print(arr.get(j)+" ");
    //             }   
    //             System.out.println("");
    //     }

    //     }
    // }
    // }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
        int n = scn.nextInt();
        String a = scn.next();
        String b = scn.next();
        check(a, b,n);
        }
    }

    
}