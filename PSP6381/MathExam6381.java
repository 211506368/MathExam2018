import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MathExam6381 {
 private static int n;
 private static int grade = 1;

 public static void main(String[] args) {
	 for(int i=0;i<args[0].length();i++) {
		   if(args[0].charAt(i)>'9' || args[0].charAt(i)<'0') {
		    System.out.println("������������������");
		    return;
		   }
		  }
		  n=Integer.parseInt(args[0]);
		  for(int i=0;i<args[1].length();i++) {
			   if(args[1].charAt(i)>'9' || args[0].charAt(i)<'0') {
			    System.out.println("������������������");
			    return;
			   }
			  } 
		  grade=Integer.parseInt(args[1]);
		  if(!(grade>0 && grade<=2)) {
			  System.out.println("�꼶������.�꼶ֻ����1��2");
			  return;
		  }
		   StringBuffer timu= new StringBuffer();
	       StringBuffer daan = new StringBuffer();
	       if(grade>0 && grade<=2) {
	       String ysf;
	       int p=0,m;
				  if(grade==1) {
					  for(int i = 1; i <= n; i++) {
						  int num1=(int) (Math.random()*101);
	                      int num2=(int) (Math.random()*101);
					   p=(int) (Math.random()*101)%2;
					   if(p==0) {ysf="+";}
					   else { ysf="-"; }
					   if(ysf.equals("+")) { m=num1+num2; }
					   //Ϊ������ָ������ڽ��м�����ʱ����֤��һ�������ڵڶ�������
					   else {
					     if(num1 < num2) {
					    int t;
					    t= num1;
					    num1 = num2;
					    num2 = t;
					   }
					     m=num1-num2;
					   }
					   timu.append("(" + i + ") " + num1 +" "+ ysf +" "+ num2 +" ="+ System.lineSeparator());
					   daan.append("(" + i + ") " + num1 + " "+ysf +" "+ num2 + " = " + m + System.lineSeparator());
					  }
					  }
				  else {
					  for(int i = 1; i <= n; i++) {
						  int num1=(int) (Math.random()*101);
	                      int num2=(int) (Math.random()*101);
						  int sjs;
						  sjs=(int) (Math.random()*101);
						  if(sjs%4==0) {ysf="+";}
						  else if(sjs%4==1) {ysf="-";}
						  else if(sjs%4==2) {ysf="*";}
						  else {ysf="/";}
						  int q=0;
						  if(ysf.equals("+")) {
						   m=num1+num2;
						  }
						  //Ϊ������ָ������ڽ��м�����ʱ����֤��һ�������ڵڶ�������
						  else if(ysf.equals("-")){
						    if(num1 < num2) {
						   int t;
						   t= num1;
						   num1 = num2;
						   num2 = t;
						  }
						    m=num1-num2;
						  }
						  else if(ysf.equals("*")) {
						 	 num1=(int) (Math.random()*10);
						 	 num2=(int) (Math.random()*10);
						 	 m=num1*num2;
						  }
						  else {
						 	 num1=(int) (Math.random()*10);
						 	 num2=(int) (Math.random()*10);
						 	 q=num1%num2;
						 	 m=num1/num2;
						  }
						  timu.append("(" + i + ") " + num1 +" "+ ysf+" " + num2 +" ="+ System.lineSeparator());
						  if(ysf.equals("/") && q!=0) {
						 	 daan.append("(" + i + ") " + num1 +" "+ ysf +" "+ num2 + " = " + m +"..."+ q +System.lineSeparator());
						  }else {
						  daan.append("(" + i + ") " + num1 + " "+ysf +" "+ num2 + " = " + m + System.lineSeparator());
						  
				  }
			  }
 //public static void main(String[] args) {
 // System.out.println("��������������ʾ��Ŀ������");
     //Scanner sc=new Scanner(System.in);
     //n=sc.nextInt();
     //while(n<=0) {
      // s=new Scanner(System.in);
     // n=s.nextInt();
    // }
   //  System.out.println("������1��2��ʾ�꼶��");
     //Scanner g=new Scanner(System.in);
     //grade=g.nextInt();
    // while(grade<=0 || grade>2) {
    //  System.out.println("�������ִ��������������꼶��");
     // Scanner p=new Scanner(System.in);
   //   grade=p.nextInt();
     //}
//��������StringBuffer�������������������Ŀ�ͱ�׼��

 //��¼��Ŀ�ʹ�
 
}
}
			
//����Ŀ�ʹ�д���ļ�
try {
 write("out6381.txt",timu,daan);
 System.out.println("��Ŀ������");
} catch (IOException e) {
 e.printStackTrace();
}
}

private static void write(String filename,StringBuffer timu,StringBuffer daan) throws IOException {
   // ����1��ȷ��������ļ���Ŀ�ĵأ�
// ���filename�а���·��������ȷ��·���Ѵ���
  File file = new File(filename);
  File parentFile = file.getParentFile();
  if(parentFile!=null&&!parentFile.exists()) {
   parentFile.mkdirs();
   System.out.println("����Ŀ¼��" + parentFile);
  }
  file.createNewFile();
// ����2������ָ���ļ��������
  OutputStream out = new FileOutputStream(file);
// ����3��д������
  out.write(timu.toString().getBytes());
  out.write(System.lineSeparator().getBytes());
  String str="--------------------��׼��--------------------";
  byte[] d=str.getBytes();
  out.write(d);
  out.write(System.lineSeparator().getBytes());
  out.write(System.lineSeparator().getBytes());
  out.write(daan.toString().getBytes());
  out.write(System.lineSeparator().getBytes());
  String s="          211606381 ��������ΰ��   "+LocalDateTime.now();
  out.write(s. getBytes());
   // ����4���ر�
  out.close();
 }
}