package Decorator;
/**
 * 装饰者模式的例子
 * 模拟一个房子装修的例子
 * @author dell
 *
 */
public class DecoratorTest {

	public static void main(String[] args) {
		//java的IO就是使用装饰者模式设计的，所以可以看到那种层层包裹的样子
		House house = new ElectricalEquipment(new Furniture(new Rough()));
		System.out.println(house.description());
		System.out.println("当前价格是："+house.getPrice()+"万元");
	}

}

/**
 * @Component：抽象组件->也是最本质的东西，不管怎么装饰，它的本质不变，比如一个人，再怎么化妆，她还是个人。
 * 共同的父类
 * 房子的概念
 * @author dell
 *
 */
interface House{
	//描述
	String description();
	//价格
	double getPrice();
}

/**
 * @Component：具体组件->充当被装饰的角色，初始化的角色，装饰的基础。
 * 实体->毛坯房，待装修
 * @author dell
 *
 */
class Rough implements House{

	@Override
	public String description() {
		return "毛坯房("+this.getPrice()+"万元)：";
	}

	@Override
	public double getPrice() {
		return 100;
	}
	
}

/**
 * @Component：装饰类的共同父类，也继承了抽象组件
 * 装修的概念
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
 * @Component：具体装饰类：家具类
 * @author dell
 *
 */
class Furniture extends Decoration{
	
	//被装饰者被包裹
	public Furniture(House house) {
		super(house);
	}
	
	//自己独有的方法：返回家具的价格
	public double furnitruePrice(){
		return 20;
	}
	//自己独有的方法：返回家具的描述
	public String furnitureDes(){
		return "[btp家具：它的美符合任何时代的标准。("+this.furnitruePrice()+"万元)]";
	}
	
	//修饰后的行为
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
 * @Component：具体装饰类：电器类
 * @author dell
 *
 */
class ElectricalEquipment extends Decoration{
	//被装饰者被包裹
	public ElectricalEquipment(House house) {
		super(house);
	}
	//自己独有的方法：返回电器的价格
	public double electricalEquipmentPrice(){
		return 40;
	}
	//自己独有的方法：返回电器的描述
	public String electricalEquipmentDes(){
		return "[btp电器：众里寻他千百度，想要几度就几度。("+this.electricalEquipmentPrice()+"万元)]";
	}
	
	//修饰后的行为
	@Override
	public String description() {
		return super.description()+this.electricalEquipmentDes();
	}

	@Override
	public double getPrice() {
		return super.getPrice()+this.electricalEquipmentPrice();
	}
}
