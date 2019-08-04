package leetcode;

import java.util.concurrent.Semaphore;

public class Foo {
	final Semaphore hasFirstRun = new Semaphore(0);
	final Semaphore hasSecondRun = new Semaphore(0);
	
	public Foo() {
		
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		hasFirstRun.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {

		// printSecond.run() outputs "second". Do not change or remove this line.
		hasFirstRun.acquire();
		printSecond.run();
		hasSecondRun.release();
	}

	public void third(Runnable printThird) throws InterruptedException {

		// printThird.run() outputs "third". Do not change or remove this line.
		hasSecondRun.acquire();
		printThird.run();
	}
}
