

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class MathExam6360 {
	
	public static void create(int count) {
		File file = new File ("out.txt");//�����ı�
		FileWriter fw=null;
			try {
				fw = new FileWriter(file);
			
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}	
			BufferedWriter bw = new BufferedWriter(fw);
		int first=0,symbol=0,second=0,sign=1,mark=0,w=0;
		int [] an=new int[count+5];
		int [] bn=new int[count+5];
		int [] cn=new int[count+5];
		int [] dn=new int[count+5];
		Random r =new Random(); 
		while(sign<=count) {
			if(mark==0) {//�ж�����Ƿ���Ҫ���£�����Ҫ��������š�
		try {
			bw.write(String.valueOf("("+sign+") "));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
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
			 {  try {
				bw.write(String.valueOf(first+" + "+second+" = "));
				
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
				}
			 else if(symbol==1)//�жϷ��ţ�0Ϊ+�ţ�1Ϊ-��
			 {
				 if(first-second < 0)//�ж�ʽ�ӵĽ���Ƿ�Ϊ���������ǣ����˳���ѭ�������¿�ʼwhileѭ����
					{mark=1;break;}
				try {
					bw.write(String.valueOf(first+" - "+second+" = "));
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			 	
			 	}
				if(symbol==0)//�жϷ��ţ�Ȼ��Ѵ𰸴�������an
					{an[w]=first+second;}
				else if(symbol==1)
					{an[w]=first-second;}

				bn[w]=first; //��ʽ�ӵ����ִ��������У�����֮�����ȡ
				cn[w]=symbol;
				dn[w]=second;
				sign++;
			 	mark=0;//�����ж�ʽ���Ƿ���Ҫ������š�
				w++;
			}
			
		}
		if(mark==0)
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		try {
			bw.write(String.valueOf("-----------------��׼�� -----------------------"));
			bw.newLine();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		

		for(int i=0;i<count;i++)//ѭ������𰸣��������顣
		{
			if(cn[i]==0) {
				try {
					bw.write(String.valueOf("(" + (i+1) +") "+ bn[i]+" + "+dn[i]+" = "+an[i]));
					bw.newLine();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
			}
			else if(cn[i]==1) {
				try {
					bw.write(String.valueOf("(" + (i+1) +") "+ bn[i]+" - "+dn[i]+" = "+an[i]));
					bw.newLine();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
					}
			}
		}
		try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				}
	}
	public static void main(String[] args)  {
		// TODO �Զ����ɵķ������
		int num[] = new int [args.length];//�������飬���ڶ�ȡ����
		num [0] = Integer.parseInt(args[0]);//������ת��Ϊ����
		create(num[0]);
		
		}	
	}

		
		

	

