import java.util.*;

class graph{
	
		public static class Edge{
		int v1;
		int v2;
		int weight;
		
		Edge(int v1,int v2,int weight){
			this.v1=v1;
			this.v2=v2;
			this.weight=weight;
		}
	}
		
		public static void addEdge(ArrayList<ArrayList<Edge>> graph,int v1,int v2,int weight){
			
			graph.get(v1).add(new Edge(v1,v2,weight));
			graph.get(v2).add(new Edge(v2,v1,weight));
		}
		
		public static void display(ArrayList<ArrayList<Edge>> graph){
			
			for(int v=0;v<graph.size();v++){
				System.out.print(v+"->");	
				
				for(int e=0;e<graph.get(v).size();e++){
					Edge out=graph.get(v).get(e);
				System.out.print("[ "+out.v1+" "+out.v2+" "+ out.weight+"]");	
				}
				System.out.println('.');
			}
		}
		
		public static boolean hasPath(int s,int d,ArrayList<ArrayList<Edge>> graph,boolean[] visited){

			if(s==d){
				return true;
			}
			
			visited[s]=true;
			
			for(int e=0;e<graph.get(s).size();e++){
				int nbr=graph.get(s).get(e).v2;
				if(visited[nbr]==false){
				  boolean ans=hasPath(nbr,d,graph,visited);
					if(ans==true){
					return true;
					}
				}	
			}
		return false;}
		
	    public static void printAllPath(int s,int d,ArrayList<ArrayList<Edge>> graph,boolean[] visited,String psf){
			if(s==d){
				System.out.println(psf+" "+s);
				return; 
			}
				visited[s]=true;
			
			for(int e=0;e<graph.get(s).size();e++){
				int nbr=graph.get(s).get(e).v2;
				if(visited[nbr]==false){
					printAllPath(nbr,d,graph,visited,psf+" "+s);
				}
			}
			visited[s]=false;
		}
		
		
		static String minpath;
		static String maxpath;
		static int mindis=Integer.MAX_VALUE;
		static int maxdis=Integer.MIN_VALUE;;
	//	static ArrayList<String> paths=new ArrayList<>();
	//	static ArrayList<Integer> dis=new ArrayList<>();
		
		public static void minmaxPath(int s,int d,ArrayList<ArrayList<Edge>> graph,boolean[] visited,String psf,int dsf){
			if(s==d){
				psf=psf+s;
				
				if(dsf>maxdis){
					maxdis=dsf;
					maxpath=psf;
				}
				if(dsf<mindis){
					mindis=dsf;
					minpath=psf;
					
				}
				
				//path.add(psf+" "+s);
				//distance.add(dsf+graph.get(s).get(0).weight);
				return; 
			}
				visited[s]=true;
			for(int e=0;e<graph.get(s).size();e++){
				int nbr=graph.get(s).get(e).v2;
				if(visited[nbr]==false){
					minmaxPath(nbr,d,graph,visited,psf+" "+s,dsf+graph.get(s).get(e).weight);
				}
			}
			visited[s]=false;
		}
			
		static String cpath;
		static String fpath;
		static int cdis=Integer.MAX_VALUE;
		static int fdis=Integer.MIN_VALUE;;
			
			public static void ceilfloorPath(int s,int d,ArrayList<ArrayList<Edge>> graph,boolean[] visited,String psf,int dsf,int factor){
			if(s==d){
				psf=psf+s;
				if(dsf>factor&&dsf<cdis){
					cpath=psf;
					cdis=dsf;
				}
				if(dsf<factor&&dsf>fdis){
					fpath=psf;
					fdis=dsf;
				}
				return; 
			}
				visited[s]=true;
			for(int e=0;e<graph.get(s).size();e++){
				int nbr=graph.get(s).get(e).v2;
				if(visited[nbr]==false){
					ceilfloorPath(nbr,d,graph,visited,psf+" "+s,dsf+graph.get(s).get(e).weight,factor);
				}
			}
			visited[s]=false;
		}
		
