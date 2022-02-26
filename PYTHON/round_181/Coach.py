line = [int (x) for x in input().split()]
students = line[0]
constraints = line[1]
sets = list()
for i in range(1,students+1):
    sets.append({i})
for i in range(constraints):
    line = [int (x) for x in input().split()]
    student1 = line[0]
    student2 = line[1]
    set1 = None
    set2 = None
    for group in sets:
        if student1 in group:
            set1 = group
        if student2 in group:
            set2 = group
        if set1 is not None and set2 is not None:
            break
    if set1 == set2:
        continue
    sets.remove(set1)
    sets.remove(set2)
    sets.append(set1.union(set2))
sets.sort(key= len,reverse=True)
groupsOfOne = list()
groupsOfTwo = list()
for i in range(len(sets)):
    if len(sets[i])>3:
        print('-1')
        exit()
    elif len(sets[i]) == 3:
        print(' '.join(str(sets[i])[1:-1].split(', ')))
    elif len(sets[i]) == 2:
        groupsOfTwo.append(sets[i])
    elif len(sets[i]) == 1:
        groupsOfOne.append(sets[i])
if len(groupsOfOne) == len(groupsOfTwo):
    for i in range(len(groupsOfOne)):
        overallSet = groupsOfOne[i].union(groupsOfTwo[i])
        print(' '.join(str(overallSet)[1:-1].split(', ')))
elif len(groupsOfOne) > len(groupsOfTwo) and (len(groupsOfOne)-len(groupsOfTwo))%3==0:
    for i in range(len(groupsOfTwo)):
        overallSet = groupsOfOne[i].union(groupsOfTwo[i])
        print(' '.join(str(overallSet)[1:-1].split(', ')))
    index = len(groupsOfTwo)
    while len(groupsOfOne) > index:
        print(f'{str(groupsOfOne[index])[1:-1]} {str(groupsOfOne[index+1])[1:-1]} {str(groupsOfOne[index+2])[1:-1]}',end='\n')
        index+=3
else:
    print('-1')