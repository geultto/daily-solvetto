import Foundation

let info = readLine()!.components(separatedBy: " ").compactMap { Int($0) }
let k = info[0]
let n = info[1]

let numbers = Array(1...k).map { String($0) }

func selectNumbers(_ numbers: [String], _ selected: [String], _ threshold: Int) {
    if selected.count >= threshold {
        print(selected.joined(separator: " "))
        return
    }

    for number in numbers {
        var selected = selected
        selected.append(number)

        selectNumbers(numbers, selected, threshold)
    }
}

selectNumbers(numbers, [], n)