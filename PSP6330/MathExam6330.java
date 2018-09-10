import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.Sides;

public class MathExam6330 {		
	// ����Сѧһ�꼶��ѧ�Ӽ�������
	public static void getFirstGradeMathSubject(int n,int grade){
		/* ������������ֱ����ڴ����ʽ�ʹ�
		 ע��:��������ҿ�,���鳤��Ӧ��Ϊn+1���������������Խ��
		 */
		String[] mathSubjectArray = new String[n+1];
		mathSubjectArray[0]="";
		String[] sumArray = new String[n+1];
		sumArray[0]=null;
		for(int i=1;i<=n;i++){
		    int firstNumber;
		    int secondNumber;
		    int	thirdNumber;
		    String randomSymbol=null;
		    Random randomNumber=new Random();
		    /* ȡ������[0��21)֮�������,ǰ�������������Ϊ��ʽ������,
			�������������Ϊȷ����ʽ���ŵ����ݣ��������������10ʱ,
		       ��ʽΪ�ӷ�����֮Ϊ����
		    */
		    firstNumber=randomNumber.nextInt(21);
		    secondNumber=randomNumber.nextInt(21-firstNumber);
		    thirdNumber=randomNumber.nextInt(21);
		    if(thirdNumber>10){
		    	randomSymbol="+";
		    }else{
		    	randomSymbol="-";
		    }
		    mathSubjectArray[i]="("+i+")"+" "+firstNumber+randomSymbol+secondNumber+" = ";
		    if(randomSymbol.equals("-")){
		    	if((firstNumber-secondNumber)>=0){
		    		sumArray[i]=firstNumber-secondNumber+"";
		    	}else{
		    		sumArray[i]=secondNumber-firstNumber+"";
		    		mathSubjectArray[i]="("+i+")"+" "+secondNumber+randomSymbol+firstNumber+" = ";
		    	}
		    }else{
		    	sumArray[i]=firstNumber+secondNumber+"";
		    }
		}
		saveMathAnswer(mathSubjectArray, sumArray);
		getMathAnswer();
	}
	
	// ����Сѧ���꼶�˳�������
	public static void getSecondGradeMathSuject(int n,int grade){
		/* ������������ֱ����ڴ����ʽ�ʹ�
		 ע��:��������ҿ�,���鳤��Ӧ��Ϊn+1���������������Խ��
		 */
		String[] mathSubjectArray = new String[n+1];
		mathSubjectArray[0]="";
		String[] sumArray = new String[n+1];
		sumArray[0]=null;
		for(int i=1;i<=n;i++){
		    int firstNumber;
		    int secondNumber;
		    int	thirdNumber;
		    String randomSymbol=null;
		    Random randomNumber=new Random();
		    /* ȡ������1-9֮������������Ϊ��ʽ������,
			�������������Ϊȷ����ʽ���ŵ����ݣ��������������4ʱ,
		       ��ʽΪ�˷�����֮Ϊ����
		    */
		    firstNumber=randomNumber.nextInt(9)+1;
		    secondNumber=randomNumber.nextInt(9)+1;
		    thirdNumber=randomNumber.nextInt(9);
		    if(thirdNumber>4){
		    	randomSymbol="��";
		    }else{
		    	randomSymbol="��";
		    }
		    mathSubjectArray[i]="("+i+")"+" "+firstNumber+randomSymbol+secondNumber+" = ";
		    // �����̺�����
    		String quotient=null;
    		String remainder=null;
    		// �ж���ʽ�ǳ˷����㻹�ǳ�������
		    if(randomSymbol.equals("��")){
		    	// ����ʽΪ����ʱ��������������������ʹ����������С��81
		    	firstNumber=randomNumber.nextInt(80)+1;
		    	secondNumber=randomNumber.nextInt(80)+1;
		    	// �жϱ������Ƿ���ڳ���
		    	if(firstNumber>secondNumber){
		    		// �ж��Ƿ��ܹ�����
		    		if((firstNumber%secondNumber)==0){
		    			quotient=firstNumber/secondNumber+"";
		    			sumArray[i]=quotient;
		    		}else{
		    			quotient=firstNumber/secondNumber+"";
		    			remainder=firstNumber%secondNumber+"";
		    			sumArray[i]=quotient+"..."+remainder;
		    		}
		    	// �޸�������Ҫ��Ӧ���޸���ʽ
		    	mathSubjectArray[i]="("+i+")"+" "+firstNumber+randomSymbol+secondNumber+" = ";
		    	}else{
		    		//��������С�ڳ���ʱ���������ͳ�������
		    		if((secondNumber%firstNumber)==0){
		    			quotient=secondNumber/firstNumber+"";
		    			sumArray[i]=quotient;
		    		}else{
		    			quotient=secondNumber/firstNumber+"";
		    			remainder=secondNumber%firstNumber+"";
		    			sumArray[i]=quotient+"..."+remainder;
		    		}
		    		mathSubjectArray[i]="("+i+")"+" "+secondNumber+randomSymbol+firstNumber+" = ";
		    	}
		    }else{
		    	sumArray[i]=firstNumber*secondNumber+"";
		    }
		}
		saveMathAnswer(mathSubjectArray, sumArray);
		getMathAnswer();	
	}
	
