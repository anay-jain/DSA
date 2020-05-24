
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader in = new FastReader();
		Writer out = new Writer(System.out);
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));

		int t = in.nextInt();
		while(t-->0) {
        int n = in.nextInt();
        int[]arr1 = new int[n];
        for(int i =0;i<arr1.length;i++)
            arr1[i] = in.nextInt();
        boolean flag = false;
        HashMap<Integer,Integer>freqmap1 = new HashMap<>();
        HashMap<Integer,Integer>indexmap1 = new HashMap<>();
        for(int i =0;i<arr1.length;i++){
            
            if(indexmap1.containsKey(arr1[i])){
                int lastindex = indexmap1.get(arr1[i]);
                if(lastindex!=(i-1)){
                    flag = true;
                    break;
                }
                indexmap1.put(arr1[i],i);
            }
            else{
                indexmap1.put(arr1[i],i);
            }
            
        }
        for(int i = 0;i<arr1.length;i++){
            freqmap1.put(arr1[i],freqmap1.getOrDefault(arr1[i],0)+1);   
        }
        HashSet<Integer>set = new HashSet<>();
        for(Map.Entry<Integer,Integer>entry:freqmap1.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(set.contains(val)){
                flag  =true;
                break;
                
            }
            set.add(val);
        }
		if(flag){
		    System.out.println("NO");
		}
		else{
		      System.out.println("YES");

		}
	    	    
	}
		
		out.flush();
		out.close();
		
    }
}
	