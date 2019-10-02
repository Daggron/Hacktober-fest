import java.net.*;
import java.util.*;
import java.io.*;

public class ClientProgram implements Runnable{
	int clientport = 10,serverport = 20;
	DatagramSocket dc;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Thread recThread;
	ClientProgram() throws Exception{
		dc = new DatagramSocket(clientport);
		recThread = new Thread(this);
		recThread.start();
		senddd();
	}
	public void senddd() throws Exception{
		while(true){
			String data = br.readLine();
			if(data.equals("EXIT"))
				break;
			DatagramPacket dp = new DatagramPacket(data.getBytes(),data.length(),InetAddress.getLocalHost(),serverport);
			dc.send(dp);
		}
		dc.close();
	}
	public void run(){
		byte b[] = new byte[1000];
		while(true){
			try{
				DatagramPacket dp = new DatagramPacket(b,b.length);
				dc.receive(dp);
				String data = new String (b,0,dp.getLength());
				System.out.println("Server:"+data);
			}
			catch(Exception e){}
		}
	}
	public static void main(String[] args) throws Exception {
		new ClientProgram();
	}
}
