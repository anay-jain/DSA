for _ in range(int(input())):
    n=int(input())
    g = list(map(int,input().split()))
    g.sort()
    for i in range(1,n-1,2):
        g[i],g[i+1]=g[i+1],g[i]
    for i in g:
        print(i,end=" ")  