package com.java.primarymath;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("out.txt");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		int[] first=new int[100]; // ��һ����
		int[] second=new int[100];//�ڶ�����
		String[] fuhao=new String[100]; //����
		int[] pass=new int[100];//��
		Scanner s = new Scanner(System.in);
		System.out.println("��������Ҫ����Ŀ������");
		int n=s.nextInt();
		Random  r=new Random();
		int k,m,f,i=0;
		boolean p=true;
			while(p)
			{
			k=r.nextInt(100);
			m=r.nextInt(100);
			f=r.nextInt(10);
			if (f%2==0) {  //�ӷ�
				if(k+m<=100)
				{
					first[i]=k;
					second[i]=m;
					fuhao[i]="+";
					pass[i]=k+m;
					i++;
					
				}
			}
			else	//����
			{
				if(k-m>=0)
				{
					//System.out.println("("+(i+1)+") "+k+" - "+m+" = ");
					first[i]=k;
					second[i]=m;
					fuhao[i]="-";
					pass[i]=k-m;
					i++;
				}
			}
			if(i==n)
				break;
		}
			for (int j = 0; j < n; j++) {
				System.out.println("("+(j+1)+") "+first[j]+" "+fuhao[j]+" "+second[j]+" =");
				
			}
			System.out.println("��׼��");
			for (int j = 0; j < n; j++) {
				System.out.println("("+(j+1)+") "+first[j]+" "+fuhao[j]+" "+second[j]+" = "+pass[j]);
				
			}
			 // byte[] ti =timu[i-1].getBytes();	// ���ַ���ת��Ϊ�ֽ���Ϊ��д��txt�ļ�
		      //byte[] da =daan[i-1].getBytes();
		      //byte[] h=huanhang.getBytes();
		      //u.write(ti);	// ��ת���õ��ֽ���д��txt
		      //u.write(h);

	}
	}
	
