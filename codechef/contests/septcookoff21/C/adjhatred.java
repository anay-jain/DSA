import java.util.Scanner;

public class adjhatred{
    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
            Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();
            while(t-->0){
                int n = scn.nextInt();
                int[] arr = new int[n];
                for(int i =0;i<n;i++){
                    arr[i]=scn.nextInt();
                }
                int odd =0;
                int even =0;
                // making odd even 
                int i=0;
                int j =n-1;
                while(i<j){
                    if(arr[i]%2==0 && arr[j]%2!=0){
                        even++;
                        odd++;
                        swap(arr,i,j);
                        i++;
                        j--;

                    }
                    else if(arr[i]%2!=0 && arr[j]%2==0){
                        even++;
                        odd++;
                        i++;
                        j--;
                    }
                    else if(arr[j]%2==0){
                        j--;
                        even++;
                    }
                    else{
                        i++;
                        odd++;
                    }
                }
                if(odd>=1 && even>=1){
                    for(int k =0 ;k <n;k++){
                        System.out.print(arr[k]+" ");
                    }
                    System.out.println("");
                }
                else{
                    System.out.println(-1);
                }
                }
                
            }
    }

