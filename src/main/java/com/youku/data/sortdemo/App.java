package com.youku.data.sortdemo;



/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		
		int parent = (2 - 1) >>> 1;
//		
//		int parent1 = (0 - 1) >> 1;
		System.out.println(parent);
//		System.out.println(parent1);
		
		//ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(1000);
		
		
		PriorityBlockingQueue_copy<String> aa = new PriorityBlockingQueue_copy<String>();

		int i = 30;
		for (; i > 0; i--) {
			//System.out.println(i);
			
		aa.offer(i+"str");
			
			//aa.offer(new A());

		}
		
		
	
		
		
		
		
		
	}
	
	
	
//    public boolean offer(E e) {
//        if (e == null)
//            throw new NullPointerException();
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        int n, cap;
//        Object[] array;
//        while ((n = size) >= (cap = (array = queue).length))
//            tryGrow(array, cap);
//        try {
//            Comparator<? super E> cmp = comparator;
//            if (cmp == null)
//                siftUpComparable(n, e, array);
//            else
//                siftUpUsingComparator(n, e, array, cmp);
//            size = n + 1;
//            notEmpty.signal();
//        } finally {
//            lock.unlock();
//        }
//        return true;
//    }
	
  static class  A {
	  
	  
	  public String a;
  }
}
