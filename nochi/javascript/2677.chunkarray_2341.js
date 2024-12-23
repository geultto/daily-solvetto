/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function (arr, size) {
    const array = [];
    let startIndex = 0
    while (arr.length > startIndex) {
        const lastIndex = startIndex + size
        const subArr = arr.slice(startIndex, lastIndex);
        array.push(subArr)
        startIndex = lastIndex
    }
    return array
};