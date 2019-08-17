for _ in range(int(input())):
    n = int(input())
    memo = [0 for i in range(n+1)]
    memo[0] = 1
    score = [3 ,5,10]
    for i in range(3,n+1):
        for k in range(len(score)):
            if i>=score[k]:
                memo[i] +=memo[i-score[k]]

    print(memo[n])

     