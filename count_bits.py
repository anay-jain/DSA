# counting the no. of bits in a number


def count_bits(x):
    count = 0
    while x:
        count += x & 1
        x >>= 1
        print x

    return count

print count_bits(15)


