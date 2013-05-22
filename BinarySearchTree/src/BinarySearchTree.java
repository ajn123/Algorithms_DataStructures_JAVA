public class BinarySearchTree {

	private Node<Integer> root;
	
	public static void main(String[] args) {
		BinarySearchTree a = new BinarySearchTree();
		Node<Integer> one = new Node<Integer>(10);
		a.insert(one, 6);
		a.insert(one, 7);
		a.insert(one, 5);
		a.insert(one, 2);
		a.delete(one, 6);

		System.out.println(a.root.getLeft().getLeft().getElement());

	}

	public BinarySearchTree() {
		this.root = null;
	}

	private Node<Integer> insert(Node<Integer> tree, int element) {
		if (root == null) {
			root = tree;
		}

		if (tree.getElement() < element && tree.getRight() == null) {
			tree.setRight(new Node<Integer>(element));
			return tree;
		} else if (tree.getElement() >= element && tree.getLeft() == null) {
			tree.setLeft(new Node<Integer>(element));
			return tree;
		} else if (tree.getElement() < element) {
			return insert(tree.getRight(), element);
		} else {
			return insert(tree.getLeft(), element);
		}

	}

	private Node find(Node<Integer> tree, int element) {

		if (tree == null) {
			return null;
		} else if (element == tree.getElement()) {
			return tree;
		} else if (tree.getElement() < element) {
			return find(tree.getRight(), element);
		} else {
			return find(tree.getLeft(), element);
		}

	}

	private void delete(Node<Integer> tree, int element) {
		if (find(tree, element) == null) {
			return;
		} else {
			if (find(tree, element).getLeft() == null
					&& find(tree, element).getRight() == null) {
				if (element > findParent(tree, element).getElement()) {
					findParent(tree, element).setRight(null);
				} else {
					findParent(tree, element).setLeft(null);
				}
			} else if (find(tree, element).getLeft() != null
					&& find(tree, element).getRight() == null
					&& findParent(tree, element).getElement() < element)
				findParent(tree, element).setRight(
						find(tree, element).getLeft());
			else if (find(tree, element).getLeft() != null
					&& find(tree, element).getRight() == null
					&& findParent(tree, element).getElement() >= element)
				findParent(tree, element)
						.setLeft(find(tree, element).getLeft());
			else if (find(tree, element).getLeft() == null
					&& find(tree, element).getRight() != null
					&& findParent(tree, element).getElement() < element)
				findParent(tree, element).setRight(
						find(tree, element).getRight());
			else if (find(tree, element).getLeft() == null
					&& find(tree, element).getRight() != null
					&& findParent(tree, element).getElement() >= element)
				findParent(tree, element).setLeft(
						find(tree, element).getRight());
			else if (find(tree, element).getLeft() != null
					&& find(tree, element).getRight() != null
					&& findParent(tree, element).getElement() < element) {

				int next = nextSuccessor(find(tree, element)).getElement();
				delete(tree, next);
				findParent(tree, element).getRight().setElement(
						next);

			} else if (find(tree, element).getLeft() != null
					&& find(tree, element).getRight() != null
					&& findParent(tree, element).getElement() >= element) {
				
				
				int next = nextSuccessor(find(tree, element)).getElement();
				delete(tree, next);
				findParent(tree, element).getLeft().setElement(
						next);

			}

		}
	}

	private Node nextSuccessor(Node<Integer> tree) {
		if (tree.getRight() != null) {
			return getSmallest(tree.getRight());
		} else {
			return tree;
		}
	}

	private Node findParent(Node<Integer> tree, int element) {
		if (tree.getElement() == element) {
			return tree;
		} else if (tree.getLeft() != null
				&& element == tree.getLeft().getElement()) {
			return tree;
		} else if (tree.getRight() != null
				&& element == tree.getRight().getElement()) {
			return tree;

		} else if (tree.getElement() < element) {
			return findParent(tree.getRight(), element);
		} else {
			return findParent(tree.getLeft(), element);
		}
	}

	private Node getSmallest(Node<Integer> tree) {
		if (tree.getLeft() == null) {
			return tree;
		} else {
			return getSmallest(tree.getLeft());
		}
	}
}