			public static void hamiltonian(int s,ArrayList<ArrayList<Edge>> graph,boolean[] visited,ArrayList<Integer> psf,int os){
				
				// we can use string here but it is not efficient for the edges number greater than 9 bcz in comparision of
				// psf.size and graph.size we will count 10th node as 2 length in string but in arraylist it will consitute length or size 1;
				// and instead of passing os=orignal source we can use psf.get(0); the 1st element is our orignal source
				
				if(psf.size()==graph.size()-1){
					psf.add(s);
					for(int i=0;i<psf.size();i++){
					System.out.print(psf.get(i)+" ");
					}
					boolean cycledetected=false;
					
					for(int i=0;i<graph.get(s).size();i++){
						int nbr=graph.get(s).get(i).v2;
						if(nbr==os){
							cycledetected=true;
							break;
						}
						
					}
					
					if(cycledetected){
						System.out.println('*');
					}else{
						System.out.println('.');
					}
				psf.remove(psf.size()-1);		
				return;}
				
			visited[s]=true;
			psf.add(s);
			for(int e=0;e<graph.get(s).size();e++){
				int nbr=graph.get(s).get(e).v2;
				if(visited[nbr]==false){
					hamiltonian(nbr,graph,visited,psf,os);
				}
			}
			psf.remove(psf.size()-1);
			visited[s]=false;
			}
	
			
			public static class thelper implements Comparable<thelper>{
				int vtx;
				String psf;
				int dsf;
				
				thelper(int vtx,String psf,int dsf){
					this.vtx=vtx;
					this.psf=psf;
					this.dsf=dsf;
				}
				
				public int compareTo(thelper other){
					
					return this.dsf-other.dsf;
				}
				
			}
			
			
			Queue<int> qu=new LinkedList<>();
			
			public static boolean bfslevel(ArrayList<ArrayList<Edge>> graph,int src,int dest){
				LinkedList<thelper> queue=new LinkedList<>();
				thelper rn=new thelper(src,""+src,0);
				queue.addLast(rn);
				
				boolean[] visited=new boolean[graph.size()];
//				visited[rn.vtx]=true;
				while(queue.size()>0){
				
				thelper cp=queue.getFirst();
				queue.removeFirst();
	//			System.out.println(cp.psf+" @"+cp.dsf);
				if(visited[cp.vtx]==true){
					continue;
				}else{
					visited[cp.vtx]=true;
				}
				if(cp.vtx==dest){
					System.out.println(cp.psf+" ");
					return true;
				}
				
				for(int e=0;e<graph.get(cp.vtx).size();e++){
					Edge nn=graph.get(cp.vtx).get(e);
					if(visited[nn.v2]==false){
					thelper ns=new thelper(nn.v2,cp.psf+" "+nn.v2,cp.dsf+nn.weight);
					queue.addLast(ns);
					}
				}
				
				}
			return false;}
	
			public static void gccComponent(ArrayList<ArrayList<Edge>> graph,int src,ArrayList<Integer> scomp,boolean[] visited){
				LinkedList<thelper> queue=new LinkedList<>();
				thelper rn=new thelper(src,""+src,0);
				queue.addLast(rn);
				
				
				while(queue.size()>0){
				
				thelper cp=queue.getFirst();
				queue.removeFirst();
				if(visited[cp.vtx]==true){
					continue;
				}else{
					visited[cp.vtx]=true;
					
				}
				
					scomp.add(cp.vtx);
					
				
				
				for(int e=0;e<graph.get(cp.vtx).size();e++){
					Edge nn=graph.get(cp.vtx).get(e);
					if(visited[nn.v2]==false){
					thelper ns=new thelper(nn.v2,cp.psf+" "+nn.v2,cp.dsf+nn.weight);
					queue.addLast(ns);
					}
				}
				
				}
			}
						
