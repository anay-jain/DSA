def ch(arr):
    n= len(arr)
    check = [False for i in range(128)]
    for i in range(n):
        val =ord(arr[i])
        if(check[val] == True):
            return False
        check[val] = True
    return True
        
arr = input()
if ch(arr):
    print("It is unique")
else:
    print("It's not unique")    
