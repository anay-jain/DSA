import java.util.ArrayList;

public class mystack{
    
    
    protected int idx=-1;
    protected int[] st;

    mystack(){
        this.st = new st[10];
    }
    mystack(int size){
        this.st = new st[size];
    
    }
    public void print(){
        for(int i =0;i<this.idx;i++){
            System.out.print(this.st[i]+" ");
        }
    }
    public int pop(){
        if(idx==-1){
            System.err.println("empty");
            return -1;
        }
        else{
            int rv = this.st[idx];
            this.st[idx]=0;
            idx--;
            return rv;
        }
    }
    public void push(int x){
        if(idx==st.length-1){
            System.err.println("overflow");


        }
        else{
            this.st[++idx]=x;
        }
    }
}