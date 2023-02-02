package kr.co.challengers.mvc.parameter;

import lombok.Data;

@Data
public class UploadFileParameter {
    private String pathname;
    private String filename;
    private String originalFilename;
    private int size;
    private String contentType;
    private String resourcePathname;

}
