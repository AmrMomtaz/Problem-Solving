T = int(input())
for t in range(T):
    line = [int(x) for x in input().split()]
    N = line[0]
    M = line[1]
    candies = [int(x) for x in input().split()]
    total = sum(candies)
    print(f'Case #{(t+1)}: {sum(candies)%M}')