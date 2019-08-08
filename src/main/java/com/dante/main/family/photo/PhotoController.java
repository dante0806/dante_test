package com.dante.main.family.photo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

}
