package kopo24_0419_7Gang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SWC07P35_ReportSheet {
	
	static ArrayList<SWC07P35_OneRec> k24_ArrayOneRec = new ArrayList<SWC07P35_OneRec>();

	// 누적 총합
	static int k24_sum_kor = 0; // 국어 합
	static int k24_sum_eng = 0; // 영어 합
	static int k24_sum_mat = 0; // 수학 합
	static int k24_sum_sum = 0; // 합계의 합(?)
	static double k24_sum_ave = 0; // 평균의 합
	
	// 누적 평균
	static double k24_sum_kor_ave = 0; // 국어 평균
	static double k24_sum_eng_ave = 0; // 영어 평균
	static double k24_sum_mat_ave = 0; // 수학 평균
	static double k24_sum_sum_ave = 0; // 합계의 평균
	static double k24_sum_ave_ave = 0; // 평균의 평균(?)
	
	// 한페이지 합
	static int k24_page_sum_kor = 0; // 국어 합
	static int k24_page_sum_eng = 0; // 영어 합
	static int k24_page_sum_mat = 0; // 수학 합
	static int k24_page_sum_sum = 0; // 합계의 합
	static double k24_page_sum_ave = 0; // 평균의 합
	
	// 한페이지 평균
	static double k24_page_sum_kor_ave = 0; // 국어 평균
	static double k24_page_sum_eng_ave = 0; // 영어 평균
	static double k24_page_sum_mat_ave = 0; // 수학 평균
	static double k24_page_sum_sum_ave = 0; // 합계의 평균
	static double k24_page_sum_ave_ave = 0; // 평균의 평균
	
	static int k24_page = 0; // 페이지 표기 초기값
	
	static int k24_page_iPerson = 0; // 페이지 표기 인원 수 초기값
	
	static int k24_iPerson = 200; // 학생 수
	
	static int k24_page_cut = 40; // 한 페이지에 출력될 인원 수
	
	// 랜덤 데이터 만들기
	public static void k24_dataSet() {
		for (int k24_i = 0; k24_i < k24_iPerson; k24_i++) { // 학생 수 만큼 반복
			String k24_name = String.format("홍길%03d", k24_i); // 이름 만들기
			int k24_kor = (int)(Math.random() * 100); // 국어점수 만들기
			int k24_eng = (int)(Math.random() * 100); // 영어점수 만들기
			int k24_mat = (int)(Math.random() * 100); // 수학점수 만들기
			// 하나의 OneRec클래스의 데이더 생성 후 ArrayList에 집어넣음
			k24_ArrayOneRec.add(new SWC07P35_OneRec(k24_i, k24_name, k24_kor, k24_eng, k24_mat));
		}
	}
	
	// 헤더 인쇄
	public static void k24_HeaderPrint() {
		SimpleDateFormat k24_sdf = new SimpleDateFormat( "출력일자 : yyyy.M.dd HH:mm:ss" ); // 심플데이터포멧 객체생성, 인스턴스 생성하여 객체에 연결, 형태는 다음과 같음.
		Date k24_date = new Date(); // 시스템의 최근일자를 가져옴
		
		System.out.printf("%23s\n\n", "성적집계표");
		System.out.printf("%s%51s\n", "PAGE: " + (k24_page + 1), k24_sdf.format(k24_date)); // 데이트 객체에 저장된 값을 심플데이터포멧 객체의 포멧함수로 변환 출력
		System.out.printf("==============================================================\n");
		System.out.printf("%s%5s%7s%5s%5s%5s%7s\n", "번호", "이름", "국어", "영어", "수학", "총점", "평균");
		System.out.printf("==============================================================\n");
	}
	
	// 내용 인쇄
	public static void k24_ScorePrint(int k24_i) {
		SWC07P35_OneRec k24_rec = k24_ArrayOneRec.get(k24_i); // k24_i번째 클래스내용 잡기
		
		System.out.printf("%03d%9s%6d%7d%7d%7d%9.0f\n", // 잡은 클래스 내용값을 출력
				  k24_rec.k24_student_id() + 1, k24_rec.k24_name(),
				  k24_rec.k24_kor(), k24_rec.k24_eng(), k24_rec.k24_mat(),
				  k24_rec.k24_sum(), k24_rec.k24_ave());
		
		k24_page_iPerson++; //페이지에 1줄 표기되면 1씩 증가
		
		/*
		 * 잡은 클래스 내용값 계산하기
		 */
		// 누적합과 한페이지 합의 계산은 같다.
		k24_sum_kor += k24_rec.k24_kor(); k24_page_sum_kor += k24_rec.k24_kor();
		k24_sum_eng += k24_rec.k24_eng(); k24_page_sum_eng += k24_rec.k24_eng();
		k24_sum_mat += k24_rec.k24_mat(); k24_page_sum_mat += k24_rec.k24_mat();
		k24_sum_sum += k24_rec.k24_sum(); k24_page_sum_sum += k24_rec.k24_sum();
		k24_sum_ave += k24_rec.k24_ave(); k24_page_sum_ave += k24_rec.k24_ave();
		
		// 누적 평균은 누적합을 더합 갯수로 나눈다.
		k24_sum_kor_ave = (double)k24_sum_kor / (k24_i + 1); // (k24_i의 시작값은 0이라서 1을 더해준다)
		k24_sum_eng_ave = (double)k24_sum_eng / (k24_i + 1);
		k24_sum_mat_ave = (double)k24_sum_mat / (k24_i + 1);
		k24_sum_sum_ave = (double)k24_sum_sum / (k24_i + 1);
		k24_sum_ave_ave = k24_sum_ave / (k24_i + 1);
	}
	
	// 꼬리 인쇄
	public static void k24_TailPrint(int k24_i) {
		if (k24_i == ((k24_page_cut - 1) + (k24_page_cut * k24_page)) ) { // 30개가 출력되면 조건 만족
			
			// 한페이지 평균은 표기된 인원수만큼 출력후 초기화되는 한페이지합을 표기된 인원수로 나눠서 구한다
			k24_page_sum_kor_ave = (double)k24_page_sum_kor / k24_page_iPerson;
			k24_page_sum_eng_ave = (double)k24_page_sum_eng / k24_page_iPerson;
			k24_page_sum_mat_ave = (double)k24_page_sum_mat / k24_page_iPerson;
			k24_page_sum_sum_ave = (double)k24_page_sum_sum / k24_page_iPerson;
			k24_page_sum_ave_ave = k24_page_sum_ave / k24_page_iPerson;
			
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "현재페이지");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "합계", k24_page_sum_kor, k24_page_sum_eng, k24_page_sum_mat, k24_page_sum_sum, k24_page_sum_ave); // 각 칼럼별 합계 출력
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n", "평균", k24_page_sum_kor_ave, k24_page_sum_eng_ave, k24_page_sum_mat_ave, k24_page_sum_sum_ave, k24_page_sum_ave_ave); // 각 칼럼별 평균 출력
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "누적페이지");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "합계", k24_sum_kor, k24_sum_eng, k24_sum_mat, k24_sum_sum, k24_sum_ave); // 각 칼럼별 합계 출력
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n\n\n\n", "평균", k24_sum_kor_ave, k24_sum_eng_ave, k24_sum_mat_ave, k24_sum_sum_ave, k24_sum_ave_ave); // 각 칼럼별 평균 출력
			
			// 30개를 출력했으니 페이지를 넘겨준다!
			k24_page++;
			
			// 새 페이지로 넘어갔으니 현재페이지 값들을 초기화해준다!
			k24_page_sum_kor = 0;k24_page_sum_kor_ave = 0;
			k24_page_sum_eng = 0;k24_page_sum_eng_ave = 0;
			k24_page_sum_mat = 0;k24_page_sum_mat_ave = 0;
			k24_page_sum_sum = 0;k24_page_sum_sum_ave = 0;
			k24_page_sum_ave = 0;k24_page_sum_ave_ave = 0;
			k24_page_iPerson = 0; // 한 페이지의 계산이 끝나면 0로 초기화 해준다
		} else if (k24_i + 1 == k24_iPerson) { // 마지막 학생(200번째)이 출력되면 조건 만족
			
			// 한페이지 평균은 표기된 인원수만큼 출력후 초기화되는 한페이지합을 표기된 인원수로 나눠서 구한다
			k24_page_sum_kor_ave = (double)k24_page_sum_kor / k24_page_iPerson;
			k24_page_sum_eng_ave = (double)k24_page_sum_eng / k24_page_iPerson;
			k24_page_sum_mat_ave = (double)k24_page_sum_mat / k24_page_iPerson;
			k24_page_sum_sum_ave = (double)k24_page_sum_sum / k24_page_iPerson;
			k24_page_sum_ave_ave = k24_page_sum_ave / k24_page_iPerson;
			
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "현재페이지");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "합계", k24_page_sum_kor, k24_page_sum_eng, k24_page_sum_mat, k24_page_sum_sum, k24_page_sum_ave); // 각 칼럼별 합계 출력
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n", "평균", k24_page_sum_kor_ave, k24_page_sum_eng_ave, k24_page_sum_mat_ave, k24_page_sum_sum_ave, k24_page_sum_ave_ave); // 각 칼럼별 평균 출력
			System.out.printf("==============================================================\n");
			System.out.printf("%s\n", "누적페이지");
			System.out.printf("%s%16d%7d%7d%7d%9.0f\n", "합계", k24_sum_kor, k24_sum_eng, k24_sum_mat, k24_sum_sum, k24_sum_ave); // 각 칼럼별 합계 출력
			System.out.printf("%s%16.0f%7.0f%7.0f%7.0f%9.0f\n\n\n\n", "평균", k24_sum_kor_ave, k24_sum_eng_ave, k24_sum_mat_ave, k24_sum_sum_ave, k24_sum_ave_ave); // 각 칼럼별 평균 출력
		} // 그 외에는 아무것도 안한다.
	}
	
	public static void main(String[] args) {
		k24_dataSet(); // iPerson개의 데이터 ArrayList에 생성저장
//		k24_dataSort(); // 오름차순 정렬!
		for (int k24_i = 0; k24_i < k24_iPerson; k24_i++) { // 학생 수 만큼 반복
			if (k24_i % k24_page_cut == 0) { // 헤더 출력 조건
				k24_HeaderPrint(); // 데이터 출력부분
			}
			
			k24_ScorePrint(k24_i); // ArrayList에서 k24_i번째 클래스 출력
			
			k24_TailPrint(k24_i); // 꼬리 출력부분
		}
	}
	
	public static void k24_dataSort() {
		// 컴페어레이터 비교기준함수명 정의(클래서 잡아서)
		Comparator<SWC07P35_OneRec> k24_bi_kyo_gi_jun = new Comparator<SWC07P35_OneRec>() {
			
			@Override // 오버라이드
			public int compare(SWC07P35_OneRec k24_a1, SWC07P35_OneRec k24_a2) {
				return (k24_a2.k24_sum() - k24_a1.k24_sum()); // 앞 레코드와 뒷 레코드를 비교!
			}
		};
		Collections.sort(k24_ArrayOneRec, k24_bi_kyo_gi_jun); // 설정한 내용대로 정렬(sort!)
	}

}
