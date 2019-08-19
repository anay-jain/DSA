# trapping rainwater problem
#finding local maximum
def maxwater(arr, start,end):
    count=0
    for mt in range(start,end):
        if arr[mt] < arr[start]:
            count +=(arr[start]-arr[mt])
    return count


blocks = list(map(int,input().split()))
t=0
finalans =0
    for i in range(len(blocks)-1):
        if blocks[i+1]>=blocks[t]:
            finalans += maxwater(blocks,t,i+1)
            t = i
            print(finalans)
print(finalans)