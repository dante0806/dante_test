package com.dante.main.domain.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadResponse {
	private String file_name;
    private String file_path_uri;
    private String file_type;
    private long file_size;
    
    public FileUploadResponse(String file_name, String file_path_uri, String file_type, long file_size) {
        this.file_name = file_name;
        this.file_path_uri = file_path_uri;
        this.file_type = file_type;
        this.file_size = file_size;
    }
}
