
def minimizeMeetingCost(N, M, costs):
    mx = N if N>M else M
    final = 10000
    dp = [[10000 for i in range(N)] for i in range(M)]
    a,b,c,d=0,0,0,0
    for i in range(N):
        for j in range(M):
            if i>0:
                a = costs[i-1][j]
            if j>0:
                b = costs[i][j-1]
            if i <N:
                c = costs[i+1][j]
            if j <M:
                d = costs[i][j+1]
            ans = costs[i][j]+a+b+c+d
            dp[i][j] = min(ans , dp[i][j])
            final = min(final , dp[i][j])
    return final        
    # Write your code here

if __name__ == '__main__':

    N = int(input().strip())

    M = int(input().strip())

    costs_rows = int(input().strip())
    costs_columns = int(input().strip())

    costs = []

    for _ in range(costs_rows):
        costs.append(list(map(int, input().rstrip().split())))

    result = minimizeMeetingCost(N, M, costs)