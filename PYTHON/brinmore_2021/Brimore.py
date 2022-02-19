def calculate_score(tup,num):
    result = 0
    for element in tup:
        result+=abs(element-num)
    return result

def find_maximum_set(tup,index):
    global dynamic
    global  results
    if index == -1:
        return 0
    if tup in dynamic:
        return dynamic.get(tup)
    lst = list()
    for i in range(len(tup)):
        lst.append( tuple([tup[x] for x in range(len(tup)) if x != i]) )
        score = find_maximum_set(lst[-1],index-1)
        score += calculate_score(lst[-1],tup[i])
        if tup not in dynamic:
            dynamic[tup] = score
        if score>results[index]:
            results[index] =score
    return dynamic[tup]



n = int(input())
numbers = [int(x) for x in input().split()]
numbers.sort()
results = list()
for _ in range(n-1):
    results.append(0)
#results[0] = numbers[-1]-numbers[0]
dynamic = dict()
find_maximum_set(tuple(numbers),n-2)
for result in results:
    print(str(result)+' ' ,end='')