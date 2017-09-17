package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式单例模式版本2：类加载时不构造单例对象，只有真正要使用的时候才构造，即“随造随用”
 * version1线程不安全，所以可以在返回单例对象的方法上使用synchronized，加上锁。
 * 在方法上加锁，线程在调用getSole()方法时，如果锁已经被一个线程占用，则其他线程会先阻塞。
 * 这样的后果是降低了系统的效率。
 * 反射依然可以打破单例性。
 * @author btp
 *
 */
public class LasyModeSingletonVersion2 {
	
	/*
	 * 计数对象的个数
	 */
	public static volatile int count = 0;
	/*
	 * 同样把构造器设为私有
	 */
	private LasyModeSingletonVersion2() {
		synchronized(LasyModeSingletonVersion2.class) {
			count++;
			System.out.println("现在类的个数为："+count);
		}
	}
	/*
	 * 声明单例对象为null
	 */
	private static LasyModeSingletonVersion2 sole = null;
	
	public synchronized static LasyModeSingletonVersion2 getSole() {
		//只有sole为空时才构造，否则直接返回
		if(null == sole) {
			sole = new LasyModeSingletonVersion2();
		}
		return sole; 
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		/*
		 * 打印结果：
		 * 现在类的个数为：1
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
		//通过反射依然可以构造新的对象
		Class<LasyModeSingletonVersion2> c = LasyModeSingletonVersion2.class;
		LasyModeSingletonVersion2 anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("现在存在对象个数："+LasyModeSingletonVersion2.count);
	}

}
