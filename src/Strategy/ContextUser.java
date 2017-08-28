package Strategy;
/**
 * @Component：上层调用者，和上下文交互
 * @author dell
 *
 */
public class ContextUser {

	public static void main(String[] args) {
		//使用算法1
		ContextUseStrategy context = new ContextUseStrategy(new ConcreteStrategy1());
		context.executeStrategy();
		//使用算法2
		context.setaStrategy(new ConcreteStrategy2());
		context.executeStrategy();
		//使用算法3
		context.setaStrategy(new FictitiousStrategy(){

			@Override
			public void executeStrategy() {
				//算法的实现
				System.out.println("算法3执行");
			}
			
		});
		context.executeStrategy();
	}

}
