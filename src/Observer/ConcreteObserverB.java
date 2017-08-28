package Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Component������Ĺ۲��ࣺʵ����java�Դ���java.util.Observer�ӿ�
 * java�Ѿ��ṩ�˶Թ۲���ģʽ��֧�֣�java.util.Observable�����۲��ߣ��Լ�java.util.Observer���۲��ߣ�
 * �����۲��߷����仯ʱ������ù۲��ߵ�update()�����Թ۲��߽��и��¡�
 * @author btp
 *
 */
public class ConcreteObserverB implements Observer {
	
	/*
	 * arg�ǲ��������԰������ɶ������Ϣ���۲�����������Ȥ����ϢӦ����Observable������
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		
	}

}
