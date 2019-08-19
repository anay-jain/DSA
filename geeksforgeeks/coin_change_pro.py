for _ in range(int(input())):
    n,ar,m=int(input()),list(map(int,input().split())),int(input())
    dp=[0]*(m+1)
    dp[0]=1
    for i in range(n):
        for j in range(ar[i],m+1):
            dp[j]+=dp[j-ar[i]]
            print(dp[j])
    print(dp[m]) 