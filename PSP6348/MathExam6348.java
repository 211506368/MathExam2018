import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MathExam6348 {
	/*
	 * ���������ܣ� 1.check���������������Ƿ������� 2.init������ʼ�������Ŀ�ʹ� 3.OutPutFile��������Ŀ���Ϊout.txt�ļ�
	 */
	public static void main(String[] args) {
		// ����һ���ɱ��ַ�������ƴ����Ŀ�ʹ�
		StringBuffer stringBuffer = new StringBuffer();
		// �������Ĳ����Ƿ�����
		if (!check(args))
			return;
		// ��ʼ����ȡ��Ŀ�ʹ�
		init(stringBuffer, args);
		outPutFile(stringBuffer);
	}

	/*
	 * ������������������ ����������ֻ��Ϊ���������ֵֻ��10000 �������Ϊ00000000000001֮������� �������Ϊ����
	 */
	public static boolean check(String[] s) {
		char[] allChar = s[0].toCharArray();
		char[] charArray = s[1].toCharArray();
		int k = 0;
		// ��������Ĳ���ֻ��Ϊ0��1��2��
		if (s.length == 0 || s.length > 2) {
			System.out.println("����Ĳ����������󣡣�");
			return false;
		}
		if (s[0].equals("0")) {
			System.out.println("������Ŀ����0������");
			return false;
		}
		//���Ƶڶ�������ֻ����1��2
		if (s.length == 2) {
			if (!(s[1].equals("1") || s[0].equals("2"))) {
				System.out.println("�ڶ�������ֻ��Ϊ1��2");
				return false;
			}
		}
		
		// ȥ����һ������ǰ�����е�����0
		k=0;
		while (allChar[k++] == '0');
		s[0] = new String(allChar, k - 1, allChar.length - k + 1);
		// ������������Ŀ����������10000����Ŀ
		if (s[0].length() > 4) {
			System.out.println("��Ŀ��������������10000���ڵ���");
			return false;
		}
		// ����һ�������Ǹ�����
		k = 0;
		while (!Character.isDigit(allChar[k++])) {
			System.out.println("������һ������������");
			return false;
		}
		return true;
	}
	/*
	 * init����������Ŀ�ʹ�
	 */
	public static void init(StringBuffer strbuf, String[] s) {

		int result = 0; // ��ʾ��Ŀ��
		int remainder = 0; // ��ʾ����
		String operator = null; // ��ʾ��������������
		String[] mark_code = { "+", "-", "*", "/" }; // Сѧ1�꼶��2�꼶���е�����
		StringBuffer strbuf1 = new StringBuffer(); // ���ڴ𰸵�ƴ��
		// forѭ��ƴ����Ŀ�ʹ�
		for (int i = 1; i <= Integer.valueOf(s[0]); i++) {
			// �ж��꼶 �жϸ��꼶��Ӧ������
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
			// ��Ŀ���
			String number = "(" + i + ")" + " ";
			// ����2�������
			int first = (int) (Math.random() * 100);
			int second = (int) (Math.random() * 100);
			// �����꼶��������ָ������Ŀ
			if (operator.equals("+")) {
				if (s.length == 2 && s[1].equals("2")) {
					// ���꼶�ļӷ���Ŀ�𰸲�����100
					while (first + second > 100) {
						first = (int) (Math.random() * 100);
						second = (int) (Math.random() * 100);
					}
				} else {
					while (first + second > 100) {
						// 1�꼶�ļӷ���
						// 1. �𰸲�����100
						// 2. ������2λ��+��λ��
						// 3. ������2λ��+����10λ��
						if (first % 2 == 0) {
							first = (int) (Math.random() * 100);
							second = (int) (Math.random() * 100);
							if (second > 10)
								second = second / 10;
						} else {
							first = (int) (Math.random() * 100);
							if (first > 10)
								second = second / 10 * 10;
							second = (int) (Math.random() * 100);
						}
					}
				}
				result = first + second;
			} else if (operator.equals("-")) {
				// ������ߵ�����������ұߵ�����
				if (first < second) {
					int t;
					t = first;
					first = second;
					second = t;
				}
				if (!(s.length == 2 && s[1].equals("2"))) {
					// 2�꼶�ļ�����
					// 1. �𰸲���Ϊ����
					// 2. ������2λ��-��λ��
					// 3. ������2λ��-����10λ��
					if (second > 10)
						second = second / 10 * 10;
					result = first - second;
				} else {
					result = first - second;
				}
			} else if (operator.equals("*")) {
				// ���Ƴ˷�ֻ����99�˷��������
				while (first > 10 || second > 10) {
					first = (int) (Math.random() * 10);
					second = (int) (Math.random() * 10);
				}
				result = first * second;
			} else {
				// �������Ϊ��ʱ�� ��������Ϊ0
				while (second == 0) {
					second = (int) (Math.random() * 100);
				}
				// ���Ƴ���ֻ����С�ڵ���10
				while (second > 10) {
					second /= 10;
				}
				if (first % second == 0) {
					result = first / second;
				} else { // ���Ʋ����������𰸺���������ʾ����
					if (first > second) {
						result = (int) (first / second);
						remainder = first - (int) (first / second) * second;
					} else {
						result = (int) (first / second);
						remainder = second;
					}
				}
			}
			// ���Ϊ����Ҫ�����Ƿ�������ƴ���ڴ𰸺���
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

	public static void outPutFile(StringBuffer strbuf) {

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