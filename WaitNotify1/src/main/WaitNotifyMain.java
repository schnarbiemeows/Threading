package main;

import classes.Pojo;
import classes.Process1;
import classes.Process2;

/**
 * @author dylan
 *
 */
public class WaitNotifyMain {

	/*
	 * here we have two different process sharing the same Pojo, and the Pojo
	 * contains the wait/notify methods, but the synchronization blocks are in the
	 * client Processes
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pojo pojo = new Pojo();
		Process1 p1 = new Process1(pojo);
		Process2 p2 = new Process2(pojo);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(pojo.getField1());
	}

}
