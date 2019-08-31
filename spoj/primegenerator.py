# sieve of eratosthenes
for _ in range(int(input())):
    t,n = map(int,input().split())
    prime = [True for i in range(n+1)]
    m=2
    while m*m <= n :
        if(prime[m] == True):
            for p in range(m*2,n+1,m):
                prime[p] = False
        m+=1           
    prime[0],prime[1] = False,False
    for i in range(t,n+1):
        if prime[i]== True:
            print(i)                