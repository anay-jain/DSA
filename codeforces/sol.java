public class sol{
    public static class Note{
        private String msg;
        int id;
        Note(){

        }
        Note(String msg){
            this.msg=msg;
        }
        public string getMessage(){
            return this.msg;
        }
        // update
        public  setMessgae(String s){
            this.msg=s;
        }
    }
    public static void main(String[] args){
        Note s = new Note("this is my msg..oka");
        s.msg="dsnfgs";
        System.out.println(s.getMessage());
        
    }
}