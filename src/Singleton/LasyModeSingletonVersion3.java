package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����ʽ����ģʽ�汾3�������ʱ�����쵥������ֻ������Ҫʹ�õ�ʱ��Ź��죬�����������á�
 * version2�̰߳�ȫ������ÿ������Ҫ������������Ч��̫�͡�
 * �Ż��ķ�ʽ��ֻ�ڱ�Ҫ���ٽ����������������������ϼ�������version3��
 * �ڴ��������ʱ�����������ͨ����ӡ��������ַ�ʽ�ֲ���ȫ�ˣ������߳�a�����˷�����
 * �ж�null == sole��ok�����Ϊtrue���������׼��������󡣴�ʱ�߳�bҲ�����˷�����
 * ��ʱa��δ����������Դ�ʱnull == soleҲ��true���������Ѿ���a��ã�����������a��ɣ�
 * a�����˶���֮���ͷ�����b��ã�bҲ������������ֲ�ֻ��һ�������ˣ�����ͬ���̲߳���ȫ��
 * @author baitp
 *
 */
public class LasyModeSingletonVersion3 {

	/*
	 * ��������ĸ���
	 */
	public static volatile int count = 0;
	/*
	 * ͬ���ѹ�������Ϊ˽��
	 */
	private LasyModeSingletonVersion3() {
		synchronized(LasyModeSingletonVersion3.class) {
			count++;
			System.out.println("������ĸ���Ϊ��"+count);
		}
	}
	/*
	 * ������������Ϊnull
	 */
	private static LasyModeSingletonVersion3 sole = null;
	
	public static LasyModeSingletonVersion3 getSole() {
		//ֻ��soleΪ��ʱ�Ź��죬����ֱ�ӷ���
		if(null == sole) {
			synchronized(LasyModeSingletonVersion3.class) {
				//�ڹ�����ٽ����ϼ�����������������������
				sole = new LasyModeSingletonVersion3();
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
					LasyModeSingletonVersion3.getSole();
				}
				
			});
		}
		exec.shutdown();
		//ͨ��������Ȼ���Թ����µĶ���
		Class<LasyModeSingletonVersion3> c = LasyModeSingletonVersion3.class;
		LasyModeSingletonVersion3 anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("���ڴ��ڶ��������"+LasyModeSingletonVersion3.count);
	}


}
