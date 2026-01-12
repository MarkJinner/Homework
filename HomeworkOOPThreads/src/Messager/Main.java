package Messager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testApp(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testApp(int number) throws InterruptedException {
		Buffer buffer = new Buffer();
		Pop pop = new Pop(buffer);
		Push push = new Push(buffer);
		Pull pull = new Pull(buffer);
		Tap tap = new Tap(buffer);
		
		pop.getT().join();
		push.getT().join();
		pull.getT().join();
		tap.getT().join();
		System.out.println(buffer.getList().size());
	}

}
