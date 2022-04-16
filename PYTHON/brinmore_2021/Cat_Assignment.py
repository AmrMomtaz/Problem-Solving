from math import gcd
from functools import reduce

line_1 = [int(x) for x in input().split()]
initial = line_1[1]
lst = [int(x) for x in input().split()]
lst.append(initial)
lst.sort()
sub = lst[0]
final = [x - sub for x in lst]
res = final[0]
for c in final[1:]:
    res = gcd(res, c)
print(res)