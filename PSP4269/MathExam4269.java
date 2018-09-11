import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MathExam4269 {
	static int a;
	static int b;
	static int sym;

	public static boolean check() {
		a = (int) (0 + Math.random() * (100 - 0 + 1));
		b = (int) (0 + Math.random() * (100 - 0 + 1));
		sym = (int) (1 + Math.random() * (2 - 1 + 1));
		if (sym == 1) {
			if ((a + b) > 100) {
				return false;
			} else {
				return true;
			}
		} else {
			if ((a - b) < 0) {
				return false;
			} else {
				return true;
			}

		}

	}

	public static boolean isNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void math(int n) {
		String prob;
		String ans;
		ArrayList<String> probs = new ArrayList<String>();
		ArrayList<String> anss = new ArrayList<String>();
		boolean end = false;
		for (int i = 1; i <= n; i++) {
			do {
				end = check();
			} while (!end);

			if (sym == 1) {
				prob = "(" + i + ")" + " " + a + " " + "+" + " " + b;
				ans = "(" + i + ")" + " " + a + " " + "+" + " " + b + " " + "=" + " " + (a + b);
			} else {
				prob = "(" + i + ")" + " " + a + " " + "-" + " " + b;
				ans = "(" + i + ")" + " " + a + " " + "-" + " " + b + " " + "=" + " " + (a - b);
			}
			probs.add(prob);
			anss.add(ans);

		}

		File file = new File("out.txt");
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("�ļ�����ʧ��,������");
				e.printStackTrace();
			}
		}
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] data;
			for (String str : probs) {
				str += "\r\n";
				data = str.getBytes();
				try {
					out.write(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("д�����!");
					e.printStackTrace();
				}
			}
			String fg = "-----------------��׼��-----------------" + "\r\n";
			data = fg.getBytes();
			try {
				out.write(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("д�����!");
				e.printStackTrace();
			}
			for (String str : anss) {
				str += "\r\n";
				data = str.getBytes();
				try {
					out.write(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("д�����!");
					e.printStackTrace();
				}
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("io����");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�Ҳ����ļ�,������");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("����Ĳ���������Ϊ1,������");
		}else {
			String str = args[0];
			if (isNum(str)) {
				if (str.length() >= 5) {
					System.out.println("�������ݹ���,������");
				} else {
					math(Integer.parseInt(str));
				}
			} else {
				System.out.println("��������,����������");
			}
		}
	}
}
