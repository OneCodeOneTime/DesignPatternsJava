package Iterator;

import java.lang.reflect.Array;

/**
 * ����ģʽ����
 * @author baitp
 *
 */
public class IteratorTest {

	public static void main(String[] args) {
		/*ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("ni");
		arrayList.add("hao");
		AbIterator<String> it = arrayList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		LinkList<String> linkList = new LinkList<>();
		linkList.add("ni");
		linkList.add("hao");
		AbIterator<String> it2 = linkList.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
	}

}

/**
 * ���󼯺ϣ��൱��Aggregate��ɫ
 * @author baitp
 */
interface AbList<T>{
	public AbIterator<T> iterator();
}
/**
 * ������������൱��Iterator��ɫ
 * @author baitp
 */
interface AbIterator<T>{
	public boolean hasNext();
	public T next();
}
/**
 * ���弯��1���൱��ConcreteAggregate��ɫ
 * �ڲ�ʹ������
 * @author baitp
 */
class ArrayList<T> implements AbList<T>{
	private T[] ts;
	private int defaultSize = 10;
	private int realSize = 0;
	private int addIndex = 0;
	public ArrayList() {}
	public ArrayList(int size) {
		realSize = size;
	}
	@SuppressWarnings("unchecked")
	public void add(T t) {
		if(null == ts) {
			ts = (T[])Array.newInstance(t.getClass(), 0 == realSize?defaultSize:realSize);
		}
		ts[addIndex++] = t;
		addIndex %= ts.length;
	}
	@Override
	public AbIterator<T> iterator() {
		return new ArrayListIterator<T>();
	}
	
	/**
	 * ���Է��ʵ����弯�ϵĵ�������һ��ʹ���ڲ���ʵ��
	 * ��һ��Ҫ���м��ϣ�ֻҪ���Է��ʵ����϶��󼴿ɣ�jdk��ArrayListҲ��ʹ�ô��ַ�ʽʵ�֡�
	 * @author baitp
	 */
	class ArrayListIterator<E> implements AbIterator<E>{
		private int index = 0;
		@Override
		public boolean hasNext() {
			return index != ts.length-1 && null != ts[index];
		}
		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			return (E) ts[index++];
		}
		
	}
}
/**
 * ���弯��2���൱��ConcreteAggregate��ɫ
 * �ڲ�ʹ������
 * @author baitp
 */
class LinkList<T> implements AbList<T>{
	Node<T> head;
	Node<T> index;
	
	public void add(T value) {
		if(null == head) {
			index = (head = new Node<T>(value,null));
		}else {
			index.next = new Node<T>(value,null);
			index = index.next;
		}
	}
	
	@Override
	public AbIterator<T> iterator() {
		return new LinkListIterator<T>();
	}
	
	/**
	 * ���Է��ʵ����弯�ϵĵ�������һ��ʹ���ڲ���ʵ��
	 * @author baitp
	 */
	class LinkListIterator<E> implements AbIterator<E>{
		@SuppressWarnings("unchecked")
		private Node<E> itIndex = (LinkList<T>.Node<E>) head;
		@Override
		public boolean hasNext() {
			return itIndex != null;
		}
		
		@Override
		public E next() {
			E value = itIndex.getValue();
			itIndex = itIndex.next;
			return value;
		}
		
	}
	/**
	 * ����Ľڵ���
	 * @author baitp
	 */
	class Node<E>{
		E value;
		Node<E> next;
		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public Node(E value, LinkList<T>.Node<E> next) {
			super();
			this.value = value;
			this.next = next;
		}
		
	}
}


