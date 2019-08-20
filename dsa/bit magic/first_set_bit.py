for _ in range(int(input())):
    t =int(input())
    count = 1
    if(t==0):
        count=0
    while(t):
        if(t&1):
            break
        else:
            t>>=1
            count+=1
    print(count)        