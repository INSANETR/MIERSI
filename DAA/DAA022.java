import java.util.Scanner;

class Node {
    boolean isBlack;
    boolean isNull;
    int value;
    Node left, right;

    Node(int v) {
	isNull  = (v==0);
	isBlack = (v>=0);
	value   = Math.abs(v);
    }
}

public class DAA022 {
	static Node readPreOrder(Scanner input) {
		int v = input.nextInt();
		Node aux = new Node(v);

		if (v!=0) {
			aux.left  = readPreOrder(input);
			aux.right = readPreOrder(input);
		}

		return aux;
    }

    static int minimum(Node t) {
		if (t.isNull) return Integer.MAX_VALUE;

		int minLeft  = minimum(t.left);
		int minRight = minimum(t.right);

		return Math.min(t.value, Math.min(minLeft, minRight));
    }

    static int maximum(Node t) {
		if (t.isNull) return Integer.MIN_VALUE;

		int maxLeft  = maximum(t.left);
		int maxRight = maximum(t.right);

		return Math.max(t.value, Math.max(maxLeft, maxRight));
    }

    static int size(Node t) {
		if (t.isNull) return 0;

		return 1 + size(t.left) + size(t.right);
    }

	static boolean rootProperty(Node t) {
		return t.isBlack;
	}

	static boolean leafProperty(Node t) {
		if (t.isNull && !t.isBlack) { return false; }

		if (t.isNull && t.isBlack) { return true; }

		return leafProperty(t.left) && leafProperty(t.right);
	}

	static boolean redProperty(Node t) {
		if (t.isNull) { return true;}

		if (!t.isBlack && (!t.left.isBlack || !t.right.isBlack)) { return false; }

		if (!t.isBlack && t.left.isBlack && t.right.isBlack) { return redProperty(t.left) && redProperty(t.right); }

		return redProperty(t.left) && redProperty(t.right); 
	}

	static int blackHeight(Node t) { 
    	if (t.isNull) { return 1; }

        int leftBlackHeight = blackHeight(t.left);
		if (leftBlackHeight == 0) { return 0; }

        int rightBlackHeight = blackHeight(t.right); 
		if (rightBlackHeight == 0) { return 0; }
         
		if (leftBlackHeight != rightBlackHeight) { return 0; } 
		
		if (t.isBlack) { return 1 + leftBlackHeight; }

		return 0 + leftBlackHeight;
	}

	static boolean blackProperty(Node t) {
		return blackHeight(t) > 0;
	}

	static boolean BSTProperty(Node t) {
		if (t.isNull) { return true; }

		if (!t.left.isNull && maximum(t.left) > t.value) { return false; }

		if (!t.right.isNull && minimum(t.right) < t.value) { return false; }

		return BSTProperty(t.left) && BSTProperty(t.right);
	}

    public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
	
		int A = input.nextInt();

		for (int i = 0; i < A; i++) {
			Node root = readPreOrder(input);

			if (rootProperty(root) && leafProperty(root) && redProperty(root) && blackProperty(root) && BSTProperty(root)) { System.out.println("SIM"); }

			else { System.out.println("NAO"); }
		}
	}	
}