package com.dante.main.common;

import java.io.IOException;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dante.main.domain.common.File;
import com.dante.main.domain.common.FileRepository;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public File storeFile(MultipartFile Mfile) throws FileUploadException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(Mfile.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileUploadException("파일이름에 부적합한 문자열이 들어 있습니다.") ; 
            }

            File file = new File(fileName,Mfile.getSize(), Mfile.getContentType(), Mfile.getBytes());

            return fileRepository.save(file);
        } catch (IOException ex) {
            throw new FileUploadException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

	@Override
    public Optional<File> getFile(Long id) {
        return fileRepository.findById(id);
    }

}
