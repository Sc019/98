import time

class TreeNode:
    def __init__(self, freq, data):
        self.freq = freq
        self.data = data
        self.left = None
        self.right = None

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def insert(head, t):
    p = Node(t)
    p.next = None
    if head is None:
        return p
    if t.freq < head.data.freq:
        p.next = head
        return p
    q = head
    while q.next is not None and t.freq > q.next.data.freq:
        q = q.next
    p.next = q.next
    q.next = p
    return head

def encode():
    word = input("\nEnter a Message: ")
    print("\nEncoded Message =", end=' ')
    for char in word:
        for j in range(n):
            if alphabets[j] == char:
                print(codes[j], end='')
    print()

def create():
    head = None
    n = int(input("\nEnter No. of alphabets: "))
    for i in range(n):
        x = input("\nEnter alphabet: ")
        probability = float(input("\nEnter frequency: "))
        p = TreeNode(probability, x)
        p.left = p.right = None
        head = insert(head, p)
    for i in range(1, n):
        t1 = head.data
        t2 = head.next.data
        head = head.next.next
        p = TreeNode(t1.freq + t2.freq, '')
        p.left = t1
        p.right = t2
        head = insert(head, p)
    return head.data

def preorder(p, i, word):
    if p is not None:
        if p.left is None and p.right is None:
            word[i] = ''
            print(f"{p.data} --- {''.join(word)}")
            alphabets.append(p.data)
            codes.append(''.join(word))
        word[i] = '0'
        preorder(p.left, i + 1, word)
        word[i] = '1'
        preorder(p.right, i + 1, word)

def decode(p):
    word = input("\nEnter an Encoded message: ")
    q = p
    i = 0
    print("Decoded Message =", end=' ')
    while i < len(word):
        if word[i] == '0':
            q = q.left
        else:
            q = q.right
        if q.left is None and q.right is None:
            print(q.data, end='')
            q = p
        i += 1
    print()

n = 0
alphabets = []
codes = []

root = None
exitFlag = False

while not exitFlag:
    print("\n1)Create Huffman Tree")
    print("2)Encode a Message")
    print("3)Decode a message")
    print("4)Exit")
    op = int(input("Enter Your Choice: "))

    if op == 1:
        start_time = time.time()
        root = create()
        end_time = time.time()
        print("Time taken to create Huffman Tree: {:.2f} seconds".format(end_time - start_time))
        print("\nPrefix codes:")
        word = [''] * 30
        preorder(root, 0, word)
    elif op == 2:
        start_time = time.time()
        encode()
        end_time = time.time()
        print("Time taken to encode a message: {:.2f} seconds".format(end_time - start_time))
    elif op == 3:
        start_time = time.time()
        decode(root)
        end_time = time.time()
        print("Time taken to decode a message: {:.2f} seconds".format(end_time - start_time))
    elif op == 4:
        exitFlag = True
'''1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice: 1

Enter No. of alphabets: 4

Enter alphabet: A

Enter frequency: 0.3

Enter alphabet: B

Enter frequency: 0.2

Enter alphabet: C

Enter frequency: 0.2

Enter alphabet: D

Enter frequency: 0.3
Time taken to create Huffman Tree: 0.00 seconds

Prefix codes:
A --- 0
B --- 10
C --- 110
D --- 111

1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice: 2

Enter a Message: ABBACD
Encoded Message = 010100110

Time taken to encode a message: 0.00 seconds

1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice: 3

Enter an Encoded message: 010100110
Decoded Message = ABBACD

Time taken to decode a message: 0.00 seconds

1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice: 4
'''