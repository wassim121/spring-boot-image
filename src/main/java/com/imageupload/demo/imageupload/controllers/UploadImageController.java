 package com.imageupload.demo.imageupload.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imageupload.demo.imageupload.entites.ImageModel;
import com.imageupload.demo.imageupload.repository.ImageRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("upload")
public class UploadImageController {
	
	@Autowired
	ImageRepository imageRepo  ;
	
	@GetMapping("/hello")
	public String testController() {
		return "hello Word !! ";
	}
	
	@PostMapping("image")
	public ImageModel uploadImage(@RequestParam("MyFile") MultipartFile file) throws IOException {
		ImageModel img= new ImageModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
		final ImageModel savedImg = imageRepo.save(img);
		System.out.println("image saved ");
		return savedImg ;
	}
	
	  @GetMapping("/images")
	    public List<ImageModel> getAllImages() {
	        List<ImageModel> allImages = imageRepo.findAll();
	        return allImages;
	    }
	 

}
