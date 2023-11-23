package com.gmail.oi;

public class Philosopher implements Runnable {
	private int number;
	private ThreadCounter count;
	private Table table;
	private State state;
	private int pickedFork = 0;
	private Fork rightFork;
	private Fork leftFork;

	public Philosopher(Table table, int number) {
		this.table = table;
		this.count = this.table.getCount();
		this.number = number;
		this.state = State.THINKING;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ThreadCounter getCount() {
		return count;
	}

	public void setCount(ThreadCounter count) {
		this.count = count;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getPickedFork() {
		return pickedFork;
	}

	public void setPickedFork(int pickedFork) {
		this.pickedFork = pickedFork;
	}

	public Fork getRightFork() {
		return rightFork;
	}

	public void setRightFork(Fork fork) {
		this.rightFork = fork;
		fork.setFree(false);
	}

	public Fork getLeftFork() {
		return leftFork;
	}

	public void setLeftFork(Fork fork) {
		this.leftFork = fork;
		fork.setFree(false);
	}

	private void pickRightFork() {
		for (int i = 0; i < this.table.getForks().length; i++) {
			if (i == this.number && this.table.getForks()[i].isFree()) {

				if (this.number != this.pickedFork) {
					this.setRightFork(this.table.getForks()[i]);
					System.out.println(this + " picked right " + this.table.getForks()[i]);
//					System.out.println(this.table.getForks()[i].isFree());
				} 
				else {
//					System.out.println((this.getNumber() + 1) + " skipped picking..."+ this.getState().getMessage());
//					System.out.println(this.rightFork);
				}

			}
		}
		this.pickedFork++;
		if (this.pickedFork == this.table.getNumber()) {
			this.setPickedFork(0);
		}
	}

	private void pickLeftFork() {

		for (int i = 0; i < this.getTable().getForks().length; i++) {
			if (i < this.getTable().getForks().length - 1 && i == this.number) {
				if (this.getTable().getForks()[i + 1].isFree()) {
					this.setLeftFork(this.getTable().getForks()[i + 1]);
					System.out.println(this + " picked left " + (this.getTable().getForks()[i + 1]));
					break;
				}
			} else if (i == this.getTable().getForks().length - 1 && i == this.number) {
				if (this.getTable().getForks()[0].isFree()) {
					this.setLeftFork(this.getTable().getForks()[0]);
					System.out.println(this + " picked left " + (this.getTable().getForks()[0]));
					break;
				}
			}
		}
	}

	private void runPhilosopher() throws InterruptedException {
		while (!Thread.currentThread().isInterrupted()) {
			if (count.getCount() < this.table.getNumber()) {
				synchronized (count) {
					count.addCount();
					if (this.number == count.getCount() - 1) {

						
						pickRightFork();

						if (this.rightFork != null) {
							pickLeftFork();
							if (this.leftFork != null && this.rightFork != null) {
								this.setState(state.EATING);
								System.out.println((this.getNumber()+1) + " " + this.getState().getMessage());
								this.setState(state.THINKING);

							}
						}
						else {
							System.out.println((this.getNumber()+1) + " " + this.getState().getMessage());
						}
						
						this.rightFork = null;
						this.leftFork = null;
						this.table.setCountP(this.table.getCountP() + 1);

					} else {
						count.takeCount();
					}
					if (count.getCount() == this.table.getNumber()) {
						count.setCount(0);
						synchronized (table) {
							if (this.table.getCountP() == this.table.getNumber()) {
								this.table.putAllForks();

								Thread.currentThread().sleep(10);
							}
						}
						Thread.currentThread().sleep(1000);

					}
				}

			}

		}
	}

	@Override
	public void run() {
		try {
			runPhilosopher();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Philosopher " + (this.number + 1);
	}

}
