package com.youku.data.sortdemo.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadMXBean threadMXbean = ManagementFactory.getThreadMXBean();
		
		ThreadInfo[] threadinfos = threadMXbean.dumpAllThreads(false, false);
		
		for(ThreadInfo ti : threadinfos)
		{
			System.out.println("thread id is "+ti.getThreadId() +" thread name is "+ti.getThreadName());
		}
		
	}

}
