package Strategy;
/**
 * @Component���ϲ�����ߣ��������Ľ���
 * @author dell
 *
 */
public class ContextUser {

	public static void main(String[] args) {
		//ʹ���㷨1
		ContextUseStrategy context = new ContextUseStrategy(new ConcreteStrategy1());
		context.executeStrategy();
		//ʹ���㷨2
		context.setaStrategy(new ConcreteStrategy2());
		context.executeStrategy();
		//ʹ���㷨3
		context.setaStrategy(new FictitiousStrategy(){

			@Override
			public void executeStrategy() {
				//�㷨��ʵ��
				System.out.println("�㷨3ִ��");
			}
			
		});
		context.executeStrategy();
	}

}
