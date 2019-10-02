import java.net.*;

public class Networking{
	public static void main(String args[]){
		Socket s = new Socket("Internicnet",42)
		s.accept();
		InputStream is = s.getInputStream(); 
	}
}