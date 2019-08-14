def fib(n):
    memo = [0] * (n+1) # declaring all variables to 0 upto n 
    memo[0] , memo[1] = 0 , 1
    for i in range(2 , n+1):
        memo[i] = memo[i-1] + memo[i-2]
        print(memo[i])
    return memo[n]


n = int(input())
print(fib(n))   

