package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 懒汉式单例模式版本4:终版
 * 版本3也不安全，因为线程b获得a释放的锁之后同样会构造对象，所以如果b在获得锁
 * 之后再进行一次判断，是不是就安全了呢？结果是的，但是这种方式依然可以通过反射来再次构造一个对象。
 * 所以也不是严格意义上的完美的单例。
 * @author baitp
 *
 */
public class LasyModeSingletonVersion4 {
	/*
	 * 计数对象的个数
	 */
	public static volatile int count = 0;
	/*
	 * 同样把构造器设为私有
	 */
	private LasyModeSingletonVersion4() {
		synchronized(LasyModeSingletonVersion4.class) {
			count++;
			System.out.println("现在类的个数为："+count);
		}
	}
	/*
	 * 声明单例对象为null
	 */
	private static LasyModeSingletonVersion4 sole = null;
	
	public static LasyModeSingletonVersion4 getSole() {
		//只有sole为空时才构造，否则直接返回
		if(null == sole) {
			//在构造的临界区上加锁，而不是整个方法加锁
			synchronized(LasyModeSingletonVersion4.class) {
				//获得锁之后继续再一次判断，这样就安全了
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
		//通过反射依然可以构造新的对象
		Class<LasyModeSingletonVersion4> c = LasyModeSingletonVersion4.class;
		LasyModeSingletonVersion4 anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("现在存在对象个数："+LasyModeSingletonVersion4.count);
	}
}
