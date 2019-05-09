package kr.or.ddit.basic.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
	public static void main(String[] args) {

		// 서버 소켓을 만들고, 클라이언트가 접속하면 소켓을 만들어
		// 데이터를 받는 클래스와 데이터를 보내는 클래스에 이 소켓을 넘겨준다.
		ServerSocket server = null;
		Socket socket = null;

		try {
			server = new ServerSocket(7777);
			System.out.println("서버준비 완료");
			socket = server.accept();	// 서버 켜지면 블락되어있다가 Client가 접속하면 다음 흐름으로 넘어감
			// Main은 죽었지만 Sender와 Clinet가 쓰레드로 생성되어서 서로 주고받음.

			System.out.println(socket.toString());

			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
