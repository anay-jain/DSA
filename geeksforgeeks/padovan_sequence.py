def fib(n):
    memo = [0] * (n+1)
    memo[0] , memo[1] , memo[2] = 1 ,1,1
    for i in range(3,n+1):
        memo[i] = memo[i-2] +memo[i-3]    
    return memo[n]

t = int(input())
for i in range(t):
    n = int(input())
    result = fib(n) % 1000000007
    print(result)


