package Decorator;
/**
 * @Component�����幹��
 * ConcreteComponent������ġ���ԭʼ��������Ľӿڻ�������ʵ�֣���Ҫװ�εľ�������
 * �䵱�ˡ���װ���ߡ��Ľ�ɫ�� 
 * װ����Ҫװ�εĶ����������
 * @author dell
 *
 */
public class ConcreteComponent extends Component{

	@Override
	public void operate() {
		System.out.println("do something");
	}

}
