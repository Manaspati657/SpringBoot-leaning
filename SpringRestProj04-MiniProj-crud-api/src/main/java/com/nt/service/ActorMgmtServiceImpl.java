package com.nt.service;



import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.customResponse.NotFoundException;
import com.nt.model.Actor;
import com.nt.repo.IActorRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService{

	@Autowired private IActorRepo actorRepo;
	
	@Override
	public String registerActor(Actor actor) {
		Actor actorSave=actorRepo.save(actor);
		return "Actor Registered with id value ::"+actorSave.getActorid();
	}
	
	@Override
	public Iterable<Actor> getAllActor(){
		Iterable<Actor> actorList=actorRepo.findAll();
		Collections.sort((List<Actor>)actorList,(t1,t2)->t1.getActorname().compareTo(t2.getActorname()));
		return actorList;
	}
	
	@Override
	public Actor getActorById(int id) {
		return actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
	}
	
	@Override
	public List<Actor> fetchActorByCategories(String cagtegory1,String category2){
		List<Actor> list=actorRepo.getActorsByCategories(cagtegory1, category2);
		return list;
	}
	
	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> opt=actorRepo.findById(actor.getActorid());
		if(opt.isPresent()) {
			actorRepo.save(actor);
			return "Successfully updated!!!";
		}else {
			throw new NotFoundException("Actor not found");
		}
	}
	
	@Override
	public String deleteActorById(int id) {
		Optional<Actor> opt=actorRepo.findById((id));
		if(opt.isPresent()) {
			actorRepo.deleteById(id);;
			return "Successfully deleted!!!";
		}else {
			throw new NotFoundException("Actor not found");
		}	
	}
	
	@Override
	public String updateActorMobileNo(int id , long newMobileNo) {
		Optional<Actor> opt=actorRepo.findById((id));
		if(opt.isPresent()) {
			Actor actor=opt.get();
			actor.setMobileNo(newMobileNo);
			actorRepo.save(actor);
			return "Successfully mobile no updated!!!";
		}else {
			throw new NotFoundException("Actor not found");
		}	
	}
}

















