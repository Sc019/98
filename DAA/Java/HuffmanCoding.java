import java.util.Scanner;

class TreeNode {
    float freq;
    char data;
    TreeNode left, right;

    public TreeNode(float freq, char data) {
        this.freq = freq;
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Node {
    TreeNode data;
    Node next;

    public Node(TreeNode data) {
        this.data = data;
        this.next = null;
    }
}

public class HuffmanCoding {
    static int n = 0;
    static char[] alphabets = new char[30];
    static String[] codes = new String[30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;
        TreeNode root = null;
        boolean exitFlag = false; // Flag to exit the loop

        do {
            System.out.println("\n1)Create Huffman Tree");
            System.out.println("2)Encode a Message ");
            System.out.println("3)Decode a message ");
            System.out.println("4)Exit"); // Add "Exit" option
            System.out.print("Enter Your Choice : ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    long startTime = System.currentTimeMillis();
                    root = create();
                    long stopTime = System.currentTimeMillis();
                    System.out.println("Time taken to create Huffman Tree: " + (stopTime - startTime) + " milliseconds");
                    System.out.println("\nPrefix codes : \n");
                    preorder(root, 0, new StringBuilder());
                    break;
                case 2:
                    startTime = System.currentTimeMillis();
                    encode();
                    stopTime = System.currentTimeMillis();
                    System.out.println("Time taken to encode a message: " + (stopTime - startTime) + " milliseconds");
                    break;
                case 3:
                    startTime = System.currentTimeMillis();
                    decode(root);
                    stopTime = System.currentTimeMillis();
                    System.out.println("Time taken to decode a message: " + (stopTime - startTime) + " milliseconds");
                    break;
                case 4: // Add a case for "Exit"
                    exitFlag = true; // Set the exit flag to true
                    break;
            }
        } while (!exitFlag);
    }

    static Node insert(Node head, TreeNode t) {
        Node p = new Node(t);
        if (head == null) {
            return p;
        }
        if (t.freq < head.data.freq) {
            p.next = head;
            return p;
        }
        Node q = head;
        while (q.next != null && t.freq > q.next.data.freq)
            q = q.next;
        p.next = q.next;
        q.next = p;
        return head;
    }

    static void encode() {
        Scanner scanner = new Scanner(System.in);
        String word;
        int i, j;
        System.out.print("\nEnter a Message : ");
        word = scanner.next();
        System.out.print("\nEncoded Message = ");
        for (i = 0; i < word.length(); i++) {
            for (j = 0; j < n && alphabets[j] != word.charAt(i); j++) ;
            if (j < n) {
                System.out.print(codes[j]);
            }
        }
        System.out.println();
    }

    static TreeNode create() {
        TreeNode p, t1, t2;
        Node head;
        int num;
        char x;
        float probability;
        head = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter No. of alphabets : ");
        num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.print("\nEnter alphabet : ");
            x = scanner.next().charAt(0);
            System.out.print("\nEnter frequency : ");
            probability = scanner.nextFloat();
            p = new TreeNode(probability, x);
            head = insert(head, p);
        }
        for (int i = 1; i < num; i++) {
            t1 = head.data;
            t2 = head.next.data;
            head = head.next.next;
            p = new TreeNode(t1.freq + t2.freq, '-');
            p.left = t1;
            p.right = t2;
            head = insert(head, p);
        }
        return head.data;
    }

    static void preorder(TreeNode p, int i, StringBuilder word) {
        if (p != null) {
            if (p.left == null && p.right == null) {
                word.setLength(i);
                System.out.println(p.data + " --- " + word);
                alphabets[n] = p.data;
                codes[n++] = word.toString();
            }
            word.append('0');
            preorder(p.left, i + 1, word);
            word.setCharAt(i, '1');
            preorder(p.right, i + 1, word);
        }
    }

    static void decode(TreeNode p) {
        Scanner scanner = new Scanner(System.in);
        String word;
        TreeNode q;
        System.out.print("\nEnter an Encoded message : ");
        word = scanner.next();
        q = p;
        int i = 0;
        System.out.print("\nDecoded Message = ");
        while (i < word.length()) {
            if (word.charAt(i) == '0')
                q = q.left;
            else
                q = q.right;
            if (q.left == null && q.right == null) {
                System.out.print(q.data);
                q = p;
            }
            i++;
        }
        System.out.println();
    }
}
/*1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice : 1

Enter No. of alphabets : 5
Enter alphabet : A
Enter frequency : 0.2
Enter alphabet : B
Enter frequency : 0.15
Enter alphabet : C
Enter frequency : 0.35
Enter alphabet : D
Enter frequency : 0.15
Enter alphabet : E
Enter frequency : 0.15
Time taken to create Huffman Tree: 0 milliseconds

Prefix codes :
A --- 0
C --- 10
B --- 110
D --- 1110
E --- 1111

1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice : 2

Enter a Message : ABCE
Encoded Message = 01101011101111
Time taken to encode a message: 0 milliseconds

1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice : 3

Enter an Encoded message : 01101011101111
Decoded Message = ABCE

1)Create Huffman Tree
2)Encode a Message
3)Decode a message
4)Exit
Enter Your Choice : 4
 */