	// �������ɵ���Ŀ����
	public static void saveMathAnswer(String[] mathSubjectArray, String[] sumArray){
		File file=new File("out.txt");
		if(!file.exists()){
			File parent=file.getParentFile();
			if(parent!=null  && !parent.exists()){
				file.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BufferedWriter bw=null;
		String str="";
		try{
			bw=new BufferedWriter(new FileWriter(file));
			// ������ʽ
			for(int i=1;i<mathSubjectArray.length;i++){
				str=mathSubjectArray[i];
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			bw.newLine();
			bw.flush();
			// ���ɴ�
			for(int i=1;i<mathSubjectArray.length;i++){
				str=mathSubjectArray[i]+sumArray[i];
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ������ɵ���Ŀ�ʹ�
	public static void getMathAnswer(){
		File file=new File("out.txt");
		BufferedReader br=null;
		String str="";
		try {
			br=new BufferedReader(new FileReader(file));
			try {
				while((str=br.readLine())!=null){
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
			System.out.println("������:��Ҫ���ɵ���Ŀ��(1-100) ���ɼ��꼶����Ŀ(1��2�꼶)");
			Scanner sc=new Scanner(System.in);
			String input=sc.nextLine();
			// ��д���������ʽ��������ʽ�����˲����ϸ�ʽ������
			String regex="(([1-9]|[1-9][0-9]|100)( ?)(1?|2{1}))";
			int n;
			int grade;
			// �ж������Ƿ��Կո��β
			int flag=0;
			if(input.matches(regex)){
				//ֻ������Ŀ�������,��:10
				for(int i=0;i<input.length();i++){
					if((input.substring(i,i+1)).equals(" ")){
						flag=1;
						break;
					}
				}
				if(flag==0){
					n=Integer.valueOf(input);
					grade=1;
					getFirstGradeMathSubject(n, grade);
					return ;
				}
				// ����Ϊ��Ŀ��+һ���ո�����,��:10+һ���ո�
				if(input.endsWith(" ")){
					n=Integer.valueOf(input.substring(0, input.length()-1));
					grade=1;
					getFirstGradeMathSubject(n, grade);
					return ;
				}else{
					// ������ϸ�ʽ����:10 1��2ʱ�����
					String[] spiltArray=null;
					spiltArray=input.split(" ");
					n=Integer.valueOf(spiltArray[0]);
					grade=Integer.valueOf(spiltArray[1]);
					if(grade==1){
						getFirstGradeMathSubject(n, grade);
					}else{
						getSecondGradeMathSuject(n, grade);
					}
					return ;
				}
			}else{
				System.out.println("�����ʽ����!"
				+ "�밴�����¸�ʽ����:\n��Ҫ���ɵ���Ŀ��(1-100)"+" "
				+ "���ɼ��꼶����Ŀ(1��2�꼶)"
				+ "\nע:���û��ָ���꼶����Ĭ������һ�꼶��ѧ����Ŀ");
			}
		
		}
	}

