

//������


import java.util.ArrayList;
import java.util.Random;

class MathExam4331{
	
	static ArrayList<String> answerSet;      //�𰸼���
	static int testNumber=0;                  //���	
	static int n=0;                            //����
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length!=0) {     //n����Ϸ���ʱ��
		
		n=Integer.valueOf(args[0]);
		answerSet=new ArrayList();
		Random rand=new Random();
		
		for(int i=1;i<=n;i++) {
			int s=rand.nextInt(2);
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
			}
			
		}
		
		//�����Ŀ(����)
		OutPutSet ops=new OutPutSet(n);
		}
		else
			System.out.println("��������������С��20000������");
		
	}

}
