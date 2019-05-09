package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 이 클래스는 소켓을 통해서 메시지를  보내는 역할을 담당한다.
 */

public class Sender extends Thread {
	Socket socket;
	DataOutputStream dos; // 데이터 출력용 스트림(보조스트림)
	String name;

	public Sender(Socket socket) {
		this.socket = socket;
		name = "[" + socket.getInetAddress() + " : " + socket.getPort() + "]";

		try { // socket.getOutputStream하면 OutputStream이 반환되므로 그걸 DataOutputStream에 넣음
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (dos != null) {	// dos는 생성자 타이밍에 생성되었을꺼기 때문에 null 아닐꺼임
			try {
				dos.writeUTF(name + " >>> " + sc.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
}
