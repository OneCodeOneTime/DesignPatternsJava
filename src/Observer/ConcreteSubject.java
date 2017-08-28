package Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Component：具体的主题：被观察者，被观察者改变了要通知在它上面注册的观察者，继承自java.util.Observable
 * java已经提供了对观察者模式的支持：java.util.Observable（被观察者）以及java.util.Observer（观察者）
 * 观察者观察的对象，在内会维护一个观察者的列表，订阅会添加观察者，取关会删除观察者。当发生变化，会通知并更新订阅的观察者。
 * @author btp
 *
 */
public class ConcreteSubject extends Observable {
	//Observable维护一个线程同步的Vector
	//public synchronized void addObserver(Observer o) -> 注册一个观察者对象
	//public synchronized void deleteObserver(Observer o) -> 取消一个观察者对象的订阅
	//public void notifyObservers() -> 通知更新观察者
	//public void notifyObservers(Object arg) -> 通知更新观察者
	//public synchronized void deleteObservers() -> 清空所有的观察者
	//protected synchronized void setChanged() -> 设置被观察者为修改状态，此时可通知并更新观察者们
	//protected synchronized void clearChanged() -> 设置被观察者为无修改状态，一般通知并更新完观察们之后调用
	//public synchronized boolean hasChanged() -> 返回此时被观察者是否有更新
	//public synchronized int countObservers() -> 返回此时在被观察者上注册的观察者的数量
	//and so on...add the information the ConcreteSubject contained
}
