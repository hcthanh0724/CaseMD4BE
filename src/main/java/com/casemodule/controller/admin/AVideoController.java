package com.casemodule.controller.admin;

import com.casemodule.model.Video;
import com.casemodule.service.IPostService;
import com.casemodule.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AVideoController {
    // ThanVideo
    @Autowired
    private IVideoService iVideoService;
    @Autowired
    private IPostService iPostService;
    @GetMapping("/video")
    public ResponseEntity<List<Video>> getAll(){
        return new ResponseEntity<>(iVideoService.findAll(),HttpStatus.ACCEPTED);
    }
    @PostMapping("/video")
    public ResponseEntity<?> createVideo( @RequestBody Video video) {
//        Post post = iPostService.findById(idPost);
//        video.setUrl(String.valueOf(post));
        iVideoService.save(video);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("video/{idVideo}")
    public ResponseEntity<?> edit(@PathVariable int idVideo, @RequestBody Video video){
        video.setId(idVideo);
        iVideoService.save(video);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/video/{idVideo}")
    public ResponseEntity<Video> deleteVideo(@PathVariable int idVideo) {
        Video video = iVideoService.findById(idVideo);
        iVideoService.delete(idVideo);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }
}
