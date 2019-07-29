# counting the no. of bits in a number


def count_bits(x):
    count = 0
    while x:
        count += x & 1
        # it will give us the and of last bit and 1 
        # then we right shift the last digit and it gets eliminated. 
        x >>= 1
        print x

    return count

print count_bits(45)


