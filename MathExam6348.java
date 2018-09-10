import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MathExam6348 {
	public static void main(String[] args) {
		StringBuffer strbuf = new StringBuffer();
		//�������Ĳ����Ƿ�����
		boolean check = check(args);
		if (check) {
			// ��ʼ����ȡ��Ŀ�ʹ�
			init(strbuf,args);
			// ����Ŀ�ʹ𰸵Ŀɱ��ַ���ת�ɶ�����
			byte[] bytes = new String(strbuf).getBytes();
			// �������ƴ����ļ�����������out.txt
			try {
				FileOutputStream fos = new FileOutputStream("out.txt");
				try {
					fos.write(bytes);
				} catch (IOException e) {
					System.out.println("�ļ�д������");
				}
			} catch (FileNotFoundException e) {
				System.out.println("�ļ�δ�ҵ�����");
			}
			// �������ִ�еĽ��
			System.out.println("��Ŀ�Ѿ����ɣ��������out.txt");
		}
	}
	/*
	 * ������������������
	 * ����������ֻ��Ϊ���������ֵֻ��10000
	 * �������Ϊ00000000000001������
	 * �������Ϊ����
	 * */
	public static boolean check(String[] s) {
		char[] ca = s[0].toCharArray();
		int k = 0;
		if (s.length == 0 || s.length > 2) {
			System.out.println("����Ĳ����������󣡣�");
			return false;
		}
		
		while (ca[k++] == '0');
		s[0] = new String(ca, k - 1, ca.length - k + 1);
		
		if (s[0].length() > 4) {
			System.out.println("���ֹ���");
			return false;
		}
		k = 0;
		while (!Character.isDigit(ca[k++])) {
			System.out.println("������һ������������");
			return false;
		}
		return true;
	}
	/*
	 * ������Ŀ�ʹ�
	 * */
	public static void init(StringBuffer strbuf, String[] s) {
		
			int result = 0; // ��Ŀ��
			int remainder = 0; // ����
			String operator = null; // ��������������
			String[] mark_code = { "+", "-", "*", "/" }; // Сѧ1�꼶��2�꼶�е�����
			StringBuffer strbuf1 = new StringBuffer(); // ���ڴ𰸵�ƴ��
			//
			for (int i = 1; i <= Integer.valueOf(s[0]); i++) {
				if (s.length == 1) {
					operator = mark_code[(int) (Math.random() * 2)];
				} else {
					if (Integer.valueOf(s[1]) == 1) {
						operator = mark_code[(int) (Math.random() * 2)];
					} else if (Integer.valueOf(s[1]) == 2) {
						operator = mark_code[(int) (Math.random() * 4)];
					} else {
						System.out.println("�����꼶���󣡣�");
						System.exit(0);
					}
				}
				String number = "(" + i + ")" + " ";
				// ����2�������
				int first = (int) (Math.random() * 100);
				int second = (int) (Math.random() * 100);
				// �ж�����������Ҫ����ʲô����
				if (operator.equals("+")) {
					result = first + second;
				} else if (operator.equals("-")) {
					// ������ߵ�����������ұߵ�����
					if (first < second) {
						int t;
						t = first;
						first = second;
						second = t;
					}
					
					result = first - second;
				} else if (operator.equals("*")) {
					result = first * second;
				} else {
					// �������Ϊ��ʱ�� ��������Ϊ0
					while (second == 0) {
						second = (int) (Math.random() * 100);
					}
					if (first % second == 0) {
						result = first / second;
					} else {
						if (first > second) {
							result = (int) (first / second);
							remainder = first - (int) (first / second) * second;
						} else {
							result = (int) (first / second);
							remainder = second;
						}
					}
				}
				// ���Ϊ����Ҫ�����Ƿ����������
				if (operator.equals("/")) {
					strbuf1.append(number + first + " " + operator + " " + second + " " + "=" + " " + result + "..."
							+ remainder + "\r\n");
				} else {
					strbuf1.append(number + first + " " + operator + " " + second + " " + "=" + " " + result + "\r\n");
				}
				strbuf.append(number + first + " " + operator + " " + second + "\r\n");
			}
			// ����Ŀ�ʹ�ƴ����strbuf�ɱ��ַ�������
			strbuf = strbuf.append("\r\n" + strbuf1);
		
	}

}