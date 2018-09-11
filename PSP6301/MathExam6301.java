
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
	
public class MathExam6301 {
		//����
		public static void operation(int n){
			File file = new File("out.txt");
			OutputStream out;
			try {
				out = new FileOutputStream(file);
				int[] an= new int[n];
				String random = "";
				String[] Symbol= {"+","-"};
					for(int i=0;i<n;i++) {
						int index = (int)(Math.random()*(Symbol.length));
						random = Symbol[index];   //�������Symbol1�е�Ԫ��
						if(random.equals("+")) {
							int a = (int)(Math.random()*(50+1)); //���ѡ��0~50֮�����
							int b = (int)(Math.random()*(50+1));
							an[i]=a+b;
							String output = "("+(i+1)+") "+a+" + "+b+" = "+"\n";
							out.write(output.getBytes());
				
						}
					
						else{
							int a = (int)(Math.random()*(100+1));
							int b = (int)(Math.random()*a);
							an[i]=a-b;
							String output = "("+(i+1)+") "+a+" - "+b+" = "+"\n";
							out.write(output.getBytes());
				
							}
					}
					String flag = "\n";
					out.write(flag.getBytes());
					//�����
					Scanner in = new Scanner(file);
					int j=0;
					while(in.hasNextLine()&&j!=n) {
						String s = in.nextLine()+an[j]+"\n";
						out.write(s.getBytes());
						j++;
					}
					//ʱ��
					Date date = new Date();
					String time = "yyyy��MM�� dd��  HH:mm";
					SimpleDateFormat sdf = new SimpleDateFormat(time);
					String now = "			211606301   ������    "+sdf.format(date)+"\n";
					out.write(now.getBytes());
					out.close();
				} catch (IOException e) {
					System.out.println("���쳣");
				}	
		}	
		public static void main(String[] args){
			int [] num = new int[args.length];
				num[0]=Integer.parseInt(args[0]); //����һ��������Stringת��ΪInt
				operation(num[0]);		
			}	
		}