package Template;
/**
 * ����ģ��A��ʵ�����̹Ǽ��еĿɱ䲿�֡��ҿ�ͨ�����ӷ���Ӱ�� ���̡�
 * @author btp
 *
 */
public class ConcreteTemplateA extends FrameWork{
	
	/*
	 * ���巽����ʵ���˸���ĳ��󷽷���Ϊ���󷽷��ṩ����ʵ�֡�
	 * @see Template.FrameWork#variableStep1()
	 */
	@Override
	void variableStep1() {
		System.out.println("A.variableStep1()");
	}

	@Override
	void variableStep2() {
		System.out.println("A.variableStep2()");
	}
	
	/*
	 * ���ӷ�����д��Ӱ�����̹Ǽ�
	 */
	boolean doJudge(){
		return true;
	}

}
