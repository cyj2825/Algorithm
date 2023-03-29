import sys
input = sys.stdin.readline

n = int(input())
myStack = []

for i in range(n):
    command = input().split()
    if command[0] == "push":
        myStack.append(int(command[1]))
    elif command[0] == "pop":
        if len(myStack) == 0:
            print(-1)
        else:
            print(myStack.pop())
    elif command[0] == "top":
        if len(myStack) == 0:
            print(-1)
        else:
            print(myStack[-1])
    elif command[0] == "size":
        print(len(myStack))
    elif command[0] == "empty":
        if len(myStack) == 0:
            print(1)
        else:
            print(0)