



import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MathExam6318 {

	public static void main(String[] args) throws Throwable {
		
		File file =new File("out.txt");
		if(!file.exists()){						//�����ļ�
			file.createNewFile();
           System.out.println("�ļ��������");
        }
		
		int n,i=1,grade;
		Scanner sc=new Scanner(System.in);
		System.out.println("����������Ҫ���ɵ��������꼶");
		n=sc.nextInt();
		grade=sc.nextInt();
		String [] as=new String[n+1];
		String [] bs=new String[n+1];	
		String [] cs=new String[n+1];	
		StringBuffer qs = null;
		StringBuffer rs = null;
		FileOutputStream in=new FileOutputStream(file);
		if(grade==1) {
		for(i=0;i<n;i++)
		{
		int a=(int)(Math.random()*100+1);
		int b=(int)(Math.random()*a+1);
		int c=(int)(Math.random()*2);
		if(c%2==0) {
			System.out.println("("+(i+1)+")"+a+"+"+b+"=");
			qs = new StringBuffer("("+(i+1)+")"+a+"+"+b+"=");
			rs = new StringBuffer(" "+(a+b));
			as[i]=("("+(i+1)+")"+a+"+"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			else {
			System.out.println("("+(i+1)+")"+a+"-"+b+"=");
			qs = new StringBuffer("("+(i+1)+")"+a+"-"+b+"=");
			rs = new StringBuffer(" "+(a-b));
			as[i]=("("+(i+1)+")"+a+"-"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			byte[] ba = as[i].getBytes();
			String ka ="\n\r";
			byte[] ra = ka.getBytes(); 
			in.write(ba);
			in.write(ra);	
		}
		
		String daan ="-------------��׼��--------------";
		byte[] pa = daan.getBytes();	
		String ka ="\n\r";
		byte[] ra = ka.getBytes(); 
		in.write(pa);	
		in.write(ra);
		System.out.println("-------------��׼��--------------");
		for(i=0;i<n;i++)
		{
			System.out.println(cs[i]);
			byte[] ta = cs[i].getBytes();
			in.write(ta);
			in.write(ra);
			
		}
				
				}
		else {
			for(i=0;i<n;i++)
			{
			int a=(int)(Math.random()*10+1);
			int b=(int)(Math.random()*10+1);
			int c=(int)(Math.random()*2);
			if(c%2==0) {
				System.out.println("("+(i+1)+")"+a+"x"+b+"=");
				qs = new StringBuffer("("+(i+1)+")"+a+"x"+b+"=");
				rs = new StringBuffer(" "+(a*b));
				as[i]=("("+(i+1)+")"+a+"x"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
				}
			else {
				if(a%b==0) {
				System.out.println("("+(i+1)+")"+a+"��"+b+"=");
				qs = new StringBuffer("("+(i+1)+")"+a+"��"+b+"=");
				rs = new StringBuffer(" "+(a/b));
				as[i]=("("+(i+1)+")"+a+"��"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
				
				}
				else {
				System.out.println("("+(i+1)+")"+a+"��"+b+"=");
				qs = new StringBuffer("("+(i+1)+")"+a+"��"+b+"=");
				rs = new StringBuffer(" "+(a/b)+"..."+a%b);
				as[i]=("("+(i+1)+")"+a+"��"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
					}
				
				
				}
				
				byte[] ba = as[i].getBytes();
				String ka ="\n\r";
				byte[] ra = ka.getBytes(); 
				
				in.write(ba);
				in.write(ra);	
			}
			String daan ="-------------��׼��--------------";
			byte[] pa = daan.getBytes();	
			String ka ="\n\r";
			byte[] ra = ka.getBytes(); 
			in.write(pa);
			in.write(ra);
		
		System.out.println("-------------��׼��--------------");
		for(i=0;i<n;i++)
		{
			System.out.println(cs[i]);
			byte[] ta = cs[i].getBytes();
			in.write(ta);
			in.write(ra);
			
		}
			}
		
															}
}
		
		
		
		

