class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        sum_of_digit_dict = {}
        for num in nums:
            sum_of_digits = sum(int(d) for d in str(num))

            if entry := sum_of_digit_dict.get(sum_of_digits):
                if len(entry) == 1:
                    if num < entry[0]:
                        sum_of_digit_dict[sum_of_digits] = [num, entry[0]]
                    else:
                        sum_of_digit_dict[sum_of_digits] = [entry[0], num]
                else:
                    if entry[0] <= num <= entry[1]:
                        sum_of_digit_dict[sum_of_digits] = [num, entry[1]]
                    elif entry[1] <= num:
                        sum_of_digit_dict[sum_of_digits] = [entry[1], num]
            else:
                sum_of_digit_dict[sum_of_digits] = [num]

        answer = -1
        for k, v in sum_of_digit_dict.items():
            if len(v) == 2:
                answer = max(answer, sum(v))

        return answer