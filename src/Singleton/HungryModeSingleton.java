package Singleton;
/**
 * ����ʽ����ģʽ������ص�ʱ��͹��쵥������
 * �ص㣺��Ϊ������ص�ʱ����Ѿ������˶������Բ������̰߳�ȫ�����⣬���Ǽ����ٶȻ��������ռ���ڴ档
 * û������ʹ�õ�ʱ���ټ��ء�
 * ���и��޴��ȱ�㣺���������������ϵĵ�������ͨ���������������һ������
 * @author btp
 *
 */
public class HungryModeSingleton {
	/*
	 * ����HungryModeSingleton����ĸ���
	 */
	public static volatile int count = 0;
	/*
	 * ������ֻ������Ϊprivate����ζ�Ź�����ֻ��������ʹ��
	 */
	private HungryModeSingleton() {
		synchronized(HungryModeSingleton.class) {
			count++;
		}
	}
	
	/*
	 * ͨ����������ȡ������������أ����Ե�����������Ϊpublic static
	 */
	public static HungryModeSingleton sole = new HungryModeSingleton();
	
	/*
	 * Ҳ��ͨ����������ȡ
	 */
	public static HungryModeSingleton getSole() {
		return sole;
	}
	
	public static void main(String...args) throws InstantiationException, IllegalAccessException {
		HungryModeSingleton sole = HungryModeSingleton.sole;
		HungryModeSingleton soleAlias = HungryModeSingleton.getSole();
		System.out.println("���ڴ��ڶ��������"+HungryModeSingleton.count);
		//ͬһ���൥�������ֱ��ͨ��==���Ƚ�
		System.out.println(sole == soleAlias);
		//ͨ�����乹���HungryModeSingleton��һ������
		Class<HungryModeSingleton> c = HungryModeSingleton.class;
		HungryModeSingleton anoSole = c.newInstance();
		System.out.println(sole == anoSole);
		System.out.println("���ڴ��ڶ��������"+HungryModeSingleton.count);
	}
}
