


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class MathExam4354 {

	static int n;
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		boolean g;
		int j=0;
		Random random = new Random();
		if((args.length==0 ||args.length>2)||(args.length==1 && !args[0].matches("\\d*"))
				||(args.length==2 && (!args[0].matches("\\d*") || !args[1].matches("\\d*")))
				) {
			System.out.println("��������");
		}
		else {
			n=Integer.valueOf(args[0]);
			if(args.length==2 && args[1].equals("2")) {
				for(int i=0;i<n;i++) {
					g = random.nextBoolean();
					if (g == false) {
						j++;
						w(list,j);               // ���ó˷����㷽��
						
					} else if (g == true) {
						j++;
						z(list,j);               // ���ó������㷽��
						
					}
				}
				h(list);
			}
			else {
				if((args.length==2 && args[1].equals("1")) ||(args.length==1 ) ) {
					for(int i=0;i<n;i++) {
						g = random.nextBoolean();
						if (g == false) {
							j++;
							y(list, j) ;            // ����+�����㷽��						
						} else if (g == true) {
							j++;
							x(list,j);               // ����-�����㷽��
						
						}
					}
					h(list);
				}
			}
		}
			
	}

	public static void w(ArrayList<String> list,int j) {
		// �˷����㷽��
		Random r = new Random();
		int i = 0;
		int answer = 0;
		int a = 0;
		int b = 0;
		a = r.nextInt(9 + 1);
		// aΪ��һ�������
		b = r.nextInt(9 + 1);
		// bΪ�ڶ��������
		answer = a * b;
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);
		list.add("(" + (j + 1) + ") " + a1 + " * " + b1 + " = ");
		list.add(answer1);
	}

	public static void z(ArrayList<String> list,int j) {
		// �������㷽��
		Random r = new Random();
		int i = 0;
		int a = 0;
		int b = 0;
		int answer = 0;
		a = r.nextInt(9) + 1;
		// aΪ��һ�������
		b = r.nextInt(9) + 1;
		// bΪ�ڶ��������
		answer = a / b;
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);
		list.add("(" +( j + 1) + ") " + a1 + " / " + b1 + " = ");
		list.add(answer1);
	}

	public static void y(ArrayList<String> list, int j) {
		// �ӷ����㷽��
		Random r = new Random();
		int answer = 0;
		int a = 0;
		int b = 0;

		do {
			a = r.nextInt(100);
			// aΪ��һ�������
			b = r.nextInt(100);
			// bΪ�ڶ��������
			answer = a + b;
		} while (answer >= 100);
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);

		list.add("(" + (j) + ") " + a1 + " + " + b1 + " = ");

		list.add(answer1);

	}
	
	public static void x(ArrayList<String> list, int j) {
		// �p�����㷽��
		Random r = new Random();
		int answer = 0;
		int a = 0;
		int b = 0;

		do {
			a = r.nextInt(100);
			// aΪ��һ�������
			b = r.nextInt(100);
			// bΪ�ڶ��������
			answer = a - b;
		} while (answer < 0);
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);

		list.add("(" + (j) + ") " + a1 + " - " + b1 + " = ");

		list.add(answer1);

	}
	
	public static void h(ArrayList<String> list) { // �½�һ����������ר�����
		int i = 0;
		File toFile = new File("out.txt");
		PrintStream ps = null;
		OutputStream os = null;
		try {
			// ps=new PrintStream(toFile);//��ֱ�Ӵ�File
			os = new FileOutputStream(toFile, false);// true��ԭ�ļ���׷��
			ps = new PrintStream(os, true);// true�Զ�ˢ��
			for (i = 0; i <= 2*n- 2; i = i + 2) {
				ps.println(list.get(i));
			}
			ps.println();
			for (i = 0; i <= 2*n - 2; i = i + 2) {
				ps.print(list.get(i));
				ps.println(list.get(i + 1));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}

	}
	
}
	
	
	
	
	
	