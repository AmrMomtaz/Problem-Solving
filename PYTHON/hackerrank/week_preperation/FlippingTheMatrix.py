#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'flippingMatrix' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY matrix as parameter.
#

def flippingMatrix(matrix):
    mid = int(len(matrix)/2)
    for i in range(mid):
        if sum(matrix[i][mid:])> sum(matrix[i][:mid]):
            matrix[i] = matrix[i][mid:] + matrix[i][:mid]
    for i in range(mid,len(matrix)):
        if sum(matrix[i][mid:])> sum(matrix[i][:mid]):
            matrix[i] = matrix[i][mid:] + matrix[i][:mid]
    total = 0
    for j in range(mid):
        sum_up = 0
        sum_down = 0
        for i in range(len(matrix)):
            if i < mid :
                sum_up += matrix[i][j]
            else:
                sum_down += matrix[i][j]
        total += max(sum_up,sum_down)
    return total
if __name__ == '__main__':
    fptr = open('output.txt', 'w')

    q = int(input().strip())

    for q_itr in range(q):
        n = int(input().strip())

        matrix = []

        for _ in range(2 * n):
            matrix.append(list(map(int, input().rstrip().split())))

        result = flippingMatrix(matrix)

        fptr.write(str(result) + '\n')

    fptr.close()
