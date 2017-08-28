package Strategy;
/**
 * @Component：虚拟的策略：策略的父类，表明提供策略。针对一组策略。
 * 准备一组算法，并将每一个算法封装起来，使得它们可以互换。
 * 策略模式代表一个算法族，算法之间可以相互替代，比如：
 * 我们有几个电脑维修工，维修来自客户的坏电脑，每个维修工相当于一个算法，
 * 根据电脑的类型和电脑的损坏程序安排维修工去维修，可能有些维修工擅长维修笔记本，
 * 有些擅长维修台式机，或者来了一个电脑，你搞不定我再来搞定，总有一个人能搞定
 * @author btp
 *
 */
public abstract class FictitiousStrategy {
	/*
	 * 执行策略
	 */
	public abstract void executeStrategy();
}
