public class RandomOfMultiply extends RandomNumber {
	//���꼶�ĳ˷�
	//(A*B)��ֵӦ��С��100��A��B��ӦΪһλ��������λ��	
	public void createRandomAandB(Bean bean) {
		//Ϊʹ���ɵ���Ŀ���ӽ����꼶�ĳ˳��⣬�ʽ�A��ȡֵ��Χ����Ϊ 5��30
		int randomA = 5 + random.nextInt(26);
		// B��ȡֵ��ΧΪ 1�� (100/A)
		int randomB = 1 + random.nextInt((100/randomA)+1-1);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
