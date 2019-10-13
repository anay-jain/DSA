import java.util.ArrayList;
public class mazepath{
    public static void main(String[] args){

    }

        // basecase
        if(sr==er &&  ec==es){
            ArrayList <String> finalans = new ArrayList<>();
            finalans.append(recAns);
            return finalans;
        }

       
        
        ArrayList <String> finalans = mazepath1(sr+1, s+1, ec, er);
        if(sr<er){
            String recAns = "h" + mazepath1(sr+1, se, ec, er);
        }
        if(se<ec){
            String recAns = "v" + mazepath1(sr, se+1, ec, er);
        }

        return finalans;

    }

    

}