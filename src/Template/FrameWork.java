package Template;

/**
 * 定义：定义一个操作中算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变算法的结构即可重定义该算法中的某些特定步骤。
 * 思想：主框架相同，细节不同。
 * 和策略模式的不同点：策略模式就是定义算法族, 然后通过组合算法族和委托的办法来实现类, 模板方法则是父类定义算法的骨架，子类再来实现骨架中的部分步骤。
 * @Component：抽象模板（Abstract Template）：
 * ①给出一个逻辑流程的完整框架方法，流程中的方法可以是具体方法或抽象方法，实现一个业务或算法逻辑。
 * ②定义流程框架中的抽象方法，待子类实现。
 * @author btp
 *
 */
public abstract class FrameWork {
	/*
	 * 模板方法：搭建逻辑框架，比如业务流程，一般修饰为final，防止子类的重写
	 */
	public final void LogicFrameWork(){
		//完整的逻辑流程
		regularStep1();
		if(doJudge()){
			regularStep2();
		}
		variableStep1();
		variableStep2();
	}
	
	/*
	 * 普通方法：逻辑框架中的固定步骤，一般子类最好不建议重写这部分的方法，代表了流程中的固定部分。
	 */
	void regularStep1(){
		System.out.println("FrameWork.regularStep1()");
	}
	void regularStep2(){
		System.out.println("FrameWork.regularStep2()");
	}
	
	/*
	 * 钩子方法（Hook Method）：一般提供空实现，子类去拓展，从而达到影响逻辑的效果。
	 */
	boolean doJudge(){
		return false;
	}
	
	/*
	 * 抽象方法：逻辑框架中的可变步骤，交由子类实现
	 */
	abstract void variableStep1();
	abstract void variableStep2();
	
}
