package Observer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * һ���۲���ģʽ��demo��
 * ����һ����˾�кܶಿ�ţ������������ţ��������ţ����Բ��ţ�������Щ���Ŷ�Ҫ�ܶ��»�Ĺ�Ͻ����
 * ��������Ҫ���ն��»�����������£�����������ž��൱�ڹ۲��ߣ����»��൱�ڱ��۲��ߡ�
 * @author dell
 *
 */
public class ObserverTest{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		//1.�½�һ�����»�
		Directorate ob = new Directorate();
		//2.���»ᴴ����������
		Observer executive = new Executive();
		Observer hr = new HR();
		Observer itu_d = new ITU_D();
		Observer td = new TD();
		ob.addObserver(executive);
		ob.addObserver(hr);
		ob.addObserver(itu_d);
		ob.addObserver(td);
		//3.���»Ὺʼ��ת���������������ŵ�ָ��
		ob.setIndicationForExecutive("��ǰ��ʼ��"+(new Date().getMonth()+2)+"�·����е�׼������");
		ob.setIndicationForHR("�е�100����");
		ob.setIndicationForITUD("��ɸ�����Ʒ��ɨβ����");
		ob.setIndicationForTD("������ɶ��٣����Զ���");
		//3.֪ͨ��������
		ob.notifyObservers(new Date().getMonth()+1+"�·ݵĹ���");
		//4.Ҳ���Ե�����һ�����ŷ�������
		ob.setIndicationForITUD("����¿���һ���µ���������ϵͳ");
		ob.notifyObservers("");
	}
}

/**
 * @Component�����۲���->���»�
 * ְ�ܣ��Ը������ŷ���ָʾ���䵱���۲��ߵĽ�ɫ
 * �̳���java.util.Observable��
 * @author btp
 *
 */
class Directorate extends Observable{
	/*
	 * ���������ŵ�ָʾ
	 */
	private String indicationForExecutive;
	/*
	 * ���������ŵ�ָʾ
	 */
	private String indicationForHR;
	/*
	 * ���������ŵ�ָʾ
	 */
	private String indicationForITUD;
	/*
	 * �����Բ��ŵ�ָʾ
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
	 * ��д�����֪ͨ�������ŵķ���
	 * @see java.lang.Object#toString()
	 */
	public void notifyObservers(Object arg) {
		System.out.println(this.toString());
		//��ʾ�µ�ָʾ�Ѿ���ã�����֪ͨ����������
		this.setChanged();
		super.notifyObservers(arg);
    }

	@Override
	public String toString() {
		return new SimpleDateFormat("yyyy��MM��dd��").format(new Date())+"���»��ָ�� [�������ţ�(" + indicationForExecutive + "), ������Դ���ţ�(" + indicationForHR
				+ "), ��������(" + indicationForITUD + "), ���Բ���(" + indicationForTD + ")";
	}
	
	
}

/**
 * @Component���۲��� -> ��������
 * ְ�ܣ��ڶ��»��ָʾ�£���ɹ�˾�������ֵĹ���
 * ʵ����java.util.Observer�ӿ�
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
			//ֻ������ı��ʱ������½����µ�����
			if(null == nextStepJob||(null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForExecutive()))) {
				nextStepJob = myDirectorate.getIndicationForExecutive();
				String nextStepJob = "��������"+arg+":"+myDirectorate.getIndicationForExecutive();
				System.out.println("���������յ�ָ��(" + nextStepJob +")");
			}
			
		}else {
			throw new RuntimeException("���������Ҳ����Լ��Ķ��»ᣬ�޷���������");
		}
	}
}

/**
 * @Component���۲��� -> ������Դ����
 * ְ�ܣ��ڶ��»��ָʾ�£���ɹ�˾��Ƹ��صĹ���
 * ʵ����java.util.Observer�ӿ�
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
			//ֻ������ı��ʱ������½����µ�����
			if(null == nextStepJob || (null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForHR()))) {
				nextStepJob = myDirectorate.getIndicationForHR();
				String nextStepJob = "������Դ����"+arg+":"+myDirectorate.getIndicationForHR();
				System.out.println("������Դ�����յ�ָ��(" + nextStepJob +")");
			}
		}else {
			throw new RuntimeException("������Դ�����Ҳ����Լ��Ķ��»ᣬ�޷���������");
		}
	}
}

/**
 * @Component���۲��� -> ��������
 * ְ�ܣ��ڶ��»��ָʾ�£���ɹ�˾��������
 * ʵ����java.util.Observer�ӿ�
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
			//ֻ������ı��ʱ������½����µ�����
			if(null == nextStepJob || (null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForITUD()))) {
				nextStepJob = myDirectorate.getIndicationForITUD();
				String nextStepJob = "��������"+arg+":"+myDirectorate.getIndicationForITUD();
				System.out.println("���������յ�ָ��(" + nextStepJob +")");
			}
		}else {
			throw new RuntimeException("���������Ҳ����Լ��Ķ��»ᣬ�޷���������");
		}
	}
}

/**
 * @Component���۲��� -> ���Բ���
 * ְ�ܣ��ڶ��»��ָʾ�£���ɹ�˾��Ʒ�Ĳ��Թ���
 * ʵ����java.util.Observer�ӿ�
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
			//ֻ������ı��ʱ������½����µ�����
			if(null == nextStepJob ||(null != nextStepJob && !nextStepJob.equals(myDirectorate.getIndicationForTD()))) {
				nextStepJob = myDirectorate.getIndicationForTD();
				String nextStepJob = "���Բ���"+arg+":"+myDirectorate.getIndicationForTD();
				System.out.println("���Բ����յ�ָ��(" + nextStepJob +")");
			}
		}else {
			throw new RuntimeException("���Բ����Ҳ����Լ��Ķ��»ᣬ�޷���������");
		}
	}
}


