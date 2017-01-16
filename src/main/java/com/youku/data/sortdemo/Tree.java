package com.youku.data.sortdemo;

public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a2 = new int[] { 10, 32, 44, 65, 78, 87, 76, 54, 43, 34, 56, 99,
				9, 3, 4, 2, 7, 1, 6, 60 };
		Node n = new Node(a2[0]);

		for (int i = 1; i < a2.length; i++) {

			n.insert(new Node(a2[i]));
		}

		n.midlist(n);

	}

	static class Node {
		private int value;
		public Node left;
		public Node right;

		public Node(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
		}

		public void insert(Node n) {
			if (n.value <= this.value) {
				if (this.left == null) {
					this.left = n;
				} else {
					this.left.insert(n);
				}
			} else {

				if (this.right == null) {
					this.right = n;
				} else {
					this.right.insert(n);
				}
			}
		}

		public void midlist(Node n) {
			if (n.left != null) {
				midlist(n.left);
			}
			//System.out.println("this is left ");
			System.out.println("mid list " + n.value);
			//System.out.println("this is right ");
			if (n.right != null) {
				midlist(n.right);
			}

		}

	}

}
