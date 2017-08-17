package Strategy;
/**
 * ���Ե������ģ��Ͳ��Դ򽻵����������Ϊ�ǶԲ��Եĵ��ã�
 * �����ĺͽӿڽ��и��ӽ������̳ǵĵ����ߺ������Ĵ򽻵���
 * �ͱ������ά�޹����ͻ����Ի��ˣ�����ȥ����ֱ����ĳ��ά�޹���
 * �ͻ�ֻ�������ϲ�����صķ�������ҿͷ���㣬��վ��ͷ������㰲����Ӧ��ά�޹���
 * �����վ���߿ͷ���������������ģ�����ص�ά�޹��򽻵���
 * @author btp
 *
 */
public class ContextUseStrategy {
	/*
	 * ��װ��һ������
	 */
	private FictitiousStrategy aStrategy;
	/*
	 * ����һ�������Ķ��󣬽����Զ�����
	 */
	public ContextUseStrategy(FictitiousStrategy aStrategy){
		this.aStrategy = aStrategy;
	}
	/*
	 * ���ò���
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
