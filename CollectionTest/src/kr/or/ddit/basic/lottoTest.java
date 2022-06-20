package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class lottoTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		
		while (run) {
			System.out.println("===============================");
			System.out.println("Lotto 프로그램");
			System.out.println("-------------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("===============================");
			System.out.print("메뉴선택: ");
			
			int menuNum = Integer.parseInt(scanner.next());
			
			switch (menuNum) {
			case 1:
				System.out.println();
				System.out.println("Lotto 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력: ");
				int fee = Integer.parseInt(scanner.next());
				
				System.out.println("로또 번호는 아래와 같습니다.");
				//1~45사이의 중복되지 않는 정수 6개 만들기
				
				Random random = new Random();
				
					
					for (int i = 1; i <= fee/1000; i++) {
						Set<Integer> intRnd = new HashSet<Integer>();
						while (intRnd.size() < 6) {
							int num = (int) (random.nextInt(45) + 1);
							intRnd.add(num);
					}
					System.out.println("로또번호 "+ i + ":" + intRnd);
				}
				
				
				int rest = fee % 1000;
				System.out.println("받은 금액은 " + fee + "원이고 거스름돈은 " + rest + "원 입니다.");
				
				break;
				
				
			case 2:
				run = false;
				break;
				
				default:
					System.out.println("잘못 입력하였습니다. 다시 시도해주세요.");

			
			}
		}
		System.out.println("감사합니다.");
		
		
	}
}
