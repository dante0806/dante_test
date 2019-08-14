package com.dante.main.init;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="file")
public class FileUploadProperties {
	//private String uploadDir = "C:/Users/김시은/Desktop/images";
	private String uploadDir = "../dante_test/src/main/webapp/upload/images";
	 
    public String getUploadDir() {
        return uploadDir;
    }
 
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
