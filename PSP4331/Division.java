import java.util.ArrayList;
import java.util.Random;

//��������
//���꼶������������һλ������Ҳ��һλ�����������ĳ��������ڳ���
public class Division extends Operation{

	public Division(ArrayList<String> answerSet,int testNumber) {
		
		boolean isRemainder=false;          //�Ƿ���Ҫ��������
		Random rand=new Random(); //���������
		
		firstNumber=rand.nextInt(9)+1;       //(����)     �����������ΧΪ[0-9)�����������+1���ܱ������0��10�����
		secondNumber=rand.nextInt(9)+1;           //(��)   ��������ڶ����������ڳ���		
		answerNumber=firstNumber*secondNumber;      //(������)
				
		isRemainder=rand.nextBoolean();
		
		if(isRemainder)                       //��Ҫ���������
		{	
			remainder=rand.nextInt(firstNumber-1);     //��������
			answerNumber=answerNumber+remainder;    //�����µı�����
			answerSet.add("("+testNumber+")"+" "+answerNumber+" * "+firstNumber+" =");//�ѽ������ļ�����
			answerSet.add(" "+secondNumber+"..."+remainder); //�Ѵ������������
		}
		else {                 //����Ҫ�������������		
			answerSet.add("("+testNumber+")"+" "+answerNumber+" * "+firstNumber+" =");//�ѽ������ļ�����
			answerSet.add(" "+secondNumber); //�Ѵ������������
		}
	}
}
