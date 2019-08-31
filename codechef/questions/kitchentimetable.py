for _ in range(int(input())):
    n=int(input())
    g=list(map(int,input().split()))
    p=list(map(int,input().split()))
    count=0
    for i in range(n):
        if i==0 and g[i]>=p[i]:
            count+=1
        else:
            tt=g[i]-g[i-1]
            if tt>=p[i]:
                count+=1
    print(count)                            