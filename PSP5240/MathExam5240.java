import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MathExam5240 {
	
	public static int addition(int i,OutputStream out) {
		int a =(int) (Math.random()*100);
		int b =(int) (Math.random()*(100-a+1));
		String word=("("+(i+1)+") "+a +" + "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return a+b;
	}
	public static int subtraction (int i,OutputStream out){
		int a =(int) (Math.random()*100);
		int b =(int) (Math.random()*(a+1));
		String word=("("+(i+1)+") "+a +" - "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return a-b;
	}
	public static void math(int n){
		int intArray[] = new int[n];
		String filename="out";
		  File file = new File(filename+".txt"); 
		  OutputStream out;
		try {
			out = new FileOutputStream(file);
			for(int i=0;i<n;i++)
		{
			if ((int) (Math.random()*2)==0) {//���мӷ�����
				intArray[i]=addition(i,out);
		}else {//���м�������
			intArray[i]=subtraction(i,out);

		}
			
		}

			 String word = "---------------��׼��--------------- "+"\n";
			  out.write(word.getBytes());
			  //��ȡ���������һ��
			  Scanner scanner0=new Scanner(file);
			  int i=0;
			  while(scanner0.hasNextLine()&&(i!=n)) {
				  word =(scanner0.nextLine())+intArray[i]+"\n";
				  out.write(word.getBytes());
				  i++;
			  }
			  Date date1=new Date();
			  String str="yyyy��MM��dd�� HH:mm";
			  SimpleDateFormat sdf1 = new SimpleDateFormat(str);
			  String time="211605240 л����"+sdf1.format(date1)+"\n";
			  out.write(time.getBytes());
			  out.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	public static int Input(String[] args) {
		String regex="\\d*";
		if(args.length!=1) {//����������Ϊ���
			System.out.println("�����뵥��������");
			Scanner input=new Scanner(System.in);
			args[0]=input.nextLine();
		}
		
		int n=nonnumeric(regex,args);
		while(n>30 || n<0) {
			System.out.println("������һ��������30��С��0������");
			Scanner input=new Scanner(System.in);
			args[0]=input.nextLine();
			n=nonnumeric(regex,args);
		}
		return n;
		
	}
	public static int nonnumeric(String regex,String[] args) {
		
		while(!args[0].matches(regex)) {//���������벻Ϊ����
			System.out.println("��������ȷ�����֡�");
			Scanner input=new Scanner(System.in);
			args[0]=input.nextLine();
		
			}
			String s = String.valueOf(args[0]);
			int n = Integer.parseInt(s);
			return n;
			
	}
	public static void main(String[] args){
		// TODO �Զ����ɵķ������
		System.out.println("---------------��ӭʹ��MathExam5240����---------------");
		System.out.println("1.�밴�ո�ʽ�����롰��Ŀ���������֣����� ����8���������Զ����ɰ˵������⡣");
		System.out.println("2.�������һ�ο�����30�������⡣ѧϰ��һ��ѭ�򽥽��Ĺ��̣����˲�֮������");
		System.out.println("3.ʹ�ù������������޷������bug������ϵ���ͣ���ѻ��һ�װ˽��д���Ľ���");
		System.out.println("-----------------------------------------------------");
		int n=Input(args);
		try {
			math(n);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		

	}

}
