class Solution {
    func minimumRecolors(_ blocks: String, _ k: Int) -> Int {
        let blocks = blocks.map { String($0) }
        var result = blocks[0..<k].filter { $0 == "W" }.count
        var current = result
        let n = blocks.count
        var startingWasWhite = blocks[0] == "W"

        if k < n {
            for i in 1..<(n - k + 1) {
                var newCurrent = current

                if startingWasWhite { newCurrent -= 1 }
                if blocks[i+k-1] == "W" { newCurrent += 1 } 

                startingWasWhite = blocks[i] == "W"

                current = newCurrent
                result = min(result, newCurrent)
            }
        }

        return result
    }
}class Solution {
    func minimumRecolors(_ blocks: String, _ k: Int) -> Int {
        let blocks = blocks.map { String($0) }
        var result = blocks[0..<k].filter { $0 == "W" }.count
        var current = result
        let n = blocks.count
        var startingWasWhite = blocks[0] == "W"

        if k < n {
            for i in 1..<(n - k + 1) {
                var newCurrent = current

                if startingWasWhite { newCurrent -= 1 }
                if blocks[i+k-1] == "W" { newCurrent += 1 } 

                startingWasWhite = blocks[i] == "W"

                current = newCurrent
                result = min(result, newCurrent)
            }
        }

        return result
    }
}