/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function (arr, fn) {
    const newArr = [];
    let index = 0;
    while(index < arr.length) {
        newArr.push(fn(arr[index], index++))
    }
    return newArr
};