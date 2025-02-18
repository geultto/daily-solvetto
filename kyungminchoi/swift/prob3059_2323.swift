class Solution {
    func smallestNumber(_ pattern: String) -> String {
        var results: [String] = []
        let patterns = Array(pattern.map { String($0) }.reversed())

        for i in 1...9 {
            traverse([i], patterns, &results)
        }

        return results.sorted()[0]
    }

    func traverse(_ current: [Int], _ patterns: [String], _ results: inout [String]) {
        guard !patterns.isEmpty else {
            results.append(current.map { String($0) }.joined())
            return
        }

        let criteria = current[current.endIndex - 1]
        var patterns = patterns
        let pattern = patterns.removeLast()

        if pattern == "I" {
            let satisfyingNumbers = (1...9).filter { $0 > criteria && !current.contains($0) }

            guard !satisfyingNumbers.isEmpty else {
                return
            }

            for number in satisfyingNumbers {
                var newCurrent = current
                newCurrent.append(number)

                traverse(newCurrent, patterns, &results)
            }
        } else if pattern == "D" {
            let satisfyingNumbers = (1...9).filter { $0 < criteria && !current.contains($0) }

            guard !satisfyingNumbers.isEmpty else {
                return
            }

            for number in satisfyingNumbers {
                var newCurrent = current
                newCurrent.append(number)

                traverse(newCurrent, patterns, &results)
            }
        }
    }
}