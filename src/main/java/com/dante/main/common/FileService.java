package com.dante.main.common;

import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import com.dante.main.domain.common.File;

public interface FileService {
	
	File storeFile(MultipartFile Mfile) throws FileUploadException;
	
	Optional<File> getFile(Long id);
}
