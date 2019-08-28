# sieve of eratosthenes
for _ in range(int(input())):
    t,n = map(int,input().split())
    prime = [True for i in range(t,n+1)]
    m=t
    dif=t
    while m*m <= n :
        if(prime[m-dif] == True):
            for p in range(m,n+1,m):
                prime[p-dif] = False
        m+=1
    if t==1:            
        prime[0],prime[1] = False,False
    if t==0:
        prime[0]=False
    for i in range(t,n+1):
        if prime[i-dif]== True:
            print(i)                