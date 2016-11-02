def mergesort(a):
    if len(a) == 1:
        return a

    li_1 = a[:len(a)//2]
    li_2 = a[len(a)//2:]

    li_1 = mergesort(li_1)
    li_2 = mergesort(li_2)

    return merge(li_1, li_2)

def merge(a, b):
    c = []
    length_a = len(a)
    length_b = len(b)
    while length_a > 0 and length_b > 0:
        if a[0] > b[0]:
            c.append(b[0])
            del b[0]
            length_b -= 1
        else:
            c.append(a[0])
            del a[0]
            length_a -=1

    while length_a > 0:
        c.append(a[0])
        del a[0]
        length_a -= 1

    while length_b > 0:
        c.append(b[0])
        del b[0]
        length_b -= 1

    return c

numbers = [4,1,7,8,2,9,10,11,11,255,20,1,6]
print(numbers)
numbers = mergesort(numbers)
print(numbers)
