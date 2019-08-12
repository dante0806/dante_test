package com.dante.main.init;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="file")
public class FileUploadProperties {
	private String uploadDir = "/src/main/resources/uploads/";
	 
    public String getUploadDir() {
    	System.out.println("uploadDir >> " + uploadDir);
        return uploadDir;
    }
 
    public void setUploadDir(String uploadDir) {
    	System.out.println("uploadDir >> " + uploadDir);
        this.uploadDir = uploadDir;
    }
}