			public  static void gcc(ArrayList<ArrayList<Edge>> graph,ArrayList<ArrayList<Integer>> comps){
				
				boolean[] visited=new boolean[graph.size()];
				for(int i=0;i<graph.size();i++){
					if(visited[i]==false){
						ArrayList<Integer> scomp=new ArrayList<>(); 
							gccComponent(graph,i,scomp,visited);
							comps.add(scomp);	
					}	
				}	
			}
			
			public  static boolean isConnected(ArrayList<ArrayList<Edge>> graph){
				
				boolean[] visited=new boolean[graph.size()];
				ArrayList<Integer> scomp=new ArrayList<>(); 
				gccComponent(graph,0,scomp,visited);
				
				
			
			return scomp.size()==graph.size();}
							
			public static boolean iscyclicComp(ArrayList<ArrayList<Edge>> graph,int src,boolean[] visited){
				LinkedList<thelper> queue=new LinkedList<>();
				thelper rn=new thelper(src,""+src,0);
				queue.addLast(rn);
				
				while(queue.size()>0){
				thelper cp=queue.getFirst();
				queue.removeFirst();
				if(visited[cp.vtx]==true){
					return true;
				}else{
					visited[cp.vtx]=true;
				}
				
				for(int e=0;e<graph.get(cp.vtx).size();e++){
					Edge nn=graph.get(cp.vtx).get(e);
					if(visited[nn.v2]==false){
					thelper ns=new thelper(nn.v2,cp.psf+" "+nn.v2,cp.dsf+nn.weight);
					queue.addLast(ns);
					}
				}
				}
				
			return false;}
			
			public  static boolean iscyclic(ArrayList<ArrayList<Edge>> graph){
				
				boolean[] visited=new boolean[graph.size()];
				
				for(int i=0;i<graph.size();i++){
					
					if(visited[i]==false){
						 
							boolean ans=iscyclicComp(graph,i,visited);
							if(ans==true){
									return true;
							}
					}	
				}
			return false;}
						
			public static boolean isBiparComp(ArrayList<ArrayList<Edge>> graph,int src,int[] visited){
				LinkedList<thelper> queue=new LinkedList<>();
				thelper rn=new thelper(src,""+src,0);
				queue.addLast(rn);
				queue.addLast(null);
				int level=1;
				while(queue.size()>0){
				thelper cp=queue.getFirst();
				queue.removeFirst();
				if(cp==null){
					level++;
					if(queue.size()>0){
					queue.addLast(null);	
					}
					continue;
				}
				if(visited[cp.vtx]==0){
					visited[cp.vtx]=level;
				}else{	
					if(level%2!=visited[cp.vtx]%2){
						return false;
					}else continue;
				}
				for(int e=0;e<graph.get(cp.vtx).size();e++){
					Edge nn=graph.get(cp.vtx).get(e);
					if(visited[nn.v2]!=0){
					thelper ns=new thelper(nn.v2,cp.psf+" "+nn.v2,cp.dsf+nn.weight);
					queue.addLast(ns);
					}
				}
			  }
			return true;}
						
			public static boolean isBipartite(ArrayList<ArrayList<Edge>> graph){
				int[] visited=new int[graph.size()];
				for(int i=0;i<graph.size();i++){
					if(visited[i]==0){		 
							boolean ans=isBiparComp(graph,i,visited);
							if(ans==false){
									return ans;
							}
					}	
				}
			return true;
			}
			
			public static void dijkasstra(ArrayList<ArrayList<Edge>> graph,int src){
				
				PriorityQueue<thelper> queue=new PriorityQueue<>();
				thelper rn=new thelper(src,""+src,0);
				queue.add(rn);
				boolean[] visited=new boolean[graph.size()];
				
				while(queue.size()>0){
				
				thelper cp=queue.peek();
				queue.remove();
				if(visited[cp.vtx]==true){
					continue;
				}else{
					visited[cp.vtx]=true;	
				}
					System.out.println(cp.vtx+" via"+cp.psf+" @"+cp.dsf);
					
				for(int e=0;e<graph.get(cp.vtx).size();e++){
					Edge nn=graph.get(cp.vtx).get(e);
					if(visited[nn.v2]==false){
					thelper ns=new thelper(nn.v2,cp.psf+" "+nn.v2,cp.dsf+nn.weight);
					queue.add(ns);
					}
				}
				
				}	
			}
						
