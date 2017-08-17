package Strategy;
/**
 * 具体的策略类：包含真正可以执行的算法
 * 从虚拟策略类继承而来
 * 比如擅长维修台式机的维修工B
 * @author btp
 *
 */
public class ConcreteStrategy2 extends FictitiousStrategy{

	@Override
	public void executeStrategy() {
		//算法的实现
		System.out.println("算法2执行");
	}

}
