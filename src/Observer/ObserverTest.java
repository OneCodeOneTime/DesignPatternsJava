package Observer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * 一个观察者模式的demo：
 * 比如一个公司有很多部门，比如行政部门，技术部门，测试部门，但是这些部门都要受董事会的管辖治理，
 * 各个部门要遵照董事会的命令来办事，这里各个部门就相当于观察者，董事会相当于被观察者。
 * @author dell
 *
 */
public class ObserverTest{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		//1.新建一个董事会
		Directorate ob = new Directorate();
		//2.董事会创建各个部门
		Observer executive = new Executive();
		Observer hr = new HR();
		Observer itu_d = new ITU_D();
		Observer td = new TD();
		ob.addObserver(executive);
		ob.addObserver(hr);
		ob.addObserver(itu_d);
		ob.addObserver(td);
		//3.董事会开始运转：发布给各个部门的指令
		ob.setIndicationForExecutive("提前开始在"+(new Date().getMonth()+2)+"月份上市的准备工作");
		ob.setIndicationForHR("招到100个人");
		ob.setIndicationForITUD("完成各个产品的扫尾工作");
		ob.setIndicationForTD("开发完成多少，测试多少");
		//3.通知各个部门
		ob.notifyObservers(new Date().getMonth()+1+"月份的工作");
		//4.也可以单独对一个部门发布命令
		ob.setIndicationForITUD("这个月开发一个新的人力管理系统");
		ob.notifyObservers("");
	}
}

/**
 * @Component：被观察者->董事会
 * 职能：对各个部门发布指示，充当被观察者的角色
 * 继承自java.util.Observable类
 * @author btp
 *
 */
class Directorate extends Observable{
	/*
	 * 给行政部门的指示
	 */
	private String indicationForExecutive;
	/*
	 * 给人力部门的指示
	 */
	private String indicationForHR;
	/*
	 * 给开发部门的指示
	 */
	private String indicationForITUD;
	/*
	 * 给测试部门的指示
	 */
	private String indicationForTD;
	
	public Directorate() {}

	
	public Directorate(String indicationForExecutive, String indicationForHR, String indicationForITUD,
			String indicationForTD) {
		super();
		this.indicationForExecutive = indicationForExecutive;
		this.indicationForHR = indicationForHR;
		this.indicationForITUD = indicationForITUD;
		this.indicationForTD = indicationForTD;
	}

	public String getIndicationForExecutive() {
		return indicationForExecutive;
	}

	public void setIndicationForExecutive(String indicationForExecutive) {
		this.indicationForExecutive = indicationForExecutive;
	}

	public String getIndicationForHR() {
		return indicationForHR;
	}

	public void setIndicationForHR(String indicationForHR) {
		this.indicationForHR = indicationForHR;
	}

	public String getIndicationForITUD() {
		return indicationForITUD;
	}

	public void setIndicationForITUD(String indicationForITUD) {
		this.indicationForITUD = indicationForITUD;
	}

	public String getIndicationForTD() {
		return indicationForTD;
	}

	public void setIndicationForTD(String indicationForTD) {
		this.indicationForTD = indicationForTD;
	}
	
	/*
	 * 重写父类的通知各个部门的方法
	 * @see java.lang.Object#toString()
	 */
	public void notifyObservers(Object arg) {
		System.out.println(this.toString());
		//表示新的指示已经拟好，可以通知各个部门了
		this.setChanged();
		super.notifyObservers(arg);
    }

	@Override
	public String toString() {
		return new SimpleDateFormat("yyyy年MM月dd日").format(new Date())+"董事会的指令 [行政部门：(" + indicationForExecutive + "), 人力资源部门：(" + indicationForHR
				+ "), 开发部门(" + indicationForITUD + "), 测试部门(" + indicationForTD + ")";
	}
	
	
}

/**
 * @Component：观察者 -> 行政部门
 * 职能：在董事会的指示下，完成公司行政部分的工作
 * 实现了java.util.Observer接口
 * @author btp
 */
