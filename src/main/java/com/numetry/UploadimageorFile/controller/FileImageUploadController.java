package com.numetry.UploadimageorFile.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileImageUploadController {
	
@PostMapping("/upload-file")
public String UploadImage(@RequestParam("file")MultipartFile file) throws Exception{
	System.out.println(file.getOriginalFilename());
	System.out.println(file.getName());
	System.out.println(file.getContentType());
	System.out.println(file.getSize());
	
	String Path_Directory="C:\\Users\\kamal\\Downloads\\UploadimageorFile\\UploadimageorFile\\src\\main\\resources\\static\\image";
	Files.copy(file.getInputStream(), Paths.get(Path_Directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
	return  "Successfully Image is Uploaded";
	
}
}
