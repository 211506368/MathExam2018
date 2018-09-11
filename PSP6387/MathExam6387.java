import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

import java.util.Scanner;


public class MathExam6387 {

	private static int x,y,f;
	private static String[] str ;
	private static String rem;

	public static void main(String args[]) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub

		//String[] ת��Ϊ int
		int i =Integer.valueOf(args[0]).intValue();
		int g =Integer.valueOf(args[1]).intValue();
		//����������ļ���
		File file = new File("out6387.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		choiceGrade(i, g);
		
	}
	
	//һ�꼶�ӷ�����
	public static void gradeOne( int n ) {
		str = new String[n];
		for (int i = 0; i < n ; i++) {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			f = (int)(Math.random()*2);
			// �жϼӷ��ͼ��� 0Ϊ�ӷ�
			if ( f == 0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);
			}
			else {
				if (x-y < 0) {
					System.out.println("(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " " + (y-x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
				}
			}
		}
		System.out.println("--------��׼��--------");
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�ѧ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println("              211606387 ������Ҷ����  " +sdf.format(new Date()));
	}
	
	//���꼶�˷�����
	public static void gradeTwo( int n ) {
		str = new String[n];
		for (int i = 0; i < n; i++) {
			x = new Random().nextInt(10) + 1;
			y = new Random().nextInt(10) + 1;
			f = (int)(Math.random()*2);
			
			if ( f == 0 && y!=0 && x!=0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " " + (x*y);
			}
			else {
				if (x-y < 0 ) {
					System.out.println("(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " " + (y/x) + judgementRemainder(y,x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " " + (x/y) + judgementRemainder(x,y);
				}
			}
		}
		System.out.println("--------��׼��--------");
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�����ѧ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println("              211606387 ������Ҷ����  " +sdf.format(new Date()));
	}
	
	//ѡ���꼶
	public static void choiceGrade( int n , int g ) {
		if ( g == 1 ) {
			gradeOne(n);
		}
		else if ( g == 2) {
			gradeTwo(n);
		}
		else {
			System.out.println("����Ա�������ޣ����꼶��δ���");
		}
	}
	
	//�ж�����
	public static String judgementRemainder( int x , int y ) {
		if( (x%y) == 0) {
			
			rem = " ";
		}
		else {
			rem = "..." + (x%y) + " ";
		}
		return rem;
	}
}