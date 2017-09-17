package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式单例模式版本1：类加载时不构造单例对象，只有真正要使用的时候才构造，即“随造随用”
 * 线程不安全，比如两个线程a,b同时调用LasyModeSingletonVersion1.getSole():
 * 线程a做了null == sole的判断，ok，判断结果是true，准备开始调用构造器；在a调用构造器之前，
 * 线程b刚好也做了null == sole的判断，此时a还没构造出对象，此时null == sole的结果还是true，
 * 这样a和b就会都进行构造器的调用，这样就不止一个对象了。
 * 
 * 而且通过反射同样可以构造出多个对象。
 * @author btp
 *
 */
public class LasyModeSingletonVersion1 {
	/*
	 * 计数对象的个数
	 */
	public static volatile int count = 0;
	/*
	 * 同样把构造器设为私有
	 */
	private LasyModeSingletonVersion1() {
		synchronized(LasyModeSingletonVersion1.class) {
			count++;
			System.out.println("现在类的个数为："+count);
		}
	}
	/*
	 * 声明单例对象为null
	 */
	private static LasyModeSingletonVersion1 sole = null;
	
	public static LasyModeSingletonVersion1 getSole() {
		//只有sole为空时才构造，否则直接返回
		if(null == sole) {
			sole = new LasyModeSingletonVersion1();
		}
		return sole; 
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		/*
		 * 下面程序的打印结果：
		 * 现在类的个数为：1
		 * 现在类的个数为：2
		 * 现在类的个数为：3
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
		System.out.println("现在存在对象个数："+LasyModeSingletonVersion1.count);
	}

}
