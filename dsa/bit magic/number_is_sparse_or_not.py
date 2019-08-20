for _ in range(int(input())):
    n = int(input())
    flag=1
    while(n):
        if(n&1 and (n>>1)&1):
            flag=0
            break
        else:
            n>>=1
    if flag:
        print("1")
    else:
        print("0")    