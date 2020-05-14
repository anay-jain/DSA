import  java.util.Scanner;

public class addtwoarray{

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int i = scn.nextInt();
        int[] arr1 = new int[i];
        arrinput(arr1, i);
        int j = scn.nextInt();
        int[] arr2 = new int[j];
        arrinput(arr2 , j);
        int z = i>j?i:j;
        i=i-1;j=j-1;
        // z=z+1;
        int[] arr3= new int[z+1];
        for(int it=0;it<z+1;it++){
            arr3[it]=0;
        }
        int carry=0;
        while(i>=0 || j>=0 || carry!=0){
            int sum=0;
            if(i>=0){
                sum+=arr1[i];
            }
            if(j>=0){
                sum+=arr2[j];
            }
            sum+=carry;
            int remainder = sum%10;
            carry = sum/10;
            arr3[z]=remainder;
            i--;j--;z--;


        }
        
        for(int it =0;it< arr3.length;it++){
            if(it==0){
                if(arr3[it]==0){
                    continue;
                }
                else{
                    System.out.print(arr[it] + " ");
                }
            }
            System.out.print(arr[it] + " ");
            
    }
    }
    public static void arrinput(int[] arr, int n){
        for(int it=0;it<n;it++){
            arr[it]= scn.nextInt();
        }
    }

   
}