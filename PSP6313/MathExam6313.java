import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class MathExam6313 {
	
	//��������StringBuffer�������������������Ŀ�ͱ�׼��
	private static StringBuffer topic = new StringBuffer();
	private static StringBuffer standAnswer = new StringBuffer();
	
	//����4���������
	private static String[] Operator = { " + ", " - ", " * ", " / " };

	public static void main(String[] args) {
		// �ж��û�����Ĳ����Ƿ����Ҫ��

		if(judgmentParameter(args)){
			// �����û��������Ŀ����
			int len = Integer.parseInt(args[0]);
			//�����꼶��Ĭ��1�꼶
			int grade = 1;
			if(2 == args.length) {
				 grade = Integer.parseInt(args[1]);
			}
			//������Ŀ
			generatingTopic(len,grade);
			// д���ļ�
			try {
				write313("out.txt");
				System.out.println("Сѧ" + grade + "�꼶��ѧ����Ŀ�����ɣ���鿴out.txt�ļ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * ���ã�������Ŀ
	 * @param len �û�Ҫ�����ɵ���Ŀ����
	 * @param grade �꼶
	 */
	private static void generatingTopic(int len,int grade) {
		for (int i = 1; i <= len; i++) {
			// ��ȡ�����������num1,num2��ʾ����������������;
			int num1 = (int) (Math.random() * 101);
			int num2 = (int) (Math.random() * 101);
			
			// symbol�����������;
			int index = (1 == grade) ? ((int) (Math.random() * 10)) % 2 : ((int) (Math.random() * 10)) % 4;
			String symbol = Operator[index];
			
			//ȷ��Сѧ1�꼶�ӷ����ᳬ��100
			while(1 == grade && 0 == index && num1 + num2 >= 100) {
				num1 = (int) (Math.random() * 101);
				num2 = (int) (Math.random() * 101);
			}
			// ������
			int res = 0;
			int remainder = 0; // ����
			switch (symbol) {
			case " + ":
				res = num1 + num2;
				break;
			case " - ":
				// ȷ����һ�����ȵڶ������󣬱���������ָ�����Сѧ�Ӽ��޸���
				if (num1 < num2) {
					int temp = num1;
					num1 = num2;
					num2 = temp;
				}
				res = num1 - num2;
				break;
			case " * ":
				res = num1 * num2;
				break;
			case " / ":
				//��ֹ����Ϊ0
				while(0 == num2) {
					num2 = (int) (Math.random() * 101);
				}
				res = num1 / num2;
				remainder = num1 % num2;
				break;
			}
			// ����Ŀ�ʹ𰸼�¼
			topic.append("(" + i + ") " + num1 + symbol + num2 + System.lineSeparator());
			if (symbol.equals(" / ")) {
				standAnswer.append("(" + i + ") " + num1 + symbol + num2 + " = " + res
						+ (remainder != 0 ? ("..." + remainder) : "") + System.lineSeparator());
			} else {
				standAnswer.append("(" + i + ") " + num1 + symbol + num2 + " = " + res + System.lineSeparator());
			}
		}
	}

	
	/**
	 * ���ã��ж��û�����Ĳ����Ƿ�Ϸ�
	 * @param args �û�����Ĳ���
	 * @return     ������Ҫ��ʱ���� true�����򷵻�false
	 */
	private static boolean judgmentParameter(String[] args) {
		if (0 == args.length) {
			System.out.println("���г���ʱ�������������ִ���Ҫ���ɵ��������꼶��");
			return false;
		} else if (args.length > 2) {
			System.out.println("����������������ֲ�������һ��������Ŀ�������ڶ��������꼶");
			return false;
		} else {

			//ȥ����һ��������ǰ��0
			String str1 = args[0].replaceFirst("^0*", "");
			// �����һ�������Ƿ�������
			Pattern pattern = Pattern.compile("[0-9]*");
			boolean matches = pattern.matcher(str1).matches();

			if (matches && str1.length() > 4) {
				System.out.println("��һ���������ֹ������������У��������");
				return false;
			} else if (!matches) {
				System.out.println("����ĵ�һ���������������������������У�����һ��������");
				return false;
			}

			if (2 == args.length) {
				//ȥ���ڶ�����������ǰ��0
				String str2 = args[1].replaceFirst("^0*", "");
				// �����һ�������Ƿ���1��2
				Pattern compile = Pattern.compile("[1-2]?");
				boolean matches2 = compile.matcher(str2).matches();
				
				if (!matches2) {
					System.out.println("����ĵڶ�����������1��2�����������У��ڶ�����������1��2");
					return false;
				}
			}
		}
		return true;
	}

	
	/**
	 * ���ã������ɵ���Ŀ�ͺʹ�д��ָ���ļ�
	 * @param filename       ��Ҫд����ļ���
	 * @throws IOException   ���ļ������Ϸ�ʱ�׳��쳣
	 */
	private static void write313(String filename) throws IOException {
		// ����1��ȷ��������ļ���Ŀ�ĵأ�
		// ���filename�а���·��������ȷ��·���Ѵ���
		File file = new File(filename);
		File parentFile = file.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
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