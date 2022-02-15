factorials = list()
factorials.append(1)

def modular_exponentiation(b,e,m):
    binary = bin(e)[2:]
    x = b
    result = 1
    for i in binary[::-1]:
        if i =='1':
            result *= x
            result = result%m
        x*=x
        x=x%m
    return result


def inverse(a):
    return modular_exponentiation(a,1000000005,1000000007)


def combination(n, r):
    global factorials
    n_fac = factorials[n]
    p_fac = inverse(factorials[r])
    n_p_fac = inverse(factorials[n-r])
    return (((n_fac*p_fac)%1000000007)*n_p_fac)%1000000007


def checkGold(num, l, r):
    txt = str(num)
    for char in txt:
        if char != str(l) and char != str(r):
            return False
    return True


line = [int(x) for x in input().split()]
l = line[0]
r = line[1]
n = line[2]

for i in range(1,n+1):
    factorials.append(((factorials[-1]*i)%1000000007))

def solve(l, r, n):
    sum = l * n
    diff = r - l
    result = 0
    for i in range(n + 1):
        if checkGold(sum, l, r):
            result += combination(n, i)
            result %= 1000000007
        sum += diff
    print(result)

solve(l,r, n)