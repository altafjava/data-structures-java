package com.altafjava.patterns.breadthfirstsearch;

class TreeNodeWithNext {
	int val;
	TreeNodeWithNext left;
	TreeNodeWithNext right;
	TreeNodeWithNext next;

	TreeNodeWithNext(int x) {
		val = x;
		left = right = next = null;
	}

// level order traversal using 'next' pointer
	void printLevelOrder() {
		TreeNodeWithNext nextLevelRoot = this;
		while (nextLevelRoot != null) {
			TreeNodeWithNext current = nextLevelRoot;
			nextLevelRoot = null;
			while (current != null) {
				System.out.print(current.val + " ");
				if (nextLevelRoot == null) {
					if (current.left != null)
						nextLevelRoot = current.left;
					else if (current.right != null)
						nextLevelRoot = current.right;
				}
				current = current.next;
			}
			System.out.println();
		}
	}
}
