package Strategy;

import java.lang.reflect.Array;
import java.util.Arrays;

//һ�������㷨��
public class StrategyTest {

	public static void main(String[] args) {
		//�ͻ���
		//ʹ��ð������
		SortUse<Integer> user = new SortUse<Integer>(new Integer[]{99,2,100,33,2,2,3,555,6,7,88},new BubbleSort<Integer>());
		System.out.println("ð������ǰ��"+user);
		user.sort();
		System.out.println("ð�������"+user);
		//ʹ�ò�������
		user.setT(new Integer[]{45,2,4,111,98,54,0,1,2});
		user.setSort(new InsertSort<Integer>());
		System.out.println("��������ǰ��"+user);
		user.sort();
		System.out.println("���������"+user);
		//ʹ��ֱ��ѡ������
		user.setT(new Integer[]{45,2,4,111,98,54,0,1,2});
		user.setSort(new SelectionSort<Integer>());
		System.out.println("ֱ��ѡ������ǰ��"+user);
		user.sort();
		System.out.println("ֱ��ѡ�������"+user);
		//ʹ�ù鲢����
		user.setT(new Integer[]{45,2,4,111,98,54,0,1,2});
		user.setSort(new MergeSort<Integer>());
		System.out.println("�鲢����ǰ��"+user);
		user.sort();
		System.out.println("�鲢�����"+user);
		//ʹ�ù鲢����
		user.setT(new Integer[]{111,98,54,45,4,2,2,1,0});
		user.setSort(new QuickSort<Integer>());
		System.out.println("��������ǰ��"+user);
		user.sort();
		System.out.println("���������"+user);
	}
}



/*
 * @Component�������㷨�������ģ�����һ�������㷨�����á����㷨���������������㷨��
 */
class SortUse<T extends Comparable<? super T>>{
	private Sort<T> sort;
	private T[] t;
	
	//����Ҫ����Ķ������顢�Ƚ����Լ�Ҫʹ�õ������㷨
	public SortUse(T[] t,Sort<T> sort){
		this.sort = sort;
		this.t = t;
	}
	
	public void sort(){
		this.sort.sort(t);
	}
	
	public Sort<T> getSort() {
		return sort;
	}

	public void setSort(Sort<T> sort) {
		this.sort = sort;
	}
	
	public T[] getT() {
		return t;
	}

	public void setT(T[] t) {
		this.t = t;
	}

	public String toString(){
		return Arrays.toString(t);
	}
}

/*
 *@Component������������ࣺ����һ�������㷨���� Ϊ�����Ķ������˹����ӿڡ�
 */
abstract class Sort<T extends Comparable<? super T>>{
	public abstract void sort(T[] t);
}

/*
 * ������㷨ʵ���ࣺʵ����������Ľӿ�
 * ������㷨ʵ���ࣺð������
 */
class BubbleSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		T temp;
		for(int i = t.length-1;i>=0;i--){
			for(int j = i-1;j>=0;j--){
				if(t[i].compareTo(t[j]) < 0){
					temp = t[i];
					t[i] = t[j];
					t[j] = temp;
				}
			}
		}
	}
}

/*
 * @Component��������㷨ʵ���ֱࣺ�Ӳ�������
 * ��ֵ����һ���Ѿ��ź��������
 */
class InsertSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		T temp;
		//�ӵ�һ����ʼ��
		for(int i = 1;i < t.length;i++){
			for(int j = 0;j < i;j++){
				if(t[i].compareTo(t[j]) < 0){
					temp = t[i];
					//Ҫ�����λ��֮���Ԫ��ȫ�������
					for(int k = i;k > j;k--){
						t[k] = t[k-1];
					}
					t[j] = temp;
					break;
				}
			}
		}
	}
	
}

/*
 * @Component��������㷨ʵ���ࣺϣ������
 * 
 */
class ShellSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		
	}
	
}


/*
 * @Component��������㷨ʵ���ֱࣺ��ѡ������
 * �Ӻ����������ѡȡ������С��ֵ��������Ѿ��ź�������еĺ�һλ����ֵ
 */
class SelectionSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		//��¼Ҫ����Ԫ�ص�����
		int index;
		//��¼��Сֵ
		T min;
		//��ʱֵ���������������ֵʹ��
		T temp;
		for(int i = 0;i < t.length-1;i++){
			min = t[i];
			index = i;
			for(int j = i+1;j < t.length;j++){
				if(min.compareTo(t[j]) > 0){
					min = t[j];
					index = j;
				}
			}
			temp = t[i];
			t[i] = t[index];
			t[index] = temp;
		}
	}
	
}

/*
 * @Component��������㷨ʵ���ࣺ������
 * 
 */
class HeapSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		// TODO Auto-generated method stub
		
	}
	
}


/*
 * @Component��������㷨ʵ���ࣺ�鲢����
 * ��1���������и����ź���
 * ��2���ϲ������ź�������У�ʹ֮��Ϊһ�����������
 */
class MergeSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		sort(t,0,t.length-1);
	}
	
	private void sort(T[] t,int low,int high){
		int middle = (low + high) / 2;
		if(low < high){
			//middle�������
			sort(t,low,middle);
			//middle�ұ�����
			sort(t,middle+1,high);
			//�ź�����������кϲ�
			mergeTwoList(t,low,middle,high);
		}
	} 
	
	//�����ź����������кϲ�
	@SuppressWarnings("unchecked")
	private void mergeTwoList(T[] t,int low,int middle,int high){
		if(t.length > 0 && null != t[0]){
			//����һ����ʱ���飬���������ֵ
			T[] temp = (T[]) Array.newInstance(t[0].getClass(), high - low +1);
			int headOfList1 = low;
			int headOfList2 = middle + 1;
			int indexOfTemp = 0;
			while(headOfList1 <= middle && headOfList2 <= high){
				if(t[headOfList1].compareTo(t[headOfList2]) < 0){
					temp[indexOfTemp++] = t[headOfList1++];
				}else{
					temp[indexOfTemp++] = t[headOfList2++];
				}
			}
		
			//��ʱһ����һ�������߿ջ����������߿գ�����һ������Ĳ��������Ƶ���ʱ������
			while(headOfList1 <= middle){
				temp[indexOfTemp++] = t[headOfList1++];
			}
			while(headOfList2 <= high){
				temp[indexOfTemp++] = t[headOfList2++];
			}
			indexOfTemp = 0;
			//���ź������ʱ����������Ƶ�ԭ�ȵ�������
			for(int i = low;i <= high;i++){
				t[i] = temp[indexOfTemp++];
			}
		}else{
			throw new RuntimeException();
		}
		
	}
}

/*
 * @Component��������㷨ʵ���ࣺ��������
 *��1�������ݼ�֮�У�ѡ��һ��Ԫ����Ϊ"��׼"��pivot����
 *��2������С��"��׼"��Ԫ�أ����Ƶ�"��׼"����ߣ����д���"��׼"��Ԫ�أ����Ƶ�"��׼"���ұߡ�
 *��3����"��׼"��ߺ��ұߵ������Ӽ��������ظ���һ���͵ڶ�����ֱ�������Ӽ�ֻʣ��һ��Ԫ��Ϊֹ��
 */
class QuickSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		sort(t,0,t.length-1);
	}
	
	private void sort(T[] t,int low,int high){
		//low < high������²�����
		if(low < high){
			T baseObject = t[low];
			int left = low;
			int right = high;
			//��¼��һ��Ҫ�������ֵ
			int index = low;
			while(left != right){
				//��ֹ��ָ���left < right�ŵ�ǰ����
				while(left < right && t[right].compareTo(baseObject) >= 0){
					right--;
				}
				t[index] = t[right];
				t[right] = null;
				index = right;
				while(left < right && t[left].compareTo(baseObject) <= 0){
					left++;
				}
				t[index] = t[left];
				t[left] = null;
				index = left;
			}
			t[index] = baseObject;
			//���������
			sort(t,low,index-1);
			//�Ұ�������
			sort(t,index+1,high);
		}
	}
}
