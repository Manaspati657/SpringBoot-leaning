package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerData;
import com.nt.entity.JobSeekerInfo;
import com.nt.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerOperationsController {

	@Autowired IJobSeekerMgmtService service;
	@Autowired private Environment env;
	@Autowired private ServletContext sc;
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showJSResistrationForm(@ModelAttribute("js") JobSeekerData jsData) {
		
		//return LvN
		return "Jobseeker_register";
	}
	
	@PostMapping("/register")
	public String registerJSByUploadingFiles(@ModelAttribute("js") JobSeekerData jsData,
			Map<String,Object> map) throws Exception
	{
//		get Upload folder location from properties file
		String storeLocation=env.getRequiredProperty("upload.store");
//		if that not available then create it
		File file=new File(storeLocation);
		if(!file.exists()) {
			file.mkdir();
		}
		
//		get InputStreams representation the upload files content
		MultipartFile resumeFile=jsData.getResume();
		MultipartFile photoFile=jsData.getPhoto();
		InputStream isResume=resumeFile.getInputStream();
		InputStream isPhoto=photoFile.getInputStream();
		
//		get the names of the upload files
		String resumeFileName=resumeFile.getOriginalFilename();
		String photoFileName=photoFile.getOriginalFilename();
		
//		create outputstreams representing empty destination files
		OutputStream osResume=new FileOutputStream(file.getAbsoluteFile()+"\\"+resumeFileName);
		OutputStream osPhoto=new FileOutputStream(file.getAbsoluteFile()+"\\"+photoFileName);
		
//		perform file copy operation
		IOUtils.copy(isPhoto, osPhoto);
		IOUtils.copy(isResume, osResume);
		
//		close stream
		isPhoto.close();
		isResume.close();
		osPhoto.close();
		osResume.close();
		
//		prepare Entity class object from Model class object
		JobSeekerInfo jsInfo=new JobSeekerInfo();
		jsInfo.setJsAddrs(jsData.getJsAddrs());
		jsInfo.setJsName(jsData.getJsName());
		jsInfo.setPhotoPath(photoFileName);
		jsInfo.setResumePath(resumeFileName);
		
//		use service
		String msg=service.registerJobSeeker(jsInfo);
		
//		keep the uploaded file names and location in model attributes
		map.put("file1",photoFileName);
		map.put("file2",resumeFileName);
		map.put("resultMsg", msg);
		
//		return LVN
		return "show_result";
	}
	
	
	@GetMapping("list_js")
	public String showReport(Map<String,Object> map) {
		
		List<JobSeekerInfo> list=service.fetchAllJobseekers();
		
		System.out.println(list.size());
		
//		add result to model
		map.put("jsList", list);
		
//		return LVN
	    return "show_report";
	}
	
	@GetMapping("/download")
	public String fileDownload(HttpServletResponse res,
			@RequestParam("jsId") Integer id,
			@RequestParam("type") String type) throws Exception{
		
//		get file name from db
		String fileName=null;
		if(type.equalsIgnoreCase("resume"))
			fileName=service.getPersonFilesName(id, "resume");
		else
			fileName=service.getPersonFilesName(id, "photo");
		
//		get Upload folder location from properties file
		String storeLocation=env.getRequiredProperty("upload.store");
		String filePath=storeLocation+"/"+fileName;
		System.out.println(filePath+"===================");
		
//		create File object representing file to be download
		File file=new File(filePath);
		
//		get the length of the file and make it as the response context length
		res.setContentLengthLong(file.length());
		
//		get MIME of the file and make it as the response content type
		String mimeType=sc.getMimeType(filePath);
		mimeType = mimeType == null ? "application/octet-stream":mimeType;
		res.setContentType(mimeType);
		
//		create Inputstream pointing to the file
		InputStream is=new FileInputStream(file);
//		create OutputStream pointing to the response object
		OutputStream os=res.getOutputStream();
		
//		instruct the browser to give file content as downloadable file
		res.setHeader("Content-Dispostion","attachment;fileName"+file.getName());
		
//		write file content to response object
		IOUtils.copy(is, os);
		
//		close streams
		is.close();
		os.close();
		
		return null;//makes the handler method to send response directly to browser
	}
	
}





























