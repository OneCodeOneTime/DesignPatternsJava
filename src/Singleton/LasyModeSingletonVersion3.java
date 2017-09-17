package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式单例模式版本3：类加载时不构造单例对象，只有真正要使用的时候才构造，即“随造随用”
 * version2线程安全，但是每个请求都要在锁上阻塞，效率太低。
 * 优化的方式是只在必要的临界区加锁，不在整个方法上加锁，如version3。
 * 在创建对象的时候加锁，但是通过打印结果，这种方式又不安全了，比如线程a进入了方法，
 * 判断null == sole，ok，结果为true，获得锁，准备构造对象。此时线程b也进入了方法，
 * 此时a还未构造对象，所以此时null == sole也是true，但是锁已经被a获得，所以阻塞等a完成，
 * a构造了对象之后释放锁，b获得，b也构造对象，所以又不只有一个对象了，所以同样线程不安全。
 * @author baitp
 *
 */
public class LasyModeSingletonVersion3 {

	/*
	 * 计数对象的个数
	 */
	public static volatile int count = 0;
	/*
	 * 同样把构造器设为私有
	 */
	private LasyModeSingletonVersion3() {
		synchronized(LasyModeSingletonVersion3.class) {
			count++;
			System.out.println("现在类的个数为："+count);
		}
	}
	/*
	 * 声明单例对象为null
	 */
	private static LasyModeSingletonVersion3 sole = null;
	
	public static LasyModeSingletonVersion3 getSole() {
		//只有sole为空时才构造，否则直接返回
		if(null == sole) {
			synchronized(LasyModeSingletonVersion3.class) {
				//在构造的临界区上加锁，而不是整个方法加锁
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
		//通过反射依然可以构造新的对象
		Class<LasyModeSingletonVersion3> c = LasyModeSingletonVersion3.class;
		LasyModeSingletonVersion3 anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("现在存在对象个数："+LasyModeSingletonVersion3.count);
	}


}
