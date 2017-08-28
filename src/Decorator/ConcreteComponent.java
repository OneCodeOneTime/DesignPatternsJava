package Decorator;
/**
 * @Component：具体构件
 * ConcreteComponent是最核心、最原始、最基本的接口或抽象类的实现，你要装饰的就是它。
 * 充当了“被装饰者”的角色。 
 * 装饰器要装饰的对象就是它。
 * @author dell
 *
 */
public class ConcreteComponent extends Component{

	@Override
	public void operate() {
		System.out.println("do something");
	}

}
