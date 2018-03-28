package Iterator;
/**
 * 具体的迭代器
 * 可以访问到集合元素并遍历
 * 可以遍历集合对象的元素
 * @author baitp
 *
 * @param <T>
 */
public class ConcreteIterator<T> implements Iterator<T> {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public T next() {
		return null;
	}

}
