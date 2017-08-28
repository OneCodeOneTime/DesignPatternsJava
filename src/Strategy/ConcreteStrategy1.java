package Strategy;
/**
 * @Component：具体的策略类：包含真正可以执行的算法
 * 从虚拟策略类继承而来。
 * 比如擅长修理笔记本的维修工A
 * @author btp
 *
 */
public class ConcreteStrategy1 extends FictitiousStrategy{

	@Override
	public void executeStrategy() {
		//算法的实现
		System.out.println("算法1执行");
	}

}
