from math import sqrt, floor
def jumpSearch(sortedvals, tofind):
    n = len(sortedvals)
    a = 0
    rootn = floor(sqrt(n))
    b = rootn
    while (sortedvals[min(b,n)-1] < tofind):
        a = b
        b += rootn
        if (a >= n):
            return False
    while sortedvals[a] < tofind:
        a += 1
        if a == min(b,n):
            return False
    return sortedvals[a] == tofind

def binarySearch(sortedvals, tofind):
    start = 0
    end = len(sortedvals)
    mid = (end - start)//2 + start
    while start < end and sortedvals[mid]!=tofind:
        if sortedvals[mid] < tofind:
            start = mid + 1
        elif sortedvals[mid] > tofind:
            end = mid
        mid = (end - start) // 2 + start
    return mid < end and sortedvals[mid] == tofind

