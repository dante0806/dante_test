package com.dante.main.family.photo;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dante.main.common.FileService;
import com.dante.main.domain.common.FileUploadResponse;
import com.dante.main.domain.common.UploadFile;
import com.dante.main.domain.photo.Album;
import com.dante.main.domain.photo.AlbumRepository;
import com.dante.main.domain.photo.Photo;
import com.dante.main.domain.photo.PhotoRepository;

@Controller
public class PhotoController {
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	AlbumRepository albumRepository;
	
	@Autowired
	FileService fileService;
	
	@GetMapping("/photoList")
	public ModelAndView photoList() throws NumberFormatException, Exception{
		ModelAndView mv = new ModelAndView();
		List<Photo> photoList = photoRepository.findAll();
		int index =0;
		for (Photo photo : photoList) {
			System.out.println("photoList.get(all) >> " + photoList.get(index));
			//Optional<UploadFile> uploadFile = fileService.getUploadFile(Long.parseLong(String.valueOf(photoList.get(index).getFile_id())));
			//System.out.println("asdasd >>> " + uploadFile.get());
			index++;
		}
		mv.addObject("photoList", photoList);
		mv.setViewName("main/photo/photoList");
		return mv;
	}
	
	@GetMapping("/photoWrite")
	public ModelAndView photoWrite(@RequestParam("photo_id") Long id){
		ModelAndView mv = new ModelAndView();
		List<Album> albumList = albumRepository.findAll();
		mv.addObject("albumList", albumList);
		if(id != null){
			//게시글 fetch
			Optional<Photo> photo = photoRepository.findById(id);
			mv.addObject("photo", photo.get());
		}
		mv.setViewName("main/photo/photoWrite");
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/addAlbum")
	public int addAlbum(@RequestBody Map<String, Object> param){
		int result = 0;
		try {
			Album album = Album.builder()
												.album_name(String.valueOf(param.get("album_name")))
											  	.reg_id(String.valueOf(param.get("reg_id")))
											  	.build();
			albumRepository.save(album);
			result=1;
		} catch (Exception e) {
		}
		return result;
	}
	
	@PostMapping("/regPhoto")
	public String regPhoto(@ModelAttribute("photoForm") Photo photoForm, @RequestParam(value="file") MultipartFile Mfile) throws IllegalStateException, IOException{
		try {
			
			String fileName = Mfile.getOriginalFilename();
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                                .path("/downloadFile/")
	                                .path(Mfile.getOriginalFilename())
	                                .toUriString();
			new FileUploadResponse(fileName, fileDownloadUri, Mfile.getContentType(), Mfile.getSize());
			UploadFile uploadFile = fileService.storeFile(Mfile);
			
			Photo photo = Photo.builder().album_id(photoForm.getAlbum_id())
													     .photo_title(photoForm.getPhoto_title())
													     .photo_content(photoForm.getPhoto_content())
													     .file_id(uploadFile.getId())
													     .reg_id("")
											.build();
			photoRepository.save(photo); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/photoList";
	}
	
	//테스트
	/*@PostMapping("/uploadFile")
    public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file) {
        return null;
    }
    
    @PostMapping("/uploadMultipleFiles")
    public List<FileUploadResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return null;
    }
    
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        return null;
    }*/
	
	
}
