import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author ������
 * ���������й���MathExam���Զ�����һ��Сѧһ�꼶����ѧ�Ӽ������⡣
 */

public class MathExam6317 {
	public static void main(String[] args) throws IOException {

		//ȷ��������ļ�
		File file = new File("out.txt");
		//����ָ���ļ������������
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		
//		@SuppressWarnings("resource")
//		Scanner input = new Scanner(System.in);
//		System.out.println("Сѧһ�꼶��ѧ�Ӽ�������");
//		System.out.println("��������Ŀ������");
		
		//��ȡ����̨������Ŀ����n����ʽΪString
//		String args[0] = input.nextLine();
		
		//ѭ���жϣ�������Ƿ���һ��������
//		while(true) {
//			if(!(args[0].matches("\\d+"))) {
//				System.out.println("����1.����������������������һ��1~1000��������");
//				args[0] = input.nextLine();	
//			}
//			else {
//				break;
//			}
//		}
//		//��n��String����ת��Ϊint����
//		int n = Integer.parseInt(args[0]);
//		
//		//ѭ���жϣ���n�ķ�Χ����1~1000ʱ������ѭ�����������»�ȡ����̨����
//		while(true) {
//			if(n>0 && n<=1000) {
//				break;
//			}
//			else {
//				System.out.println("����2.����������������������һ��1~1000��������");
//				args[0] = input.nextLine();
//			}
//			n = Integer.parseInt(args[0]);
//		}
		
		while(true) {
			if(!(args[0].matches("\\d+"))) {
				return;
			}
			else if(Integer.parseInt(args[0])>0 && Integer.parseInt(args[0])<=1000) {
				break;
			}
			else {
				return;
			}
		}
		
		//������Ŀ
		for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
			//�������������
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			//�����������Ŀ
			if(num1 > num2) {
				//���ɼ���
				if(num2 >= 10)
					num2 = num2%10*10;
				System.out.println("("+ i +") " + num1 +" - "+ num2 );
				String str = ("("+ i +") " + num1 +" - "+ num2 + " = " + (num1-num2));
				//д������
				out.writeUTF(str);
//				System.out.println(str);
			}	
			else {
				//���ɼӷ�
				if(num2 >= 10)
					num2 = num2%10*10;
				System.out.println("("+ i +") " + num1 +" + "+ num2 );
				String str = ("("+ i +") " + num1 +" + "+ num2 + " = " + (num1+num2));
				//д������
				out.writeUTF(str);
//				System.out.println(str);
			}
		}
		out.close();
		
		System.out.println();
		
		//����ָ���ļ�������������
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		//������   �����Ŀ�ʹ�
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			System.out.println(in.readUTF());
		}
		in.close();
		
	}//main
}