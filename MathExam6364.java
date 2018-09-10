package com.MathExam6364;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MathExam6364 {
	public static void main(String[] args) throws FileNotFoundException{
	Scanner input = new Scanner(System.in);
	boolean flag = true;// ��һ�����
	while(flag) {
	String str = input.nextLine();
	int num = 0;
	int grade = 1;// Ĭ���꼶Ϊһ�꼶
	int i = 0;
	char ch = str.charAt(i);
	while (ch != ' ') {
		i++;
		if (i == str.length()) {
			break;
		}else {
			ch = str.charAt(i);
		}
		}
    num = Integer.parseInt(str.substring(0, i));// ��ȡ��һ�����ָ�ֵ��num
	if (i != str.length()) {
		grade = Integer.parseInt(str.substring(i+1,str.length()));}// ���еڶ���ֵ�����ȡ�ڶ���ֵ��grade
	if (grade > 2) {
		System.out.println("��������ȷ���꼶��(1 or 2)");
	}else{
		if (num <= 0 || num >= 10000){
			System.out.println("��������ֲ��ڷ�Χ֮�ڣ�1~10000�������������룡");
		}else {
			flag = false;
			mathExam6364(num,grade);// ���������������ķ���
		}
		}
	}
}
	static void mathExam6364(int num,int grade) throws FileNotFoundException {
		// û����Ļ�gradeĬ��Ϊ1����������1
		PrintStream ps = new PrintStream("e:/out.txt"); 
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
			for (int s = 0;s < num;s ++) 
				System.out.println("(" + (s+1) + ") " + list1.get(s));
			System.out.println(" ");
			for (int p = 0;p < num;p ++) 
				System.out.println("(" + (p+1) + ") " + list2.get(p)); 
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
				for (int s = 0;s < num;s ++) System.out.println("(" + (s+1) + ") " + list1.get(s));
				System.out.println(" ");
				for (int p = 0;p < num;p ++) System.out.println("(" + (p+1) + ") " + list2.get(p)); 
			}
			Date day = new Date();
			// ��ȡ��ǰϵͳʱ�䣬���������Ϊyyyy��MM��dd��  HH:mm
			SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd��  HH:mm"); 
			System.out.println("                 211606364�����"+df.format(day));  
	}
	}
	