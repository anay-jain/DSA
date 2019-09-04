for _ in range(int(input())):
    x,y,k,n=map(int,input().split())
    p = [0 for i in range(n)]
    c = [0 for i in range(n)]
    flag=0
    for i in range(n):
        p[i],c[i]=map(int,input().split())
        page_left=(x-y)
    for t in range(n):
        if p[i]>=page_left and c[i]<=k:
            flag=1       
    if flag:
        print("LuckyChef")
    else:
        print("UnluckyChef")

