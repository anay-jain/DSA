import java.util.ArrayList;
import java.util.Scanner;
public class tns{
    
    public static void main(String[] args){

        int[] arr={0,1,0,1,1,1,0,1,0,1,1,1,0};
        // int[] arr2 ={1};
        // int arrnew[] = mergesort(arr, 0,arr.length);
        // displayarr(arrnew);
       
        int[] sortarr= sortoneandzero(arr);
        displayarr(sortarr);
        
    }
    public static void swap(int a , int b){
        int temp = a;
        a=b;
        b= temp;
    }
    public static int[] sortoneandzero(int[] arr){
        int i=0,j=arr.length-1,k=0;
       
        while(k!=arr.length){
            if(arr[i]!=0 && arr[j]!=1){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                
            }
            else if(arr[i]==0){
                i++;
            }
            else if(arr[j]==1){
                j--;
            }
            
            // System.out.print(arr1[k]);
            k++;
        }
        // displayarr(arr1);rn
        return arr;
      
    }
    

    public static int[] mergesort(int[] arr , int li , int ri){
        if(ri-li==0){
           int[] base = new int[1];
           base[0]= arr[li];
            return base;
        }

        int mid=(li+ri)/2;
        int arr1[]= mergesort(arr, li, mid);
        int arr2[]= mergesort(arr, mid+1 , ri);
        int newarr[]= mergesortedarray(arr1, arr2);
        return newarr;
    }
    public static void displayarr(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
       

    }
    public static int[] mergesortedarray(int[] arr1 , int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length || j<arr2.length){
            if(i<arr1.length && j<arr2.length){
                if(arr1[i]<arr2[j]){
                    arr[k]=arr[i];
                    i++;
                }
                else{
                    arr[k]=arr[j];
                    j++;
                
                }

            }
            else if(i<arr1.length){
                arr[k]=arr[i];
                i++;
            }
            else if(j<arr2.length){
                arr[k]=arr[j];
                j++;
            }
            k++;
        }

        return arr;
    }












    // public static void mergearr(int[] arr1 , int[] arr2){
    //     ArrayList<Integer> arr =new ArrayList<>();
    //     int n = arr1.length+arr2.length;
    //     int num1=0,num2=0,temp1=arr1[0],temp2=arr2[0];
    //     while(n!=0){
    //         if(num1<arr1.length){
                
    //             temp1=arr1[num1];
              
    //         }
    //         if(num2<arr2.length){
    //             temp2=arr2[num2];
               
    //         }
    //         if(temp1>temp2){
    //             arr.add(temp1);
    //             num1++;
    //         }
    //         else{
    //             arr.add(temp2);
    //             num2++;
    //         }
    //         n--;
    //     }
    //     for(int i: arr){
    //         System.out.print(i+" ");
    //     }
       
    // }
}