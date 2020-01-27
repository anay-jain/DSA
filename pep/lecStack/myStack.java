public  class myStack{
    int idx=0;
    int[] st ;
    public myStack(){
        this.st = new int[10];
    }
    public myStack(int size){
        this.st = new int[size];
    }
    public  void push(int x){
        if(idx==st.length){
            System.out.println("Stack is overflow");
            return ;
        }
         st[idx]=x;
        idx++;
       
    }
    // constructor me this. laga kar access karna hota hai
    public int top(){
        if(idx==0){
            System.out.println("Stack is empty");
            return -1;
        }
        return st[idx];
    }
    public int pop(){
        if(idx==0){
            System.out.println("Stack is Underflow");
            return -1 ;
        }
        int rv = st[idx];
        st[idx]=0;
        idx--;
        return rv;
    }
    public void print(){
        for(int i =idx-1;i>=0;i--){
            System.out.print(st[i]+" ");
        }
    }
    public int size(){
        return idx;
    }
    public boolean isEmpty(){
        return idx==0;
    }

}