

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
public class MathExam6360 {

	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		File file = new File ("out.txt");//�����ı�
		int num[] = new int [args.length];//�������飬���ڶ�ȡ����
	
		if(!file.exists())//�ж��ļ��Ƿ���ڣ������ڲഴ��
		{
		file.createNewFile();
		System.out.println("out.txt�������");
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		num [0] = Integer.parseInt(args[0]);//������ת��Ϊ����
		int first=0,symbol=0,second=0,sign=1,q=0,mark=0,w=0;
		int [] an=new int[num[0]];
		int [] bn=new int[num[0]];
		int [] cn=new int[num[0]];
		int [] dn=new int[num[0]];
		
		Random r =new Random(); 
		while(sign<=num[0]) {
			if(mark==0) {//�ж�����Ƿ���Ҫ���£�����Ҫ��������š�
		bw.write(String.valueOf("("+sign+")"+" "));
			}
		for(int i=0;i<4;i++)//ѭ���ĴΣ�������������������ڵ��Ĵν��з����жϣ�������ı�����ʽ�ӡ�
		{
			if(i==0)
			{int number = (int)Math.floor((r.nextDouble()*100.0));//����ʽ�ӵĵ�һ����
			first=number;}
			else if(i==1)
			{
			 int number = (int)Math.floor((r.nextDouble()*2.0));//���ɵڶ������֣������жϷ���
			 symbol=number;
			}
			else if(i==2)
			{int number = (int)Math.floor((r.nextDouble()*100.0));//���ɵ���������
				second=number;}		
			else if(i==3)
			{
			 if (symbol==0)//�жϷ��ţ�0Ϊ+�ţ�1Ϊ-��
			 {  bw.write(String.valueOf(" "+ first+" "));
				bw.write(String.valueOf("+"));
			 	bw.write(String.valueOf(" "+second+" "));
			 	bw.write(String.valueOf("="));
				sign++;
				mark=0;//֤��ʽ�ӳɹ�д�룬�����Ҫ���¡�
				bn[w]=first;
				cn[w]=0;
				dn[w]=second;
				w++;
				}
			 else if(symbol==1)//�жϷ��ţ�0Ϊ+�ţ�1Ϊ-��
			 {
				 if(first-second < 0)//�ж�ʽ�ӵĽ���Ƿ�Ϊ���������ǣ����˳���ѭ�������¿�ʼwhileѭ����
					{mark=1;break;}
				bw.write(String.valueOf(" "+ first+" "));
				bw.write(String.valueOf("-"));
				bw.write(String.valueOf(" "+second+" "));
				bw.write(String.valueOf("="));
			 	sign++;
			 	mark=0;
				bn[w]=first;
				cn[w]=1;
				dn[w]=second;
				w++;
			 	}
			for(;;)
			 {
				if(symbol==0)//�жϷ��ţ�Ȼ��Ѵ𰸴�������an
				{	an[q]=first+second;q++;break;}	
				else if(symbol==1)
				{	an[q]=first-second;q++;break;}
			 }
			}
			
		}
		if(mark==0)
		bw.newLine();
		}
		bw.write(String.valueOf("-----------------��׼�� -----------------------"));
		bw.newLine();
		int flag=1;
		for(int i=0;i<num[0];i++)//ѭ������𰸣��������顣
		{
			if(cn[i]==0) {
			bw.write(String.valueOf("(" + flag +")"));
			bw.write(String.valueOf(" "+ bn[i]+" "));
			bw.write(String.valueOf("+"));
			bw.write(String.valueOf(" "+dn[i]+" "));
			bw.write(String.valueOf("="));
			bw.write(String.valueOf(" "+an[i]));
			bw.newLine();
			flag++;
			}
			else if(cn[i]==1) {
			bw.write(String.valueOf("(" + flag +")"));
			bw.write(String.valueOf(" "+ bn[i]+" "));
			bw.write(String.valueOf("-"));
			bw.write(String.valueOf(" "+dn[i]+" "));
			bw.write(String.valueOf("="));
			bw.write(String.valueOf(" "+an[i]));
			bw.newLine();
			flag++;
			}
		}
		bw.close();
		fw.close();
		}
}
	/*	while((data=BR.readLine())!=null) {
		bw.write(String.valueOf(data));		
		bw.write(String.valueOf(' '));
		bw.write(String.valueOf(an[q]));
		bw.newLine();
		bw.flush();
		q++;		
		}
		
		BR.close();
		fr.close();
		//cd eclipse/��ҵ/��ҵ1/01work6360/src
	 for(q=0;q<num[0];q++)
		{
		bw.write(String.valueOf(an[q]));
		bw.newLine();}
		*/
		
		

	

