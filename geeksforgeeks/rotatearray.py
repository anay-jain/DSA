for _ in range(int(input())):
    g,p = map(int,input().split())
    ar = list(map(int,input().split()))
    ar=ar[p:]+ ar[:p]
  #  print(' '.join(ar))
    print(*ar , sep=" ")