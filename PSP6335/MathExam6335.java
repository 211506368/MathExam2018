
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathExam6335 {
	/*
 * ���һ�������й���MathExam���Զ�����һ��Сѧһ�꼶����ѧ���������⡣
 *     1.�����˶��꼶������ʶ�𡣣�
 *     2.ȷ�������н��ܵĲ����ǿա�һ�����������������Ͷ�������������С�
 *     ��Ĭ��ֵ�����ղ���������Ϊ��10�����꼶Ϊ��2����    һ���������꼶Ĭ��ֵΪ��2���� 
 *     						������������ʹ��Ĭ��ֵ��       �������ֻ����ǰ��������ֵ����
 *     ��ps�����������롰00000000001����ʶ�����bug����������
 * 		coding �� GBK
 * 		MathExam_V1.0.8
 */	
	int firstNumber, secondNumber;		
	int symbol;	
	static int grade;
	static int count;		
	int result;		
	String cutLine = "====================��׼��====================";
	
	String[] str_ArithmeticProblem = new String[100+1];	//���������
	String[] str_MathAnswer = new String[100+1];	//��������⼰��
	
	//����Ĳ���Ϊ��ֵ
	public MathExam6335(){
		String count_Default = "10";	//�������Ĭ��ֵ
		String grade_Default = "2";
		inPut(count_Default, grade_Default);
		mathProblem(count);
		outPut();
	}
	
	//����Ĳ���ֻ��һ��
	public MathExam6335(String args0){
		String grade_Default = "2";
		inPut(args0, grade_Default);
		mathProblem(count);
		outPut();
	}
	
	//����Ĳ�����������
	public MathExam6335(String args0,String args1){
		inPut(args0, args1);
		mathProblem(count);
		outPut();
	}

	public void inPut(String str0,String str1) {
		// TODO Auto-generated method stub
		boolean flag1 = true;
		boolean flag2 = true;
		
		Scanner in = new Scanner(System.in);
		String regex1 = "[1-9]{1}[0-9]{0,1}";		//������ʽ�ж��������Ϊ����������
		String regex2 = "[1-2]{1}{0}";
		Pattern pattern1 = Pattern.compile(regex1);
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher1,matcher2;
		
		while (true) {
			
			matcher1 = pattern1.matcher(str0);
			matcher2 = pattern2.matcher(str1);
			
			try {
				flag1 = matcher1.matches();
				flag2 = matcher2.matches();
				
				if(!flag1 || !flag2){	
						throw new NumberFormatException();		
				} else {	
					count = Integer.valueOf(str0);
					grade = Integer.valueOf(str1);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				if(!flag1){
					System.out.println("�������ֻ������99���ڵ���Ŀ�������밴�涨����������Ŀ���� : ");
					str0 = in.next();
				} 
				if(!flag2){
					System.out.println("��������꼶Ϊ\"1\"��\"2\" ���밴�涨���������꼶 : ");
					str1 = in.next();
				}
				continue;
			}			
			break;
		}
	}
	
	private void outPut() {
		// TODO Auto-generated method stub
		File file = new File("out.txt");
		Date date = new Date();//����һ��ʱ����󣬻�ȡ����ǰ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//����ʱ����ʾ��ʽ
		String currentTime = "\r\n         211606335   ������   " + sdf.format(date);//����ǰʱ���ʽ��Ϊ��Ҫ������
		byte[] bytesdate = currentTime.getBytes();

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
			fos.write(bytesdate);
			fos.flush();
			fos.close();	//�ر��ļ������
			
			System.out.print("-------  ���ι�����" + count + "��Сѧ"+ grade + "�꼶�����⣬���out.txt�ļ��鿴����    -------");
			
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
	private void div(int i) {
		// TODO Auto-generated method stub
		while(true){
			int n1 = (int)(Math.random()*82);
			int n2 = (int)(Math.random()*81+1);
			if(n1 % n2 == 0){
				result = n1 / n2;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = " + result;
			}else if(n1 % n2 != 0){
				result = n1 / n2;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = " + result + "..." + (n1 % n2);
			}
			break;
		}
	}
	
	//����������
	public void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(grade*2);
			firstNumber = (int)(Math.random()*20+1);
			secondNumber = (int)(Math.random()*20+1);
			
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
					div(i);
					break;

				default:
					break;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0){
			new MathExam6335();
		} else if(args.length == 1){
			new MathExam6335(args[0]);
		}
		else if(args.length == 2){
			new MathExam6335(args[0], args[1]);
		}else {
			new MathExam6335(args[0], args[1]);
		}
		

	}
}
