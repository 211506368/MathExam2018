public class RandomOfMultiply extends RandomNumber {
	//���꼶�ĳ˷�
	//(A*B)Ӧ���ھžų˷�����
	// �� A��B��Ӧ��Ϊ��λ��
	public void createRandomAandB(Bean bean) {
		int randomA = 1 + random.nextInt(9);
		int randomB = 1 + random.nextInt(9);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
