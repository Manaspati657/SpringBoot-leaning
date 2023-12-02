package com.nt.beans2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("petrol")
@Primary
public class PetrolEngine implements Engine{

	public PetrolEngine() {
		System.out.println("PetrolEngine::--0 param constructor");
	}
	
	@Override
	public void start() {
		System.out.println("PetrolEngine:: Engine Started...");
	}
	
	@Override
	public void stop() {
		System.out.println("PetrolEngine:: Engine Stopped...");
	}
}
