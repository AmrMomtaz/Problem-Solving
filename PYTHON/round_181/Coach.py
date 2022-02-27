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
        for element in sets[i]:
            print(str(element) + ' ' , end='')
        print('\n',end='')
    elif len(sets[i]) == 2:
        groupsOfTwo.append(sets[i])
    elif len(sets[i]) == 1:
        groupsOfOne.append(sets[i])
if len(groupsOfOne) == len(groupsOfTwo):
    for i in range(len(groupsOfOne)):
        overallSet = None
        overallSet = groupsOfOne[i].union(groupsOfTwo[i])
        for element in overallSet:
            print(str(element) + ' ', end='')
        print('\n', end='')
elif len(groupsOfOne) > len(groupsOfTwo):
    while len(groupsOfTwo)>0:
        overallSet = groupsOfOne.pop().union(groupsOfTwo.pop())
        for element in overallSet:
            print(str(element) + ' ', end='')
    while len(groupsOfOne)>0:
        
else:
    print('-1')