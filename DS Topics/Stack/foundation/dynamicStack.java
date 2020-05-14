public class dynamicStack extends myStack{
    // push fn
    public dynamicStack(){
        // System.out.println("jf");
    }
    public dynamicStack(int size){
        super(size);
    }
    @Override
    public void push(int x){
        if(this.idx == st.length-1){
            int[] temp = new int[st.length*2];
            for(int i =0;i<st.length;i++){
             temp[i]=st[i];
             
            }
     this.st = temp;   }
   
     super.push(x);
    }
   
}