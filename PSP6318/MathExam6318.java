



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MathExam6318 {

	public static void main(String[] args) throws Throwable {
		
		File file =new File("out.txt");
		if(!file.exists()){						//�����ļ�
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("�ļ�����ʧ�ܣ�");
				e.printStackTrace();
			}
		}
		Scanner sc=new Scanner(System.in);
		for(;;)								 {
        int flag=4;
		int []n =new int [args.length] ;
		n[0]=Integer.parseInt(args[0]);
		n[1]=Integer.parseInt(args[1]);
	    	if(args[0].length()>5 && Integer.parseInt(args[0])>100) {
	    		System.out.print(" �������Ŀ��̫��");					//������������
				flag=0; }												  
			if(Integer.parseInt(args[1])>2){
				System.out.print(" ������꼶��̫��");					//�����꼶������													 
				flag=1; }									  
	    	if(n[0]<=0 && !args[0].matches("\\d*")) {
	    		System.out.print(" �������Ŀ�����ԣ�ӦΪ������");			//��������Ϊ������
	    		flag=2;
	    				}
	    	if(n[1]<=0 && !args[1].matches("\\d*")) {
	    		System.out.print(" ������꼶�����ԣ�ӦΪ������");			//�����꼶��Ϊ������
	    		flag=3;
	    				}
	    	if(flag!=4) {System.out.println("\n"+"��������Ŀ�����꼶");	args[0]=sc.next();args[1]=sc.next();continue;}//�������������������� ��������� ֱ����ȷΪֹ
		int i=1;
		
		//System.out.println("����������Ҫ���ɵ��������꼶");
		String [] as=new String[n[0]+1];
		String [] bs=new String[n[0]+1];	
		String [] cs=new String[n[0]+1];	
		StringBuffer qs = null;
		StringBuffer rs = null;
		FileOutputStream in=new FileOutputStream(file);
		if(n[1]==1) {
		for(i=0;i<n[0];i++)
		{													
		int a=(int)(Math.random()*100+1);
		int b=(int)(Math.random()*100+1);
		int c=(int)(Math.random()*2);
		while(a+b>=100 && c%2==0) {						//�޶��ӷ�����Ͳ��ᳬ��100
			 a=(int)(Math.random()*100+1);
			 b=(int)(Math.random()*100+1);
		}
		if(c%2==0) {
			System.out.println("("+(i+1)+")"+a+"+"+b+"=");			//�ӷ�����
			qs = new StringBuffer("("+(i+1)+")"+a+"+"+b+"=");	
			rs = new StringBuffer(" "+(a+b));
			as[i]=("("+(i+1)+")"+a+"+"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			else {
				while(a-b<0 && c%2!=0) {						//�޶�����������С��0
					 a=(int)(Math.random()*100+1);
					 b=(int)(Math.random()*a+1);
				}	
			System.out.println("("+(i+1)+")"+a+"-"+b+"=");			//��������
			qs = new StringBuffer("("+(i+1)+")"+a+"-"+b+"=");
			rs = new StringBuffer(" "+(a-b));
			as[i]=("("+(i+1)+")"+a+"-"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			byte[] ba = as[i].getBytes();
			String ka ="\r\n";
			byte[] ra = ka.getBytes(); 
			in.write(ba);
			in.write(ra);	
		}
		
		String daan ="-------------��׼��--------------";
		byte[] pa = daan.getBytes();									//д�롰��׼�𰸡�
		String ka ="\r\n";
		byte[] ra = ka.getBytes(); 
		in.write(pa);	
		in.write(ra);
		System.out.println("-------------��׼��--------------");
		for(i=0;i<n[0];i++)
		{																//����𰸲�д���ı�
			System.out.println(cs[i]);
			byte[] ta = cs[i].getBytes();
			in.write(ta);
			in.write(ra);
			
		}
				
				}
		else {
			for(i=0;i<n[0];i++)								
			{
			int a=(int)(Math.random()*10+1);									
			int b=(int)(Math.random()*10+1);						//��֤������Ϊ0
			int c=(int)(Math.random()*2);
			if(c%2==0) {
				System.out.println("("+(i+1)+")"+a+"x"+b+"=");				//�˷�����
				qs = new StringBuffer("("+(i+1)+")"+a+"x"+b+"=");
				rs = new StringBuffer(" "+(a*b));
				as[i]=("("+(i+1)+")"+a+"x"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
				}
			else {
				if(a%b==0) {
				System.out.println("("+(i+1)+")"+a+"��"+b+"=");				//�������㣨��������
				qs = new StringBuffer("("+(i+1)+")"+a+"��"+b+"=");			
				rs = new StringBuffer(" "+(a/b));
				as[i]=("("+(i+1)+")"+a+"��"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
				
				}
				else {
				System.out.println("("+(i+1)+")"+a+"��"+b+"=");			//�������㣨��������
				qs = new StringBuffer("("+(i+1)+")"+a+"��"+b+"=");
				rs = new StringBuffer(" "+(a/b)+"..."+a%b);
				as[i]=("("+(i+1)+")"+a+"��"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
					}
				
				
				}
				
				byte[] ba = as[i].getBytes();							//д����Ŀ���������
				String ka ="\r\n";
				byte[] ra = ka.getBytes(); 
				in.write(ba);
				in.write(ra);	
			}
			String daan ="-------------��׼��--------------";
			byte[] pa = daan.getBytes();							//д�롰��׼�𰸡�
			String ka ="\r\n";
			byte[] ra = ka.getBytes(); 
			in.write(pa);
			in.write(ra);
		
		System.out.println("-------------��׼��--------------");
		for(i=0;i<n[0];i++)
		{															//����𰸲�д����Ŀ+��
			System.out.println(cs[i]);
			byte[] ta = cs[i].getBytes();
			in.write(ta);
			in.write(ra);
			
		}
		     }
		System.out.println("��ѡ����������˳����˳��Ļ�����0�������Ļ�����1");
			int gg=sc.nextInt(); 
			while(gg!=0&&gg!=1){
				System.out.println("����������������޷�ƥ����Ӧ���ܣ���ѡ����������˳����˳��Ļ�����0�������Ļ�����1");      //��ѡ����������ֲ���0��1��һֱѭ������ȷΪֹ
				gg=sc.nextInt(); 
			}	 
			if(gg==0) {System.out.println("ллʹ��");break;}														//ѭ��������Ŀ+�𰸣�����ѡ��Ŀ�����꼶��
			else if(gg==1){
				System.out.println("��������Ŀ�����꼶");	//�µ���Ŀ�����꼶
				int []p =new int [args.length] ;
				args[0]=sc.next();args[1]=sc.next();	
				flag=4;
				for(;;) {		
					if(args[0].length()>5 &&Integer.parseInt(args[0])>10000) {
		    		System.out.print("�������Ŀ��̫��");					//������������
					flag=0;}
				if(p[1]>2){
					System.out.print("������꼶��̫��");					//�����꼶������													 
					flag=1;}									  
		    	if(Integer.parseInt(args[0])<=0 && !args[0].matches("\\d*")) {
		    		System.out.print("�������Ŀ�����ԣ�ӦΪ������");			//��������Ϊ������
		    		flag=2;}
		    	if(Integer.parseInt(args[1])<=0 && !args[1].matches("\\d*")) {
		    		System.out.print("������꼶�����ԣ�ӦΪ������");			//�����꼶��Ϊ������
		    		flag=3;}
		    	if(flag!=4) {
		    		System.out.println("\n"+"��������Ŀ�����꼶");	args[0]=sc.next();args[1]=sc.next();break;}	//�������������������� ��������� ֱ����ȷΪֹ	
		    		}continue;
			
							}
											}
														}					
				}
		
		
		
		

