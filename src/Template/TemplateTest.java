package Template;
/**
 * 模板模式是对多态、继承和复写的良好的应用。模板代码一方面将一些方法延迟到子类中实现，有助于算法的拓展，一方面也省去了大量的重复代码。
 * 就比如我们去填个表格，表格的格式都是固定的，你只需要往里面填写内容即可，不需要每次去银行还要自己画个表格再填。
 * 模板模式减少了代码的繁琐程度，利于coder把注意力集中在代码的可变部分。总不能去吃饭还要建个食堂。
 * “开放-闭合原则”
 * 
 * 下面是一个例子，关于招聘的例子。招聘的流程大致相同，只不过可能不同岗位的应聘会少许不同。
 * @author btp
 *
 */
public class TemplateTest {

	public static void main(String[] args) {
		RecruitProcess recruit = new GoodJavaRecruit();
		recruit.RecruitProcesses();
		System.out.println("---------------------------");
		recruit = new BadJavaRecruit();
		recruit.RecruitProcesses();
		System.out.println("---------------------------");
		recruit = new GreatTestEngineerRecruit();
		recruit.RecruitProcesses();
		System.out.println("---------------------------");
	}

}

abstract class RecruitProcess{
	/*
	 * 从一个公司的角度来看招聘的大致流程
	 */
	public final void RecruitProcesses(){
		//发布招聘信息
		releaseRecruitInformation();
		//筛选简历
		screenResume();
		if(resumeQualified()){
			//简历通过打电话预约笔试
			appointmentForWTest();
			//应聘者笔试
			writtenExam();
			if(goodWwrittenExam()){
				//笔试合格
				//笔试通过之后面试
				interview();
				if(goodInterview()){
					//面试通过邮件发送录取信息
					emailForSuccess();
				}else{
					//面试不合格通知面试者
					emailForFail();
				}
			}else{
				//笔试不合格通知面试者
				emailForFail();
			}
		}else{
			//简历不合格通知面试者
			emailForFail();
		}
	}
	
	/*
	 * 公司发布招聘信息
	 */
	void releaseRecruitInformation(){
		System.out.println("--在拉勾网上发布招聘信息--");
	}
	
	/*
	 * 筛选简历
	 */
	void screenResume(){
		System.out.println("--简历筛选，挑选符合条件的简历--");
	}
	
	/*
	 * 钩子方法：影响流程，简历是否合格
	 * 默认合格返回true
	 */
	boolean resumeQualified(){
		return true;
	}
	
	/*
	 * 打电话给应聘者预约笔试
	 */
	void appointmentForWTest(){
		System.out.println("--打电话给招聘者预约笔试--");
	}
	
	/*
	 * 应聘者笔试：延迟给应聘者实现
	 */
	abstract void writtenExam();
	
	/*
	 * 钩子方法：影响流程，笔试是否合格
	 * 默认合格返回true
	 */
	boolean goodWwrittenExam(){
		return true;
	}
	
	/*
	 * 应聘者面试：延迟给应聘者实现
	 */
	abstract void interview();
	
	/*
	 * 钩子方法：影响流程，面试是否合格
	 * 默认合格返回true
	 */
	boolean goodInterview(){
		return true;
	}
	
	/*
	 * 邮件通知应聘者成功录取
	 */
	void emailForSuccess(){
		System.out.println("--恭喜您被我司录取！--");
	}
	
	/*
	 * 邮件通知应聘out
	 */
	void emailForFail(){
		System.out.println("--很遗憾您不符合我司的要求，期待下次合作！！--");
	}
}

/**
 * 招聘java工程师
 * @author btp
 *
 */
class GoodJavaRecruit extends RecruitProcess{
	
	//java工程师的简历不错：性别男，爱好女。简历筛选通过。
	
	/*
	 * java笔试
	 * @see Template.RecruitProcess#writtenExam()
	 */
	@Override
	void writtenExam() {
		System.out.println("大牛做Java笔试：万物皆是对象，还是找不到对象...");
	}
	
	/*
	 * java面试
	 * @see Template.RecruitProcess#interview()
	 */
	@Override
	void interview() {
		System.out.println("大牛进行Java面试：侃侃而谈，无所不知，就是不知道对象在哪...");
	}
	
}

class BadJavaRecruit extends RecruitProcess{
	
	//java工程师的简历勉强可以：本科生，无对象，无爱好。
	
	/*
	 * java笔试
	 * @see Template.RecruitProcess#writtenExam()
	 */
	@Override
	void writtenExam() {
		System.out.println("小菜做Java笔试：万物皆是对象，不知道怎么销毁对象和回收空间...");
	}
	
	/*
	 * java面试
	 * @see Template.RecruitProcess#interview()
	 */
	@Override
	void interview() {
		System.out.println("小菜进行Java面试：我不是coder，我只是bug的搬运工...");
	}
	
	/*
	 * 钩子方法：影响流程，笔试是否合格
	 * 默认合格返回true
	 */
	boolean goodWwrittenExam(){
		System.out.println("--笔试不合格--");
		return false;
	}
}

/**
 * 测试工程师招聘
 */
class GreatTestEngineerRecruit extends RecruitProcess{
	
	//测试工程师工程师的简历：什么bug在我眼中都是HelloKitty
	
	/*
	 * 测试笔试
	 * @see Template.RecruitProcess#writtenExam()
	 */
	@Override
	void writtenExam() {
		System.out.println("测试之神做测试笔试：一切在我缜密的逻辑之下无所遁形...");
	}
	
	/*
	 * 测试面试
	 * @see Template.RecruitProcess#interview()
	 */
	@Override
	void interview() {
		System.out.println("测试之神进行测试面试：什么linux，什么sql，空气中充满了活跃的气氛...");
	}
}


