def check(arr):
    letters ={}
    for letter in arr:
        if letter in letters:
            return False
        letters[letter] = True
    return True        

if __name__ == '__main__':
    import sys
    print(check(sys.argv[-1]))