import java.util.*;

//import Graph.twentyonedec.bfs_pair;
//import Graph.twentyonedec.edge;

import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class sortvs{
	static class pair implements Comparable<pair> {

//		String s ;
//		int level= 0;
//		pair(String s,int level){
//			this.s = s;
//			this.level = level;
//		
//		}
		int value;
		int index;

		pair(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(pair o) {
			return this.value - o.value;
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws java.lang.Exception {
		FastReader in = new FastReader();
		int test = in.nextInt();
		for (int t = 0; t < test; t++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] arr = new int[n + 1];
			pair[] pairarr = new pair[n + 1];
			HashMap<Integer, Integer> map = new HashMap<>();
			HashMap<Integer, Integer> map1 = new HashMap<>();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			boolean[] vis = new boolean[n + 1];
			graph.add(new ArrayList<Integer>());
			pairarr[0] = new pair(0, 0);
			for (int i = 1; i <= n; i++) {
				arr[i] = in.nextInt();
				map.put(i, arr[i]);
				map1.put(arr[i], i);
				pair npair = new pair(arr[i], i);
				pairarr[i] = npair;
				graph.add(new ArrayList<Integer>());
			}
			if (m == 0) {
				int countswap = 0;
				for (int i = 1; i < arr.length; i++) {
					int nextnode = -1;

					if (!vis[i]) {
						vis[i] = true;
						if (i != map.get(i)) {
							int c = map.get(i);
							while (!vis[c]) {
								vis[c] = true;
								nextnode = map.get(c);
								c = nextnode;
								countswap++;
							}
						}
					}
				}

				System.out.println(countswap);
			} else {
		    	dsu d = new dsu(n);
				for (int i = 0; i < m; i++) {
					int u = in.nextInt();
					int v = in.nextInt();
		    		d.union(u, v);
					addedge(graph, u, v);
				}
		    	for(int val:d.parent)
		    		System.out.print(val+" ");

				boolean[]vis2 = new boolean[n+1];
				Arrays.sort(pairarr);
				int cycle= 1;
				int ans = 0;
				System.out.println();
				for(int i =1;i<pairarr.length;i++) {
					pair rpair = pairarr[i];

					if(!vis2[i]) {
						vis2[i] = true;
						if(rpair.value!= rpair.index) {
							
							pair npair = pairarr[rpair.index];
//							System.out.println(rpair.value+" "+rpair.index);
                            npair=rpair;
							while(!vis2[npair.index]) {
								
								vis2[npair.index] =true;

								npair = pairarr[npair.index];
								int pa = d.find(npair.value);
								int pb = d.find(npair.index);
//								System.out.println(npair.value+"->"+pa+" "+pb);
								if(pa!=pb) {
//									System.out.println("Hi");
									cycle++;
								}
							}		
						}
					}
				}
				System.out.print(cycle);
			}
		}

	}

	public static void gcchelper(ArrayList<ArrayList<Integer>> graph) {
		boolean[] vis = new boolean[graph.size()];

		for (int i = 0; i < graph.size(); i++) {
			if (!vis[i]) {
				ArrayList<Integer> list = newgcc(graph, vis, i);
				gccarr.add(list);
			}
		}

	}

	static ArrayList<ArrayList<Integer>> gccarr = new ArrayList<>();

	public static ArrayList<Integer> newgcc(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int s) {
//		int count =0;

		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Integer> que = new LinkedList<>();
		que.addLast(s);
		visited[s] = true;
		while (que.size() != 0) {
			int rpair = que.removeFirst();
			list.add(rpair);

			visited[rpair] = true;
			for (int i = 0; i < graph.get(rpair).size(); i++) {
				if (!visited[graph.get(rpair).get(i)]) {
					visited[graph.get(rpair).get(i)] = true;
					int nbr = graph.get(rpair).get(i);
					que.add(nbr);
				}
			}

		}

		return list;
	}

	public static void addedge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
//		if(u<0 || v < 0 || u>graph.size() || v > graph.size()) return;
//		else {
		graph.get(u).add(v);
		graph.get(v).add(u);
//		}

	}

	public static void display(ArrayList<ArrayList<Integer>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + " ----->  ");
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print("(" + graph.get(i).get(j) + ")");
			}
			System.out.println();
		}

	}

	public static String swapstring(String s, int i, int j) {
		StringBuilder strB = new StringBuilder(s);
		char l = strB.charAt(i), r = strB.charAt(j);
		strB.setCharAt(i, r);
		strB.setCharAt(j, l);
		return strB.toString();
	}

	static int count = 0;

	public static void swap(int[] arr, int a, int b, HashMap<Integer, Integer> map1) {
		count++;
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

		int temp1 = map1.get(arr[b]);
		map1.put(arr[b], map1.get(arr[a]));
		map1.put(arr[a], temp1);

	}

	public static class dsu {
		static int[] parent;
		static int[] size;

		dsu(int n) {
			parent = new int[n + 1];
			size = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public static int find(int x) {
			if (parent[x] == x)
				return x;
			parent[x] = find(parent[x]);
			return parent[x];
		}

		public static void union(int a, int b) {
			int pa = find(a);
			int pb = find(b);
			if (pa == pb)
				return;
//			System.out.println(pa+" "+pb);
			if (size[pa] >= size[pb]) {
				parent[pb] = pa;
				size[pa] += size[pb];
			} else if (size[pa] < size[pb]) {
				parent[pa] = pb;
				size[pb] += size[pa];
			}

		}
	}

	static class Writer {
		private final PrintWriter p;

		Writer(OutputStream o) {
			p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(o)));
		}

		void print(Object... o1) {
			for (Object o11 : o1) {
				p.print(o11 + " ");
			}
		}

		void print(String s) {
			p.print(s);
		}

		void println(Object... o1) {
			print(o1);
			p.println();
		}

		void flush() {
			p.flush();
		}

		void close() {
			p.close();
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

	}

}