def setbits(n):
    count=0
    while(n>0):
        n=n&(n-1)
        count+=1
    return count    
for _ in range(int(input())):
    n = int(input())
    res=0
    for i in range(n+1):
        res+=setbits(i)    
    print(res)    