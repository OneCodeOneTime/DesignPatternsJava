package Iterator;
/**
 * ���弯��
 * ���Դ���������ĵ���������������������Ԫ��
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
