package com.example.zzyzzy.semiprojectv1.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NewGalleryDTO {

    private Integer ggno;
    private String title;
    private String userid;
    private String simgname;
    private String contents;
}


