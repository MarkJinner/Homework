package ThreadKiller;

public class ThreadKiller implements Runnable{
	private int random;
	private int x;
	private Thread t;
	
	public ThreadKiller(int x) {
		this.x = x;
		t = new Thread(this);
		t.start();
	}
	
	public ThreadKiller() {
		
	}
	
	private void runThreadsKill() {
		Thread one = new Thread(new TimeDisplayer());
		one.start();
		
		while(!Thread.currentThread().isInterrupted()) {
			random = this.getRandom(x);
			if(random !=x) {
				System.out.println(random);
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				Thread.currentThread().interrupt();
				one.interrupt();
				System.out.println("Thread killer killed threads");
			}
			random = this.getRandom(x);
		}
	}
	
	private int getRandom(int max) {
		return 1+(int)(Math.random()*max);
	}

	@Override
	public void run() {
		runThreadsKill();
		
	}
	
	
	
	
	
}
