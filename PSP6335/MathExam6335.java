package com.wuyiz.homework;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MathExam6335 {
	/*
	 * ���һ�������й���MathExam���Զ�����һ��Сѧһ�꼶����ѧ���������⡣
	 *     1.��ӳ˷�-�������������ɷ�����
	 *     2......
	 * 		-encoding �� GBK
	 * 		MathExam_V1.0.3
	 */	
	int firstNumber, secondNumber;		
	int symbol;	
	int count;		
	int result;	
	String cutLine = "====================��׼��====================";
	
	String[] str_ArithmeticProblem = new String[100];	//���������
	String[] str_MathAnswer = new String[100];	//��������⼰��
	
	public MathExam6335() {
		// TODO Auto-generated constructor stub
		inPut();
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
	
	private void inPut() {
		// TODO Auto-generated method stub
		System.out.print("��������������Ŀ��");
		Scanner in =new Scanner(System.in);
		count = in.nextInt();
	}
	
	private void outPut() {
		// TODO Auto-generated method stub
		File file = new File("out.txt");
		if(!file.exists()){	//�ж��ļ��Ƿ����
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			String str = "\r\n";
			byte[] bytes = str.getBytes();
			byte[] bytescut = cutLine.getBytes();
			
			FileOutputStream fos = new FileOutputStream(file);
			for (int i = 0; i < count; i++) {
				byte[] b_ArithmeticProblem = str_ArithmeticProblem[i].getBytes();
				fos.write(b_ArithmeticProblem);
				fos.write(bytes);
			}
			fos.write(bytescut);
			fos.write(bytes);
			fos.flush();
			for (int i = 0; i < count; i++) {
				byte[] b_MathAnswer = str_MathAnswer[i].getBytes();
				fos.write(b_MathAnswer);
				fos.write(bytes);
			}
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//����������
	public void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(2);
			firstNumber = (int)(Math.random()*100+1);
			secondNumber = (int)(Math.random()*100+1);
			
			switch (symbol) {
			case 0:		//�ӷ�
				result = firstNumber + secondNumber;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = " + result;
				break;
				
			case 1:		//	����
				result = firstNumber - secondNumber;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = " + result;
				
			case 2:		//�˷�
				result = firstNumber * secondNumber;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " x " + secondNumber + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " x " + secondNumber + " = " + result;
				
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
		new MathExam6335();

	}
}
