/*
 *��һ��������ԭ�й淶��4�ո�����
 *�ڶ���:�����˶�import������֯��ʽҪ��,ֻҪ��һ���߼��Լ��ɣ������ϸ�����.
 *������:��Ҫ��δʹ�õ�import������ɾ�� 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MathExam6320 {
	public static void CreateFile() {
		/* ����txt�ļ� */
		String filename="out.txt";
		File file=new File(filename);
		if(!file.exists()) {
			System.out.println("�ļ������ɹ�");
		}else {
			System.out.println("�ļ��Ѵ���");
		}
	}
	
	public static void print(int N,int M) {
		char sign[]= {'+','-','*','/'};
		Random random=new Random();
		Map<Integer,String> map1=new HashMap<Integer,String>();
		Map<Integer,Integer> map2=new HashMap<Integer,Integer>();
		/* �������������ӵ�����洢 */
		for(int i = 1; i <= N; i++) {
			int x=random.nextInt(M);
			int y=random.nextInt(M);
			int f=random.nextInt(M)%2;
			int num = 0;
			
			switch (f) {
				case 0:num=x+y;	break;
				case 1:
					while(y>x) {
						y=random.nextInt(M);
					}
					num=x-y;	break;
			}
			map1.put(i,x+" "+sign[f]+" "+y);
			map2.put(i,num);
		}
		
		/* ���ļ�д������� */
		PrintStream pS=null;
		try {
			pS = new PrintStream(new FileOutputStream("out.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�����ļ�ʧ��");
			e.printStackTrace();
		}
		/* ��Ŀ */
		for (int i = 1; i <= N; i++) {
			pS.println("("+i+") "+map1.get(i));
		}
		pS.println("");
		System.out.println("");
		/* ��׼�� */
		for (int i = 1; i <= N; i++) {
			pS.println("("+i+") "+map1.get(i)+" = "+map2.get(i));
		}
		pS.close();
	}
	
	public static void main(String[] args) {
		try	{
			if(args[0] != null && args[0].matches("0*[0-9]{0,3}")){
			Integer N=Integer.parseInt(args[0]);
			CreateFile();
			print(N,50);
			}else {
				System.out.println("������Ϸ�����(��Χ��1~999������)");
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("���������");
		}
	}
}