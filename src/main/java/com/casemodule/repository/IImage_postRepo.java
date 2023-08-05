package com.casemodule.repository;

import com.casemodule.model.Image;
import com.casemodule.model.Image_post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IImage_postRepo extends JpaRepository<Image_post,Integer> {
    @Query(value = "SELECT * FROM Image_post WHERE image_id =:image_id ",nativeQuery = true)
    Image_post getImage(@Param("image_id") int image_id);
    void deleteAllByImageId(int image_id);
}
