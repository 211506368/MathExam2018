import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MathExam6301 {
	//���Բ�����С
	public static void para(int n1){
		if(n1>0 && n1<=50) {
			operation(n1);
		}
		else if(n1>50) {
			System.out.println("�������������̫��");
	}
		else{
			System.out.println("������Ϊ��������");
	}

}
	//���Բ�����λ
	private static void number(String args1, int num){  
		int g=0;
		for(int i=0;i<args1.length();i++) {
			if(args1.charAt(i)!='0') {g++;}
			else {break;}
		}
			if(g>0) {
				para(num);	
			}
			else if(g==0) {
				System.out.println("������λ����Ϊ0��");
			}
		}
	//����
	public static void operation(int n){
		File file = new File("out.txt");
		OutputStream out;
		try {
			out = new FileOutputStream(file);
			int[] an= new int[n];
			String random = "";
			String[] Symbol= {"+","-"};
				for(int i=0;i<n;i++) {
					int index = (int)(Math.random()*(Symbol.length));
					random = Symbol[index]; //�������Symbol1�е�Ԫ��
					if(random.equals("+")) {
						int a = (int)(Math.random()*(50+1));//���ѡ��0~50֮�����
						int b = (int)(Math.random()*(50+1));
						System.out.printf("("+(i+1)+") "+a+" + "+b+" = "+"\n");
						an[i]=a+b;
						String output = "("+(i+1)+") "+a+" + "+b+" = "+"\n";
						out.write(output.getBytes());
					}
					else{
						int a = (int)(Math.random()*(100+1));
						int b = (int)(Math.random()*a);
						System.out.printf("("+(i+1)+") "+a+" - "+b+" = "+"\n");
						an[i]=a-b;
						String output = "("+(i+1)+") "+a+" - "+b+" = "+"\n";
						out.write(output.getBytes());
						}
				}
			
			
			String flag = "\n";
			out.write(flag.getBytes());
			//�����
			Scanner in = new Scanner(file);
			int j=0;
			while(in.hasNextLine()&&j!=n) {
				String s = in.nextLine()+an[j]+"\n";
				out.write(s.getBytes());
				j++;
			}
			//ʱ��
			Date date = new Date();
			String time = "yyyy��MM�� dd��  HH:mm";
			SimpleDateFormat sdf = new SimpleDateFormat(time);
			String now = "			211606301   ������    "+sdf.format(date)+"\n";
			out.write(now.getBytes());
			out.close();
		} catch (IOException e) {
			System.out.println("���쳣");
		}
	}
	public static void main(String[] args){
		int [] num = new int[args.length];	
		String regex = "\\d*";
		if(args.length==0) {
			System.out.println("�����������");
		}
		else if(args[0].matches(regex)) {//�жϵ�һ�������Ƿ�������
			num[0]=Integer.parseInt(args[0]);  //����һ��������Stringת��ΪInt
			if(args.length>=2) {
				System.out.println("ֻ������һ��������");
			}
			
			else{
				number(args[0],num[0]);	
			}
			}
		else {
			System.out.println("������Ϊ��������");
		}
		}
	}

