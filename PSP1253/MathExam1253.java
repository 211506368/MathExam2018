
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class MathExam1253 { 
	public static void main(String[] args) {
		int grade = 1;
		if(args.length==2){
			if (args[1].equals("1") || args[1].equals("2")) {
				grade = Integer.valueOf(args[1]);
			} else {
				System.out.println("�������󣬳������");
				System.exit(0);
			}
		}
		if(args.length!=1 && args.length!=2 ){
			System.out.println("�������󣬳������");
			System.exit(0);
		}
			
		// TODO Auto-generated method stub
		boolean r = args[0].matches("[0-9]+");
		String h = args[0].substring(0, 1);
		int n = 0;
		if (r == true && args[0].length() < 5 && h != "0") {
			n = Integer.valueOf(args[0]);
		} else {
			System.out.println("�������󣬳������");
			System.exit(0);
		}
		
		Random rand = new Random();
		if (grade==1) {
			int d = 0;
			String x = "";
			String y = "";
			for (int i = 1; i <= n; i++) {
				int c = (rand.nextInt(2));// 0��ʾ�ӷ���1��ʾ����
				if (c == 0) {
					int a = (rand.nextInt(100));// �����������0-99����Ӽ�����,��֮�Ͳ�����100
					int b = (rand.nextInt(100 - a));
					d = a + b;
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "+" + " " + b + " " + "=";// ����Ŀ����x
					y = y + "(" + i + ")" + " " + a + " " + "+" + " " + b + " " + "=" + " " + d;// ����Ŀ���𰸴���y

				} else {

					int a = (rand.nextInt(100));// �����������0-99����Ӽ�����,��b������a
					int b = (rand.nextInt(10));
					d = a - b;
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "-" + " " + b + " " + "=";// ����Ŀ����x
					y = y + "(" + i + ")" + " " + a + " " + "-" + " " + b + " " + "=" + " " + d;// ����Ŀ���𰸴���y

				}
			}
			String z = x;
			String k = y;
			try {
				File f = new File("out.txt");
				PrintStream f1 = new PrintStream(new FileOutputStream(f));
				System.setOut(f1);
				System.out.println(z);
				System.out.println(k);
			} catch (Exception e) {
			}
		} else {
			int d = 0;
			int d1 = 0;
			String x = "";
			String y = "";
			for (int i = 1; i <= n; i++) {
				int c = (rand.nextInt(2));// 0��ʾ�˷�����1��ʾ����
				if (c == 0) {
					int a = (rand.nextInt(9)+1);// �����������1-9����˳�����
					int b = (rand.nextInt(9)+1);
					d = a * b;
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "*" + " " + b + " " + "=";// ����Ŀ����x
					y = y + "(" + i + ")" + " " + a + " " + "*" + " " + b + " " + "=" + " " + d;// ����Ŀ���𰸴���y
				} else {
					int a = (rand.nextInt(100));// �����������1-9����˳�����,��b������a,b��Ϊ0
					int b = (rand.nextInt(9)+1);
					d = a / b;
					d1 = a % b;
					if(a%b!=0) {
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=";// ����Ŀ����x
					y = y + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=" + " " + d+"..."+d1;// ����Ŀ���𰸴���y

				}else {
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=";// ����Ŀ����x
					y = y + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=" + " " + d;// ����Ŀ���𰸴���y
				}
				}
			}
			String z = x;
			String k = y;
			try {
				File f = new File("out.txt");
				PrintStream f1 = new PrintStream(new FileOutputStream(f));
				System.setOut(f1);
				System.out.println(z);
				System.out.println(k);
			} catch (Exception e) {
			}
		}

	}
}
