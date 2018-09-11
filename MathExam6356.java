import java.io.File;
import java.util.*;
import java.text.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class MathExam6356 {
	static int n;
	static int grade=1;
	static int[] a;
	static int[] b;
	static int[] c;
	static Random fuhao = new Random();
	static Random num1 = new Random();
	static Random num2 = new Random();// ������ͬ��Random�������ɵ������������һ���ġ�

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner input=new Scanner(System.in);
		if (args.length == 1 || args.length==2) {
			if(args.length==2) {
				grade=Integer.parseInt(args[1]);
			}
			try {
				n = Integer.parseInt(args[0]);
				if (n <= 0 || n > 500) {
					System.out.println("������0-500��������");
					System.exit(0);
				}

			} catch (NumberFormatException e) {
				System.out.println("������Ĳ���������,����������");
				System.exit(0);
			}
			if (grade==1) {
				gradeOne();
			}else {
				gradeTwo();
			}
			File file = new File("out.txt");
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);// �Ѵ����Ĵ�ӡ���������ϵͳ��
			outPut();
		} else {
			System.out.println("����������������������");
			System.exit(0);
		}
	}

	private static void gradeTwo() {
		a = new int[n];
		b = new int[n];
		c = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = num1.nextInt(9); // 0-100�������
			b[i] = num2.nextInt(9);
			c[i] = fuhao.nextInt(2);//0�ǳ˷�1�ǳ���
			if(c[i]==1 || b[i]==0) {
				b[i] = num2.nextInt(8)+1;
			}
		}
		
	}

	public static void outPut() {
		for (int i = 0; i < n; i++) {
			if(grade==1) {
			if (c[i] == 0) {
				System.out.println("(" + (i + 1) + ") " + a[i] + "+" + b[i] + " =");
			} else {
				System.out.println("(" + (i + 1) + ") " + a[i] + "-" + b[i] + " =");
			}
			}else {
				if (c[i] == 0) {
					System.out.println("(" + (i + 1) + ") " + a[i] + "*" + b[i] + " =");
				} else {
					System.out.println("(" + (i + 1) + ") " + a[i] + "/" + b[i] + " =");
				}
			}
		}
		System.out.println("--------------��׼��----------------");
		for (int i = 0; i < n; i++) {
			if(grade==1) {
			if (c[i] == 0) {
				System.out.println("(" + (i + 1) + ") " + a[i] + "+" + b[i] + " =" + " " + (a[i] + b[i]));
			} else {
				System.out.println("(" + (i + 1) + ") " + a[i] + "-" + b[i] + " =" + " " + (a[i] - b[i]));
			}
		}else {
			if (c[i] == 0) {
				System.out.println("(" + (i + 1) + ") " + a[i] + "*" + b[i] + " =" + " " + (a[i] * b[i]));
			} else if(a[i]%b[i]==0){
				System.out.println("(" + (i + 1) + ") " + a[i] + "/" + b[i] + " =" + " " + (a[i] / b[i]));
			}else {
				System.out.println("(" + (i + 1) + ") " + a[i] + "/" + b[i] + " =" + " " + (a[i] / b[i])+"..."+(a[i]%b[i]));

			}
		}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		String time = sdf.format(new Date());
		System.out.println("211606356 ���� " + time);// ���ѧ������ ʱ��
	}

	public static void gradeOne() {
		a = new int[n];
		b = new int[n];
		c = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = num1.nextInt(100); // 0-100�������
			b[i] = num2.nextInt(100);
			c[i] = fuhao.nextInt(2);
		}
		for (int i = 0; i < n; i++) {
			if (c[i] == 0) {// ����ӷ�
				while (a[i] + b[i] > 100) {
					// ����ʹ���100�������
					a[i] = num1.nextInt(100);
					b[i] = num2.nextInt(100);
				}

			} else {// �������
				while (a[i] - b[i] < 0) {
					// �����С��0�������
					a[i] = num1.nextInt(100);
					b[i] = num2.nextInt(100);
				}
			}

		}
	}
}
