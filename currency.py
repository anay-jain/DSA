g = list(map(int,input().split()))
n=len(g)
x = [[1 for i in range(n)] for j in range(n)]
for i in range(1,n):
    x[0][i]=g[i]
for i in range(1,n):
    x[i][0]=(1/x[0][i])
for i in range(1,n):
    for j in range(1,n):
        if i!=j:
            x[j][i]=x[i][0] * x[0][j]
for i in range(n):
    print()
    for j in range(n):
        print(x[i][j],end="  \      ")

t=int(input("From currency"))
y=int(input("To currency"))
print(x[t][y])
                   