
	 import java.io.File;
	 import java.io.FileOutputStream;
	 import java.io.IOException;
	 import java.io.OutputStream;
	 import java.util.regex.Pattern;

	 public class MathExam6373 {
	 	private static int leng;

	 	public static void main(String[] args) {
	 		
	 		
	 		if(0 == args.length) {
	 			System.out.println("������Ҫ���ɵ����������֡�");
	 			return ;
	 		}else if(args.length > 1){
	 			System.out.println("ֻ����һ�����ֲ���");
	 			return ;
	 		}else {
	 			Pattern pattern = Pattern.compile("[0-9]*");
	 		    boolean matches = pattern.matcher(args[0]).matches(); 
	 		    if(matches && args[0].length() > 4) {
	 				System.out.println("�������ֹ�������������");
	 				return ;
	 		    }else if(matches) {
	 		    	leng = Integer.parseInt(args[0]);
	 		    }else {
	 				System.out.println("����Ĳ�������������������������");
	 				return ;
	 		    }
	 		}
	 		
	 		
	 		StringBuffer top = new StringBuffer();
	 		StringBuffer answer = new StringBuffer();
	 		for(int i = 1; i <= leng; i++) {
	 			int n1 = (int) (Math.random()*101);
	 			int n2 = (int) (Math.random()*101);
	 			if(n1 < n2) {
	 				int t = n1;
	 				n1 = n2;
	 				n2 = t;
	 			}
	 			String sym = (0 == ((int) (Math.random()*10))%2)? " + " : " - ";	
	 			int res = (sym.equals(" + ")) ? n1 + n2 :n1 - n2;
	 			top.append("(" + i + ") " + n1 + sym + n2 + System.lineSeparator());
	 			answer.append("(" + i + ") " + n1 + sym + n2 + " = " + res + System.lineSeparator());
	 		}
	 		
	 		try {
	 			write("out.txt",top,answer);
	 			System.out.println("��ѧ����Ŀ�����ɣ���鿴�ļ�");
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	 	}
	 	
	 	private static void write(String filengame,StringBuffer top,StringBuffer answer) throws IOException {
	 	    
	 		
	 		  File file = new File(filengame);
	 		  File parentFile = file.getParentFile();
	 		  if(parentFile!=null&&!parentFile.exists()) {
	 			  parentFile.mkdirs();
	 			  System.out.println("����Ŀ¼��" + parentFile);
	 		  }
	 		  file.createNewFile();
	 		  OutputStream out = new FileOutputStream(file);
	 		  out.write(top.toString().getBytes());
	 		  out.write(System.lineSeparator().getBytes());
	 		  out.write(answer.toString().getBytes());
	 		  out.close();
	 	  }
	 
	 		
	 }


