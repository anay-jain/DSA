x=int(input())
for i in range(1,x+1):
	final,no1,no2=0,0,0
	a , b = input().split(" ")
	a,b=int(a),int(b)
	if a<b:
		a , b = b ,a
	part = int(input())
	for i in range(1,part+1):
		xtemp ,ytemp = input().split(" ")
		no1=no1+int(xtemp)
		no2=no2+int(ytemp)
	if no1>no2:
		final=no2*a + no2*b
	else:
		final=no2*a + no1*b
	print(final)	