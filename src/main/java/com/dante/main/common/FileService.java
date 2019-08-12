package com.dante.main.common;

import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.dante.main.domain.common.UploadFile;

public interface FileService {
	
	UploadFile storeFile(MultipartFile Mfile) throws FileUploadException;
	
	Resource loadFileAsResource(String fileName);
	
	Iterable<UploadFile> getFileList() throws Exception;
	
	Optional<UploadFile> getUploadFile(Long id) throws Exception;
}
