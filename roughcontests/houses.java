import java.util.*;

public class houses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        int n=8;
        int ar[] = new int[n];
        for (int j = 0; j < n; j++)
            ar[j] = scan.nextInt();
        int k = scan.nextInt();
        scan.close();
        System.out.println(houses_(ar, k));
        // for (int i : arr) {
        //     System.out.print(i + " ");
        // }
    }
    public static List<Integer> houses_(int[] ar, int n){
        
        for(int i=0;i<n;i++){
            ar=   housesess(ar, n);
          }
        List<Integer> arr = new ArrayList<Integer>();
        // Collections.addAll(arr, ar);
        for(int i=0;i<ar.length;i++){
            arr.add(ar[i]);
        }
        return arr;
        // return Arrays.asList(ar);

    }
    public static int[] housesess(int[] houses, int n) {
        int[] arr = new int[houses.length];
        for (int i = 0; i < houses.length; i++) {
            int a = i - 1 < 0 ? 0 : houses[i - 1];
                int b=  i + 1 == houses.length ? 0 : houses[i + 1];
                arr[i]=a^b;
        }

        // for (int ele : houses) {
        //     res.add(ele);
        // }
        return arr;
    }

}