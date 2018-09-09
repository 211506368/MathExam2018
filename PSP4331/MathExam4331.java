

//������


import java.util.ArrayList;
import java.util.Random;

class MathExam4331{
	
	static ArrayList<String> answerSet;      //�𰸼���
	static int testNumber=0;                  //���	
	static int n=0;							//����
	static String errMessage;           //������Ϣ
	static int grade=1;            //�꼶��Ĭ��Ϊһ�꼶
	static boolean isErro=true;      //�Ƿ����
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length==0 || args.length>2) {
			isErro=false;
			errMessage="��������Ϊ�գ��Ҳ���������С�ڵ���2";
		}
		else if(!args[0].matches("\\d*")) {
			isErro=false;
			errMessage="��һ��������ȫΪ���֣�����������";
		}
		else if(args[0].length()>5 && args[0].matches("1|1\\d*")) {      
			isErro=false;
			errMessage="��һ������������Ŀ���������0С��9999";
		} 
		else if(args.length==2) {
			if(!args[1].matches("\\d*")) {
				isErro=false;
				errMessage="�ڶ������������꼶��ȫΪ����";
			}
			else if(!args[1].matches("[12]"))
			{
				isErro=false;
				errMessage="�ڶ������������꼶��Ϊ����1��2";
			}
			
			
		}
		
		if(isErro) {          //n����Ϸ���ʱ��
		
		n=Integer.valueOf(args[0]);
		if(args.length==2 && Integer.valueOf(args[1])==2) {			
			grade=2;
		}
		else 
			grade=0;
		answerSet=new ArrayList();
		Random rand=new Random();
		
		for(int i=1;i<=n;i++) {
			int s=rand.nextInt(2);
			s=s+grade;
			switch(s) {
				case 0:                          //Ϊ�Ӻ�ʱ
				{
					testNumber++;
					AddOperation opp=new AddOperation(answerSet,testNumber);
					break;
				}
				case 1:                      //Ϊ����ʱ
				{
					testNumber++;
					Subtraction opp=new Subtraction(answerSet,testNumber);
					break;
				}
				case 2:                    //�˷�
				{
					testNumber++;
					Multiplication opp=new Multiplication(answerSet,testNumber);
					break;
				}
				case 3:                  //����
				{
					testNumber++;
					Division opp=new Division(answerSet,testNumber);
					break;
				}
			}
			
		}
		
		//�����Ŀ(����)
		OutPutSet ops=new OutPutSet(n);
		}
		else
			System.out.println(errMessage);
		
	}

}
