def mul(arr,i):
    final =arr.pop(i)
    ans= reduce((lambda x, y: x*y) , final)
    return ans

n = int(input())
for i in range(n):
    t=int(input())
for i in range(n):
    mul()        