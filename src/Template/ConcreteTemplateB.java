package Template;
/**
 * @Component������ģ��B��ʵ�����̹Ǽ��еĿɱ䲿�֡��ҿ�ͨ�����ӷ���Ӱ�� ���̡�
 * @author btp
 *
 */
public class ConcreteTemplateB extends FrameWork{

	/*
	 * ���巽����ʵ���˸���ĳ��󷽷���Ϊ���󷽷��ṩ����ʵ�֡�
	 * @see Template.FrameWork#variableStep1()
	 */
	@Override
	void variableStep1() {
		System.out.println("B.variableStep1()");
	}

	@Override
	void variableStep2() {
		System.out.println("B.variableStep2()");
	}
	
	 //����д���ӷ���...
}
