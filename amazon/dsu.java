public class dsu {
    static int n =6;
   static int[] par = new int[n];
   static int[] rank = new int[n];
    
   public static void dsu1(int[][] arr){
      
       for(int i =0;i<n;i++){
           par[i]=i;
           rank[i]=1;
       }
       for(int i =0;i<arr.length;i++){
           int u = arr[i][0];
           int v = arr[i][1];
           merge(u,v);
            
           
       }
       for(int i =0;i<n;i++){
        System.out.println(par[i]);

      }
      
   }
   public static int find(int u){
       if(u==par[u]) return u;
       return par[u] = find(par[u]);
   }
   
  public static void merge(int u , int v ){
       int l1 = find(u);
       int l2 = find(v);
       if(l1!=l2){
        if(rank[l1]>rank[l2]){
        // jiski rank jyada vahi parent bnega
            par[l2]=l1;
        
       }
           else if(rank[l1]>rank[l2]){
           par[l1]=l1;
           }
       else{
            par[l2]=l1;
            rank[l1]++;
       }
    }
  }
  public static void main(String[] args) {
    int[][] arr = {{1,2},{3,2},{4,1},{4,3}};
   dsu1(arr);
      
    
}
}
