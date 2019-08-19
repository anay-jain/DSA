for _ in range(int(input())):
    n = int(input())
    memo = [0 for i in range(n+1)]
    memo[0] = 1
    coins= [3,5,10]
    for coin in coins:
        for i in range(coin ,n+1):
            memo[i]+=memo[i-coin]
            
    print(memo[n])

    