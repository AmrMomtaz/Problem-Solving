import sys
T = int(input())

for t in range(1,T+1):
    line = [int(x) for x in input().split()]
    N = line[0]
    M = line[1]
    P = line[2]
    orders = list()
    forbidden = set()
    for _ in range(N):
        orders.append(input())
    for _ in range(M):
        forbidden.add(int(input(), 2))
    count = list()
    for _ in range(P):
        count.append(0)
    for order in orders:
        for i in range(len(order)):
            if order[i]=='1':
                count[i]+=1
    score = sys.maxsize
    for n in range(0,2**P):
        if n in forbidden:
            continue
        new_order = bin(n)[2:]
        if len(new_order) < P:
            new_order = '0' * (P - len(new_order)) + new_order
        new_score = 0
        for i in range(len(new_order)):
            if new_order[i]=='0':
                new_score+=count[i]
            else:
                new_score+=(N-count[i])
        if new_score<score:
            score = new_score
    print(f'Case #{t}: {score}')