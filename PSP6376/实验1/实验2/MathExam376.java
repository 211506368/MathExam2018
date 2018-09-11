import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class MathExam376 {
	private static int leng;
	private static int Grade = 1;
	private static String[] Operator = { " + ", " * "," - ", " / " };

	public static void main(String[] args) {
		

		if (0 == args.length) {
			System.out.println("���г���ʱ������Ҫ���ɵ����������֡�");
			return;
		} else if (args.length > 2) {
			System.out.println("�������������ֲ�������һ������Ŀ�������ڶ������꼶");
			return;
		} else {

			Pattern pattern = Pattern.compile("[0-9]*");
			boolean matches = pattern.matcher(args[0]).matches();

			if (matches && args[0].length() > 4) {
				System.out.println("��һ���������ֹ�������������");
				return;
			} else if (matches) {
				leng = Integer.parseInt(args[0]);
			} else {
				System.out.println("����ĵ�һ����������������������������");
				return;
			}

			if (2 == args.length) {
				Pattern compile = Pattern.compile("[1-2]?");
				boolean matches2 = compile.matcher(args[1]).matches();
				if (!matches2) {
					System.out.println("����ĵڶ�����������1��2������������");
					return;
				} else {
					Grade = Integer.parseInt(args[1]);
				}
			}
		}

		StringBuffer top = new StringBuffer();
		StringBuffer answer = new StringBuffer();
		for (int i = 1; i <= leng; i++) {
			int n1 = (int) (Math.random() * 101);
			int n2 = (int) (Math.random() * 101);
			if (n1 < n2) {
				int t = n1;
				n1 = n2;
				n2 = t;
			}
			int index = (1 == Grade) ? ((int) (Math.random() * 10)) % 2 : ((int) (Math.random() * 10)) % 4;
			String sym = Operator[index];
			int r = 0;
			int remainder = 0; 
			switch (sym) {
			case " + ":
				r = n1 + n2;
				break;
			case " * ":
				r = n1 * n2;
				break;

			case " - ":
				r = n1 - n2;
				break;

			case " / ":
				r = n1 / n2;
				break;
				
			}
			top.append("(" + i + ") " + n1 + sym + n2 + System.lineSeparator());
			if (sym.equals(" / ")) {
				answer.append("(" + i + ") " + n1 + sym + n2 + " = " + r
						+ (remainder != 0 ? ("..." + remainder) : "") + System.lineSeparator());
			} else {
				answer.append("(" + i + ") " + n1 + sym + n2 + " = " + r + System.lineSeparator());
			}
		}
		try {
			write313("out.txt", top, answer);
			System.out.println("��ѧ����Ŀ�����ɣ���鿴�ļ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void write313(String filengame, StringBuffer top, StringBuffer answer) throws IOException {

		File file = new File(filengame);
		File parentFile = file.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
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