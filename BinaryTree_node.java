package binaryTree;

import java.util.Comparator;

/***
 * ���������
 * 
 * @author LaZY����־һ��
 *
 * @param <Type>
 */
public class BinaryTree_node {

	Integer data;// ������
	//Integer number;//�ڵ�Ĳ���˳��
	BinaryTree_node leftChildren;// ָ�����������ӵ�ָ����
	BinaryTree_node rightChildren;// ָ��������Ҷ��ӵ�ָ����
	BinaryTree_node parent;//ָ�������˫�׵�ָ����

	public BinaryTree_node() {
		super();
	}

	public BinaryTree_node(Integer data, BinaryTree_node leftChildren, BinaryTree_node rightChildren) {
		super();
		this.data = data;
		this.leftChildren = leftChildren;
		this.rightChildren = rightChildren;
	}

	public BinaryTree_node(Integer data) {
		super();
		this.data = data;
	}



//	@Override
//	public String toString() {
//		return "node [data=" + data + "] ";
//	}
	
	

	/***
	 * �ȽϽڵ�Ĵ�С
	 * 
	 * @param node
	 *            ���ȽϵĽڵ�
	 * @return 1���� 0����� �� -1��С
	 */
	public int comparTo(BinaryTree_node node) {
		if (this.data > node.data) {
			return 1;
		} else if (this.data == node.data) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "node [data=" + data + ", parent=" + parent + "] ";
	}
}
