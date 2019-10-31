import java.util.ArrayList;
public class mazepath{
    public static ArrayList<String> mp(int sr , int sc, int er , int ec){
        if(sr==er && sc==ec){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList <String> myans = new ArrayList<>();
        if(sr<er){
            ArrayList <String> horizontal = mp(sr+1, sc, er, ec);
        for(String s:horizontal){
            myans.add("h"+s);
        }
        }
        if(sc<ec){
            ArrayList <String> vertical = mp(sr,sc+1,er,ec);
            for(String s : vertical){
                myans.add("v"+s);
            }
        }
       
        return myans;
    }   
    public static void main(String[] args){
        System.out.println(mp(0, 0, 2, 2));

    }

}