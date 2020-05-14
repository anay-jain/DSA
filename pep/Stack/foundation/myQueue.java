public class myQueue{
    int st=0;
    int end=0;
    int sizeCount=0;
    int[] que ;
    myQueue(){
        int[] que = new int[10];
    }
    myQueue(int size){
        int[] que = new int[size];
    }
    public void push(int x){
        if(sizeCount<=que.length){
            System.out.println("Queueu is filled");
            return ;
        }
        sizeCount++;
        que[end]=x;
        end = (end+1)%que.length;
       
    }
    public  int pop(){
        if(sizeCount==0){
            System.out.println("queue is empty");
            return -1;
        }
        int rv = que[st];
        que[st]=0;
        st =(st+1)%que.length;
        return rv;
    }
    
}