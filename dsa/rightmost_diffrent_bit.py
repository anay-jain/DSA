import math
m,n = map(int, input().split())
test = m ^ n
if(m==n):
    count =  -1
else:
    count =  int(math.log2(test & -test )+1)
print(count)    