import java.util.ArrayList;
public class knightproblem{
    public static void main(String[] args){
        //  boolean[][] path={{false,false,false},
        //                   {false,false,true},
        //                   {false,false,false},
        //                  };
        String keys[][] = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"s","t","u"},{"v","w","x"},{"y","z"}};
        // System.out.println(floodFill_eightCallsonlyone(0,0,3,3,new boolean[4][4],0));
        System.out.println(keyPad_01("245", keys));
    }
    public static boolean isValid(int x,int y,boolean[][] isdone){
      if(x>=0 && y>=0 && x<isdone.length && y<isdone[0].length && !isdone[x][y]) return true;
      return false;
    }


    public static int floodFill_eightCalls(int sr,int sc,int er,int ec,boolean[][] isdone){
        if(sr==er && sc==ec){
        //  ArrayList<String> base=new ArrayList<>();
        //  base.add("");
         return 1;
        }
        int count=0;
        int[][] dir={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        // String[] dirName={"D","R","U","L","1","3","4","2"};
    
        // ArrayList<String> myAns=new ArrayList<>();
        
        isdone[sr][sc]=true;
        for(int d=0;d<dir.length;d++){
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
             
        if(isValid(x,y,isdone)){
            count+=floodFill_eightCalls(x,y,er,ec,isdone);
            // for(String s:calls){
            //   myAns.add(dirName[d] + s);
            // }  
          }
        }

        // isdone[sr][sc]=false;

        return count;


    }
     public static ArrayList <String> floodFill_eightCallsonlyone(int sr,int sc,int er,int ec,boolean[][] isdone, int count){
        if(sr==er && sc==ec){
            
          ArrayList<String> base=new ArrayList<>();
         base.add("");
         count =1;
         return base;
        }
         ArrayList<String> myAns=new ArrayList<>();
    //    if(count==1){
    //        return myAns;
    //    }
        int[][] dir={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
         String[] dirName={"D","R","U","L","1","3","4","2"};
    
        
        
        isdone[sr][sc]=true;
        for(int d=0;d<dir.length;d++){
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
             
        if(isValid(x,y,isdone) && count !=1){
            ArrayList <String> calls =floodFill_eightCallsonlyone(x,y,er,ec,isdone,count);
            for(String s:calls){
              myAns.add(dirName[d] + s);
             }  
          }
        }

        isdone[sr][sc]=false;
      
        return myAns;


    }
    // public static ArrayList <String> Knighttour()
    //  public static ArrayList <String> knighttour(int sr,int sc,int er,int ec,int[][] path){
    //     if(sr==er && sc==ec){
            
    //       ArrayList<String> base=new ArrayList<>();
    //      base.add("");
    //      count =1;
    //      return base;
    //     }
    //      ArrayList<String> myAns=new ArrayList<>();
    // //    if(count==1){
    // //        return myAns;
    // //    }
    //     int[][] dir={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    //      String[] dirName={"D","R","U","L","1","3","4","2"};
    
        
        
    //     isdone[sr][sc]=true;
    //     for(int d=0;d<dir.length;d++){
    //         int x=sr+dir[d][0];
    //         int y=sc+dir[d][1];
             
    //     if(isValid(x,y,isdone) && count !=1){
    //         ArrayList <String> calls =knighttour(x,y,er,ec,path);
    //         for(String s:calls){
    //           myAns.add(dirName[d] + s);
    //          }  
    //       }
    //     }

    //     isdone[sr][sc]=false;
      
    //     return myAns;


    // }

        public static ArrayList<String> keyPad_01(String ques, String[][] keys){
            if( ques.length()==0){
                ArrayList <String> base = new ArrayList<>();
                base.add("");
                return base;
            }
            char ch = ques.charAt(0);
            // int q = Character.getNumericValue(ch);
            int q = ch-'0';
            // System.out.println(q);
        
            ques = ques.substring(1);
            ArrayList <String> ans = new ArrayList<>();
            
            for(int i=0;i< keys[q].length;i++){
                ArrayList <String> arr = keyPad_01(ques, keys);
                for(String s: arr){
                    ans.add(keys[q][i] + s);
                }
            }

            return ans;
        }

        

}