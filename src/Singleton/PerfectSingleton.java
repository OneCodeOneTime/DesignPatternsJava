package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * enum���˲��ܼ̳����ⷽ�棬�����������һ����ͨ���ࡣ
 * ʹ��enum������������һ���ܴ�ĺô�������ö�ٵĹ�������ö�����ǲ��ɵ��õģ�ͨ������Ҳ���ܵ��ã�jvm��֤����һ�㣬
 * �����ר��Ϊ������Ƶ�һ����
 * ö��Ҳ����ӵ�����ԣ�����������ö�پ��ǵ���ʵ�ֵ�����������
 * @author baitp
 *
 */
public enum PerfectSingleton {
	SOLE("��������"){
		//ö�ٵķ���
		public void printDesc() {
			System.out.println(desc);
		}
	};
	
	//ö�ٵ�����
	String desc;
	//�����������ǲ���private�ģ���ֻ�����ڲ�ʹ��
	PerfectSingleton(String desc){
		this.desc = desc;
		System.out.println("----�������----");
	}
	
	abstract void printDesc();
	
	public static void main(String...args) {
		PerfectSingleton sole = PerfectSingleton.SOLE;
		System.out.println(sole.desc);
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0;i<100;i++) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(PerfectSingleton.SOLE.desc);
				}
				
			});
		}
	}
}
