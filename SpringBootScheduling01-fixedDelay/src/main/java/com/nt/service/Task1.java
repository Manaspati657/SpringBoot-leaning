package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("task1")
public class Task1 {

	@Scheduled(initialDelay = 10000,fixedDelay = 3000)
	public void doTask() {
		System.out.println("thread (task1) name:: "+Thread.currentThread().getName());
		System.out.println("thread (task1) hashCode:: "+Thread.currentThread().hashCode());
		System.out.println("task1 with a fixed delay time ........ -> "+new Date());
	}
	
	@Scheduled(initialDelay = 10000,fixedRate = 5000)
	public void doTask2() {
		System.out.println("thread (task2) name:: "+Thread.currentThread().getName());
		System.out.println("thread (task2) hashCode:: "+Thread.currentThread().hashCode());
		System.out.println("task2 with a fixed rate time ........ -> "+new Date());	}
	
//	@Scheduled(fixedDelay = 3000)
//	public void generateSalesReport() {
//		System.out.println("Sales report on ........ -> "+new Date());
//	}
	
	
}
