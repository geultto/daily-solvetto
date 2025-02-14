class ProductOfNumbers {
    private var numbers: [Int]

    private var startFrom: Int {
        numbers.count - 1
    }

    init() {
        numbers = []    
    }
    
    func add(_ num: Int) {
        numbers.append(num)
    }
    
    func getProduct(_ k: Int) -> Int {
        var starting = startFrom
        var result = 1

        for i in 0..<k {
            // can assume that numbers always has at least k elements
            result *= numbers[starting - i]
        }

        return result
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * let obj = ProductOfNumbers()
 * obj.add(num)
 * let ret_2: Int = obj.getProduct(k)
 */