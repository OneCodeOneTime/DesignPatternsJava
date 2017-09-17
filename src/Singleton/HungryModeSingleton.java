package Singleton;
/**
 * 饿汉式单例模式：类加载的时候就构造单例对象。
 * 特点：因为在类加载的时候就已经构造了对象，所以不存在线程安全的问题，但是加载速度会变慢，且占用内存。
 * 没有做到使用的时候再加载。
 * 且有个巨大的缺点：并不是真正意义上的单例，可通过反射轻易再造出一个对象。
 * @author btp
 *
 */
public class HungryModeSingleton {
	/*
	 * 计数HungryModeSingleton对象的个数
	 */
	public static volatile int count = 0;
	/*
	 * 构造器只能修饰为private，意味着构造器只能在类内使用
	 */
	private HungryModeSingleton() {
		synchronized(HungryModeSingleton.class) {
			count++;
		}
	}
	
	/*
	 * 通过类名来获取单例对象，类相关，所以单例对象设置为public static
	 */
	public static HungryModeSingleton sole = new HungryModeSingleton();
	
	/*
	 * 也可通过方法来获取
	 */
	public static HungryModeSingleton getSole() {
		return sole;
	}
	
	public static void main(String...args) throws InstantiationException, IllegalAccessException {
		HungryModeSingleton sole = HungryModeSingleton.sole;
		HungryModeSingleton soleAlias = HungryModeSingleton.getSole();
		System.out.println("现在存在对象个数："+HungryModeSingleton.count);
		//同一个类单例对象可直接通过==来比较
		System.out.println(sole == soleAlias);
		//通过反射构造出HungryModeSingleton的一个对象
		Class<HungryModeSingleton> c = HungryModeSingleton.class;
		HungryModeSingleton anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("现在存在对象个数："+HungryModeSingleton.count);
	}
}
