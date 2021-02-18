import unittest
from random import randint
from sorted_search import jumpSearch, binarySearch 
class TestSearchMethods(unittest.TestCase):

    def test_jump_contains(self):
        l = list(range(10))
        for i in l:
            self.assertTrue(jumpSearch(l, i))

    def test_binary_contains(self):
        l = list(range(10))
        for i in l:
            self.assertTrue(binarySearch(l, i))

    def test_jump_not_contains(self):
        l = list(range(10))
        for i in l:
            self.assertFalse(jumpSearch(l, i+10))

    def test_binary_not_contains(self):
        l = list(range(10))
        for i in l:
            self.assertFalse(binarySearch(l, i+10))

    def test_jump_random_contains(self):
        l = [randint(0,1000000) for i in range(10)]
        l.sort()
        for i in l:
            self.assertTrue(jumpSearch(l, i))

    def test_binary_random_contains(self):
        l = [randint(0,1000000) for i in range(10)]
        l.sort()
        for i in l:
            self.assertTrue(binarySearch(l, i))

    def test_jump_random_not_contains(self):
        l = [randint(0,1000000)//2 * 2 for i in range(10)]
        l.sort()
        for i in l:
            self.assertFalse(jumpSearch(l, i+1))

    def test_binary_random_not_contains(self):
        l = [randint(0,1000000)//2 * 2 for i in range(10)]
        l.sort()
        for i in l:
            self.assertFalse(binarySearch(l, i+1))

if __name__ == '__main__':
    unittest.main()
