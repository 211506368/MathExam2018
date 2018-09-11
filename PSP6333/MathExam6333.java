import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MathExam6333 {
	static int n;
	static int grade;
	public static void main(String args[]) throws FileNotFoundException {
		if(args.length==1) {//�жϲ�������
			try {
 				n = Integer.parseInt(args[0]);
 				if (n <= 0) {
 					System.out.println("��Ŀ��������Ϊ0���������������룡");
 				}
 			} catch(NumberFormatException e) {
 				System.out.println("��Ŀ��������Ϊ�����������������룡");
 			}
			String[] str=  new String[50];
			File file =new File("out6333.txt");//����Ŀ�𰸷ŵ�txt�ļ���
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);
			n = Integer.parseInt(args[0]);
			grade1(n,str);
			System.out.println("-------------��׼��------------");
			answer(n,str);
			}
		if(args.length==2) {//�����������������δ���
			try {
 				n = Integer.parseInt(args[0]);
 				grade=Integer.parseInt(args[1]);
 				if (n <= 0) {
 					System.out.println("��Ŀ��������Ϊ0����������������");
 				}
 				else if(grade>2) {
 					System.out.println("���꼶��Ŀ��δ������ɣ������ڴ���");
 				}
 				else if(grade<=0) {
 					System.out.println("�꼶����Ϊ0���������������룡");
 				}
 			} catch(NumberFormatException e) {
 				System.out.println("��Ŀ��������Ϊ�����������������룡");
 			}
			n=Integer.parseInt(args[0]);//�ж���Ŀ����
			grade=Integer.parseInt(args[1]);//�ж��꼶
			String[] str=  new String[50];
			File file =new File("out6333.txt");//����Ŀ�𰸷ŵ�txt�ļ���
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);
			if(grade==1) {
				grade1(n,str);
				System.out.println("-------------��׼��------------");
				answer(n,str);
			}
			if(grade==2) {
			grade2(n,str);
			System.out.println("-------------��׼��------------");
			answer(n,str);
			}
		}
	}
	public static void grade1(int n,String[] str) {//����ķ���
		for(int i=0;i<n;i++) {
			int n1=(int)(0+Math.random()*(2-1+1));//�������0��1�������жϼӷ����߼�����0Ϊ�ӷ���1Ϊ����
			int n2=(int)(0+Math.random()*(100-1+1));
			int n3=(int)(0+Math.random()*(100-1+1));
			if(n1==0) {
				while(n2+n3>100) {//����֮�Ͳ��ܴ���100
					n2=(int)(0+Math.random()*(100-1+1));
					n3=(int)(0+Math.random()*(100-1+1));
				}
				int n4 = n2+n3;
				System.out.println("("+(i+1)+")"+n2+" "+"+"+" "+n3+" "+"=");
				 str[i]= "("+(i+1)+")"+n2+" "+"+"+" "+n3+" "+"="+" "+n4;//����Ŀ�ʹ𰸱�����str��������	
			}
			if(n1==1) {
				while(n2-n3<0) {//����֮���С��0
				 n2=(int)(0+Math.random()*(100-1+1));
				 n3=(int)(0+Math.random()*(100-1+1));
				}
				System.out.println("("+(i+1)+")"+n2+" "+"-"+" "+n3+" "+"=");
				int n4 = n2-n3;
				 str[i]= "("+(i+1)+")"+n2+" "+"-"+" "+n3+" "+"="+" "+n4;
				}
			}
	}
	public static void grade2(int n,String[] str) {
		for(int i=0;i<n;i++) {
			int n1=(int)(0+Math.random()*(2-1+1));//�������0��1�������жϼӷ����߼�����0Ϊ�˷���1Ϊ����
			
			
			if(n1==0) {
				int n2=(int)(1+Math.random()*(10-1+1));
				int n3=(int)(1+Math.random()*(10-1+1));
				int x=n2*n3;
				System.out.println("("+(i+1)+")"+n2+" "+"*"+" "+n3+" "+"=");	
				str[i]= "("+(i+1)+")"+n2+" "+"*"+" "+n3+" "+"="+" "+x;
			}
			if(n1==1) {
				int n2=(int)(0+Math.random()*(100-1+1));
				int n3=(int)(1+Math.random()*(100-1+1));
				int x =n2/n3;
				int y=n2%n3;
				System.out.println("("+(i+1)+")"+n2+" "+"��"+" "+n3+" "+"=");
				str[i]= "("+(i+1)+")"+n2+" "+"��"+" "+n3+" "+"="+" "+x+"..."+y;
			}
			}
		
	}
	public static void answer(int n,String[] str) {//���������
		int i;
		for(i=0;i<n;i++) {
			System.out.println(str[i]);
			 
		}SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
			 System.out.println("              211606333 ��������־��  " +sdf.format(new Date()));
	}
}