package forEx1;

import java.util.ArrayList;
import java.util.Iterator;

public class TestForEx2 {

	
	public static void main(String[] args) {
		
		ArrayList<String> strList = new ArrayList<String>();
		
		strList.add("월");
		strList.add("화");
		strList.add("수");
		strList.add("목");
		strList.add("금");
		strList.add("토");
		strList.add("일");

		System.out.println("기존 for문");
		for (int i = 0; i < strList.size(); i++) {
			System.out.println((i + 1) + " " + strList.get(i));
		}
		
		System.out.println();
		System.out.println("확장된 for문");
		
		int count = 1;
		for (String test : strList) {
			System.out.println(count + " " + test);
			count++;
		}
		
	}
	
}
