package kopo24_0419_7Gang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SWC07P35_ReportSheet {
	
	static ArrayList<SWC07P35_OneRec> k24_ArrayOneRec = new ArrayList<SWC07P35_OneRec>();

	// ���� ����
	static int k24_sum_kor = 0; // ���� ��
	static int k24_sum_eng = 0; // ���� ��
	static int k24_sum_mat = 0; // ���� ��
	static int k24_sum_sum = 0; // �հ��� ��(?)
	static double k24_sum_ave = 0; // ����� ��
	
	// ���� ���
	static double k24_sum_kor_ave = 0; // ���� ���
	static double k24_sum_eng_ave = 0; // ���� ���
	static double k24_sum_mat_ave = 0; // ���� ���
	static double k24_sum_sum_ave = 0; // �հ��� ���
	static double k24_sum_ave_ave = 0; // ����� ���(?)
	
	// �������� ��
	static int k24_page_sum_kor = 0; // ���� ��
	static int k24_page_sum_eng = 0; // ���� ��
	static int k24_page_sum_mat = 0; // ���� ��
	static int k24_page_sum_sum = 0; // �հ��� ��
	static double k24_page_sum_ave = 0; // ����� ��
	
	// �������� ���
	static double k24_page_sum_kor_ave = 0; // ���� ���
	static double k24_page_sum_eng_ave = 0; // ���� ���
	static double k24_page_sum_mat_ave = 0; // ���� ���
	static double k24_page_sum_sum_ave = 0; // �հ��� ���
	static double k24_page_sum_ave_ave = 0; // ����� ���
	
	static int k24_page = 0; // ������ ǥ�� �ʱⰪ
	
	static int k24_page_iPerson = 0; // ������ ǥ�� �ο� �� �ʱⰪ
	
	static int k24_iPerson = 200; // �л� ��
	
	static int k24_page_cut = 40; // �� �������� ��µ� �ο� ��
	
	// ���� ������ �����
	public static void k24_dataSet() {
		for (int k24_i = 0; k24_i < k24_iPerson; k24_i++) { // �л� �� ��ŭ �ݺ�
			String k24_name = String.format("ȫ��%03d", k24_i); // �̸� �����
			int k24_kor = (int)(Math.random() * 100); // �������� �����
			int k24_eng = (int)(Math.random() * 100); // �������� �����
			int k24_mat = (int)(Math.random() * 100); // �������� �����
			// �ϳ��� OneRecŬ������ ���̴� ���� �� ArrayList�� �������
			k24_ArrayOneRec.add(new SWC07P35_OneRec(k24_i, k24_name, k24_kor, k24_eng, k24_mat));
		}
	}
	
	// ��� �μ�
	public static void k24_HeaderPrint() {
		SimpleDateFormat k24_sdf = new SimpleDateFormat( "������� : yyyy.M.dd HH:mm:ss" ); // ���õ��������� ��ü����, �ν��Ͻ� �����Ͽ� ��ü�� ����, ���´� ������ ����.
		Date k24_date = new Date(); // �ý����� �ֱ����ڸ� ������
		
		System.out.printf("%23s\n\n", "��������ǥ");
		System.out.printf("%s%51s\n", "PAGE: " + (k24_page + 1), k24_sdf.format(k24_date)); // ����Ʈ ��ü�� ����� ���� ���õ��������� ��ü�� �����Լ��� ��ȯ ���
		System.out.printf("==============================================================\n");
		System.out.printf("%s%5s%7s%5s%5s%5s%7s\n", "��ȣ", "�̸�", "����", "����", "����", "����", "���");
		System.out.printf("==============================================================\n");
	}
	
	// ���� �μ�
	public static void k24_ScorePrint(int k24_i) {
		SWC07P35_OneRec k24_rec = k24_ArrayOneRec.get(k24_i); // k24_i��° Ŭ�������� ���
		
		System.out.printf("%03d%9s%6d%7d%7d%7d%9.0f\n", // ���� Ŭ���� ���밪�� ���
				  k24_rec.k24_student_id() + 1, k24_rec.k24_name(),
				  k24_rec.k24_kor(), k24_rec.k24_eng(), k24_rec.k24_mat(),
				  k24_rec.k24_sum(), k24_rec.k24_ave());
		
		k24_page_iPerson++; //�������� 1�� ǥ��Ǹ� 1�� ����
		
		/*
		 * ���� Ŭ���� ���밪 ����ϱ�
		 */
		// �����հ� �������� ���� ����� ����.
		k24_sum_kor += k24_rec.k24_kor(); k24_page_sum_kor += k24_rec.k24_kor();
		k24_sum_eng += k24_rec.k24_eng(); k24_page_sum_eng += k24_rec.k24_eng();
		k24_sum_mat += k24_rec.k24_mat(); k24_page_sum_mat += k24_rec.k24_mat();
		k24_sum_sum += k24_rec.k24_sum(); k24_page_sum_sum += k24_rec.k24_sum();
		k24_sum_ave += k24_rec.k24_ave(); k24_page_sum_ave += k24_rec.k24_ave();
		
		// ���� ����� �������� ���� ������ ������.
		k24_sum_kor_ave = (double)k24_sum_kor / (k24_i + 1); // (k24_i�� ���۰��� 0�̶� 1�� �����ش�)
		k24_sum_eng_ave = (double)k24_sum_eng / (k24_i + 1);
		k24_sum_mat_ave = (double)k24_sum_mat / (k24_i + 1);
		k24_sum_sum_ave = (double)k24_sum_sum / (k24_i + 1);
		k24_sum_ave_ave = k24_sum_ave / (k24_i + 1);
	}
	
	// ���� �μ�
	public static void k24_TailPrint(int k24_i) {
		if (k24_i == ((k24_page_cut - 1) + (k24_page_cut * k24_page)) ) { // 30���� ��µǸ� ���� ����
			
			// �������� ����� ǥ��� �ο�����ŭ ����� �ʱ�ȭ�Ǵ� ������������ ǥ��� �ο����� ������ ���Ѵ�
			k24_page_sum_kor_ave = (double)k24_page_sum_kor / k24_page_iPerson;
			k24_page_sum_eng_ave = (double)k24_page_sum_eng / k24_page_iPerson;
			k24_page_sum_mat_ave = (double)k24_page_sum_mat / k24_page_iPerson;
			k24_page_sum_sum_ave = (double)k24_page_sum_sum / k24_page_iPerson;
			k24_page_sum_ave_ave = k24_page_sum_ave / k24_page_iPerson;
			
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "����������");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "�հ�", k24_page_sum_kor, k24_page_sum_eng, k24_page_sum_mat, k24_page_sum_sum, k24_page_sum_ave); // �� Į���� �հ� ���
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n", "���", k24_page_sum_kor_ave, k24_page_sum_eng_ave, k24_page_sum_mat_ave, k24_page_sum_sum_ave, k24_page_sum_ave_ave); // �� Į���� ��� ���
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "����������");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "�հ�", k24_sum_kor, k24_sum_eng, k24_sum_mat, k24_sum_sum, k24_sum_ave); // �� Į���� �հ� ���
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n\n\n\n", "���", k24_sum_kor_ave, k24_sum_eng_ave, k24_sum_mat_ave, k24_sum_sum_ave, k24_sum_ave_ave); // �� Į���� ��� ���
			
			// 30���� ��������� �������� �Ѱ��ش�!
			k24_page++;
			
			// �� �������� �Ѿ���� ���������� ������ �ʱ�ȭ���ش�!
			k24_page_sum_kor = 0;k24_page_sum_kor_ave = 0;
			k24_page_sum_eng = 0;k24_page_sum_eng_ave = 0;
			k24_page_sum_mat = 0;k24_page_sum_mat_ave = 0;
			k24_page_sum_sum = 0;k24_page_sum_sum_ave = 0;
			k24_page_sum_ave = 0;k24_page_sum_ave_ave = 0;
			k24_page_iPerson = 0; // �� �������� ����� ������ 0�� �ʱ�ȭ ���ش�
		} else if (k24_i + 1 == k24_iPerson) { // ������ �л�(200��°)�� ��µǸ� ���� ����
			
			// �������� ����� ǥ��� �ο�����ŭ ����� �ʱ�ȭ�Ǵ� ������������ ǥ��� �ο����� ������ ���Ѵ�
			k24_page_sum_kor_ave = (double)k24_page_sum_kor / k24_page_iPerson;
			k24_page_sum_eng_ave = (double)k24_page_sum_eng / k24_page_iPerson;
			k24_page_sum_mat_ave = (double)k24_page_sum_mat / k24_page_iPerson;
			k24_page_sum_sum_ave = (double)k24_page_sum_sum / k24_page_iPerson;
			k24_page_sum_ave_ave = k24_page_sum_ave / k24_page_iPerson;
			
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "����������");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "�հ�", k24_page_sum_kor, k24_page_sum_eng, k24_page_sum_mat, k24_page_sum_sum, k24_page_sum_ave); // �� Į���� �հ� ���
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n", "���", k24_page_sum_kor_ave, k24_page_sum_eng_ave, k24_page_sum_mat_ave, k24_page_sum_sum_ave, k24_page_sum_ave_ave); // �� Į���� ��� ���
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "����������");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "�հ�", k24_sum_kor, k24_sum_eng, k24_sum_mat, k24_sum_sum, k24_sum_ave); // �� Į���� �հ� ���
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n\n\n\n", "���", k24_sum_kor_ave, k24_sum_eng_ave, k24_sum_mat_ave, k24_sum_sum_ave, k24_sum_ave_ave); // �� Į���� ��� ���
		} // �� �ܿ��� �ƹ��͵� ���Ѵ�.
	}
	
	public static void main(String[] args) {
		k24_dataSet(); // iPerson���� ������ ArrayList�� ��������
//		k24_dataSort(); // �������� ����!
		for (int k24_i = 0; k24_i < k24_iPerson; k24_i++) { // �л� �� ��ŭ �ݺ�
			if (k24_i % k24_page_cut == 0) { // ��� ��� ����
				k24_HeaderPrint(); // ������ ��ºκ�
			}
			
			k24_ScorePrint(k24_i); // ArrayList���� k24_i��° Ŭ���� ���
			
			k24_TailPrint(k24_i); // ���� ��ºκ�
		}
	}
	
	public static void k24_dataSort() {
		// �������� �񱳱����Լ��� ����(Ŭ���� ��Ƽ�)
		Comparator<SWC07P35_OneRec> k24_bi_kyo_gi_jun = new Comparator<SWC07P35_OneRec>() {
			
			@Override // �������̵�
			public int compare(SWC07P35_OneRec k24_a1, SWC07P35_OneRec k24_a2) {
				return (k24_a2.k24_sum() - k24_a1.k24_sum()); // �� ���ڵ�� �� ���ڵ带 ��!
			}
		};
		Collections.sort(k24_ArrayOneRec, k24_bi_kyo_gi_jun); // ������ ������ ����(sort!)
	}

}
