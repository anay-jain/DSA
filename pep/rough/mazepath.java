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
        if(sc<ec && sr<er){
            ArrayList <String> diagonal = mp(sr+1,sc+1,er,ec);
            for(String s : diagonal){
                myans.add("d"+s);
            }
        }
        return myans;
    }   
    public static int mp_height(int sr, int sc , int er , int ec){
        if(sr==er && sc == ec){
            return 0;
        }
        int maxhei=0;
        if(sr<er){
           maxhei=Math.max(maxhei, mp_height(sr+1, sc, er, ec));
        }
        if(sc<er){
            maxhei = Math.max(maxhei , mp_height(sr, sc+1, er, ec));
        }
        return maxhei+1;
    }
    public ArrayList<String> mp_floodfill(int sr , int sc, int er , int ec){
        if(sr==er && sc ==ec){
            ArrayList <String> arr = new ArrayList<>();
        }
    }
    public static void main(String[] args){
        // System.out.println(mp(0, 0, 2, 2));
        System.out.println(mp_height(0,0,2,2));
    }


}