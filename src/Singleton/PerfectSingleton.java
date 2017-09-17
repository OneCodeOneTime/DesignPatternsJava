package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * enum除了不能继承类这方面，其他方面就像一个普通的类。
 * 使用enum来创建单例有一个很大的好处，就是枚举的构造器在枚举外是不可调用的，通过反射也不能调用，jvm保证了这一点，
 * 这就像专门为单例设计的一样。
 * 枚举也可以拥有属性，方法，所以枚举就是单例实现的良好土壤。
 * @author baitp
 *
 */
public enum PerfectSingleton {
	SOLE("单例对象"){
		//枚举的方法
		public void printDesc() {
			System.out.println(desc);
		}
	};
	
	//枚举的属性
	String desc;
	//构造器不管是不是private的，都只能在内部使用
	PerfectSingleton(String desc){
		this.desc = desc;
		System.out.println("----构造对象----");
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
