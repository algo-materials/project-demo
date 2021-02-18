from sorted_search import jumpSearch, binarySearch
import timeit
from time import perf_counter
from random import randint

ITERS = 10000

n = int(input('Enter list size:'))

searchlist = sorted([randint(0,100000) for i in range(n)])
tofind = randint(0,100000)
# timeit version
print('timeit: jumpSearch')
print(timeit.timeit('jumpSearch(searchlist, tofind)', globals=globals(), number=ITERS)/ITERS)
print('timeit: binarySearch')
print(timeit.timeit('binarySearch(searchlist, tofind)', globals=globals(), number=ITERS)/ITERS)
print('---')
print('Using perf_counter')
# again, notice I'm being very consistent with what I'm searching for
# loops and perf_counter
start = perf_counter()
for i in range(ITERS):
    jumpSearch(searchlist, tofind)
end = perf_counter()
print('jumpSearch:', (end-start)/ITERS)

start = perf_counter()
for i in range(ITERS):
    binarySearch(searchlist, tofind)
end = perf_counter()
print('binarySearch:', (end-start)/ITERS)
