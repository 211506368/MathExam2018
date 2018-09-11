
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathExam6335 {
	/*
	 * ���һ�������й���MathExam���Զ�����һ��Сѧһ�꼶����ѧ���������⡣
	 *     1.Ϊ�Ӽ��˳����㷽������˷���ʵ�ʵ����ƣ�
	 *     
	 *     ��ps�����������롰00000000001����ʶ�����bug����������
	 * 		coding �� GBK
	 * 		MathExam_V1.0.6
	 */	
	int firstNumber, secondNumber;		
	int symbol;	
	static int grade;
	static int count;		
	int result;		
	String cutLine = "====================��׼��====================";
	
	String[] str_ArithmeticProblem = new String[100+1];	//���������
	String[] str_MathAnswer = new String[100+1];	//��������⼰��
	
	public MathExam6335() {
		// TODO Auto-generated constructor stub
		mathProblem(count);
		
		for (int i = 0; i < count; i++) {
			System.out.println(str_ArithmeticProblem[i]);
		}
		System.out.println(cutLine);
		for (int i = 0; i < count; i++) {
			System.out.println(str_MathAnswer[i]);
		}
		
		outPut();
	}
	
	private static void inPut(String args0,String args1) {
		// TODO Auto-generated method stub
		boolean flag;
		Scanner in = new Scanner(System.in);
		String regex = "[1-9]{1}[0-9]{0,1}";		//������ʽ�ж��������Ϊ����������
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		while (true) {
			matcher = pattern.matcher(args0);
			try {
				flag = matcher.matches();
				if(!flag){
					throw new NumberFormatException();
				} else {
					count = Integer.valueOf(args0);
					grade = Integer.valueOf(args1);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("�������������������Ŀ���� : ");
				args0 = in.next();
				continue;
			}			
			break;
		}
	}
	
	private void outPut() {
		// TODO Auto-generated method stub
		File file = new File("out.txt");
		
		if(!file.exists()){	//�ж��ļ��Ƿ����
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("�ļ�����ʱ���ִ���!");
			}
		}
		
		try {
			String str = "\r\n";
			byte[] bytes = str.getBytes();		//string����ת��Ϊ�ܱ�����ʶ��Ķ�������
			byte[] bytescut = cutLine.getBytes();
			
			FileOutputStream fos = new FileOutputStream(file);	
			for (int i = 0; i < count; i++) {
				byte[] b_ArithmeticProblem = str_ArithmeticProblem[i].getBytes();
				fos.write(b_ArithmeticProblem);
				fos.write(bytes);
			}
			fos.write(bytescut);
			fos.write(bytes);
			fos.flush();	//ˢ���ڴ�
			for (int i = 0; i < count; i++) {
				byte[] b_MathAnswer = str_MathAnswer[i].getBytes();
				fos.write(b_MathAnswer);
				fos.write(bytes);
			}
			fos.flush();
			fos.close();	//�ر��ļ������
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("δ�ҵ�ָ���ļ�!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ�д������!");
		} 
		
	}
	
	/*
	 * �ӷ���
	 *  1.һ���꼶�ļӷ�������������20���ڡ�
	 * 
*/
	private void add(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		result = n1 + n2;
		str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " + " + n2 + " = ";
		str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " + " + n2 + " = " + result;
	}
	
	/*
	 * ������
	 * 
	 * 1.һ���꼶����֮��Ӧ���ڴ���0��
	 * 2.�������ͼ�����20���ڡ�
*/
	private void sub(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		if (n1 < n2) {
			int num;
			num = n1;
			n1 = n2;
			n2 = num;
		}
		result = n1 - n2;
		str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " - " + n2 + " = ";
		str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " - " + n2 + " = " + result;
	}
	
	/*
	 * �˷���
	 * 
	 * 1.һ���꼶�ĳ˷�����Ӧ����0-9���ڡ��žų˷�����
	 * 
*/
	private void mul(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		if (n1 > 9) {
			n1 = (int)(Math.random()*10);
		} 
		if (n2 > 9) {
			n2 = (int)(Math.random()*10);
		}
		result = n1 * n2;
		str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " x " + n2 + " = ";
		str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " x " + n2 + " = " + result;
	}
	
	/*
	 * ������
	 * 
	 * 1.һ���꼶�ĳ�������Ӧ���ڡ��žų˷�����Χ���ڣ�
	 * 2.��ĸ����Ϊ��0����
	 * 
*/
	private void div(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		while(true){
			if(n1 % n2 == 0){
				result = n1 / n2;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = " + result;
			}else if(n1 % n2 != 0){
				n1 = (int)(Math.random()*82);
				n2 = (int)(Math.random()*81+1);
				continue;
			}
			break;
		}
	}
	
	//����������
	public void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(grade*2);
			firstNumber = (int)(Math.random()*100+1);
			secondNumber = (int)(Math.random()*100+1);
			
			if(grade == 1){
				switch (symbol) {
				case 0:
					add(firstNumber,secondNumber,i);
					break;
					
				case 1:
					sub(firstNumber,secondNumber,i);
					break;

				default:
					break;
				}
			} else {
				switch (symbol) {
				case 0:
					add(firstNumber,secondNumber,i);
					break;
					
				case 1:
					sub(firstNumber,secondNumber,i);
					break;
					
				case 2:
					mul(firstNumber,secondNumber,i);
					break;
					
				case 3:
					div(firstNumber,secondNumber,i);
					break;

				default:
					break;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathExam6335.inPut(args[0], args[1]);
		new MathExam6335();

	}
}
