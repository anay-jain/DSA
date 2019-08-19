def coin(coins ,amount):
    dp = [0 for i in range(amount+1)]
    ans =10000
    count = 0
    for coin in coins:
        for i in range(coin,amount+1):    
            if i>coin:
                ans = dp[i - coin] + 1
                dp[i]+=ans
    return dp[amount]                 
for _ in range(int(input())):
    deno = int(input())
    coins = [ int(co) for co in input().split()]
    amount = int(input())
    print(coin(coins,amount))