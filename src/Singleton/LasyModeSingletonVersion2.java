package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����ʽ����ģʽ�汾2�������ʱ�����쵥������ֻ������Ҫʹ�õ�ʱ��Ź��죬�����������á�
 * version1�̲߳���ȫ�����Կ����ڷ��ص�������ķ�����ʹ��synchronized����������
 * �ڷ����ϼ������߳��ڵ���getSole()����ʱ��������Ѿ���һ���߳�ռ�ã��������̻߳���������
 * �����ĺ���ǽ�����ϵͳ��Ч�ʡ�
 * ������Ȼ���Դ��Ƶ����ԡ�
 * @author btp
 *
 */
public class LasyModeSingletonVersion2 {
	
	/*
	 * ��������ĸ���
	 */
	public static volatile int count = 0;
	/*
	 * ͬ���ѹ�������Ϊ˽��
	 */
	private LasyModeSingletonVersion2() {
		synchronized(LasyModeSingletonVersion2.class) {
			count++;
			System.out.println("������ĸ���Ϊ��"+count);
		}
	}
	/*
	 * ������������Ϊnull
	 */
	private static LasyModeSingletonVersion2 sole = null;
	
	public synchronized static LasyModeSingletonVersion2 getSole() {
		//ֻ��soleΪ��ʱ�Ź��죬����ֱ�ӷ���
		if(null == sole) {
			sole = new LasyModeSingletonVersion2();
		}
		return sole; 
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		/*
		 * ��ӡ�����
		 * ������ĸ���Ϊ��1
		 */
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0;i < 100;i++) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					LasyModeSingletonVersion2.getSole();
				}
				
			});
		}
		exec.shutdown();
		//ͨ��������Ȼ���Թ����µĶ���
		Class<LasyModeSingletonVersion2> c = LasyModeSingletonVersion2.class;
		LasyModeSingletonVersion2 anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("���ڴ��ڶ��������"+LasyModeSingletonVersion2.count);
	}

}
