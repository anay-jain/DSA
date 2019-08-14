x=1221
s = str(x)
l = len(s)
if len(s)%2 ==0:
    i=int(len(s)/2)
    print(i) 
else:
    i=int(len(s)/2) 
    
print(i)
print(s[i:])
print(s[:i:-1])
if s[:i] == s[i:]:
    print("yes")
else:
    print("no")    