			public static class primshelp implements Comparable<primshelp>{
				int vtx;
				int p;
				int lodis;
				primshelp(int vtx,int p,int lodis){
					this.vtx=vtx;
					this.p=p;
					this.lodis=lodis;
				}
				public int compareTo(primshelp other){	
					return this.lodis-other.lodis;
				}
			}
			
			public static void prims(ArrayList<ArrayList<Edge>> graph,int src){
			ArrayList<ArrayList<Edge>> mst=new ArrayList<>();
			for(int i=0;i<graph.size();i++){
				mst.add(new ArrayList<Edge>());
			}	
			
				PriorityQueue<primshelp> queue=new PriorityQueue<>();
				primshelp rn=new primshelp(src,-1,0);
				queue.add(rn);
				boolean[] visited=new boolean[graph.size()];
				
				while(queue.size()>0){
				
				primshelp cp=queue.peek();
				queue.remove();
				if(visited[cp.vtx]==true){
					continue;
				}else{
					visited[cp.vtx]=true;	
				}
				
				if(cp.p!=-1){
					addEdge(mst,cp.vtx,cp.p,cp.lodis);	
				}
				
					
				for(int e=0;e<graph.get(cp.vtx).size();e++){
					Edge nn=graph.get(cp.vtx).get(e);
					if(visited[nn.v2]==false){
					primshelp ns=new primshelp(nn.v2,cp.vtx,nn.weight);
					queue.add(ns);
					}
				}
				}	
				
				for(int v=0;v<mst.size();v++){
				System.out.print(v+"->");	
				
				for(int e=0;e<mst.get(v).size();e++){
					Edge out=mst.get(v).get(e);
				System.out.print("[ "+out.v1+" "+out.v2+" "+ out.weight+"]");	
				}
				System.out.println('.');
			}
				
				
				
			}
			
			public static class KEdge implements Comparable<KEdge>{
		int v1;
		int v2;
		int weight;
		
		KEdge(int v1,int v2,int weight){
			this.v1=v1;
			this.v2=v2;
			this.weight=weight;
		}
		
		public int compareTo(KEdge other){
			
			return this.weight-other.weight;
			
		}
		
		
	}
			
			public static void kruskals(ArrayList<ArrayList<Edge>> graph){
				
				ArrayList<ArrayList<Edge>> mst=new ArrayList<>();
				for(int i=0;i<graph.size();i++){
					mst.add(new ArrayList<Edge>());
				}
				PriorityQueue<KEdge> queue=new PriorityQueue<>();
				for(int v=0;v<graph.size();v++){
					for(int e=0;e<graph.get(v).size();e++){
						Edge edge=graph.get(v).get(e);
						if(edge.v1<edge.v2){
							KEdge ke=new KEdge(edge.v1,edge.v2,edge.weight);
							queue.add(ke);
						}
					}
				}
				
				int[] dsp=new int[graph.size()];
				int[] dsr=new int[graph.size()];
				for(int i=0;i<graph.size();i++){
					dsp[i]=i;
					dsr[i]=1;
				}
				while(queue.size()>0){
						KEdge cp=queue.peek();
						queue.remove();
						int v1sl=findp(dsp,cp.v1);
						int v2sl=findp(dsp,cp.v2);
						if(v1sl!=v2sl){
							addEdge(mst,cp.v1,cp.v2,cp.weight);
							merge(dsp,dsr,v1sl,v2sl);
						}
				}
				display(mst);
			}
			
