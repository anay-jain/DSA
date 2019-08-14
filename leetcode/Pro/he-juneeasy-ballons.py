for t in range(int(input())):
    g,p=(map(int,input().split()))
    n=int(input())
    m=0
    m1=0
    for i in range(n):
        l,l1=(map(int,input().split()))
        m+=l
        m1+=l1
    if m1>m:
        t=m
        m=m1
        m1=t
    if g>p:
        print((g*m1)+(p*m))
    else:
        print((g*m)+(p*m1))