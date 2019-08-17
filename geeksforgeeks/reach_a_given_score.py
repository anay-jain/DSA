for _ in range(int(input())):
    n = int(input())
    memo = [0 for i in range(n+1)]
    memo[0] = 1
    for i in range(n+1):
        if memo[i] == 0:
            if i>2:
                memo[i] += memo[i-3]
            if i>4:
                memo[i] += memo[i-5]
            if i>9:
                memo[i] += memo[i-10]
    print(memo[n])

    