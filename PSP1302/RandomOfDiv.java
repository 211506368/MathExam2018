public class RandomOfDiv extends RandomNumber {
	//���꼶�ĳ�����
	// A��BӦΪһλ����������λ
	// AӦ�ô��ڵ���B
	// A/B��ֵ���������
	
	public void createRandomAandB(Bean bean) {
		//��A��ȡֵ��Χ����Ϊ3��99
		int randomA = 3 + random.nextInt(97);
		int randomB= 0;
		//��B��ȡֵ��Χ����Ϊ2��randomA
		randomB = 2+ random.nextInt(randomA+1-2);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
