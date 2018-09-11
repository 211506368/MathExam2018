
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MathExam6301 {
	//���Բ�����С
	public static void para(int n1,int n2){
		if(n1>0 && n1<=50) {
			operation(n1,n2);
		}
		else if(n1>50) {
			System.out.println("�������������̫��");
	}
		else{
			System.out.println("������Ϊ��������");
	}

}
	//���Բ�����λ
	private static void number(String args1, int num, int grade, String args2){
		int f=0;   
		int g=0;
		for(int i=0;i<args2.length();i++) {
			if(args2.charAt(i)!='0') {f++;}  //��1��˵�ǵڶ�������,��2��˵�ǵ�һ������
			else {break;}	
		}
		for(int i=0;i<args1.length();i++) {
			if(args1.charAt(i)!='0') {g++;}
			else {break;}
		}
			if(f>0 && g>0) {
				if(grade==2) {
					para(num,grade);
				}
				else if(grade==1) {
				para(num,grade);
				}
			}
			else if(g==0 && f==0) {
				System.out.println("�꼶��������λ����Ϊ0��");
			}
			else {
				System.out.println("�꼶��������λ�κ�һ��������Ϊ0��");
			}
		}
		
	//����
	public static void operation(int n,int m){
		File file = new File("out.txt");
		OutputStream out;
		try {
			out = new FileOutputStream(file);
			int[] an= new int[n];
			int bn[] = new int[n];
			String random = "";
			String[] Symbol1= {"+","-"};
			String[] Symbol2= {"*","/"};

			if(m==1) { //�ж��꼶
				for(int i=0;i<n;i++) {
					int index = (int)(Math.random()*(Symbol1.length));
					random = Symbol1[index];   //�������Symbol1�е�Ԫ��
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
			}
			if(m==2) {
				for(int i=0;i<n;i++) {
					int index = (int)(Math.random()*(Symbol2.length));
					random = Symbol2[index];
					if(random.equals("*")) {
						int a = (int)(Math.random()*10);
						int b = (int)(Math.random()*10);
						System.out.printf("("+(i+1)+") "+a+" * "+b+" = "+"\n");
						an[i]=a*b;
						String output = "("+(i+1)+") "+a+" * "+b+" = "+"\n";
						out.write(output.getBytes());
			
					}
					if(random.equals("/")) {
						int a = (int)(Math.random()*(100+1));
						int b = 1+(int)(Math.random()*9);
						System.out.printf("("+(i+1)+") "+a+" / "+b+" = "+"\n");
						an[i]=a/b;
						bn[i]=a%b;
						String output = "("+(i+1)+") "+a+" / "+b+" = "+"\n";
						out.write(output.getBytes());
			}
			}
			}
			String flag = "\n";
			out.write(flag.getBytes());
			//�����
			Scanner in = new Scanner(file);
			int j=0;
			while(in.hasNextLine()&&j!=n) {
				if(bn[j]==0) {
					String s = in.nextLine()+an[j]+"\n";
					out.write(s.getBytes());
				}
				else {
				String s = in.nextLine()+an[j]+"..."+bn[j]+"\n";
				out.write(s.getBytes());
				}
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
		else if(args[0].matches(regex)) { //�жϵ�һ�������Ƿ�������
			num[0]=Integer.parseInt(args[0]);  //����һ��������Stringת��ΪInt
		//1������   1�꼶
			if(args.length==1) {
				number(args[0],num[0],1,args[0]);	
				if(args.length>=2) {
				System.out.println("ֻ������һ��������");
			}
			}
		//2������
			
			else if(args.length==2) {
				if(args[1].matches(regex)) {
					num[1]=Integer.parseInt(args[1]);
					//2�꼶
					if(num[1]==2) {
						number(args[1],num[0],num[1],args[0]);
				}
					//1�꼶
					else if(num[1]==1) {
						number(args[0],num[0],num[1],args[1]);
				}
					else{
						System.out.println("�ݲ�֧�������꼶��");
					}
				}
				else {
					System.out.println("�꼶��Ϊ��������");
					}
				}
			else {
				System.out.println("ֻ����������������");
			}
		}
		else {
			System.out.println("������Ϊ��������");
		}
	}
	}


