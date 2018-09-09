import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class MathExam6313 {
	private static int len;//�����û��������Ŀ����

	public static void main(String[] args) {
		//�ж��û�����Ĳ����Ƿ����Ҫ��
		
		if(0 == args.length) {
			System.out.println("���г���ʱ������һ�����ִ���Ҫ���ɵ�������");
			return ;
		}else if(args.length > 1){
			System.out.println("ֻ��Ҫ����һ�����ֲ���");
			return ;
		}else {
			//ȥ���ַ�����ǰ��0
			String str = args[0].replaceFirst("^0*", "");
			//�����Ƿ�ȫΪ����
			Pattern pattern = Pattern.compile("[0-9]*");
		    boolean matches = pattern.matcher(str).matches(); 
		    if(matches && str.length() > 4) {
				System.out.println("�������ֹ������������У��������");
				return ;
		    }else if(matches) {
		    	len = Integer.parseInt(str);
		    }else {
				System.out.println("����Ĳ������������������������У�����һ��������");
				return ;
		    }
		}
		
		//��������StringBuffer�������������������Ŀ�ͱ�׼��
		StringBuffer topic = new StringBuffer();
		StringBuffer standAnswer = new StringBuffer();
		for(int i = 1; i <= len; i++) {
			//��ȡ�����������num1,num2��ʾ����������������; 
			int num1 = (int) (Math.random()*101);
			int num2 = (int) (Math.random()*101);
			//ȷ����һ�����ȵڶ������󣬱���������ָ�����Сѧһ�꼶�Ӽ��޸���
			if(num1 < num2) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			//symbol����������ţ��������Ϊ0�õ�  " + ",�����Ϊ1�õ�" - ";
			String symbol = (0 == ((int) (Math.random()*10))%2)? " + " : " - ";
			//������
			int res = (symbol.equals(" + ")) ? num1 + num2 :num1 - num2;
			//����Ŀ�ʹ𰸼�¼
			topic.append("(" + i + ") " + num1 + symbol + num2 + System.lineSeparator());
			standAnswer.append("(" + i + ") " + num1 + symbol + num2 + " = " + res + System.lineSeparator());
		}
		//д���ļ�
		try {
			write("out.txt",topic,standAnswer);
			System.out.println("Сѧһ�꼶��ѧ����Ŀ�����ɣ���鿴out.txt�ļ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param filename     ��Ҫд����ļ���
	 * @param topic        ��Ŀ
	 * @param standAnswer  ��׼��
	 * @throws IOException ���ļ������Ϸ�ʱ�׳��쳣
	 */
	private static void write(String filename,StringBuffer topic,StringBuffer standAnswer) throws IOException {
	    // ����1��ȷ��������ļ���Ŀ�ĵأ�
		// ���filename�а���·��������ȷ��·���Ѵ���
		  File file = new File(filename);
		  File parentFile = file.getParentFile();
		  if(parentFile!=null&&!parentFile.exists()) {
			  parentFile.mkdirs();
			  System.out.println("����Ŀ¼��" + parentFile);
		  }
		  file.createNewFile();
		// ����2������ָ���ļ��������
		  OutputStream out = new FileOutputStream(file);
		// ����3��д������
		  out.write(topic.toString().getBytes());
		  out.write(System.lineSeparator().getBytes());
		  out.write(standAnswer.toString().getBytes());
		  
	    // ����4���ر�
		  out.close();
	  }
}
