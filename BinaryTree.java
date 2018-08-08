package binaryTree;

/***
 * ������ ���ֹ����ö��������ʵ�� ȱ�ݣ�1.��ǰֻ�ܲ���ֵΪInteger���͵����ݡ�2.ֻ����Ҷ�ӽڵ��λ�ò���ڵ㡣
 * ������ķ�����getEmpty������
 * 
 * @author LaZY����־һ��
 *
 */
public class BinaryTree {

	BinaryTree_node root;// �������ĸ��ڵ�
	int size = 0;// �������н�����

	/***
	 * ��ն�����
	 */
	public void clear() {
		this.root = null;
		size = 0;
	}

	/**
	 * �������ĳ�ʼ��
	 */
	public void init() {
		clear();
	}

	/**
	 * �ж϶������Ƿ�Ϊ����
	 * 
	 * @return t:���� f���ǿ�
	 */
	public boolean isEmpty() {// �������н��Ϊ0����Ϊ����
		if (this.size != 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * �ж϶������Ƿ�Ϊ����
	 * 
	 * @return t:���� f���ǿ�
	 */
	public boolean empty() {
		if (this.root == null) {// ���ڵ�Ϊ���������Ϊ����
			return false;
		} else {
			return true;
		}
	}


	/***
	 * �������Ĳ��������ʹ�ö��������ʵ��
	 * 
	 * ����Ҫ���ҵ���֦Ϊ�գ�˵����ǰ�ڵ�ΪҪ����ڵ�ĸ���
	 * 
	 * @param root
	 *            ��ǰ�������ĸ��ڵ�
	 * @param node
	 *            Ҫ����Ľڵ�
	 * @return �������ʱ�ǣ�������½ڵ㡣 �������ʱ�ǣ��������ĸ��ڵ㣨�Ѿ�������ɵĺ������
	 */
	private BinaryTree_node insert(BinaryTree_node root, BinaryTree_node node) {
		if (root == null) {// ���ʵ�λ��û�нڵ㣬�������λ�ò����½ڵ㣨�ݹ�ĳ��ڣ�
			size++;// �������������һ
			return node;
		}
		if (node.comparTo(root) > 0) {// ����Ľڵ���ڵ�ǰ�ڵ������������
			if (root.rightChildren == null) {// ��������ʱ˵����ǰ�ڵ�ΪҪ����Ľڵ�ĸ��ס�
				node.parent = root;
			}
			root.rightChildren = insert(root.rightChildren, node);// ���½ڵ���뵽����������
		} else if (node.comparTo(root) < 0) {// ����Ľڵ�С�ڵ�ǰ�ڵ������������
			if (root.leftChildren == null) {
				node.parent = root;
			}
			root.leftChildren = insert(root.leftChildren, node);// ���½ڵ���뵽����������
		} else {// ����Ľڵ���ڵ�ǰ�ڵ������Ľڵ��Ѵ���
			System.out.println("����Ѵ���");// ���ݹ�ĳ��ڣ�
		}
		return root;
	}

	/***
	 * ��ָ�������뵽������
	 * 
	 * @param node
	 *            Ҫ����Ľڵ�
	 */
	public void insert(BinaryTree_node node) {
		this.root = insert(this.root, node);
	}

	/***
	 * ��������ɾ���������ö��������ʵ��
	 * 
	 * @param root
	 *            ��ǰ�����ڷ��ʵģ��������ĸ��ڵ�
	 * @param node
	 *            Ҫɾ���Ľڵ�
	 * @return root ��ǰ�����ڷ��ʵģ��������ĸ��ڵ�
	 */
	private BinaryTree_node delete(BinaryTree_node root, BinaryTree_node node) {
		if (root == null) {// Ҫ���ʵģ��ӣ���Ϊ����,˵��ɾ���Ľڵ㲻�ڷ��ʵĶ�������
			System.out.println("ɾ���Ľڵ㲻�ڷ�Χ��");
			return root;
		}
		if (node.comparTo(root) > 0) {// ɾ���Ľڵ���ڵ�ǰ���ӣ����ĸ��ڵ�
			root.rightChildren = delete(root.rightChildren, node);// Ҫɾ���Ľڵ��ڵ�ǰ���ӣ�������������
		} else if (node.comparTo(root) < 0) {// ɾ���Ľڵ�С�ڵ�ǰ���ӣ����ĸ��ڵ�
			root.leftChildren = delete(root.leftChildren, node);// Ҫɾ���Ľڵ��ڵ�ǰ���ӣ�������������
		} else {// ɾ���Ľڵ���ڵ�ǰ���ӣ����ĸ��ڵ�
			if (root.rightChildren != null && root.leftChildren != null) {// Ҫɾ���Ľڵ����Ҷ��Ӷ�����
				root.data = findMin(root.rightChildren).data;// ���Ե�ǰ�ڵ���Ҷ���Ϊ���ڵ�������е���С�ڵ��ֵ����ֵ����ǰ�ڵ��������
				root.rightChildren = delete(root.rightChildren, root);// ���Ҷ��ӵ�������ɾ���ող鵽����С�ڵ�
			} else {// Ҫɾ���Ľڵ�ֻ��һ������û�ж���
				size--;// �������н�������һ
				// �õ�ǰλ��ָ�������ڣ����߿�ֵ���Ķ��ӣ��������ڣ����߿�ֵ���Ķ��Ӹ�ֵ����ǰλ�ã�
				root = (root.leftChildren != null) ? root.leftChildren : root.rightChildren;
			}
		}
		return root;
	}

	/***
	 * �ڶ�������ɾ��ָ���ڵ�
	 * 
	 * @param node
	 *            Ҫɾ���Ľڵ�
	 */
	public void delete(BinaryTree_node node) {
		this.root = delete(this.root, node);
	}

	/***
	 * ���Ҷ���������С�Ľڵ�
	 * 
	 * @param root
	 *            Ҫ���ҵģ��ӣ����ĸ��ڵ�
	 * @return root��Ҫ���صĽڵ�
	 */
	public BinaryTree_node findMin(BinaryTree_node root) {
		if (root == null) {// ��ǰ�ڵ�Ϊ�գ�Ҫ����������Ϊ������//��ֹ��ָ��
			return null;
		}

		if (root.leftChildren == null) {// �ݹ�ĳ���

		} else {// ��ǰ�ڵ�������ӣ���ô��С�Ľ����ڵ�ǰ�ڵ����������
			root = findMin(root.leftChildren);
		}
		return root;
	}

	/***
	 * ��ָ�����Ϊ���ڵ㿪ʼ�����������
	 * 
	 * @param node
	 *            ��������ʼ��
	 */
	public void printBefore(BinaryTree_node node) {
		if (node == null) {// �ݹ�ĳ���

		} else {
			System.out.print(node);// ��ӡ��ǰ�ڵ�
			printBefore(node.leftChildren);// ����������
			printBefore(node.rightChildren);// ����������
		}
	}

	/***
	 * ���������������
	 */
	public void printBefore() {
		if (isEmpty()) {// �����ʿ�����ʱ�������ʾ
			System.out.println("����������ʵ���һ�ſ���������");
		} else {
			System.out.print("����������Ϊ����");// ��ʽ
			printBefore(this.root);// ����������
			System.out.println("��");// ��ʽ
		}
	}

	/***
	 * ��ö������н��ĸ���
	 * 
	 * @return ���ĸ���
	 */
	public int getSize() {
		return this.size;
	}

	/***
	 * ���ݵ�ǰ�ĸ��ڵ��������в���ָ���ڵ�
	 * 
	 * @param root
	 *            ��ǰ�ĸ��ڵ�
	 * @param node
	 *            Ҫ���ҵ�ָ���ڵ�
	 * @return node ���ҵ��Ľڵ�
	 */
	private BinaryTree_node getEmpty(BinaryTree_node root, BinaryTree_node node) {
		if (root == null) {// ���ʵ�λ��û�нڵ㣬��ʲôҲû�鵽�����ݹ�ĳ��ڣ�
			return null;
		}
		int compar = node.comparTo(root);
		if (compar > 0) {// Ҫ���ҵĽڵ���ڵ�ǰ�ڵ������������
			return getEmpty(root.rightChildren, node);// ���½ڵ���뵽����������
		} else if (compar < 0) {// Ҫ���ҵĽڵ�С�ڵ�ǰ�ڵ������������
			return getEmpty(root.leftChildren, node);// ���½ڵ���뵽����������
			// ��������������������д����������������������������������
			// return root.leftChildren = getEmpty(root.leftChildren, node);
			// ��������������������ԭ�򣺻�������ĸ��ڵ�ı䣬��Ϊ�ҵ��Ľڵ�
		} else {// ���ҵĽڵ���ڵ�ǰ�ڵ㡣
			return root;
		}
	}

	/***
	 * ��ö�������ָ���Ľڵ�
	 * 
	 * @param node
	 *            ָ��Ҫ��õĽڵ�
	 */
	public BinaryTree_node getEmpty(BinaryTree_node node) {
		return getEmpty(this.root, node);
		// System.out.println(n);
	}

	/**
	 * ���ָ���ڵ�ĸ��ڵ�
	 * 
	 * @param node
	 *            ָ���ڵ�
	 * @return ָ���ڵ�ĸ��ڵ�
	 */
	public BinaryTree_node getParent(BinaryTree_node node) {
		return node.parent;
	}

	/**
	 * ���ָ���ڵ���游�ڵ�
	 * 
	 * @param node
	 *            ָ���ڵ�
	 * @return ָ���ڵ���游�ڵ�
	 */
	public BinaryTree_node getGrand(BinaryTree_node node) {
		if (node.parent != null) {
			return node.parent.parent;
		} else {
			return null;
		}
	}

	/***
	 * ���ָ���ڵ���ֵ�
	 * 
	 * @param node
	 *            ָ���ڵ�
	 * @return ָ���ڵ���ֵ�
	 */
	public BinaryTree_node getBrother(BinaryTree_node node) {
		if (node.parent != null && node.parent.leftChildren != null) {
			return node.parent.leftChildren.comparTo(node) == 0 ? node.parent.rightChildren : node.parent.leftChildren;
		} else {
			return null;
		}
	}

	/**
	 * ���ָ���ڵ�����壨ָ���ڵ㸸�ڵ����һ�����ӣ�
	 * 
	 * @param node
	 *            ָ���Ľڵ�
	 * @return ָ���ڵ������
	 */
	public BinaryTree_node getUncle(BinaryTree_node node) {
		return this.getBrother(node.parent);
	}

	/***
	 * �жϵ�ǰ�ڵ��Ƿ����丸�ڵ������ ���ͣ���ǰ�ڵ�ĸ��ڵ�������ǵ�ǰ�ڵ㣬��Ϊ���ӡ�
	 * 
	 * @param node
	 *            Ҫ�жϵĵ�ǰ�ڵ�
	 * @return t:������ f������
	 */
	public boolean isLeft(BinaryTree_node node) {
		if (node.parent != null) {
			return node.parent.leftChildren.comparTo(node) == 0;
		} else {// ��ǰ�ڵ��޸��ڵ㣬�����ж�
			System.out.println("�޸��ڵ�");
			return false;
		}
	}

	/***
	 * �жϵ�ǰ�ڵ��Ƿ����丸�ڵ���Һ��� ���ͣ���ǰ�ڵ㲻�����Ӽ�Ϊ�Һ���
	 * 
	 * @param node
	 *            Ҫ�жϵĵ�ǰ�ڵ�
	 * @return t:���Һ��� f������
	 */
	public boolean isRight(BinaryTree_node node) {
		return !(isLeft(node));
	}

}