			public static void merge(int[] dsp,int[] dsr,int v1sl,int v2sl){
			
				if(dsr[v1sl]<dsr[v2sl]){
					dsr[v1sl]=0;
					dsp[v1sl]=v2sl;
					
				}else if(dsr[v1sl]>dsr[v2sl]){
					
					dsr[v2sl]=0;
					dsp[v2sl]=v1sl;
					
				}else{
					
					dsr[v1sl]=0;
					dsr[v2sl]+=1;
					dsp[v1sl]=v2sl;
					
					
				}
			
			
			
			}
			
			public static int findp(int[] dsp,int v){
				
				// complexity is nlog*n==e;
				
				if(v==dsp.length){
					return 0;
				}
				if(dsp[v]==v){
					return v;
				}
				else{
					
					int vv=dsp[v];
						// this is for path compression
					int par= findp(dsp,vv);
					dsp[v]=par;
					return par;
				}
				
				
			}
			
			public static class profitEdge implements Comparable<profitEdge>{
				char job;
				int dl;
				int profit;
		
				profitEdge(char v1,int v2,int weight){
					this.job=v1;
					this.dl=v2;
					this.profit=weight;
				}
		
			public int compareTo(profitEdge other){
			
				return this.profit-other.profit;
			
			}
		
		
			}
			
			public static void jobSeq(String jobs,int[] deadline,int[] profits){
				
				PriorityQueue<profitEdge> queue=new PriorityQueue<>(Collections.reverseOrder());
				int max=0;
				for(int i=0;i<deadline.length;i++){
					if(max<deadline[i]){
						max=deadline[i];
					}
				}
				char[] ans=new char[max+1];;
				int[] dsp=new int[max+1];
				for(int v=0;v<dsp.length;v++){
					dsp[v]=v;
				}
				for(int v=0;v<deadline.length;v++){
					profitEdge pe=new profitEdge(jobs.charAt(v),deadline[v],profits[v]);
					queue.add(pe);
							}
			
				while(queue.size()>0){	
						profitEdge cp=queue.peek();
						queue.remove();
						if(dsp[cp.dl]==cp.dl){
							dsp[cp.dl]=cp.dl-1;
							ans[cp.dl]=cp.job;
						}else{
							int vtx=findp(dsp,cp.dl);
							if(vtx-1>=0){
							int root=findp(dsp,vtx-1);
							dsp[vtx]=root;
							ans[vtx]=cp.job;
							}
						}
					}
				for(int i=0;i<ans.length;i++){
					System.out.print(ans[i]);
				}
			}
			
			static int mytime=0;
			
			public static void aPb(ArrayList<ArrayList<Edge>> graph,int[] disc,int[]low,int[] parent,boolean[] visited,int src,boolean[] ap){		
			//articulationPointandbridge
					
				low[src]=disc[src]=++mytime;
				visited[src]=true;
				int counter=0;	
				
				for(int i=0;i<graph.get(src).size();i++){	
					
				Edge e=graph.get(src).get(i);	
				int nbr=e.v2;
				if(parent[src]==nbr){
				// nothing to do
				
				}else if(visited[nbr]==true){
					low[src]=Math.min(low[nbr],disc[src]);
				
				}else{
				parent[nbr]=src;
				aPb(graph,disc,low,parent,visited,nbr,ap);
				low[src]=Math.min(low[nbr],low[src]);
				
				if(parent[src]==-1){
					counter++;
					if(counter==2){
						ap[src]=true;
					}
					
					
				}else{
					if(disc[src]<=low[nbr]){
						ap[src]=true;
						if(disc[src]<low[nbr]){
							System.out.println(src+" to "+nbr);
							
						}
					}
					
					
				}
				
				
				}					
				
				}
			
			}
			
