package niu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class MathExam6375 {

		private static int x,y,f;
		private static String[] str ;
		private static String rem;

		public void main(String args[]) throws FileNotFoundException, InterruptedException {
			// TODO Auto-generated method stub

			//String[] ת��Ϊ int
			int input =Integer.parseInt(args[0]);
			int grade =Integer.parseInt(args[1]);
			//����������ļ���
			File file = new File("out.txt");
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);
			choiceGrade(input, grade);
			
		}
		
		//һ�꼶�ӷ�����
		public void gradeOne( int n ) {
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
				else{
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
			System.out.println("              211606375 ������ţ��Ǭ  " +sdf.format(new Date()));
		}
		
		//���꼶�˷�����
		public void gradeTwo( int n ) {
			str = new String[n];
			for (int i = 0; i < n; i++) {
				x = (int)(Math.random()*10);
				y = (int)(Math.random()*10);
				f = (int)(Math.random()*2);
				
				if ( f == 0 && y!=0 && x!=0) {
					System.out.println("(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " " + (x*y);
				}
				else {
					if (x-y < 0 ) {
						System.out.println("(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " ");
						str[i] = "(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " " + (y/x) + "..."+(y%x);
					}
					else {
						System.out.println("(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " ");
						str[i] = "(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " " + (x/y) + "..."+(x%y);
					}
				}
			}
			System.out.println("--------��׼��--------");
			//�����
			for(String a:str)
				System.out.println(a);
			//������ں�����ѧ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
			System.out.println("              211606375 ������ţ��Ǭ  " +sdf.format(new Date()));
		}
		
		//ѡ���꼶
		public void choiceGrade( int n , int grade ) {
			if ( grade == 1 ) {
				gradeOne(n);
			}
			else if ( grade == 2) {
				gradeTwo(n);
			}
			else {
				System.out.println("�Ƚ����ѣ������꼶δ��");
			}
		}
		
}
