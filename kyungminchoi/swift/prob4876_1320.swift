import Foundation

let n = Int(readLine()!)!
let base = ["1", "2", "3", "4"]

var result = 0

func traverse(_ selected: [String], _ base: [String], _ threshold: Int, _ result: inout Int) {
    guard selected.count < threshold else {
        if isBeautiful(selected) {
            result += 1
        }

        return
    }

    for number in base {
        var newSelected = selected
        newSelected.append(number)

        traverse(newSelected, base, threshold, &result)
    }
}

func isBeautiful(_ number: [String]) -> Bool {
    var prev = number[0]
    var identical = 1

    if number.count > 1 {
        for i in 1..<number.count {
            if number[i] != prev {
                if identical % Int(prev)! != 0 { return false }

                identical = 1
                prev = number[i]
            } else {
                identical += 1
            }
        }
    }

    if identical % Int(prev)! != 0 { return false }

    return true
}

traverse([], base, n, &result)
print(result)