class Executive implements Observer{
	private String nextStepJob;
	
	public String getNextStepJob() {
		return nextStepJob;
	}
	public void setNextStepJob(String nextStepJob) {
		this.nextStepJob = nextStepJob;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Directorate myDirectorate = null;
		if(null != o && o instanceof Directorate) {
			myDirectorate = (Directorate)o;
			//只有命令改变的时候才重新接受新的命令
			if(null == nextStepJob||(null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForExecutive()))) {
				nextStepJob = myDirectorate.getIndicationForExecutive();
				String nextStepJob = "行政部门"+arg+":"+myDirectorate.getIndicationForExecutive();
				System.out.println("行政部门收到指令(" + nextStepJob +")");
			}
			
		}else {
			throw new RuntimeException("行政部门找不到自己的董事会，无法正常工作");
		}
	}
}

/**
 * @Component：观察者 -> 人力资源部门
 * 职能：在董事会的指示下，完成公司招聘相关的工作
 * 实现了java.util.Observer接口
 * @author btp
 */
class HR implements Observer{
	private String nextStepJob;
	
	public String getNextStepJob() {
		return nextStepJob;
	}
	public void setNextStepJob(String nextStepJob) {
		this.nextStepJob = nextStepJob;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Directorate myDirectorate = null;
		if(null != o && o instanceof Directorate) {
			myDirectorate = (Directorate)o;
			//只有命令改变的时候才重新接受新的命令
			if(null == nextStepJob || (null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForHR()))) {
				nextStepJob = myDirectorate.getIndicationForHR();
				String nextStepJob = "人力资源部门"+arg+":"+myDirectorate.getIndicationForHR();
				System.out.println("人力资源部门收到指令(" + nextStepJob +")");
			}
		}else {
			throw new RuntimeException("人力资源部门找不到自己的董事会，无法正常工作");
		}
	}
}

/**
 * @Component：观察者 -> 开发部门
 * 职能：在董事会的指示下，完成公司开发工作
 * 实现了java.util.Observer接口
 * @author btp
 */
class ITU_D implements Observer{
	private String nextStepJob;
	
	public String getNextStepJob() {
		return nextStepJob;
	}
	public void setNextStepJob(String nextStepJob) {
		this.nextStepJob = nextStepJob;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Directorate myDirectorate = null;
		if(null != o && o instanceof Directorate) {
			myDirectorate = (Directorate)o;
			//只有命令改变的时候才重新接受新的命令
			if(null == nextStepJob || (null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForITUD()))) {
				nextStepJob = myDirectorate.getIndicationForITUD();
				String nextStepJob = "开发部门"+arg+":"+myDirectorate.getIndicationForITUD();
				System.out.println("开发部门收到指令(" + nextStepJob +")");
			}
		}else {
			throw new RuntimeException("开发部门找不到自己的董事会，无法正常工作");
		}
	}
}

/**
 * @Component：观察者 -> 测试部门
 * 职能：在董事会的指示下，完成公司产品的测试工作
 * 实现了java.util.Observer接口
 * @author btp
 */
class TD implements Observer{
	private String nextStepJob;
	
	public String getNextStepJob() {
		return nextStepJob;
	}
	public void setNextStepJob(String nextStepJob) {
		this.nextStepJob = nextStepJob;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Directorate myDirectorate = null;
		if(null != o && o instanceof Directorate) {
			myDirectorate = (Directorate)o;
			//只有命令改变的时候才重新接受新的命令
			if(null == nextStepJob ||(null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForTD()))) {
				nextStepJob = myDirectorate.getIndicationForTD();
				String nextStepJob = "测试部门"+arg+":"+myDirectorate.getIndicationForTD();
				System.out.println("测试部门收到指令(" + nextStepJob +")");
			}
		}else {
			throw new RuntimeException("测试部门找不到自己的董事会，无法正常工作");
		}
	}
}


