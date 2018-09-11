package com.MathExam.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MathExam6310 {
	
	private static StringBuffer topic = new StringBuffer();
	private static StringBuffer standAnswer = new StringBuffer();
	//���������������Ŀ�ͱ�׼��
	private static int len;
	// �û��������Ŀ����
	private static String[] Operator = { " + ", " - "};

	public static void main(String[] args) {
		
		{
			int grade = 1;
			generatingTopic(len,grade);
			// д���ļ�
			try {
				write310("out.txt");
				System.out.println(grade+"�꼶��Ŀ����");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void generatingTopic(int len,int grade) {
		for (int i = 1; i <= len; i++) {
			
			int a = (int) (Math.random() * 100);
			int b = (int) (Math.random() * 100);
			int n = 0;
			if(n%1!=0)
			System.out.println("error"+"�����ֵ������������");
			if(n<0 || n==0)
			System.out.println("error"+"�����ֵ������������");
			// ��ȡ��������Ҫ�����
			int index = (1 == grade) ? ((int) (Math.random() * 10)) % 2 : ((int) (Math.random() * 10)) % 4;
			String symbol = Operator[index];
			
			//ȷ���Ͳ�����100
			while(0 == index && a + b >= 100) {
				a = (int) (Math.random() * 100);
				b = (int) (Math.random() * 100);
			}
			
			// ������
			int sum = 0;//��
			int job = 0;//��
			int merchant = 0;//��
			int ji = 0;//��
			int remainder = 0; // ����
			switch (symbol) {
			case " + ":
				//ȷ�����ַ���Ҫ��
				if(grade==1 && a>10 && b >10 && a%10 != 0 && b%10 !=0) {
					b = b/10*10;
				}
				sum = a + b;
				break;
			case " - ":		
				//ȷ�����ַ���Ҫ��
				if (a < b) {
					int temp = a;
					a = b;
					b = temp;
				}
				//ȷ����ĿΪ��λ���Ӽ���ʮ������λ���Ӽ�һλ��
				if(grade==1 && a>10 && b >10 && b%10 !=0) {
					b = b/10*10;
				}	
				job = a - b;
				break;
			case " * ":
				//ȷ��Ϊ���ڳ˷�
				a %= 10;
				b %= 10;
				ji = a * b;
				break;
			case " / ":
				//��ֹ����Ϊ0
				while(0 == b) {
					b = (int) (Math.random() * 100);
				}
				
				//ȷ��Ϊ���ڳ���
				if(b>10) {
					b /=10 ;
				}
				
				merchant = a / b;
				remainder = a % b;
				break;
			
			}
			// ����Ŀ�ʹ𰸼�¼
			if(sum!=0)System.out.println(sum);
			if(job!=0)System.out.println(job);
			if(merchant!=0)System.out.println(merchant);
			if(ji!=0)System.out.println(ji);
				}
		}
	private static void write310(String filename) throws IOException {
		// �٣���ȷ�����ļ�
		File file = new File(filename);
		File parentFile = file.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
			parentFile.mkdirs();
			System.out.println("����Ŀ¼��" + parentFile);
		}
		file.createNewFile();
		// �ڽ����ļ�������
		OutputStream out = new FileOutputStream(file);
		// ����������
		out.write(topic.toString().getBytes());
		out.write(System.lineSeparator().getBytes());
		out.write(standAnswer.toString().getBytes());
		// �ܽ���
		out.close();
	}
}