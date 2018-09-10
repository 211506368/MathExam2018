import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class MathExam6445 {

	public static void main(String[] args) {
		int n;
		if (!args[0].matches("\\d*")) {
			if (args[0].matches("-\\d*")) {
				System.out.println("����һ����ȷ������Ŷ������Ϊ��");
			} else {
				System.out.println("�������������������!");
			}
		} else {
			n = Integer.parseInt(args[0]);
			if (n > 100) {
				System.out.println("�������������������Сѧ��Ŷ");
			} else {
				File file = new File("out.txt");
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						System.out.println("�ļ�����ʧ�ܣ�");
						e.printStackTrace();
					}
				}
				try {
					System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("out.txt")), true));
				} catch (FileNotFoundException e) {
					System.out.println("����ض���ʧ��ʧ�ܣ�");
					e.printStackTrace();
				}
				work(n);
			}
		}
	}

	private static void work(int n) {
		int num1, num2, op;
		String str = "", result = "";
		Random rand = new Random();
		for (int i = 1; i <= n; i++) {
			num1 = rand.nextInt(101);
			num2 = rand.nextInt(101);
			op = rand.nextInt(2);
			if (op == 0) {
				if ((num1 + num2) > 0) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " + " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " + " + num2 + " = " + (num1 + num2) + "\r\n";
			} else {
				if ((num1 - num2) < 0) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " - " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " - " + num2 + " = " + (num1 - num2) + "\r\n";
			}
		}
		System.out.println(str);
		System.out.print(result);
	}
}
