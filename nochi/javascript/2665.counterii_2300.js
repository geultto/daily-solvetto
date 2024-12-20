/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function (init) {
    return {
        num: init,
        increment: function () {
            return ++this.num
        },
        decrement: function () {
            return --this.num
        }, 
        reset: function () {
            return this.num = init;
        }
    }
};


/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */