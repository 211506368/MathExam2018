package Autyunsuan;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

//import java.util.Scanner;  //����Ҫ���


public class MathExam6388 {

	private static int n1,n2,x;    //����������̬��Ա
	private static String[] str1 ;
	private static String sun;   //�����¶����ַ���

	public static void main(String args[]) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		int i =Integer.valueOf(args[0]).intValue();   //��Ŀ
		int g =Integer.valueOf(args[1]).intValue();   //�꼶
		//����������ļ���
		File file = new File("out6388.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		choiceGrade(i, g);
		
	}	
//	try { 
//		  while (b) { 
//			  System.out.print("��ȷ�����������(������)��"); 
//			  String s = (String) br.readLine(); 
//			  for (int j = 0; j < s.length(); j++) { 
//				  if (!(s.charAt(j) >= 48 && s.charAt(j) <= 57)) {
//					  System.out.println("������Ĳ���������!����������."); 
//					  b = true; 
//					  break; 
//		} 
//		  else {
//			  b = false; 
//			  }
//		} 
//		    if (!b) { 
//		    int i = Integer.parseInt(s);
//		     if(i==0){
//		      System.out.println("������Ĳ���������!����������.");
//		      break;
//		     }
//		     
//		     System.out.println("���������:" + i); 
//		    } 
//		   } 
//		  }
	//һ�꼶�Ӽ���
	public static void G1( int n ) {
		str1 = new String[n];
		for (int i = 0; i < n ; i++) {
			int x = (int)(Math.random()*100+1);
			int y = (int)(Math.random()*100+1);
			int z = (int)(Math.random()*100+1);
			// �жϼӷ��ͼ��� 
//			for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
//				int n1 = (int)(Math.random()*100+1);
//				int n2 = (int)(Math.random()*100+1);
//				if(n1 > n2) {
//					if(n2 >= 10)
//						n2 = n2%10*10;
//					System.out.println("("+ i +") " + n1 +" - "+ n2 );
//					String str = ("("+ i +") " + n1 +" - "+ n2 + " = " + (n1-n2));
//					out.writeUTF(str);
//				}	
//				else {
//					if(n2 >= 10)
//						n2 = n2%10*10;
//					System.out.println("("+ i +") " + n1 +" + "+ n2 );
//					String str = ("("+ i +") " + n1 +" + "+ n2 + " = " + (n1+n2));
//					out.writeUTF(str);;
//				}
//			}
			if ( z == 0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " ");
				str1[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);
			}
			else {
				if (x-y < 0) {
					System.out.println("(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " " + (y-x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
				}
			}
		}
//		out.close
		System.out.println("------------��׼��------------");//�����
		for(String a:str1)
			System.out.println(a);
		SimpleDateFormat time = new SimpleDateFormat("aaaa��bb��cc�� dd:ee");
		System.out.println("211606388������ "+time.format(new Date()));
	}
	
	//���꼶�˳���
	public static void G2( int n ) {
		str1 = new String[n];
		for (int i = 0; i < n; i++) {
			n1 = new Random().nextInt(10) + 1;
			n2 = new Random().nextInt(10) + 1;
			x = (int)(Math.random()*2);
			if (   n1!=0 && n2!=0 && x == 0) {
				System.out.println("(" + (i+1) + ")" +" " + n1 + "*" + n2 + " " + "=" + " ");
				str1[i] = "(" + (i+1) + ")" +" " + n1 + "*" + n2 + " " + "=" + " " + (n1*n2);
			}
			else {
				if (n1-n2 < 0 ) {
					System.out.println("(" + (i+1) + ")" +" " + n2 + "/" + n1 + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + n2 + "/" + n1 + " " + "=" + " " + (n2/n1) + judgementRemainder(n2,n1);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + n1 + "/" + n2 + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + n1 + "/" + n2 + " " + "=" + " " + (n1/n2) + judgementRemainder(n1,n2);
				}
			}
		}
		System.out.println("-----------��׼��-----------");
		//�����
		for(String k:str1) {
			System.out.println(k);
		}
		//������ں�����ѧ��
		SimpleDateFormat sdf = new SimpleDateFormat("aaaa��bb��cc�� dd:ee");
		System.out.println("211606388������" +sdf.format(new Date()));
	}
	
	//ѡ���꼶
	public static void choiceGrade( int e , int f ) {
		if ( f == 1 ) {
			G1(e);
		}
		else if ( f == 2) {
			G2(e);
		}
		else {
			System.out.println("���ޣ�ֻ��һ�꼶���꼶�����Ǹ�δ֪������");
		}
	}
	
	public static String judgementRemainder( int n1 , int n2 ) {
		if( (n1%n2) == 0) {
			
			sun = " ";
		}
		else {
			sun = "..." + (n1%n2) + " ";
		}
		return sun;
	}
}