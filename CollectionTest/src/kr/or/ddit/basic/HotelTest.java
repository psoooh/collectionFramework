package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {

	private Scanner scan;
	private Map<String, Hotel> hotelListMap;

	public HotelTest() {
		scan = new Scanner(System.in);
		hotelListMap = new HashMap<String, Hotel>(); // 자료를 해쉬맵에 저장하려고 컬렉션객체 생성
	}
//----------------------------------------------------------------------------
	//메뉴를 출력하는 메소드
	public void displayMenu(){
		
		System.out.println("********************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("********************************");
		System.out.print("메뉴선택: ");		
	}
//----------------------------------------------------------------------------	
	// 프로그램을 시작하는 메서드
	public void hotelOpen(){
		System.out.println();
		System.out.println("***************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("***************");
		System.out.println();
		
		while(true){
			
			displayMenu();  // 메뉴 출력
			
			int menuNum = scan.nextInt();   // 메뉴 번호 입력
			
			switch(menuNum){
				case 1 : checkIn();		// 체크인(등록)
					break;
				case 2 : checkOut();		// 체크아웃(삭제)
					break;
				case 3 : displayAll();		// 
					break;
					
				case 4 : 
					     System.out.println("***************");
					     System.out.println("호텔 문을 닫습니다.");
						 System.out.println("***************");
				    return;	
				default :
					System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} 
		}
	}
	
//-----------------------------------------------------------------------------------------	
	//3.객실상태 메소드
	private void displayAll() {
		Set<String> keySet = hotelListMap.keySet(); //keyset을 이용해서 key만 추려서 값을 가져온다
		
		
		if(keySet.size() == 0) {
			System.out.println("투숙객 정보가 없습니다.");
		}else {
			Iterator<String> it = keySet.iterator(); 
			 
			while(it.hasNext()) {
				
				String roomNum = it.next();
				Hotel h = hotelListMap.get(roomNum); //호텔객체에 전체 정보가 담겨있다 그래서 그걸 통해 자료들을 출력한다
				System.out.println("방번호: " + h.getRoomNum() + "투숙객: " + h.getCustomer());
			}
		}
	}
//----------------------------------------------------------------------------	
	//2. 체크아웃 메소드
	private void checkOut() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력: "); //방번호를 키값으로 해서 진행
		
		String roomNum = scan.next();
		
		//remove(key값)=> 삭제를 성공하면 삭제된 value값을 반환함, 실패하면 null이 리턴됨.
		if(hotelListMap.remove(roomNum) == null) {
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
		}else {
			System.out.println("체크아웃되었습니다.");
		}	
	}
	
	
//------------------------------------------------------------------------------	
	//1. 체크인 메소드
	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력: ");
		
		String roomNum = scan.next();
		
		System.out.print("누구를 체크인 하시겠습니까?");
		String customer = scan.next();
		
		// 이미 등록된 사람인지 검사
				//get()메소드를 이용하여 값을 가져올때 자료가 없으면 null을 반환함.
				if(hotelListMap.get(roomNum) != null) {
					System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
					return; //메소드 종료
				}
				
		hotelListMap.put(roomNum, new Hotel(roomNum, customer));
		System.out.println("체크인 되었습니다");
		
		
		
//-----------------------------------------------------------------------------		
		
	}	
	
	//메인메소드
	public static void main(String[] args) {
		new HotelTest().hotelOpen();
		
	}
//---------------------------------------------------------------------------	
	class Hotel {
		private String roomNum;
		private String customer;

		public Hotel(String roomNum, String customer) {
			super();
			this.roomNum = roomNum;
			this.customer = customer;
		}

		public String getRoomNum() {
			return roomNum;
		}

		public void setRoomNum(String roomNum) {
			this.roomNum = roomNum;
		}

		public String getCustomer() {
			return customer;
		}

		public void setCustomer(String customer) {
			this.customer = customer;
		}

	}
}