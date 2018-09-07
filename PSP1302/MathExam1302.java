

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class MathExam1302 {
	static Bean bean = new Bean();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String number = input.next();
		String grade = input.next();
		input.close();
		bean.setQuizNumber(number);// ���ó�����
		bean.setGrade(grade); //�����꼶��

		for (int n = 0; n < bean.getQuizNumber(); n++) {
			getSymbol(); // �����������
			RandomNumber ran = RandomNumberFactory.createRan(bean.getSymbol());
			ran.createRandomAandB(bean);
			Operation oper = OperationFactory.createOperate(bean);
			oper.calculate();
			bean.setText();
		}
		bean.setTxt();
		createMathExamTxt();
	}


	private static void getSymbol() {
		Random ran = new Random();
		switch (bean.getGrade()) {
		case 1:
			// �������true��false����true��Ϊ��+������false��Ϊ��-��
			if (ran.nextBoolean()) {
				bean.setSymbol("+");
			} else {
				bean.setSymbol("-");
			}
			break;
		case 2:
			// �������true��false����true��Ϊ��*������false��Ϊ��/��
			if (ran.nextBoolean()) {
				bean.setSymbol("*");
			} else {
				bean.setSymbol("/");
			}
			break;
		}
	}
	
	private static void createMathExamTxt() {
		try {
			FileOutputStream fos = new FileOutputStream("out.txt");
			PrintStream ps = new PrintStream(fos);
			ps.println(bean.getTxt());
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	//���Լ�������Ƿ�����
	@SuppressWarnings("unused")
	private static void checkNumberCorrection() {
		if(bean.getSymbol()=="/"){
			if(bean.getNumberA()<bean.getNumberB()){
				System.out.println("ERROR");
				System.exit(0);
			}
		}
		
	}

}
