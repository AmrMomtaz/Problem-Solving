#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def timeConversion(s):
    op = s[-2:]
    rest = s[2:-2]
    hour = int(s[:2])
    if op == 'AM':
        if hour == 12:
            hour = 0
    elif op == 'PM':
        if hour != 12:
            hour += 12
    hour = str(hour)
    if len(hour) < 2:
        hour = '0' + hour
    return hour+rest

if __name__ == '__main__':
    fptr = open('output.txt', 'w')

    s = input()

    result = timeConversion(s)

    fptr.write(result + '\n')

    fptr.close()
