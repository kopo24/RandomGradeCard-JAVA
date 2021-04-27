package kopo24_0419_7Gang;

public class SWC07P35_OneRec {
	
	// �л� 1���� ������
	private int k24_student_id; // ��ȣ
	private String k24_name; // �̸�
	private int k24_kor; // �������
	private int k24_eng; // ��������
	private int k24_mat; // ��������
	
	// ReportSheetŬ�������� ���� �Ű��������� ������ �� �����̺� �������� �ʱ�ȭ.
	SWC07P35_OneRec(int k24_student_id, String k24_name, int k24_kor, int k24_eng, int k24_mat) { // �Ű����� 1���� ���� ������
		this.k24_student_id = k24_student_id; // k24_i��° Ŭ�����迭�� �ִ� �Ű����������� �ʱ�ȭ
		this.k24_name = k24_name; // k24_i��° Ŭ�����迭�� �ִ� �Ű����������� �ʱ�ȭ
		this.k24_kor = k24_kor; // k24_i��° Ŭ�����迭�� �ִ� �Ű����������� �ʱ�ȭ
		this.k24_eng = k24_eng; // k24_i��° Ŭ�����迭�� �ִ� �Ű����������� �ʱ�ȭ
		this.k24_mat = k24_mat; // k24_i��° Ŭ�����迭�� �ִ� �Ű����������� �ʱ�ȭ
	}
	
	/*
	 * ReportSheetŬ�������� ȣ���� �� ���� �ֱٴ��԰���� ���Ǿ� ���ϵ� �޼ҵ�� ����
	 */
	
	// �л� �� �� ��ȣ, �̸�, �������, ��������, ��������, �հ�, ���
	public int k24_student_id() {return this.k24_student_id;} // ��ȣ ����
	public String k24_name() {return this.k24_name;} // �̸� ����
	public int k24_kor() {return this.k24_kor;} // ������� ����
	public int k24_eng() {return this.k24_eng;} // �������� ����
	public int k24_mat() {return this.k24_mat;} // �������� ����
	public int k24_sum() {return this.k24_kor + this.k24_eng + this.k24_mat;} // �� ���� ������ �� ����
	public double k24_ave() {return this.k24_sum() / 3.0;} // ��� ����
}
