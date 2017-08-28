package Decorator;
/**
 * װ����ģʽ������
 * ģ��һ������װ�޵�����
 * @author dell
 *
 */
public class DecoratorTest {

	public static void main(String[] args) {
		//java��IO����ʹ��װ����ģʽ��Ƶģ����Կ��Կ������ֲ�����������
		House house = new ElectricalEquipment(new Furniture(new Rough()));
		System.out.println(house.description());
		System.out.println("��ǰ�۸��ǣ�"+house.getPrice()+"��Ԫ");
	}

}

/**
 * @Component���������->Ҳ����ʵĶ�����������ôװ�Σ����ı��ʲ��䣬����һ���ˣ�����ô��ױ�������Ǹ��ˡ�
 * ��ͬ�ĸ���
 * ���ӵĸ���
 * @author dell
 *
 */
interface House{
	//����
	String description();
	//�۸�
	double getPrice();
}

/**
 * @Component���������->�䵱��װ�εĽ�ɫ����ʼ���Ľ�ɫ��װ�εĻ�����
 * ʵ��->ë��������װ��
 * @author dell
 *
 */
class Rough implements House{

	@Override
	public String description() {
		return "ë����("+this.getPrice()+"��Ԫ)��";
	}

	@Override
	public double getPrice() {
		return 100;
	}
	
}

/**
 * @Component��װ����Ĺ�ͬ���࣬Ҳ�̳��˳������
 * װ�޵ĸ���
 * @author dell
 *
 */
abstract class Decoration implements House{
	private House house;
	public Decoration(House house){
		this.house = house;
	}
	@Override
	public String description() {
		return house.description();
	}

	@Override
	public double getPrice() {
		return house.getPrice();
	}
}

/**
 * @Component������װ���ࣺ�Ҿ���
 * @author dell
 *
 */
class Furniture extends Decoration{
	
	//��װ���߱�����
	public Furniture(House house) {
		super(house);
	}
	
	//�Լ����еķ��������ؼҾߵļ۸�
	public double furnitruePrice(){
		return 20;
	}
	//�Լ����еķ��������ؼҾߵ�����
	public String furnitureDes(){
		return "[btp�Ҿߣ������������κ�ʱ���ı�׼��("+this.furnitruePrice()+"��Ԫ)]";
	}
	
	//���κ����Ϊ
	@Override
	public String description() {
		return super.description()+this.furnitureDes();
	}

	@Override
	public double getPrice() {
		return super.getPrice()+this.furnitruePrice();
	}
}

/**
 * @Component������װ���ࣺ������
 * @author dell
 *
 */
class ElectricalEquipment extends Decoration{
	//��װ���߱�����
	public ElectricalEquipment(House house) {
		super(house);
	}
	//�Լ����еķ��������ص����ļ۸�
	public double electricalEquipmentPrice(){
		return 40;
	}
	//�Լ����еķ��������ص���������
	public String electricalEquipmentDes(){
		return "[btp����������Ѱ��ǧ�ٶȣ���Ҫ���Ⱦͼ��ȡ�("+this.electricalEquipmentPrice()+"��Ԫ)]";
	}
	
	//���κ����Ϊ
	@Override
	public String description() {
		return super.description()+this.electricalEquipmentDes();
	}

	@Override
	public double getPrice() {
		return super.getPrice()+this.electricalEquipmentPrice();
	}
}
