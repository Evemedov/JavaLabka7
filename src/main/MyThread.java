package main;

public class MyThread extends Thread {
	private long n;
	public MyThread(long numOfFib) {
		this.n = numOfFib;
	}
	@Override
	public void run() {
		long a1 = 0;
		long a2 = 1;
		long a3;
		for(int i = 3; i < n; i++) {
			if(this.isInterrupted()) 
				return;
            
			a3 = a1 + a2;
			a1 = a2;
			a2 = a3;
		}
		try {
			MainFrame.endOfThreadExec(getName());
		}
		catch(Exception ex) {
			System.out.println("There is nothing we can do ¯\\_(ツ)_/¯ " + getName());
		}
		
	}
}
