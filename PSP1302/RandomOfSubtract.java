public class RandomOfSubtract extends RandomNumber {
	// ����һ�꼶�����������Ŀ A-B
	// AӦ�ô���B
	public void createRandomAandB(Bean bean) {
		// Ϊ����B��ȡֵ����A��ȡֵ��Χ���ó� [5-9] �� [10 20 30 ....90]
		int randomA = 0;
		//�� trueʱ������ [5-9], falseʱ������ [10 20 30 ....90]
		if (random.nextBoolean()) {
			randomA = random.nextInt(5) + 5;
		} else {
			randomA = 10 * (random.nextInt(9) + 1);
		}
		// AӦ�ô��ڵ���B
		int randomB = random.nextInt(randomA + 1);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
