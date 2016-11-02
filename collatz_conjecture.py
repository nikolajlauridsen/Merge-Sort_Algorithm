"""
A python implementation of the collatz conjecture
"""

def collatz(number):
    if number % 2 == 0:
        number //= 2
        print(number)
        return number

    elif number % 2 == 1:
        number = 3 * number + 1
        print(number)
        return number

run_throughs = 0

int_number = int(input("Please input a whole number: "))

while True:
    if int_number != 1:
        int_number = collatz(int_number)
        run_throughs += 1
    elif int_number == 1:
        print("You've reached " + str(int_number) )
        print("It took: " + str(run_throughs) + " steps")
        break