			public static void floydwarshall(int[][] mat){
				
				
				for(int i=0;i<mat.length;i++){
					for(int s=0;s<mat.length;s++){
						for(int d=0;d<mat.length;d++){
					
								if(i==s||i==d||s==d){
									continue;
								}else if(mat[s][i]==Integer.MAX_VALUE||mat[i][d]==Integer.MAX_VALUE){
									continue;
								}else{
									
								mat[s][d]=Math.min(mat[s][d],mat[s][i]+mat[i][d]);	
								}		
						}
					}	
				}
				
				for(int i=0;i<mat.length;i++){
					for(int j=0;j<mat[0].length;j++){
						System.out.print(mat[i][j]+" ");
					}
					System.out.println();
				}
			}
			
			// belmen ford..
			public static class edges{
				int u;
				int v;
				int wt;
				edges(int u,int v,int wt){
					this.u=u;
					this.v=v;
					this.wt=wt;
				}
				
			}
			
			public static class pair{
				int first;
				String second;
				
				pair(int first,String second){
					this.first=first;
					this.second=second;
				}
			}
			
			public  static void belmen(ArrayList<edges> graphh){
				ArrayList<pair> result=new ArrayList<>();
				for(int i=0;i<7;i++){
					result.add(new pair(Integer.MAX_VALUE,""));
				}
				int s=0;
				
				pair p=result.get(s);
					p.first=0;
					p.second="";	
			for(int v=0;v<7-1;v++){
				for(int e=0;e<graphh.size();e++){
					edges edge=graphh.get(e);
				// sv=su+uv;
				
				if(result.get(edge.u).first!=Integer.MAX_VALUE&&result.get(edge.u).first+edge.wt<result.get(edge.v).first){		
					result.get(edge.v).first=result.get(edge.u).first+edge.wt;
					result.get(edge.v).second=result.get(edge.u).second+edge.v;		
				}
				}
			}
				for(int e=0;e<graphh.size();e++){
					edges edge=graphh.get(e);
				// sv=su+uv;
				if(result.get(edge.u).first!=Integer.MAX_VALUE&&result.get(edge.u).first+edge.wt<result.get(edge.v).first){	
					System.out.println("negative cycle");
						return;
				}
				}
				for(int i=0;i<result.size();i++){
					System.out.println(result.get(i).first+"  "+result.get(i).second);	
				}
			}
			
			// belmen ford ended.
			
