package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����ʽ����ģʽ�汾1�������ʱ�����쵥������ֻ������Ҫʹ�õ�ʱ��Ź��죬�����������á�
 * �̲߳���ȫ�����������߳�a,bͬʱ����LasyModeSingletonVersion1.getSole():
 * �߳�a����null == sole���жϣ�ok���жϽ����true��׼����ʼ���ù���������a���ù�����֮ǰ��
 * �߳�b�պ�Ҳ����null == sole���жϣ���ʱa��û��������󣬴�ʱnull == sole�Ľ������true��
 * ����a��b�ͻᶼ���й������ĵ��ã������Ͳ�ֹһ�������ˡ�
 * 
 * ����ͨ������ͬ�����Թ�����������
 * @author btp
 *
 */
public class LasyModeSingletonVersion1 {
	/*
	 * ��������ĸ���
	 */
	public static volatile int count = 0;
	/*
	 * ͬ���ѹ�������Ϊ˽��
	 */
	private LasyModeSingletonVersion1() {
		synchronized(LasyModeSingletonVersion1.class) {
			count++;
			System.out.println("������ĸ���Ϊ��"+count);
		}
	}
	/*
	 * ������������Ϊnull
	 */
	private static LasyModeSingletonVersion1 sole = null;
	
	public static LasyModeSingletonVersion1 getSole() {
		//ֻ��soleΪ��ʱ�Ź��죬����ֱ�ӷ���
		if(null == sole) {
			sole = new LasyModeSingletonVersion1();
		}
		return sole; 
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		/*
		 * �������Ĵ�ӡ�����
		 * ������ĸ���Ϊ��1
		 * ������ĸ���Ϊ��2
		 * ������ĸ���Ϊ��3
		 */
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0;i < 100;i++) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					LasyModeSingletonVersion1.getSole();
				}
				
			});
		}
		exec.shutdown();
		Class<LasyModeSingletonVersion1> c = LasyModeSingletonVersion1.class;
		LasyModeSingletonVersion1 anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("���ڴ��ڶ��������"+LasyModeSingletonVersion1.count);
	}

}
