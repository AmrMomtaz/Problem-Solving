def geniusesCompetition(n, pairs):
    sets = list()
    for i in range(n):
        new_set = {i}
        sets.append(new_set)
    for pair in pairs:
        set1, set2 = None, None
        for sett in sets:
            if sett.__contains__(pair[0]):
                set1 = sett
            if sett.__contains__(pair[1]):
                set2 = sett
            if set1 is not None and set2 is not None:
                break
        if set1 == set2:
            continue
        union_set = set1.union(set2)
        sets.remove(set1)
        sets.remove(set2)
        sets.append(union_set)
    i, j = 0, 1
    result = 0
    while i < len(sets) - 1:
        while j < len(sets):
            result += len(sets[i]) * len(sets[j])
            j += 1
        i += 1
        j = i + 1
    return result
