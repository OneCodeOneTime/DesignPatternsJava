package Strategy;
/**
 * 策略的上下文：和策略打交道，可以理解为是对策略的调用，
 * 上下文和接口进行复杂交互。商城的调用者和上下文打交道。
 * 就比如电脑维修工，客户电脑坏了，不会去店里直接找某个维修工，
 * 客户只会在网上查找相关的服务或者找客服姐姐，网站或客服姐姐帮你安排相应的维修工，
 * 这个网站或者客服姐姐就是这个上下文，和相关的维修工打交道。
 * @author btp
 *
 */
public class ContextUseStrategy {
	/*
	 * 封装了一个策略
	 */
	private FictitiousStrategy aStrategy;
	/*
	 * 构造一个上下文对象，将策略对象传入
	 */
	public ContextUseStrategy(FictitiousStrategy aStrategy){
		this.aStrategy = aStrategy;
	}
	/*
	 * 调用策略
	 */
	public void executeStrategy(){
		this.aStrategy.executeStrategy();
	}
	
	public FictitiousStrategy getaStrategy() {
		return aStrategy;
	}
	
	public void setaStrategy(FictitiousStrategy aStrategy) {
		this.aStrategy = aStrategy;
	}
	
}
