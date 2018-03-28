package Iterator;
/**
 * 迭代器接口
 * 定义了判断是否有下一个元素的hasNext方法和获取下一个元素的next方法
 * @author baitp
 *
 */
public interface Iterator<T>{
	public boolean hasNext();
	public T next();
}
