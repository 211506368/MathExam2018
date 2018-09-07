import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MathExam7246 {
	
	final static int GRADE1MAX = 20;
	final static int GRADE2MAX = 100;
	static int number1, number2, number3;// �����������Լ�������
	static int fuhao;// 0,1,2,3�ֱ��Ӧ�ӡ������ˡ���
	static int num;
	static String[] strArrayQ;// ��Ŵ�д��txt�ļ�����Ŀ
	static String[] strArrayA;// ��Ŵ�д��txt�ļ��Ĵ�
	final static String FILENAME = "out.txt";
	
	public static void main(String args[]) throws IOException {
		if (args.length == 1 || args.length ==2) {
			// ���������������
			try {
				num = Integer.parseInt(args[0]);
				if (num < 0) {
					System.out.println("��Ŀ����Ϊ�������������У�");
				}else if (num == 0) {
					System.out.println("��������ʵ���Ŀ������");
				}
			} catch(NumberFormatException e) {
				System.out.println("��Ŀ����ѡ������������������У�");
			}
		}else {
			System.out.println("���������������������У�");
			System.exit(0);
		}
		strArrayQ = new String[num];
		strArrayA = new String[num];
		grade1();
		createTxt();
		writeToTxt();
	}
	
	private static void grade1() {
		// һ�꼶
		int result = 0;
		for(int i = 1; i <= num; i++) {
			number1 = (int)(Math.random()*(GRADE1MAX+1));
			fuhao = (int)(Math.random()*2);// ���Ž�Ϊ�ӡ���
			if(fuhao == 0) {
				number2 = (int)(Math.random()*(GRADE1MAX+1));
				result = number1 + number2;
				// ��¼��Ŀ�ʹ�
				strArrayQ[i-1] = "(" + i + ") " + number1 + " + " + number2 + " =";
				strArrayA[i-1] = "(" + i + ") " + number1 + " + " + number2 + " = " + result;
			}else if(fuhao ==1) {
				do {
					number2 = (int)(Math.random()*(GRADE1MAX+1));
				}while(number2 > number1);
				result = number1 - number2;
				// ��¼��Ŀ�ʹ�
				strArrayQ[i-1] = "(" + i + ") " + number1 + " - " + number2 + " =";
				strArrayA[i-1] = "(" + i + ") " + number1 + " - " + number2 + " = " + result;
			}
		}
	}
	
	private static void createTxt() throws IOException {
		// �����ļ���Ĭ��λ��
		File file = new File(FILENAME);
		file.createNewFile();
	}
	
	private static void writeToTxt() {
		// ��txt�ļ���д������
		File file = new File(FILENAME);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			// ����д������
			for (int i = 0; i < num; i++) {
				fw.write(strArrayQ[i]);
				fw.write("\r\n");
			}
			fw.write("--------------��׼��--------------");
			fw.write("\r\n");
			for (int i = 0; i < num; i++) {
				fw.write(strArrayA[i]);
				fw.write("\r\n");
			}
			fw.write("     " + txtFoot());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static String txtFoot() {
		// �Ų���Ϣ����
		SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		String timeStr = df.format(new Date());
		return "211617246 �ſ�� " + timeStr;
	}
}
