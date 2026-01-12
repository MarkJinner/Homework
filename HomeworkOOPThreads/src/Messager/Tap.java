package Messager;

public class Tap implements Runnable {
	private String message = "tap";
	private Buffer buffer;
	private Thread t;

	public Tap(Buffer buffer) {
		this.buffer = buffer;
		t = new Thread(this);
		t.start();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public void setMessage() throws InterruptedException {
		for (int i = 0; i < buffer.getNumberMax(); i++) {
			if(i==buffer.getNumberMax()-1) {
				System.out.println("Final message "+message);
			}
			buffer.setMessage(message);
			synchronized (buffer) {
				buffer.notifyAll();
			if (i < buffer.getNumberMax() - 1) {
					buffer.wait();
			}
			}
		}
	}

	@Override
	public void run() {
		try {
			setMessage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
