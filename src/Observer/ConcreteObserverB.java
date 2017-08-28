package Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Component：具体的观察类：实现了java自带的java.util.Observer接口
 * java已经提供了对观察者模式的支持：java.util.Observable（被观察者）以及java.util.Observer（观察者）
 * 当被观察者发生变化时，会调用观察者的update()方法对观察者进行更新。
 * @author btp
 *
 */
public class ConcreteObserverB implements Observer {
	
	/*
	 * arg是参数，可以把它当成额外的信息，观察者真正感兴趣的信息应该在Observable对象上
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		
	}

}
