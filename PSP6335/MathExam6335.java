
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
	 *     1.�޸�input()����Ϊstatic���ͣ�������һ�������д����string������
	 *     2.��input()���������������ʽ�жϽ��յĲ���Ϊ������������
	 *     ��ps�����������롰00000000001����ʶ�����bug����������
	 *     3.��ȫ�ֱ���count����static���͡�
	 * 		coding �� GBK
	 * 		MathExam_V1.0.4
	 */	
		int firstNumber, secondNumber;		
		int symbol;	
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
		
		private static void inPut(String args0) {
			// TODO Auto-generated method stub
			boolean flag;
			Scanner in = new Scanner(System.in);
			String regex = "[1-9]{1}[0-9]{0,2}";		//������ʽ�ж��������Ϊ����������
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
		
		//����������
		public void mathProblem(int count) {	
			Random rnd = new Random();
			
			for (int i = 0; i < count; i++) {
				symbol = rnd.nextInt(4);
				firstNumber = (int)(Math.random()*100+1);
				secondNumber = (int)(Math.random()*100+1);
				
				switch (symbol) {
				case 0:		//�ӷ�
					result = firstNumber + secondNumber;
					str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = ";
					str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = " + result;
					break;
					
				case 1:		//����
					result = firstNumber - secondNumber;
					str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = ";
					str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = " + result;
					
				case 2:		//�˷�
					result = firstNumber * secondNumber;
					str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " x " + secondNumber + " = ";
					str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " x " + secondNumber + " = " + result;
					
	/*
	 * 2��������������ȡ��������������֮����һ��ΪС��������Ҳ��С������������Ϊ0ʱ������������� 
	 * 1. ����Ϊ����ʱ�������쳣
	 * 2. ����ΪС��ʱ��Infinity��������󣩻�-Infinity��������� 
	 * 3. ����Ϊ0.0ʱ��NaN �������֣�
	*/
				case 3:		//����
					if(firstNumber % secondNumber == 0){
						result = firstNumber / secondNumber;
						str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " / " + secondNumber + " = ";
						str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " / " + secondNumber + " = " + result;
					}else if(firstNumber % secondNumber != 0){
						result = firstNumber / secondNumber;
						str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " / " + secondNumber + " = ";
						str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " / "
								+ secondNumber + " = " + result + "..." + (firstNumber % secondNumber);
					}
						
				default:
					break;
				}
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathExam6335.inPut(args[0]);
		new MathExam6335();

	}
}
