import numpy

def arrays(arr):
    # complete this function
    # use numpy.array
    arr.reverse()
    _temp = numpy.array(arr, float)
    return (_temp)
    
arr = input().strip().split(' ')