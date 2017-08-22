package Template;
/**
 * 具体模板A：实现流程骨架中的可变部分。且可通过钩子方法影响 流程。
 * @author btp
 *
 */
public class ConcreteTemplateA extends FrameWork{
	
	/*
	 * 具体方法：实现了父类的抽象方法，为抽象方法提供具体实现。
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
	 * 钩子方法重写：影响流程骨架
	 */
	boolean doJudge(){
		return true;
	}

}
