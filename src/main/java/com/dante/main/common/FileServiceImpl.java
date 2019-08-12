package com.dante.main.common;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dante.main.domain.common.UploadFile;
import com.dante.main.domain.common.UploadFileRepository;
import com.dante.main.init.FileUploadProperties;

@Service
public class FileServiceImpl implements FileService{
	
	private Path fileLocation;
	
	/*@Autowired
    public FileServiceImpl(Path fileLocation) {
        this.fileLocation = fileLocation;
    }*/

	@Autowired
	private UploadFileRepository uploadfileRepository;
	
	@Autowired
    public FileServiceImpl(FileUploadProperties prop) throws FileUploadException {
		System.out.println("111");
        //this.fileLocation = fileLocation;
        this.fileLocation = Paths.get(prop.getUploadDir()).toAbsolutePath().normalize();
        System.out.println("fileLocation >> " + this.fileLocation);
        try {
            Files.createDirectories(this.fileLocation);
        }catch(Exception e) {
        	throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
	}
	
	
	@Override
	public UploadFile storeFile(MultipartFile Mfile) throws FileUploadException {
        String fileName = StringUtils.cleanPath(Mfile.getOriginalFilename());

        try {
            //파일명에 부적합 문자가 있는지 확인한다.s
            if(fileName.contains("..")) {
                throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다.. " + fileName) ; 
            }

            Path targetLocation = this.fileLocation.resolve(fileName);
            
            Files.copy(Mfile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            UploadFile uploadFile = new UploadFile(fileName, Mfile.getSize(), Mfile.getContentType(), String.valueOf(targetLocation));
            uploadfileRepository.save(uploadFile);
            
            return uploadFile;
        } catch (Exception ex) {
            throw new FileUploadException("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.", ex);
        }
	}
    
	
	@Override
	public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            
            if(resource.exists()) {
                return resource;
            }else {
                throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.");
            }
        }catch(MalformedURLException e) {
            throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.", e);
        }
    }


	@Override
	public Iterable<UploadFile> getFileList() throws Exception{
		Iterable<UploadFile> iterable = uploadfileRepository.findAll();
	        
        if(null == iterable) {
            throw new Exception("업로드 된 파일이 존재하지 않습니다.");
	    }
	    
	    return  iterable;
	}

	@Override
	public Optional<UploadFile> getUploadFile(Long id) throws Exception {
	    Optional<UploadFile> uploadFile = uploadfileRepository.findById(id);
	    
	    if(null == uploadFile) {
	        throw new Exception("해당 아이디["+id+"]로 업로드 된 파일이 존재하지 않습니다.");
	    }
	    return uploadFile;
	}


}
