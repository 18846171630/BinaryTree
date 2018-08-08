package binaryTree;

public class BinaryTree_test {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		System.out.println("--------------�������ĳ�ʼ��------------------\n");
		binaryTree.init();
		System.out.println("�鿴��ʼ����Ķ�����Ϊ��");
		binaryTree.printBefore();
		System.out.println("--------------��������в�������--------------\n");
		System.out.println("��˳����룺6��2��8��1��5��3��4");
		binaryTree.insert(new BinaryTree_node(6));
		binaryTree.insert(new BinaryTree_node(2));
		binaryTree.insert(new BinaryTree_node(8));
		binaryTree.insert(new BinaryTree_node(1));
		binaryTree.insert(new BinaryTree_node(5));
		binaryTree.insert(new BinaryTree_node(3));
		binaryTree.insert(new BinaryTree_node(4));
		System.out.println("�鿴�������Ľ����");
		binaryTree.printBefore();
		System.out.println("��֤���������н�����Ϊ"+binaryTree.getSize());
		System.out.println("--------------��ȡ��������ָ���ڵ������-------\n");
		System.out.println("��ȡֵΪ3��1�Ķ������Ľڵ�");
		System.out.println(binaryTree.getEmpty(new BinaryTree_node(3)));
		System.out.println(binaryTree.getEmpty(new BinaryTree_node(1)));
//		System.out.println("--------------���������ɾ������--------------\n");
//		System.out.println("ɾ����������ֵΪ 2 �Ľڵ�");
//		binaryTree.delete(new BinaryTree_node(2));
//		System.out.println("ɾ����Ķ�����Ϊ��");
//		binaryTree.printBefore();
//		System.out.println("��֤���������н�����Ϊ"+binaryTree.getSize());
		System.out.println("--------��ø��ڵ�----------------");
		System.out.println(binaryTree.getParent(binaryTree.getEmpty(new BinaryTree_node(3))));
		System.out.println("--------����游�ڵ�------------");
		System.out.println(binaryTree.getGrand(binaryTree.getEmpty(new BinaryTree_node(4))));
		System.out.println("--------����ֵ�---------------");
		System.out.println(binaryTree.getBrother(binaryTree.getEmpty(new BinaryTree_node(5))));
		System.out.println("---------�������-------------");
		System.out.println(binaryTree.getUncle(binaryTree.getEmpty(new BinaryTree_node(3))));
		System.out.println("--------�ж�ָ���ڵ��Ƿ�Ϊ����-------");
		if (binaryTree.isLeft(binaryTree.getEmpty(new BinaryTree_node(3)))) {
			System.out.println("������");
		}else {
			System.out.println("��������");
		}
		System.out.println("--------�ж�ָ���ڵ��Ƿ�Ϊ�Һ���-------");
		if (binaryTree.isRight(binaryTree.getEmpty(new BinaryTree_node(5)))) {
			System.out.println("���Һ���");
		}else {
			System.out.println("�����Һ���");
		}
	}
}
