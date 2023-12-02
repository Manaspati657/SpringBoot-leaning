package com.nt.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.customResponse.ResponseHandler;
import com.nt.model.Actor;
import com.nt.service.IActorMgmtService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationControl {
	
//	swagger url
//	http://localhost:8086/crudApi/swagger-ui.html

	@Autowired private IActorMgmtService service;
	@Autowired private ResponseHandler responseHandler;
	
	@PostMapping("/save")
	@ApiOperation("For Actor registration") //this is for swagger API description
	public ResponseEntity<Object> saveActor(@RequestBody Actor actor){
//		try {
			String msg = service.registerActor(actor);
			System.out.println(msg);
			return responseHandler.generateResponse("Successfully added data!",HttpStatus.CREATED, null);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
//		}
	}
	
	
	@GetMapping("/getAll")
	@ApiOperation("For display All actors")
	public ResponseEntity<Object> getAllActor(){
//		try {
			List<Actor> list = (List<Actor>) service.getAllActor();
			return responseHandler.generateResponse("Successfully retrived data!",HttpStatus.OK, list);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
//		}
	}
	
	
	@GetMapping("/get/{id}")
	@ApiOperation("For getting one actor by id")
	public ResponseEntity<Object> fetchActorByid( @PathVariable int id ){
//		try {
			Actor actor=service.getActorById(id);
			return responseHandler.generateResponse("Successfully retrived data!",HttpStatus.OK, actor);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseHandler.generateResponse("no data found !!!", HttpStatus.INTERNAL_SERVER_ERROR, null);
//		}
	}
	
	@GetMapping("/actorInfo/{category1}/{category2}")
	@ApiOperation("For getting actors with categories")
	public ResponseEntity<Object> showActorByCategory( @PathVariable String category1,@PathVariable String category2 ){
//		try {
			List<Actor> actorList=service.fetchActorByCategories(category1,category2);
			return responseHandler.generateResponse("Successfully retrived data!",HttpStatus.OK, actorList);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseHandler.generateResponse("no data found !!!", HttpStatus.INTERNAL_SERVER_ERROR, null);
//		}
	}
	
	@PutMapping("/update")
	@ApiOperation("For updagte an actor")
	public ResponseEntity<Object> updateActor(@RequestBody Actor actor){
//		try {
			String msg = service.updateActor(actor);
			System.out.println(msg);
			return responseHandler.generateResponse(msg,HttpStatus.CREATED, actor);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
//		}
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation("For delete an actor")
	public ResponseEntity<Object> deleteActorByid( @PathVariable int id ){
//		try {
			String msg=service.deleteActorById(id);
			return responseHandler.generateResponse(msg,HttpStatus.OK, null);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
//		}
	}
	
	@PatchMapping("/updateMobile/{id}/{newNo}")
	@ApiOperation("For update mobile no of an actor")
	public ResponseEntity<Object> updateActorMobileNo( @PathVariable int id,@PathVariable Long newNo){
//		try {
			String msg=service.updateActorMobileNo(id,newNo);
			return responseHandler.generateResponse(msg,HttpStatus.OK, null);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
//		}
	}
	
	
}
