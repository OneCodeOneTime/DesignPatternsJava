package Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Component����������⣺���۲��ߣ����۲��߸ı���Ҫ֪ͨ��������ע��Ĺ۲��ߣ��̳���java.util.Observable
 * java�Ѿ��ṩ�˶Թ۲���ģʽ��֧�֣�java.util.Observable�����۲��ߣ��Լ�java.util.Observer���۲��ߣ�
 * �۲��߹۲�Ķ������ڻ�ά��һ���۲��ߵ��б����Ļ���ӹ۲��ߣ�ȡ�ػ�ɾ���۲��ߡ��������仯����֪ͨ�����¶��ĵĹ۲��ߡ�
 * @author btp
 *
 */
public class ConcreteSubject extends Observable {
	//Observableά��һ���߳�ͬ����Vector
	//public synchronized void addObserver(Observer o) -> ע��һ���۲��߶���
	//public synchronized void deleteObserver(Observer o) -> ȡ��һ���۲��߶���Ķ���
	//public void notifyObservers() -> ֪ͨ���¹۲���
	//public void notifyObservers(Object arg) -> ֪ͨ���¹۲���
	//public synchronized void deleteObservers() -> ������еĹ۲���
	//protected synchronized void setChanged() -> ���ñ��۲���Ϊ�޸�״̬����ʱ��֪ͨ�����¹۲�����
	//protected synchronized void clearChanged() -> ���ñ��۲���Ϊ���޸�״̬��һ��֪ͨ��������۲���֮�����
	//public synchronized boolean hasChanged() -> ���ش�ʱ���۲����Ƿ��и���
	//public synchronized int countObservers() -> ���ش�ʱ�ڱ��۲�����ע��Ĺ۲��ߵ�����
	//and so on...add the information the ConcreteSubject contained
}
