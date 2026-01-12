package Editorium;

public class Editor {
	private int maxParts;
	private int maxWriters;
	private int maxReaders;
	private boolean flag;
	private boolean stop;
	private String part;
	private int countWriters = 0;
	private int countReaders = 0;
	private int countParts = 0;

	private StringBuilder sb = new StringBuilder();

	public Editor(int maxParts, int maxWriters, int maxReaders) {
		this.maxParts = maxParts;
		this.maxWriters = maxWriters;
		this.maxReaders = maxReaders;
	}

	public Editor() {

	}

	public int getMaxParts() {
		return maxParts;
	}

	public void setMaxParts(int maxParts) {
		this.maxParts = maxParts;
	}

	public int getMaxWriters() {
		return maxWriters;
	}

	public void setMaxWriters(int maxWriters) {
		this.maxWriters = maxWriters;
	}

	public int getMaxReaders() {
		return maxReaders;
	}

	public void setMaxReaders(int maxReaders) {
		this.maxReaders = maxReaders;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public synchronized String getPart() {
		String temp = part;
		if (this.getMaxReaders() == 1) {
			while (this.flag == false) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (this.getMaxWriters() > 1) {
				System.out.println("Reader read parts " + sb.toString());
				sb.delete(0, sb.length());
			} else {
				System.out.println("Reader read part " + part);
			}
			this.flag = false;
			this.notifyAll();

		} else if (this.getMaxReaders() > 1) {
			while (countReaders < this.getMaxReaders() && this.flag == false) {

				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			System.out.println("Reader " + (countReaders+1)+" read part " + part);
			countReaders++;
			if (countReaders == this.getMaxReaders()) {
				countReaders= 0;
				this.flag = false;
				temp = part;
				this.notifyAll();
			}
			
		}



		return temp;
	}

	public synchronized void setPart(String part) {
		if (this.maxWriters == 1) {
			while (this.flag == true) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.notifyAll();
			this.part = part;
			System.out.println("Writer brought part: " + part);

			this.flag = true;

		} else if (this.maxWriters > 1) {
			while (this.countWriters < this.maxWriters && this.flag == true) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}
			countParts++;
			sb.append(part + " ");
			System.out.println("Writer " + (countWriters + 1) + " brought part: " + part);
			if (countParts == maxParts) {
				countParts = 0;
				countWriters++;
				this.notifyAll();
				this.flag = true;
				if (this.countWriters == this.maxWriters) {
					this.setStop(true);
				}
			}

		}

	}

}
