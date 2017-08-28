package Decorator;
/**
 * @Component：抽象构件
 * 通常是一个抽象类或者一个接口，定义了属性或者方法，方法的实现可以由子类实现或者自己实现。
 * 通常不会直接使用该类，而是通过继承该类来实现特定的功能，它约束了整个继承树的行为。
 * 比如说，如果Component代表人，即使通过装饰也不会使人变成别的动物。 
 * 作用：给出一个抽象接口，以规范准备接收附加责任的对象。
 * Component是一个接口或者是抽象类，就是定义我们最核心的对象，也就是最原始的对象。
 * @author dell
 *
 */
public abstract class Component {
	abstract void operate();
}
