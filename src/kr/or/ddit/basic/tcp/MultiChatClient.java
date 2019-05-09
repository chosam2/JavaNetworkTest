package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	private String userName;

	// 비즈니스 로직 처리
	public void clientStart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("대화명 : ");
		userName = sc.next();

		Socket socket = null;

		try {
			String serverIp = "127.0.0.1";
			socket = new Socket(serverIp, 7777);

			System.out.println("서버에 연결되었습니다.");

			// 송신용 쓰레드 생성
			ClientSender sender = new ClientSender(socket, userName);

			// 수신용 쓰레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);

			// 쓰레드 생성
			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 메시지를 전송하는 메서드
	class ClientSender extends Thread {
		Socket socket;
		DataOutputStream dout;
		String name;
		Scanner sc = new Scanner(System.in);

		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;

			try {
				dout = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			
		}
	}
}
