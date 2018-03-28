package Iterator;

import java.lang.reflect.Array;

/**
 * 迭代模式测试
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
 * 抽象集合，相当于Aggregate角色
 * @author baitp
 */
interface AbList<T>{
	public AbIterator<T> iterator();
}
/**
 * 抽象迭代器，相当于Iterator角色
 * @author baitp
 */
interface AbIterator<T>{
	public boolean hasNext();
	public T next();
}
/**
 * 具体集合1，相当于ConcreteAggregate角色
 * 内部使用数组
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
	 * 可以访问到具体集合的迭代器，一般使用内部类实现
	 * 不一定要持有集合，只要可以访问到集合对象即可，jdk的ArrayList也是使用此种方式实现。
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
 * 具体集合2，相当于ConcreteAggregate角色
 * 内部使用链表
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
	 * 可以访问到具体集合的迭代器，一般使用内部类实现
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
	 * 链表的节点类
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


