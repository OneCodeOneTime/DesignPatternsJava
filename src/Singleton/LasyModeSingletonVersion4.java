package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ����ʽ����ģʽ�汾4:�հ�
 * �汾3Ҳ����ȫ����Ϊ�߳�b���a�ͷŵ���֮��ͬ���ṹ������������b�ڻ����
 * ֮���ٽ���һ���жϣ��ǲ��ǾͰ�ȫ���أ�����ǵģ��������ַ�ʽ��Ȼ����ͨ���������ٴι���һ������
 * ����Ҳ�����ϸ������ϵ������ĵ�����
 * @author baitp
 *
 */
public class LasyModeSingletonVersion4 {
	/*
	 * ��������ĸ���
	 */
	public static volatile int count = 0;
	/*
	 * ͬ���ѹ�������Ϊ˽��
	 */
	private LasyModeSingletonVersion4() {
		synchronized(LasyModeSingletonVersion4.class) {
			count++;
			System.out.println("������ĸ���Ϊ��"+count);
		}
	}
	/*
	 * ������������Ϊnull
	 */
	private static LasyModeSingletonVersion4 sole = null;
	
	public static LasyModeSingletonVersion4 getSole() {
		//ֻ��soleΪ��ʱ�Ź��죬����ֱ�ӷ���
		if(null == sole) {
			//�ڹ�����ٽ����ϼ�����������������������
			synchronized(LasyModeSingletonVersion4.class) {
				//�����֮�������һ���жϣ������Ͱ�ȫ��
				if(null == sole) {
					sole = new LasyModeSingletonVersion4();
				}
				
			}
		}
		return sole; 
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0;i < 100;i++) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					LasyModeSingletonVersion4.getSole();
				}
				
			});
		}
		exec.shutdown();
		//ͨ��������Ȼ���Թ����µĶ���
		Class<LasyModeSingletonVersion4> c = LasyModeSingletonVersion4.class;
		LasyModeSingletonVersion4 anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("���ڴ��ڶ��������"+LasyModeSingletonVersion4.count);
	}
}
