#T = int(input())


def sieve_palindrome_algorithm(n):
    prime = [True for _ in range(n + 1)]
    print("Ta5")
    p = 2
    while p * p <= n:
        if prime[p]:
            for i in range(p ** 2, n + 1, p):
                prime[i] = False
        p += 1
    print("Boom")
    prime[0] = False
    prime[1] = False
    result = list()
    for p in range(n + 1):
        if prime[p]:
            result.append(p)
    return result


factors_list = sieve_palindrome_algorithm(10000000000)
'''for t in range(1, T + 1):
    A = int(input())

    print(f'Case #{t}: 4')'''
