package Decorator;
/**
 * װ�ν�ɫ
 * һ����һ�������࣬��ʲô���أ�ʵ�ֽӿڻ��߳��󷽷���
 * ������ɲ�һ���г���ķ���ѽ���������������Ȼ��һ��private����ָ��Component���󹹼���
 * Ҫ�㣺����һ��������Component����������ã�������һ������󹹼��ӿ�һ�µĽӿڡ�
 * @author dell
 *
 */
public abstract class Decorator extends Component{
	private Component component = null;
	
	//ͨ�����캯�����ݱ�������
	public Decorator(Component component){
		this.component = component;
	}
	
	//ί�и���������ִ��
	@Override
	public void operate(){
		component.operate();
	}
}
