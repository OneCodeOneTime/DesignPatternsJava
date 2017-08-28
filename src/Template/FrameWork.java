package Template;

/**
 * ���壺����һ���������㷨�Ŀ�ܣ�����һЩ�����ӳٵ������У�ʹ��������Բ��ı��㷨�Ľṹ�����ض�����㷨�е�ĳЩ�ض����衣
 * ˼�룺�������ͬ��ϸ�ڲ�ͬ��
 * �Ͳ���ģʽ�Ĳ�ͬ�㣺����ģʽ���Ƕ����㷨��, Ȼ��ͨ������㷨���ί�еİ취��ʵ����, ģ�巽�����Ǹ��ඨ���㷨�ĹǼܣ���������ʵ�ֹǼ��еĲ��ֲ��衣
 * @Component������ģ�壨Abstract Template����
 * �ٸ���һ���߼����̵�������ܷ����������еķ��������Ǿ��巽������󷽷���ʵ��һ��ҵ����㷨�߼���
 * �ڶ������̿���еĳ��󷽷���������ʵ�֡�
 * @author btp
 *
 */
public abstract class FrameWork {
	/*
	 * ģ�巽������߼���ܣ�����ҵ�����̣�һ������Ϊfinal����ֹ�������д
	 */
	public final void LogicFrameWork(){
		//�������߼�����
		regularStep1();
		if(doJudge()){
			regularStep2();
		}
		variableStep1();
		variableStep2();
	}
	
	/*
	 * ��ͨ�������߼�����еĹ̶����裬һ��������ò�������д�ⲿ�ֵķ����������������еĹ̶����֡�
	 */
	void regularStep1(){
		System.out.println("FrameWork.regularStep1()");
	}
	void regularStep2(){
		System.out.println("FrameWork.regularStep2()");
	}
	
	/*
	 * ���ӷ�����Hook Method����һ���ṩ��ʵ�֣�����ȥ��չ���Ӷ��ﵽӰ���߼���Ч����
	 */
	boolean doJudge(){
		return false;
	}
	
	/*
	 * ���󷽷����߼�����еĿɱ䲽�裬��������ʵ��
	 */
	abstract void variableStep1();
	abstract void variableStep2();
	
}
