package Decorator;
/**
 * @Component�������װ����
 * ����������������ϡ����ӵ����Ρ�
 * @author dell
 *
 */
public class ConcreteDecorator extends Decorator{
	
	//���뱻������
	public ConcreteDecorator(Component component) {
		super(component);
	}
	
	//װ���߶��еķ���
	private void methodSpecial(){
		System.out.println("���η���");
	}
	
	//��д�����operate
	//����ʵ����װ�κ����Ϊ
	@Override
	public void operate(){
		this.methodSpecial();
		super.operate();
	}
}
