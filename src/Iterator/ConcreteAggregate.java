package Iterator;
/**
 * 具体集合
 * 可以创建出具体的迭代器，用来遍历自身集合元素
 * @author baitp
 *
 * @param <T>
 */
public class ConcreteAggregate<T> implements Aggregate<T> {

	@Override
	public Iterator<T> iterator() {
		return new ConcreteIterator<T>();
	}

}
