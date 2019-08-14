def fib(n):
    memo = [0] * (n+1) # declaring all variables to 0 upto n 
    memo[0] , memo[1] = 0 , 1
    for i in range(2 , n+1):
        memo[i] = memo[i-1] + memo[i-2]
        memo[i]
    for i in range(1, n+1):
        print(memo[i] , end = " ") 
    print()           
    return memo[n]

t  =  int(input())
for i in range(t):
    n = int(input())
    fib(n)
