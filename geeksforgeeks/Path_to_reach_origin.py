def path(m,n):
    memo = [[0 for x in range(m)] for y in range(n)]   
    for i in range(0 , n):
        for x in range(0 , m):
            if i==0 or x==0:
                memo[i][x] = (memo[i-1][x] +  memo[i][x-1])
                print(memo[i][x])
    return memo
    
t  = int(input())
for y in range(t):
    m , n = map(int ,input().split())
    if m==0 or n==0:
        print('1')
    else:
        print(path(m,n))