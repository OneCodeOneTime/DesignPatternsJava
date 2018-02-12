package Singleton;

import java.util.Random;

/**
 * 更好的单例模式
 * 
 * @author baitp
 *
 */
public class BetterSingletonTest {
	
	public static void main(String...args) {
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(BetterSingleton.getSole()+"--");
				}
				
			}).start();
		}
	}
	
	
}

class BetterSingleton{
	static{
		sole = new BetterSingleton();
	}
	
	public static BetterSingleton sole;
	private BetterSingleton() {
		System.out.println(new Random().nextInt(100000));
	}
	public static BetterSingleton getSole() {
		return sole;
	}
}













