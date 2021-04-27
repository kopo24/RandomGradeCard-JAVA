package kopo24_0419_7Gang;

public class SWC07P35_OneRec {
	
	// 학생 1명의 데이터
	private int k24_student_id; // 번호
	private String k24_name; // 이름
	private int k24_kor; // 언어점수
	private int k24_eng; // 영어점수
	private int k24_mat; // 수학점수
	
	// ReportSheet클래스에서 받은 매개변수들의 값으로 각 프라이빗 변수들을 초기화.
	SWC07P35_OneRec(int k24_student_id, String k24_name, int k24_kor, int k24_eng, int k24_mat) { // 매개변수 1개를 갖는 생성자
		this.k24_student_id = k24_student_id; // k24_i번째 클래스배열에 있는 매개변수값으로 초기화
		this.k24_name = k24_name; // k24_i번째 클래스배열에 있는 매개변수값으로 초기화
		this.k24_kor = k24_kor; // k24_i번째 클래스배열에 있는 매개변수값으로 초기화
		this.k24_eng = k24_eng; // k24_i번째 클래스배열에 있는 매개변수값으로 초기화
		this.k24_mat = k24_mat; // k24_i번째 클래스배열에 있는 매개변수값으로 초기화
	}
	
	/*
	 * ReportSheet클래스에서 호출할 때 마다 최근대입값들로 계산되어 리턴될 메소드들 정리
	 */
	
	// 학생 한 명 번호, 이름, 언어점수, 영어점수, 수학점수, 합계, 평균
	public int k24_student_id() {return this.k24_student_id;} // 번호 리턴
	public String k24_name() {return this.k24_name;} // 이름 리턴
	public int k24_kor() {return this.k24_kor;} // 언어점수 리턴
	public int k24_eng() {return this.k24_eng;} // 영어점수 리턴
	public int k24_mat() {return this.k24_mat;} // 수학점수 리턴
	public int k24_sum() {return this.k24_kor + this.k24_eng + this.k24_mat;} // 세 과목 점수의 합 리턴
	public double k24_ave() {return this.k24_sum() / 3.0;} // 평균 리턴
}
