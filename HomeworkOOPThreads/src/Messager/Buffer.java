package Messager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buffer {
	private String message;
	private List<String> list = Collections.synchronizedList(new ArrayList<>());
	private boolean flag;
	private boolean stop;
	private int numberMax = 5;
	private int count = 1;

	public Buffer() {

	}

	public synchronized String getMessage() {
		String temp = message;
		return temp;
	}

	public synchronized void setMessage(String message) {
		System.out.println("count: "+count);
		while (flag = !flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count++;
		this.notifyAll();
		this.message = message;
		list.add(message);
		System.out.println(message);
		this.flag = !flag;
		
		
//		if(this.flag==flag) {
//			this.notifyAll();
//		}
		
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

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public int getNumberMax() {
		return numberMax;
	}

	public void setNumberMax(int numberMax) {
		this.numberMax = numberMax;
	}
	
	

}
