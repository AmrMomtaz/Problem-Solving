vowels = ['A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u']
T = int(input())
for t in range(1,T+1):
    kingdom = input()
    if kingdom[-1] in vowels:
        print(f'Case #{t}: {kingdom} is ruled by Alice.')
    elif kingdom[-1].lower() == 'y' :
        print(f'Case #{t}: {kingdom} is ruled by nobody.')
    else:
        print(f'Case #{t}: {kingdom} is ruled by Bob.')