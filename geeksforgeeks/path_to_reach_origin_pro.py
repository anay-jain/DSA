for _ in range(int(input())):

    n, m = [int(x) for x in input().strip().split()]

    mx = n if n>m else m

    dp = [[0 for i in range(mx+1)] for i in range(mx+1)]


    for i in range(mx+1):
        for j in range(mx+1):
            if i==0 or j==0:
                dp[i][j]=1
            else:
                dp[i][j]=dp[i-1][j]+dp[i][j-1]

    print(dp[n][m])