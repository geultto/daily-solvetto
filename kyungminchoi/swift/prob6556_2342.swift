class Solution {
    func coloredCells(_ n: Int) -> Int {
        var previous = 0
        var first = 1
        var second = 0
        var third = 0
        var fourth = -1

        while first < n {
            previous += first
            previous += second
            previous += third

            if first > 1 {
                previous += fourth
            }

            first += 1
            second += 1
            third += 1
            fourth += 1
        }

        switch first {
        case 1:
            return first + second + third
        default:
            return previous + first + second + third + fourth
        }
    }
}