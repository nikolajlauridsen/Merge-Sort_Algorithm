def mergesort(a):
    if len(a) == 1:
        return a

    # Split the 'a' array into two equally sized arrays
    li_1 = a[:len(a)//2]
    li_2 = a[len(a)//2:]

    # Split the new arrays again until there's
    # only 1 item in each of the two arrays
    li_1 = mergesort(li_1)
    li_2 = mergesort(li_2)

    # Start merging arrays until every array "fragment" is merged again
    return merge(li_1, li_2)


def merge(a, b):
    # Resulting sorted array
    c = []
    # We have to keep track of array length our self since it doesn't
    # update through each loop iteration
    length_a = len(a)
    length_b = len(b)

    # As long as both arrays has items we'll add the smallest item to
    # the result array 'c' and then delete it from where it came
    while length_a > 0 and length_b > 0:
        if a[0] > b[0]:
            c.append(b[0])
            del b[0]
            length_b -= 1
        else:
            c.append(a[0])
            del a[0]
            length_a -=1

    # Dump the rest of the items to the end of the result array
    # if there's more than one it'll be sorted on the next run through
    while length_a > 0:
        c.append(a[0])
        del a[0]
        length_a -= 1

    while length_b > 0:
        c.append(b[0])
        del b[0]
        length_b -= 1

    return c

numbers = [15,6,30,100,-5,-3.5,24.252, 24.251]
print(numbers)
numbers = mergesort(numbers)
print(numbers)
