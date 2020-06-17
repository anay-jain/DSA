import java.util.Scanner;
public class Solution{
	public static void solve(String s ){
		int axis =1;
		int n = s.length;
		int max=1;
		for(int i =1;i<n-1;i++){
			int pre = i-1;
			int suf = i+1;
			while(pre>=0 && suf < n && s.charAt(pre)==s.charAt(suf)){
				pre--;
				suf++;
				Math.max(max, suf-pre+1);
			}
				int pre = i;
			int suf = i;
			while(pre>=0 && suf < n && s.charAt(pre)==s.charAt(suf)){
				pre--;
				suf++;
				Math.max(max, suf-pre+1);
			}

		}
		/*

while( n!= 0) { sum = sum + n% 10; newsum = newsum + sum; n = n/ 10; } return newsum;

//SIMPLEST WAY 
        while(input!=0) 
        { 
         tempSum += input%10; 
         finalSum += tempSum; 
          
         input/=10; 
        }

        •    Write a program to print the n number without using any loops? eg n=5 result= 5 4 3 2 1  
•    Find the longest palindrome in the given string.  
•    Given two arrays of integers in sorted way, find the common elements between them.  
		*/

	}
	public static void main(String[] args){
	Scanner scn = new Scanner(System.in);
	solve();
	}
}