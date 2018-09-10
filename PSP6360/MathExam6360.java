

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class MathExam6360 {
	
	public static void create(int count,int grade) {
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
		int [] an=new int[count];
		int [] bn=new int[count];
		int [] cn=new int[count];
		int [] dn=new int[count];
		int [] en=new int[count];
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
				if(grade==1) 
				{
					int number = (int)Math.floor((r.nextDouble()*2.0));//���ɵڶ������֣������жϷ���
					symbol=number;
				}
				else if(grade==2)
				{
					int number = (int)Math.floor((r.nextDouble()*4.0));//���ɵڶ������֣������жϷ���
					symbol=number;
				}
				
			}
			else if(i==2)
			{	
				int number = 1+(int)Math.floor((r.nextDouble()*100.0));//���ɵ���������//���ɵ���������
				second=number;
			}		
			else if(i==3)
			{
				en[w]=0;
				if (symbol==0)//�жϷ��ţ�0Ϊ+�ţ�1Ϊ-�ţ�2Ϊ���ţ�3Ϊ�º�
				{   
					try {
						bw.write(String.valueOf(" "+ first+ " + " +second+" = "));
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					an[w]=first+second;
				}
				else if((symbol==1))
				{
					if(first-second < 0)
					{mark=1;break;}
					try {
						bw.write(String.valueOf(" "+ first+ " - " +second+" = "));
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					an[w]=first-second;
				}
				else if((symbol==2)) 
				{
					try {
						bw.write(String.valueOf(" "+ first+ " �� " +second+" = "));
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					an[w]=first*second;
				}
				else if((symbol==3)) 
				{
					en[w]=first % second;
					an[w]=(int)(first/second);
					try {
						bw.write(String.valueOf(" "+ first+ " �� " +second+" = "));
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				bn[w]=first; //��ʽ�ӵ����ִ��������У�����֮�����ȡ
				cn[w]=symbol;
				dn[w]=second;
				sign++;
				mark=0;//֤��ʽ�ӳɹ�д�룬�����Ҫ���¡�
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
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " + " +dn[i]+" = "+an[i]));
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			else if(cn[i]==1) {
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " - " +dn[i]+" = "+an[i]));
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				}
			else if(cn[i]==2) {
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " �� " +dn[i]+" = "+an[i]));
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

				}
			else if(cn[i]==3) 
			{
				if(en[i]==0) 
				{
					try {
						bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " �� " +dn[i]+" = "+an[i]));
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				else if(en[i]!=0)
				{
					try {
						bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " �� " +dn[i]+" = "+an[i]+ " ������ "+ en[i]));
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}

				}
			}
	
		try {
			bw.newLine();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
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
		num [1] = Integer.parseInt(args[1]);//������ת��Ϊ����
		create(num[0],num[1]);
		}	
	}

		
		

	

