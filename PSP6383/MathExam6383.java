import java.io.IOException;
import java.io.PrintWriter;

public class MathExam {
	//�ж��Ƿ�Ϊ������
	public static boolean isNum(String str){ 
		   for(int i=0;i<str.length();i++){ 
		      int chr=str.charAt(i); 
		      if(chr<48 || chr>57) 
		         return false; 
		   } 
		   return true; 
		}
	//ȡһ�������
	public static int GetRandomNum(){
		//(��������)(��Сֵ+Math.random()*(���ֵ-��Сֵ+1))
		return (int)(0+Math.random()*(100-0+1));
	}
	//������Ŀ(����꼶����)
	
	public static void GetQuestion(int num,int Grade) {
		if(Grade==1) {
			String TempQuestion="";
			String TempAnswer="";
			for(int i=0;i<num;i++) {
				int Temp=GetRandomNum();
				int Temp2;
				if(GetRandomNum()>49) {
					Temp2=(int)(0+Math.random()*((100-Temp)-0+1));
					TempQuestion=TempQuestion+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" + "+String.valueOf(Temp2)+" ="+"\r\n";
					TempAnswer=TempAnswer+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" + "+String.valueOf(Temp2)+" = "+String.valueOf(Temp+Temp2)+"\r\n";
				}else {
					Temp2=(int)(0+Math.random()*(Temp-0+1));
					TempQuestion=TempQuestion+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" - "+String.valueOf(Temp2)+" ="+"\r\n";
					TempAnswer=TempAnswer+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" - "+String.valueOf(Temp2)+" = "+String.valueOf(Temp-Temp2)+"\r\n";
				}			
			}
			System.out.println(TempQuestion+"\r\n"+TempAnswer);
			OutAnswer(TempQuestion+"\r\n"+TempAnswer);
		}else {
			String Question="";
			String Answer="";
			for(int j=0;j<num;j++) {
				int Ismul=GetRandomNum();
				int mul1=(int)(0+Math.random()*(10-0+1));
				if(Ismul>49) {
					int mul2=(int)(0+Math.random()*(10-0+1));
					Question=Question+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" �� "+String.valueOf(mul2)+" ="+"\r\n";
					Answer=Answer+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" �� "+String.valueOf(mul2)+" = "+String.valueOf(mul1*mul2)+"\r\n";
				}else {
					int roo;
					//���ݷ�Χ��Ҫע��
					int mul2=(int)(1+Math.random()*(mul1-1+1));
					roo=mul1%mul2;
					if(roo==0) {
						Question=Question+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" �� "+String.valueOf(mul2)+" ="+"\r\n";
						Answer=Answer+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" �� "+String.valueOf(mul2)+" = "+String.valueOf(mul1/mul2)+"\r\n";	
					}else {
						Question=Question+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" �� "+String.valueOf(mul2)+" ="+"\r\n";
						Answer=Answer+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" �� "+String.valueOf(mul2)+" = "+String.valueOf((int)mul1/mul2)+"..."+String.valueOf(roo)+"\r\n";
					}

					
				}
			}
			System.out.println(Question+"\r\n"+Answer);
			OutAnswer(Question+"\r\n"+Answer);
			
		}

	}
	//����ļ�
	//���±�����Ҫ/r/n�ſ��Ի���
	public static void OutAnswer(String str) {
		try {
			PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
			writer.println(str);
			writer.close();
		} catch ( IOException e ) {
            e.printStackTrace();
		}

	}
	//������
	public static void main(String[] args) {
		String Path;
		String Grade;
		int n=0;
		//System.out.println("GetPath:"+args.length);
		//�ж������в�������
		if(args.length!=2) {
			System.out.println("Error:001");
			return;
		}
		Path=args[0];
		Grade=args[1];
		//�ж���Ŀ�����Ƿ�Ϊ������
		if(!isNum(Path)){
			System.out.println("Error:002");
			return;		
		}
		//�ж��꼶�Ƿ���ȷ
		if(Integer.valueOf(Grade)!=1 && Integer.valueOf(Grade)!=2)
		{
			System.out.println("Error:003");
			return;		
		}
		n=Integer.valueOf(Path);
		//�ж���������Ƿ�Ϊ0
		if(n==0){
			System.out.println("Error:004");
			return;	
		}
		GetQuestion(n,Integer.valueOf(Grade));
	}

}
