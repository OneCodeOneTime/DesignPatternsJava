package Iterator;
/**
 * 代表集合接口
 * 定义方法，可以创建出“按顺序访问保存在我内部元素的人”，即可以创建一个迭代自身元素的迭代器
 * @author baitp
 *
 */
public interface Aggregate<T>{
	public Iterator<T> iterator();
}
