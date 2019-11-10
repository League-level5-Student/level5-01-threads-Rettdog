package _03_Threaded_Reverse_Greeting;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	public static void main(String[] args) {
		threadMaker(0,new Thread());
	}
	/* HINT: You will most likely need to do this with recursion */
	public static void threadMaker(int number,Thread thread) {
		if(number<=50) {
		thread = new Thread(()->threadMaker(number+1,new Thread()));
		thread.start();
		try {
			thread.join();
			System.out.println(number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	
}
