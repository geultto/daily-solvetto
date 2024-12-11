/// LeetCode No.733 Flood Fill
/// https://leetcode.com/problems/flood-fill/description/

class Solution {
    func floodFill(_ image: [[Int]], _ sr: Int, _ sc: Int, _ color: Int) -> [[Int]] {
        var image = image
        let previous = image[sr][sc]
        if color == previous {
            return image
        }

        traverse(&image, sr, sc, previous, color)

        return image
    }

    func traverse(_ image: inout [[Int]], _ row: Int, _ col: Int, _ previous: Int, _ color: Int) {
        guard (0..<image.count) ~= row && (0..<image[0].count) ~= col else { return }
        guard image[row][col] == previous else { return }

        image[row][col] = color

        traverse(&image, row+1, col, previous, color)
        traverse(&image, row-1, col, previous, color)
        traverse(&image, row, col+1, previous, color)
        traverse(&image, row, col-1, previous, color)
    }
}
