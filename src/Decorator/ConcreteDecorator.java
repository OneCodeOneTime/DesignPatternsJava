package Decorator;
/**
 * @Component：具体的装饰者
 * 负责给构件对象“贴上”附加的责任。
 * @author dell
 *
 */
public class ConcreteDecorator extends Decorator{
	
	//传入被修饰者
	public ConcreteDecorator(Component component) {
		super(component);
	}
	
	//装饰者独有的方法
	private void methodSpecial(){
		System.out.println("修饰方法");
	}
	
	//重写父类的operate
	//这其实就是装饰后的行为
	@Override
	public void operate(){
		this.methodSpecial();
		super.operate();
	}
}
