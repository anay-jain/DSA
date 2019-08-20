for _ in range(int(input())):
    n = int(input())
    count,ans=0,0
    while(n):
        if n&1:
            count+=1
            n>>=1
        else:
            n>>=1
            count=0
        ans=max(ans,count)        
    print(ans)        