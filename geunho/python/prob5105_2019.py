class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        dict1 = defaultdict(set)
        dict2 = defaultdict(set)

        for index, char in enumerate(s1):
            dict1[char].add(index)

        for index, char in enumerate(s2):
            dict2[char].add(index)

        for k, v in dict1.items():
            if len(v) != len(dict2[k]):
                return False

        num_of_diff = 0
        for key in dict1.keys():
            val1 = dict1[key]
            val2 = dict2[key]
            num_of_diff += len(val1.difference(val2))

        return True if num_of_diff <= 2 else False