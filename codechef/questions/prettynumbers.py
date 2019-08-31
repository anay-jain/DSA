for _ in range(int(input())):
    count=0
    g,p = map(int,input().split())
    for i in range(g,p+1):
        temp = str(i)
        if temp[-1] in '239':
            count+=1
    print(count)        