package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class T01_InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress클래스 => IP주소를 다루기 위한 클래스

		// naver사이트의 ip정보 가져오기
		InetAddress naverIP = InetAddress.getByName("www.naver.com");
		System.out.println("Host Name => " + naverIP.getHostName());
		System.out.println("Host Address => " + naverIP.getHostAddress());
		System.out.println();

		// 자기 자신 컴퓨터의 IP주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name : " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address : " + localIp.getHostAddress());
		System.out.println();

		// ip주소가 여러개인 호스트의 정보 가져오기
//		InetAddress[] googleIps = InetAddress.getAllByName("www.google.com");
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for (InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
	}
}
