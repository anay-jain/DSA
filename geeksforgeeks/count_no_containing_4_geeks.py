def isFour(n):
    n = str(n)
    if '4' in n :
        return True
    else:
        return False    

t  = int(input())
for v in range(t):
    count = 0
    n = int(input())
    for i in range(n+1):
        if isFour(i):
            count+=1
    print(count)               