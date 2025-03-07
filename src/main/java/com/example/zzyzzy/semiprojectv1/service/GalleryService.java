package com.example.zzyzzy.semiprojectv1.service;

import com.example.zzyzzy.semiprojectv1.domain.GalleryListDTO;
import com.example.zzyzzy.semiprojectv1.domain.GalleryImageDTO;

import java.util.List;

public interface GalleryService {

    List<GalleryListDTO> selectGallery();

    GalleryImageDTO readOneGalleryImage(int gno);
}
