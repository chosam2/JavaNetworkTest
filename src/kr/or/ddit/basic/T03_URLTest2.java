package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class T03_URLTest2 {
	public static void main(String[] args) throws IOException {
		// URLConnection => 애플리케이션과 URL간의 통신 연결을 위한 추상 클래스

		// 특정 서버(예:naver서버)의 정보와 파일 내용을 출력하는 예제
		URL url = new URL("https://www.naver.com/index.html");

		// Header정보 가져오기

		// URLConnection객체 구하기
		URLConnection urlCon = url.openConnection();

		System.out.println("Content-Type : " + urlCon.getContentType());
		System.out.println("Encoding : " + urlCon.getContentEncoding());
		System.out.println("Content : " + urlCon.getContent());
		System.out.println();

		// 전체 Header정보 출력하기
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();

		// Header의 key값 구하기
		Iterator<String> iterator = headerMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " : " + headerMap.get(key));
		}
		System.out.println("--------------------------------------------");

		// 해당 호스트의 페이지 내용 가져오기

		// 방법1 => URLConnection의 getInputStream메서드 이용하기

		// 파일을 읽어오기 위한 스트림 생성
		InputStream is = urlCon.getInputStream(); // byte타입
		InputStreamReader isr = new InputStreamReader(is, "utf-8");	// 보조스트림(캐릭터로 변환)
		BufferedReader br = new BufferedReader(isr);	// String 타입을 Buffer에 저장

		// 내용 출력하기
		while (true) {
			String str = br.readLine(); // 한줄씩 읽기
			if (str == null) // null
				break;
			System.out.println(str);
		}

		br.close(); // 스트림 닫기

		// 방법2 => URL객체의 openStream()메서드 이용하기
		// 파일을 읽어오기 위한 스트림 생성
		InputStream is2 = url.openStream();
		InputStreamReader isr2 = new InputStreamReader(is2, "utf-8");
		BufferedReader br2 = new BufferedReader(isr2);

		// 내용 출력하기
		while (true) {
			String str = br2.readLine();
			if (str == null)
				break;
			System.out.println(str);
		}

		br2.close(); // 스트림 닫기
	}
}