			public static void main(String[] args){
			ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
			int n=7;
			for(int i=0;i<n;i++){
				graph.add(new ArrayList<Edge>());
			}				
			
			addEdge(graph,0,1,10);
			addEdge(graph,0,3,40);
			addEdge(graph,1,2,10);
			addEdge(graph,2,3,10);
		//	addEdge(graph,2,5,5);
//			addEdge(graph,3,4,2);
			addEdge(graph,4,5,3);
			addEdge(graph,4,6,8);
			addEdge(graph,5,6,3);
			display(graph);
			
			
			int[][] mat={
					{Integer.MAX_VALUE,2,8,10},
					{Integer.MAX_VALUE,Integer.MAX_VALUE,3,7},
					{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1},
					{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}
			};
	//		floydwarshall(mat);
			
			
			ArrayList<edges> graphh=new ArrayList<>();
			graphh.add(new edges(0,1,2));
			graphh.add(new edges(1,2,3));
			graphh.add(new edges(2,3,4));
			graphh.add(new edges(3,4,5));
	//		graphh.add(new edges(4,2,-6));
			graphh.add(new edges(4,5,4));
	//		graphh.add(new edges(5,6,-10));
			graphh.add(new edges(6,3,2));
			boolean[] visited=new boolean[graph.size()];
//			ceilfloorPath(1,6,graph,visited,"",0,50);
//			System.out.println(cpath+"   "+fpath);
			
			//  new file in eclipse for topological sort in graph package
			
			
			
			
			
			
			
			
			
			
			
			
			
//			belmen(graphh);
			
						// edges[] graphh=new edges[7];

			
			
			
		//	boolean[] visited=new boolean[n];
		//	ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
			
		//	kruskals(graph);
			
		//	String names = "abdecfghijklmnopqrstuv";
		//int[] deadlines = { 4, 2, 3, 1, 8, 3, 2, 1, 2, 6, 5, 7, 9, 2, 6, 5, 2, 7, 6, 9, 1, 6 };
		//int[] profits = { 100, 67, 94, 44, 33, 77, 11, 99, 37, 
			//			  76, 34, 47, 78, 44, 39, 75, 49, 33, 48, 92, 43, 90 };
//			jobSeq(names,deadlines,profits);			  
			
		
//			int[] disc=new int[graph.size()];
//			int[] low=new int[graph.size()];
//			int[] parent=new int[graph.size()];
//			parent[0]=-1;
//			boolean[] visited=new boolean[graph.size()];
//			boolean[] ap=new boolean[graph.size()];
//			aPb(graph,disc,low,parent,visited,0,ap);
//			for(int i=0;i<ap.length;i++){
//				if(ap[i]==true){
//					System.out.print(i+" ap ");
//				}
				
//			}
			
			
			//gcc(graph,comps);
			//dijkasstra(graph,0);
		//	prims(graph,0);
		//	for(int i=0;i<comps.size();i++){
		//		System.out.println(comps.get(i));
		//	}
	//		System.out.println(isConnected(graph));
	//		System.out.println(iscyclic(graph));
			System.out.println(isBipartite(graph));
//			bfslevelprintlevel(graph,0,6);
//			
//			System.out.println(bfslevel(graph,0, 6));
//			ArrayList<Integer> psf=new ArrayList<>();
//			hamiltonian(1,graph,visited,psf,1);
	//		System.out.println(hasPath(0,6,graph,visited));
//			minmaxPath(0,6,graph,visited,"",0);
				
//				System.out.println(maxpath+'@'+maxdis);
//				System.out.println(minpath+'@'+mindis);
				
	//		public static void ceilfloorPath(int s,int d,ArrayList<ArrayList<Edge>> graph,boolean[] visited,String psf,int dsf,int factor){
				
//			ceilfloorPath(1,6,graph,visited,"",0,50,1);	
			
//			System.out.println(cpath+'@'+cdis);
//				System.out.println(fpath+'@'+fdis);
			
			
		}
}


//	public static void bfslevelprintlevel(ArrayList<ArrayList<Edge>> graph,int src,int dest){
//					// update required
//			LinkedList<thelper> queue=new LinkedList<>();
//				thelper rn=new thelper(src,""+src,0);
//				queue.addLast(rn);				
//				boolean[] visited=new boolean[graph.size()];
//				while(queue.size()>0){			
//				thelper cp=queue.getFirst();
//				queue.removeFirst();
//				if(visited[cp.vtx]==true){				continue;}else{visited[cp.vtx]=true;}
//				if(cp.vtx==dest){
//					System.out.print(cp.psf+" ");
				//	if(queue.getFirst()==)
				//}
			//else{
				
	//			for(int e=0;e<graph.get(cp.vtx).size();e++){
	//				Edge nn=graph.get(cp.vtx).get(e);
	//				if(visited[nn.v2]==false){
	//				thelper ns=new thelper(nn.v2,cp.psf+" "+nn.v2,cp.dsf+nn.weight);
		//			queue.addLast(ns);
					//}
//				}
//				}
//				}
//			}


//	public static boolean isConnected(ArrayList<ArrayList<Edge>> graph){				
//				boolean[] isVisitable=new boolean[graph.size()];
//				isVisitable[0]=true;
//				for(int i=1;i<graph.size();i++){			
//					for(int e=0;e<graph.get(i).size();e++){
//						Edge edge=graph.get(i).get(e);
//						if(isVisitable[edge.v2]){		
//							isVisitable[i]=true;
//							break;					}}}
//				boolean isConn=true;
				
//				for(int i=0;i<isVisitable.length;i++){
//				if(isVisitable[i]==false){
//				isConn=false;
//				break;			}}
//			return isConn;}
