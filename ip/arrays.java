import java.util.Arrays;
import java.util.Scanner;

public class arrays{

    public String orderlyQueue(String S, int K) {
        if(K>1) {
            char[] temp=S.toCharArray();
            Arrays.sort(temp);
            S = new String(temp);
        } else {
            String sTwice = S + S;
            for (int i = 1; i < S.length(); i++) {
                String tmp = sTwice.substring(i, i + S.length());
                S = (S.compareTo(tmp) > 0) ? tmp : S;
            }
        }
        return S;
    }
/*
    LEETCODE 556 
    Next Greater element 3

*/
public static void swap(char[] numCharArr , int first , int second){
    char temp = numCharArr[first];
    numCharArr[first] = numCharArr[second];
    numCharArr[second]=temp;
}

public static int justGreater(char[] numCharArr, int idx){
        int ele = (int)numCharArr[idx]-'0';
        int justGreaterEle = (int) numCharArr[idx+1]-'0';
        for(int i = idx+2 ; i< numCharArr.length;i++){
            int numFromChar = (int) numCharArr[i]-'0';
            if(ele<numFromChar&& numFromChar<justGreaterEle){
                justGreaterEle = numFromChar;
            }
        }
        return justGreaterEle;
    }

    public static int nextGreaterElement(int num) {
            String numString = Integer.toString(num);
            char[] numCharArr = numString.toCharArray();

            // find a dip
            int numCharArrLen  = numCharArr.length;
            int itr = numCharArr[numCharArrLen-1];
            int idx= numCharArrLen-1;
            for(int i = numCharArrLen-2 ; i>=0;i--){
                int numFromChar = (int)numCharArr[i]-'0';
                if(itr < numFromChar){
                    idx =i;
                    break;
                }
                itr = numFromChar;
            } 
            // find just greater element after dip
            int idxJustGreater = justGreater(numCharArr, idx);
            // swap number
            swap(numCharArr, idx, idxJustGreater);
            // sort the array 
            Arrays.sort(numCharArr, idx+1,numCharArrLen-1);
            String ansNumString = String.valueOf(numCharArr);
            int ansNum = Integer.parseInt(ansNumString);
            return ansNum;            
    }
    public static void main(String[] args) {
        int x =nextGreaterElement(201650);
        System.out.println(x);
    }
}