package com.dante.main.family.photo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dante.main.common.FileService;
import com.dante.main.domain.common.File;
import com.dante.main.domain.common.FileRepository;
import com.dante.main.domain.photo.Album;
import com.dante.main.domain.photo.AlbumRepository;
import com.dante.main.domain.photo.Photo;
import com.dante.main.domain.photo.PhotoRepository;
import com.dante.main.domain.user.User;

@Controller
public class PhotoController {
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	AlbumRepository albumRepository;
	
	@Autowired
	FileService fileService;
	
	@GetMapping("/photoList")
	public ModelAndView photoList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/photo/photoList");
		return mv;
	}
	
	@GetMapping("/photoWrite")
	public ModelAndView photoWrite(@RequestParam("photo_id") Long id){
		ModelAndView mv = new ModelAndView();
		List<Album> albumList = albumRepository.findAll();
		System.out.println("albumList >> " + albumList);
		mv.addObject("albumList", albumList);
		if(id != null){
			//게시글 fetch
			Optional<Photo> photo = photoRepository.findById(id);
			mv.addObject("photo", photo.get());
		}
		System.out.println("mv >>" + mv);
		mv.setViewName("main/photo/photoWrite");
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/addAlbum")
	public int addAlbum(@RequestBody Map<String, Object> param){
		int result = 0;
		try {
			Album album = Album.builder().album_name(String.valueOf(param.get("album_name")))
											  				.reg_id(String.valueOf(param.get("reg_id")))
											  .build();
			albumRepository.save(album);
			result=1;
		} catch (Exception e) {
		}
		return result;
	}
	
	
	@PostMapping("/regPhoto")
	public String regPhoto(@ModelAttribute("photoForm") Photo photoForm, @RequestParam("file") MultipartFile Mfile){
		try {
			File file = fileService.storeFile(Mfile);
			Photo photo = Photo.builder().album_id(photoForm.getAlbum_id())
													     .photo_title(photoForm.getPhoto_title())
													     .photo_content(photoForm.getPhoto_content())
													     .file_id(file.getId())
													     .reg_id("")
											.build();
			
			System.out.println("photo : FILE_ID >> " + photo.getFile_id());
			photoRepository.save(photo); 
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return "redirect:/photoList";
	}

}
