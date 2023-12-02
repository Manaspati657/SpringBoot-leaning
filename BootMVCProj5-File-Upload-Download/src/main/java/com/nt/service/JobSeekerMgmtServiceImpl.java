package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerRepo;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired private IJobSeekerRepo jsRepo;
	
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		return "job seeker is saved with "+jsRepo.save(info).getJsId()+" id value";
	}
	
	@Override 
	public List<JobSeekerInfo> fetchAllJobseekers(){
	  return jsRepo.findAll();
	}
	
	@Override
	public String getPersonFilesName(Integer jsId,String type) {
		JobSeekerInfo info=jsRepo.findById(jsId).get();
		if(type=="resume")
			return info.getResumePath();
		else
			return info.getPhotoPath();
	}

	
}
