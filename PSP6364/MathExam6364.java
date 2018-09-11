

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MathExam6364 {
	public static void main(String[] args) throws IOException{
		int num = 0 ;
		boolean flag = true;// �������
		int grade = 1;// Ĭ��Ϊһ�꼶
		while(flag) {
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			String stringArray[] = str.split(" ");// ʹ��" "�ո����ָ��ַ�����һ���ַ�������
			if(stringArray.length > 1 ){ // ����Ϊ1��Ĭ��ֻ������Ŀ��Ŀ���꼶Ϊһ�꼶
				try {
					num = Integer.parseInt(stringArray[0]);
					grade = Integer.parseInt(stringArray[1]);						
					}catch(NumberFormatException e){
						System.out.println("����ȷ���룡");
						continue;						
					}
				if (stringArray.length > 2) {
					System.out.println("����ȷ���룡(��Ŀ�� �꼶)");
					continue;
				}
				num = Integer.parseInt(stringArray[0]);
				grade = Integer.parseInt(stringArray[1]);
				if (num < 1 || num >10000) {
					System.out.println("������1~10000��������");
					continue;
				}
				if (grade != 1 && grade != 2) {
					System.out.println("��������ȷ���꼶��1 or 2��");
					continue;
				}
				break;					
				}
			else {
				try {
					num = Integer.parseInt(stringArray[0]);
					}catch(NumberFormatException e) {
						System.out.println("����������������Ŀ����");
						continue;
					}
			}
			num = Integer.parseInt(stringArray[0]);
			break;
			}
		mathExam6364(num,grade);
}
	static void mathExam6364(int num,int grade) throws IOException {
		// û����Ļ�gradeĬ��Ϊ1����������1
		PrintStream sysout = System.out;// �Ȱ�ϵͳ��������浽sysout
		PrintStream ps = new PrintStream("e:/out.txt"); // �´���һ�������������e���½�һ�� out.txt
		List<String> list1 = new ArrayList<String>();// �������ʽ��
		List<String> list2 = new ArrayList<String>();// �������ʽ�ӼӴ�
		if (grade == 1) {
			for (int i = 0;i < num;i ++){
				int num1 = (int)(Math.random()*100);// ������һ���������
				int num2 = (int)(Math.random()*100);// �����ڶ����������
				int c = Math.random()>0.5?1:0;// ���0��1��0Ϊ�ӷ���1Ϊ����
				int k;
				if(c == 0){
					k = num1 + num2;
					if (k <= 50) {// ���ʹ���100�� ������
						list1.add(num1 + " + " + num2 + " = ");
						list2.add(num1 + " + " + num2 + " = "+k);
				}else { 
					i--;}
				}
				if(c == 1){
					k = num1 - num2;
					if (k >= 0) {// ����С��0��������
						list1.add(num1 + " - " + num2 + " = ");
						list2.add(num1 + " - " + num2 + " = " + k);
					}else {
						i--;}
					}
			}
			for (int s = 0;s < num;s ++) {
				System.setOut(ps);
				System.out.println("(" + (s+1) + ") " + list1.get(s));
				}
			System.out.println(" ");
			for (int p = 0;p < num;p ++) {
				System.setOut(ps);
				System.out.println("(" + (p+1) + ") " + list2.get(p));
				}
		}
		// ��gradeΪ2����������2
		if (grade == 2) {	
			for (int i = 0;i < num;i ++){
				int num1 = (int)(Math.random()*20);// ������һ���������
				int num2 = (int)(Math.random()*20);// �����ڶ����������
				int c = Math.random()>0.5?1:0;// ���0��1��0Ϊ�˷���1Ϊ����
				int k;
				int x;
				if(c == 0){
					k = num1 * num2;
					if (k <= 100) {// ���˻�����100�� ������
						list1.add(num1 + " �� " + num2 + " = ");
						list2.add(num1 + " �� " + num2 + " = " + k);
						}
					else
						i--;
					}
				if(c == 1){
					k = num1 / num2;
					x = num1 % num2;
					if (num2 != 0) {//����������0��������
						list1.add(num1 + " �� " + num2 + " = ");
					if (x != 0) {
						list2.add(num1 + " �� " + num2 + " = " + k + "..." + x);
					}else
						list2.add(num1 + " �� " + num2 + " = " + k);
					}else
						i--;
					}
				}
				for (int s = 0;s < num;s ++) {
					System.setOut(ps);
					System.out.println("(" + (s+1) + ") " + list1.get(s));
				}
				System.out.println(" ");
				for (int p = 0;p < num;p ++) {
					System.setOut(ps);
					System.out.println("(" + (p+1) + ") " + list2.get(p)); 
				}
			}
			Date day = new Date();
			// ��ȡ��ǰϵͳʱ�䣬���������Ϊyyyy��MM��dd��  HH:mm
			SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd��  HH:mm");
			System.setOut(ps);
			System.out.println("                 211606364�����"+df.format(day));
			File file = new File("e:/out.txt");
			FileReader reader = new FileReader(file);
			int fileLen = (int)file.length();
			char[] chars = new char[fileLen];
			reader.read(chars);
			String txt = String.valueOf(chars);
			System.setOut(sysout);
			System.out.println(txt);
			
	}
	}