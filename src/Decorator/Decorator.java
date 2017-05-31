package Decorator;
/**
 * 装饰角色
 * 一般是一个抽象类，做什么用呢？实现接口或者抽象方法，
 * 它里面可不一定有抽象的方法呀，在它的属性里必然有一个private变量指向Component抽象构件。
 * 要点：持有一个构件（Component）对象的引用，并定义一个与抽象构件接口一致的接口。
 * @author dell
 *
 */
public abstract class Decorator extends Component{
	private Component component = null;
	
	//通过构造函数传递被修饰者
	public Decorator(Component component){
		this.component = component;
	}
	
	//委托给被修饰者执行
	@Override
	public void operate(){
		component.operate();
	}
}
