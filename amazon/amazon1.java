public class amazon1 {
    
    Scanner scn = new Scanner(System.in);
    public boolean isRobotBounded(String instructions) {
        int x =0;
        int y =0;
        int count =0;
        for(int i =0;i<instructions.length();i++){
            if(instructions.charAt(i)=='L'){
                count++;
            }
            else if(instructions.charAt(i)=='R'){
                count--;
            }
            else{
                count = count %4;
                switch (count) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x--;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x++;
                        break;
                    default:
                        break;
                }
            }

        }
        if(x==0 && y ==0) return true;
        else return false;
    }
    public static void main(String args[]){
        
    }
}
