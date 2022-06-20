package kr.or.ddit.basic;
import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {
		
		List list1 = new ArrayList(); // 인터페이스타입으로 코딩을 하면 유지보수가 쉽다는 장점이 있다.Array list1 = new ArrayList(); 
		//List list1 = new linkedList(); 이것도 가능하다!!
		
		//add()메소드를 사용해서 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111); //컴파일러가 자동으로 integer객체로 만들어 저장함 
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		// size() => 데이터 객수
		System.out.println("size => " + list1.size());
		
		//get()으로 데이터 꺼내오기 ---index값을 가지고 해당 데이터를 가져온다
		System.out.println("1번째 자료 :  " + list1.get(0));
		
		//데이터 끼워넣기도 같다 --데이터를 넣고싶은 인덱스위치, 넣을 데이터
		list1.add(0,"zzz");
		System.out.println("list1 => " + list1);
		
		//데이터 변경하기(set메소드:파라미터 반드시 2개 필요함) --바꾸고자 하는 인덱스 위치, 바꾸고자하는 값
		String temp = (String) list1.set(0, "yyy");
		System.out.println("temp => " +temp);
		System.out.println("list1 => " +list1);
		
		//삭제하기도 같다. --인덱스값 해당위치의 값을 삭제하겠다
		list1.remove(0);
		System.out.println("삭제 후: " + list1);
		
		list1.remove("bbb"); //인덱스값을 모를경우 object를 파라미터로 받는 remove()메소드도 있다
		System.out.println("bbb 삭제 후: " + list1);
		list1.remove(new Integer(111));// 매개값으로 111만 넣으면 인덱스값이 111라고 처리해서 오류가 난다 그래서 객체를 생성해서 해당값을 삭제한다
		System.out.println("111 삭제 후: " + list1);
		System.out.println("==============================");
		
		//제너릭을 지정하여 타입을 선언할 수 있다.-- 타입제한목적으로 쓰인다 String 값만 올 수 있다.
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}
	
		System.out.println("-----------------------------------");
		
		
		//contains(비교객체); => 리스트에 '비교객체'가 있으면 true
		//							    그렇지 않으면 false가 반환된다.
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		
		//indexOf(비교객체); => 리스트에서 '비교객체'를 찾아 '비교객체'가 존재하는 index값을 반환한다.
		//					  리스트에 존재하지 않으면 -1을 반환한다.
		System.out.println("DDD의 index값: " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값: " + list2.indexOf("ZZZ"));
		System.out.println("----------------------------------------");
		
		//toArray(); => 리스트안의 데이터를 배열로 변환하여 반환한다.
	    //			 => 기본적으로 Object형 배열로 반환한다.
		Object[] strArr = list2.toArray();
		String[] strArr1 = list2.toArray(new String[0]); //파라미터에 원하는 타입의 객체를 생성하면 원하는 타입의 배열로 만들 수 있다.
		System.out.println("배열의 갯수: " + strArr.length);
		
		for (int i = 4; i>=0; i--) { //for(int i = 0; i < list2.size(); i++)
			list2.remove(i); //하나 지울때마다 인덱스값이 당겨지면서 정렬된다. 따라서 거꾸로 뒤에서부터 지워야 한다! 지울때 조심해야한다
		}
		System.out.println("list2의 크기: " + list2.size());
		
	}
}