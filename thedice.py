n=input()
result = ''.join([i for i in n if i is not '6'])
s=len(result)
if n[-1] == '6':
	print(-1)
elif s == 0:
	print(-1)
else:
	print(s)	

