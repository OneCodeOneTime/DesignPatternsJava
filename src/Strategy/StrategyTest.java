package Strategy;

import java.lang.reflect.Array;
import java.util.Arrays;

//一个排序算法族
public class StrategyTest {

	public static void main(String[] args) {
		//客户端
		//使用冒泡排序
		SortUse<Integer> user = new SortUse<Integer>(new Integer[]{99,2,100,33,2,2,3,555,6,7,88},new BubbleSort<Integer>());
		System.out.println("冒泡排序前："+user);
		user.sort();
		System.out.println("冒泡排序后："+user);
		//使用插入排序
		user.setT(new Integer[]{45,2,4,111,98,54,0,1,2});
		user.setSort(new InsertSort<Integer>());
		System.out.println("插入排序前："+user);
		user.sort();
		System.out.println("插入排序后："+user);
		//使用直接选择排序
		user.setT(new Integer[]{45,2,4,111,98,54,0,1,2});
		user.setSort(new SelectionSort<Integer>());
		System.out.println("直接选择排序前："+user);
		user.sort();
		System.out.println("直接选择排序后："+user);
		//使用归并排序
		user.setT(new Integer[]{45,2,4,111,98,54,0,1,2});
		user.setSort(new MergeSort<Integer>());
		System.out.println("归并排序前："+user);
		user.sort();
		System.out.println("归并排序后："+user);
		//使用归并排序
		user.setT(new Integer[]{111,98,54,45,4,2,2,1,0});
		user.setSort(new QuickSort<Integer>());
		System.out.println("快速排序前："+user);
		user.sort();
		System.out.println("快速排序后："+user);
	}
}



/*
 * @Component：排序算法的上下文：持有一个排序算法的引用。和算法交互。调用排序算法。
 */
class SortUse<T extends Comparable<? super T>>{
	private Sort<T> sort;
	private T[] t;
	
	//传入要排序的对象数组、比较器以及要使用的排序算法
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
 *@Component：排序的虚拟类：代表一个排序算法对象。 为上下文对象定义了公共接口。
 */
abstract class Sort<T extends Comparable<? super T>>{
	public abstract void sort(T[] t);
}

/*
 * 具体的算法实现类：实现了虚拟类的接口
 * 具体的算法实现类：冒泡排序
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
 * @Component：具体的算法实现类：直接插入排序
 * 将值插入一个已经排好序的序列
 */
class InsertSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		T temp;
		//从第一个开始排
		for(int i = 1;i < t.length;i++){
			for(int j = 0;j < i;j++){
				if(t[i].compareTo(t[j]) < 0){
					temp = t[i];
					//要插入的位置之后的元素全部向后移
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
 * @Component：具体的算法实现类：希尔排序
 * 
 */
class ShellSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		
	}
	
}


/*
 * @Component：具体的算法实现类：直接选择排序
 * 从后面的序列中选取最大或最小的值，将其和已经排好序的序列的后一位交换值
 */
class SelectionSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		//记录要交换元素的坐标
		int index;
		//记录最小值
		T min;
		//临时值，交换两个坐标的值使用
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
 * @Component：具体的算法实现类：堆排序
 * 
 */
class HeapSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		// TODO Auto-generated method stub
		
	}
	
}


/*
 * @Component：具体的算法实现类：归并排序
 * （1）两个序列各自排好序
 * （2）合并两个排好序的序列，使之成为一个有序的序列
 */
class MergeSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		sort(t,0,t.length-1);
	}
	
	private void sort(T[] t,int low,int high){
		int middle = (low + high) / 2;
		if(low < high){
			//middle左边排序
			sort(t,low,middle);
			//middle右边排序
			sort(t,middle+1,high);
			//排好序的两个序列合并
			mergeTwoList(t,low,middle,high);
		}
	} 
	
	//两个排好序的数组进行合并
	@SuppressWarnings("unchecked")
	private void mergeTwoList(T[] t,int low,int middle,int high){
		if(t.length > 0 && null != t[0]){
			//构建一个临时数组，存放排序后的值
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
		
			//此时一定有一个数组走空或两个数组走空，把另一个数组的残余数据移到临时数据中
			while(headOfList1 <= middle){
				temp[indexOfTemp++] = t[headOfList1++];
			}
			while(headOfList2 <= high){
				temp[indexOfTemp++] = t[headOfList2++];
			}
			indexOfTemp = 0;
			//把排好序的临时数组的数据移到原先的数组中
			for(int i = low;i <= high;i++){
				t[i] = temp[indexOfTemp++];
			}
		}else{
			throw new RuntimeException();
		}
		
	}
}

/*
 * @Component：具体的算法实现类：快速排序
 *（1）在数据集之中，选择一个元素作为"基准"（pivot）。
 *（2）所有小于"基准"的元素，都移到"基准"的左边；所有大于"基准"的元素，都移到"基准"的右边。
 *（3）对"基准"左边和右边的两个子集，不断重复第一步和第二步，直到所有子集只剩下一个元素为止。
 */
class QuickSort<T extends Comparable<? super T>> extends Sort<T>{

	@Override
	public void sort(T[] t) {
		sort(t,0,t.length-1);
	}
	
	private void sort(T[] t,int low,int high){
		//low < high的情况下才排序
		if(low < high){
			T baseObject = t[low];
			int left = low;
			int right = high;
			//记录下一个要填的坐标值
			int index = low;
			while(left != right){
				//防止空指针把left < right放到前面来
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
			//左半区排序
			sort(t,low,index-1);
			//右半区排序
			sort(t,index+1,high);
		}
	}
}
