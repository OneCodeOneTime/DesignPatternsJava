package Template;
/**
 * ģ��ģʽ�ǶԶ�̬���̳к͸�д�����õ�Ӧ�á�ģ�����һ���潫һЩ�����ӳٵ�������ʵ�֣��������㷨����չ��һ����Ҳʡȥ�˴������ظ����롣
 * �ͱ�������ȥ�����񣬱��ĸ�ʽ���ǹ̶��ģ���ֻ��Ҫ��������д���ݼ��ɣ�����Ҫÿ��ȥ���л�Ҫ�Լ�����������
 * ģ��ģʽ�����˴���ķ����̶ȣ�����coder��ע���������ڴ���Ŀɱ䲿�֡��ܲ���ȥ�Է���Ҫ����ʳ�á�
 * ������-�պ�ԭ��
 * 
 * ������һ�����ӣ�������Ƹ�����ӡ���Ƹ�����̴�����ͬ��ֻ�������ܲ�ͬ��λ��ӦƸ������ͬ��
 * @author btp
 *
 */
public class TemplateTest {

	public static void main(String[] args) {
		RecruitProcess recruit = new GoodJavaRecruit();
		recruit.RecruitProcesses();
		System.out.println("---------------------------");
		recruit = new BadJavaRecruit();
		recruit.RecruitProcesses();
		System.out.println("---------------------------");
		recruit = new GreatTestEngineerRecruit();
		recruit.RecruitProcesses();
		System.out.println("---------------------------");
	}

}

abstract class RecruitProcess{
	/*
	 * ��һ����˾�ĽǶ�������Ƹ�Ĵ�������
	 */
	public final void RecruitProcesses(){
		//������Ƹ��Ϣ
		releaseRecruitInformation();
		//ɸѡ����
		screenResume();
		if(resumeQualified()){
			//����ͨ����绰ԤԼ����
			appointmentForWTest();
			//ӦƸ�߱���
			writtenExam();
			if(goodWwrittenExam()){
				//���Ժϸ�
				//����ͨ��֮������
				interview();
				if(goodInterview()){
					//����ͨ���ʼ�����¼ȡ��Ϣ
					emailForSuccess();
				}else{
					//���Բ��ϸ�֪ͨ������
					emailForFail();
				}
			}else{
				//���Բ��ϸ�֪ͨ������
				emailForFail();
			}
		}else{
			//�������ϸ�֪ͨ������
			emailForFail();
		}
	}
	
	/*
	 * ��˾������Ƹ��Ϣ
	 */
	void releaseRecruitInformation(){
		System.out.println("--���������Ϸ�����Ƹ��Ϣ--");
	}
	
	/*
	 * ɸѡ����
	 */
	void screenResume(){
		System.out.println("--����ɸѡ����ѡ���������ļ���--");
	}
	
	/*
	 * ���ӷ�����Ӱ�����̣������Ƿ�ϸ�
	 * Ĭ�Ϻϸ񷵻�true
	 */
	boolean resumeQualified(){
		return true;
	}
	
	/*
	 * ��绰��ӦƸ��ԤԼ����
	 */
	void appointmentForWTest(){
		System.out.println("--��绰����Ƹ��ԤԼ����--");
	}
	
	/*
	 * ӦƸ�߱��ԣ��ӳٸ�ӦƸ��ʵ��
	 */
	abstract void writtenExam();
	
	/*
	 * ���ӷ�����Ӱ�����̣������Ƿ�ϸ�
	 * Ĭ�Ϻϸ񷵻�true
	 */
	boolean goodWwrittenExam(){
		return true;
	}
	
	/*
	 * ӦƸ�����ԣ��ӳٸ�ӦƸ��ʵ��
	 */
	abstract void interview();
	
	/*
	 * ���ӷ�����Ӱ�����̣������Ƿ�ϸ�
	 * Ĭ�Ϻϸ񷵻�true
	 */
	boolean goodInterview(){
		return true;
	}
	
	/*
	 * �ʼ�֪ͨӦƸ�߳ɹ�¼ȡ
	 */
	void emailForSuccess(){
		System.out.println("--��ϲ������˾¼ȡ��--");
	}
	
	/*
	 * �ʼ�֪ͨӦƸout
	 */
	void emailForFail(){
		System.out.println("--���ź�����������˾��Ҫ���ڴ��´κ�������--");
	}
}

/**
 * ��Ƹjava����ʦ
 * @author btp
 *
 */
class GoodJavaRecruit extends RecruitProcess{
	
	//java����ʦ�ļ��������Ա��У�����Ů������ɸѡͨ����
	
	/*
	 * java����
	 * @see Template.RecruitProcess#writtenExam()
	 */
	@Override
	void writtenExam() {
		System.out.println("��ţ��Java���ԣ�������Ƕ��󣬻����Ҳ�������...");
	}
	
	/*
	 * java����
	 * @see Template.RecruitProcess#interview()
	 */
	@Override
	void interview() {
		System.out.println("��ţ����Java���ԣ�٩٩��̸��������֪�����ǲ�֪����������...");
	}
	
}

class BadJavaRecruit extends RecruitProcess{
	
	//java����ʦ�ļ�����ǿ���ԣ����������޶����ް��á�
	
	/*
	 * java����
	 * @see Template.RecruitProcess#writtenExam()
	 */
	@Override
	void writtenExam() {
		System.out.println("С����Java���ԣ�������Ƕ��󣬲�֪����ô���ٶ���ͻ��տռ�...");
	}
	
	/*
	 * java����
	 * @see Template.RecruitProcess#interview()
	 */
	@Override
	void interview() {
		System.out.println("С�˽���Java���ԣ��Ҳ���coder����ֻ��bug�İ��˹�...");
	}
	
	/*
	 * ���ӷ�����Ӱ�����̣������Ƿ�ϸ�
	 * Ĭ�Ϻϸ񷵻�true
	 */
	boolean goodWwrittenExam(){
		System.out.println("--���Բ��ϸ�--");
		return false;
	}
}

/**
 * ���Թ���ʦ��Ƹ
 */
class GreatTestEngineerRecruit extends RecruitProcess{
	
	//���Թ���ʦ����ʦ�ļ�����ʲôbug�������ж���HelloKitty
	
	/*
	 * ���Ա���
	 * @see Template.RecruitProcess#writtenExam()
	 */
	@Override
	void writtenExam() {
		System.out.println("����֮�������Ա��ԣ�һ���������ܵ��߼�֮����������...");
	}
	
	/*
	 * ��������
	 * @see Template.RecruitProcess#interview()
	 */
	@Override
	void interview() {
		System.out.println("����֮����в������ԣ�ʲôlinux��ʲôsql�������г����˻�Ծ������...");
	}
}


