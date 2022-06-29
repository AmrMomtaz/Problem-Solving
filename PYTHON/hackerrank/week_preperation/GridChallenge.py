#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'gridChallenge' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING_ARRAY grid as parameter.
#

def gridChallenge(grid):
    for i in range(len(grid)):
        grid[i] = ''.join(sorted(grid[i]))
    for j in range(len(grid[0])):
        for i in range(len(grid)-1):
            if grid[i+1][j] < grid[i][j]:
                return 'NO'
    return 'YES'

if __name__ == '__main__':
    fptr = open('output.txt', 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        grid = []

        for _ in range(n):
            grid_item = input()
            grid.append(grid_item)

        result = gridChallenge(grid)

        fptr.write(result + '\n')

    fptr.close()