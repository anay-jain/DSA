for _ in range(int(input())):
    n=int(input())
    t = int(input())
    if(n&(1<<(t))):
        print("Yes")
    else:
        print("No")