package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("20220007", "이순신", 98, 80, 100));
		studentList.add(new Student("20220002", "강감찬", 98, 79, 95));
		studentList.add(new Student("20220005", "유관순", 75, 100, 50));
		studentList.add(new Student("20220001", "사임당", 88, 80, 88));
		studentList.add(new Student("20220003", "변학도", 70, 50, 70));
		studentList.add(new Student("20220006", "일지매", 83, 90, 97));
		studentList.add(new Student("20220004", "성춘향", 83, 90, 97));

		System.out.println("정렬 전: ");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("---------------------------------------");

		Collections.sort(studentList);

		System.out.println("학번 오름차순 정렬 후: ");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("---------------------------------------");

		Collections.sort(studentList, new SortTotalScoreDesc());
		System.out.println("총점 역순 정렬(총점동점자는 학번기준 내림차순) 후: ");
		for (Student stu : studentList) {
			System.out.println(stu);
		}

	}
	
	

}

class SortTotalScoreDesc implements Comparator<Student> {

	@Override
	public int compare(Student totalSc1, Student totalSc2) {
		if (totalSc1.totalScore() == totalSc2.totalScore()) {
			return -1;
		}
		return Integer.compare(totalSc1.totalScore(), totalSc2.totalScore()) * -1;
	}

}

class Student implements Comparable<Student> {
	private String classNum;
	private String name;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	private int rank;

	public Student(String classNum, String name, int koreanScore, int englishScore, int mathScore) {
		super();
		this.classNum = classNum;
		this.name = name;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int totalScore() {
		return koreanScore + englishScore + mathScore;
	}

	public int getrank() {
		return rank;
	}

	public void setrank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "" + " [학번=" + classNum + ", 이름=" + name + ", 국어=" + koreanScore + ", 영어=" + englishScore + ", 수학="
				+ mathScore + ", 총점=" + totalScore() + ", 등수=" + getrank() + "]";
	}

	@Override
	public int compareTo(Student stu) {
		return this.getClassNum().compareTo(stu.getClassNum());
	}

}
