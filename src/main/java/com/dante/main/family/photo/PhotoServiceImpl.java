package com.dante.main.family.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dante.main.domain.photo.AlbumRepository;
import com.dante.main.domain.photo.PhotoRepository;

@Service
public class PhotoServiceImpl {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private AlbumRepository albumRepository;
}
