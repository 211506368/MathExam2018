

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
		int first=0,symbol=0,second=0,mark=0,w=0;
		int [] an=new int[count];//�������飬���ڴ洢���ݣ��洢�𰸡�
		int [] bn=new int[count];//�洢��һ�����֣�ʽ�ӵĵ�һ������
		int [] cn=new int[count];//�洢�ڶ������֣������жϷ��ţ�
		int [] dn=new int[count];//�洢���������֣�ʽ�ӵĵڶ�����
		int [] en=new int[count];//�洢������
		Random r =new Random(); 
		while(w <count) {
			
			
			if(mark==0) //�ж�����Ƿ���Ҫ���£�����Ҫ��������š�
			{
				try {
					bw.write(String.valueOf("("+ (w+1) +") "));
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
			
		for(int i=0;i<4;i++)//ѭ���ĴΣ�������������������ڵ��Ĵν��з����жϣ�������ı�����ʽ�ӡ�
		{
			if(i==0)
			{
				int number = (int)Math.floor((r.nextDouble()*100.0));//����ʽ�ӵĵ�һ����
				first=number;
				bn[w]=first; //��ʽ�ӵ����ִ��������У�����֮�����ȡ
			}
			
			
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
				cn[w]=symbol;//��ʽ�ӵ����ִ��������У�����֮�����ȡ
				
			}
			
			
			else if(i==2)
			{	
				int number = 1+(int)Math.floor((r.nextDouble()*100.0));//���ɵ���������
				second=number;
				dn[w]=second;//��ʽ�ӵ����ִ��������У�����֮�����ȡ
			}		
			
			
			else if(i==3)
			{
				en[w]=0;//��������
				
				if (symbol==0)//�жϷ��ţ�0Ϊ+�ţ�1Ϊ-�ţ�2Ϊ���ţ�3Ϊ�º�
				{   
					try {
						bw.write(String.valueOf(" "+ first+ " + " +second+" = "));//����ʽ��
						an[w]=first+second;//���𰸴洢������an��
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				
				}


				else if((symbol==1))
				{
					if(first-second < 0)
					{mark=1;break;}
					try {
						bw.write(String.valueOf(" "+ first+ " - " +second+" = "));//����ʽ��
						an[w]=first-second;//���𰸴洢������an��
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}

				}


				
				else if((symbol==2)) 
				{
					try {
						bw.write(String.valueOf(" "+ first+ " �� " +second+" = "));//����ʽ��
						an[w]=first*second;//���𰸴洢������an��
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}


				
				else if((symbol==3)) 
				{
					
					
					try {
						en[w]=first % second;//��������������en��
						bw.write(String.valueOf(" "+ first+ " �� " +second+" = "));//����ʽ��
						an[w]=(int)(first/second);//���𰸴洢������an��
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
			System.out.println(w);
			mark=0;//֤��ʽ�ӳɹ�д�룬�����Ҫ���¡�
			w++;
			
			}	
			
				
		}//��ѭ������
	
				
		if(mark==0)//�ж�ʽ���Ƿ�ɹ�д�룬����ɹ���ִ�л��С�
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	}//whileѭ��������
		
		
		
		try {
				
				bw.write(String.valueOf("-----------------��׼�� -----------------------"));
				bw.newLine();
				
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
		}
		

		for(int i=0;i<count;i++)//ѭ������𰸣��������顣
		{
			
			if(cn[i]==0) //�жϷ��ţ�0Ϊ+�ţ�1Ϊ-�ţ�2Ϊ���ţ�3Ϊ�º�
			{
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " + " +dn[i]+" = "+an[i]));//������ʽ��������ı���
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
			
			else if(cn[i]==1) //�жϷ��ţ�0Ϊ+�ţ�1Ϊ-�ţ�2Ϊ���ţ�3Ϊ�º�
			{
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " - " +dn[i]+" = "+an[i]));//������ʽ��������ı���
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
			
			else if(cn[i]==2) //�жϷ��ţ�0Ϊ+�ţ�1Ϊ-�ţ�2Ϊ���ţ�3Ϊ�º�
			{
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " �� " +dn[i]+" = "+an[i]));//������ʽ��������ı���
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

			}
			
			
			else if(cn[i]==3) //�жϷ��ţ�0Ϊ+�ţ�1Ϊ-�ţ�2Ϊ���ţ�3Ϊ�º�
			{
				
				if(en[i]==0) //�ж������Ƿ�Ϊ0��Ϊ0��ִ�����д���
				{
					try {
						bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " �� " +dn[i]+" = "+an[i]));//������ʽ��������ı���
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				
				else if(en[i]!=0)//�ж������Ƿ�Ϊ0����Ϊ0��ִ�����д���
				{
					try {
						bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " �� " +dn[i]+" = "+an[i]+ " ������ "+ en[i]));//������ʽ��������ı�������������
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
		String Regex="[1-9]{1}[0-9]{0,10}";//������ʽ��������Ĳ����޶�����������Χ�ڣ�ͬʱ��������ޡ�
		String Regex2="[1-2]{1}";//������ʽ��������Ĳ����޶�����������Χ�ڣ�ͬʱ��������ޡ�
		Pattern p =Pattern.compile(Regex);
		Pattern p2 =Pattern.compile(Regex2);		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		Matcher count=p.matcher(args[0]);
		Matcher grade=p2.matcher(args[1]);
		
			if(count.find() &&  grade.find())
			{
				int num[] = new int [args.length];//�������飬���ڶ�ȡ����
				num [0] = Integer.parseInt(args[0]);//������ת��Ϊ����
				num [1] = Integer.parseInt(args[1]);//������ת��Ϊ����
				create(num[0],num[1]);
				break;
			}
			
			else
			{	
				System.out.println("��������������������(������Χ��1-99999999999���꼶��Χ��1-2)��");
				String t = sc.nextLine();
				args = t.trim().split(" ");
				continue;
			}
		}
				
	}
}	
	

		
		

	

