#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'maxSumTriple' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY a as parameter.
#

def maxSumTriple(a):
    result = [-1]
    sum_result = -1
    i1, i2, i3 = 0, 1, 2
    while i1 < len(a)-2:
        while i2 < len(a)-1:
            while i3 < len(a):
                trial = [a[i1], a[i2], a[i3]]
                if check_trail(trial):
                    if sum(trial) > sum_result:
                        result = trial
                        sum_result = sum(trial)
                    elif max(trial) > max(result):
                        result = trial
                    elif min(trial) > min(result):
                        result = trial
                i3 += 1
            i2 += 1
            i3 = i2 + 1
        i1 += 1
        i2 = i1 + 1
    result.sort()
    return result


def check_trail(trial):
    if trial[0] + trial[1] > trial[2] and trial[1] + trial[2] > trial[0] and trial[0] + trial[2] > trial[1]:
        return True
    else:
        return False



if __name__ == '__main__':

    n = int(input().strip())

    aa = list(map(int, input().rstrip().split()))

    result = maxSumTriple(aa)
    print(result)
