package com.PSP6308;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MathExam6308 {
	public static void main(String[] args)  throws Exception{ Scanner s=new Scanner(System.in);
	   
    System.out.println("��������1�꼶����2�꼶��");
    int n=s.nextInt();	
    if(n==1) {
		show1();
		}
    if(n==2) {
		show2();
    }
		
		
	}

	public static void show1() throws IOException {
		File file = new File("out.txt");
 		FileWriter fw = new FileWriter(file);
 		BufferedWriter bw1 = new BufferedWriter(fw);
 		
 		 Scanner s=new Scanner(System.in);
		   
	        System.out.println("������һ����������");
	        int n=s.nextInt();	       
	        System.out.println("��������"+n+"����Ŀ");
	        String [] arry =  new String[n];
	        int [] answer =new int[n];
	       
	      for (int i = 0; i < n; i++) {
	    	 
	        int x=0+(int)(Math.random()*2);
	        if(x==0) {
	        	int x1=0+(int)(Math.random()*100);
	        	int x2=0+(int)(Math.random()*100);	        	 
	        if(x1+x2>100) {
	        	if(x1>50) x1=x1-50;
	        	if(x2>50) x2=x2-50;
	        }
	        	arry[i]=x1+"+"+x2+"=";
	        	answer[i]=(x1+x2);
				bw1.write(arry[i]);	
				bw1.newLine();
				
	        	}
	        else{
	        	int x1=0+(int)(Math.random()*100);
	        	int x2=0+(int)(Math.random()*100);
	        	 if(x1<x2)
		 	        {int t=0;t=x1;x1=x2;x2=t;}
	        	arry[i]=x1+"-"+x2+"=";
	        	answer[i]=(x1-x2);
				bw1.write(arry[i]);	
				bw1.newLine();
				
	        }}
	      bw1.write(("-------------��׼��--------------"));
	      bw1.newLine();
	     
	    
				
	 			
		         for (int i1 = 0; i1<n; i1++) {
					bw1.write((arry[i1]+answer[i1]));
					bw1.newLine();
					
					
		         }bw1.close();
	}
	public static void show2() throws IOException {
		File file = new File("out.txt");
 		FileWriter fw = new FileWriter(file);
 		BufferedWriter bw2 = new BufferedWriter(fw);
 		
 		 Scanner s=new Scanner(System.in);
		   
	        System.out.println("������һ����������");
	        int n=s.nextInt();	       
	        System.out.println("��������"+n+"����Ŀ");
	        String [] arry =  new String[n];
	        int [] answer =new int[n];
	        String [] yushu = new String[n];
	       
	      for (int i = 0; i < n; i++) {
	    	 
	        int x=0+(int)(Math.random()*2);
	        if(x==0) {
	        	int x1=0+(int)(Math.random()*10);
	        	int x2=0+(int)(Math.random()*10);	        	 
	        
	        	arry[i]=x1+"*"+x2+"=";
	        	answer[i]=(x1*x2);
	        	
				bw2.write(arry[i]);	
				bw2.newLine();
				
	        	}
	        else{
	        	int x1=1+(int)(Math.random()*10);
	        	int x2=1+(int)(Math.random()*10);
	        	 if(x1<x2)
		 	        {int t=0;t=x1;x1=x2;x2=t;}
	        	arry[i]=x1+"/"+x2+"=";
	        	answer[i]=(x1/x2);
	        	
	        	yushu[i]="����Ϊ"+x1%x2;
				bw2.write(arry[i]);	
				bw2.newLine();
				
	        }}
	      bw2.write(("-------------��׼��--------------"));
	      bw2.newLine();
	     
	    
				
	 			
		         for (int i1 = 0; i1<n; i1++) {
					bw2.write((arry[i1]+answer[i1]+yushu[i1]));
					bw2.newLine();
					
					
		         }bw2.close();
	}
	
	
	        }
	 
	   
	
	

