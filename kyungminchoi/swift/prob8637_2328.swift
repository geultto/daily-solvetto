class Solution {
    func findMissingAndRepeatedValues(_ grid: [[Int]]) -> [Int] {
        var result = [0, 0]
        let numbers = grid.flatMap { $0 }
        let base = Array(1...numbers.count)
        var occurence = [Int: Int]()

        for number in numbers {
            if let prev = occurence[number] {
                occurence[number] = prev + 1
            } else {
                occurence[number] = 1
            }
        }

        for number in base {
            if let current = occurence[number] {
                if current == 2 {
                    result[0] = number
                }
            } else {
                result[1] = number
            }
        }

        return result
    }
}