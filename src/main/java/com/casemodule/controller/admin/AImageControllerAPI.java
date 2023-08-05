package com.casemodule.controller.admin;

import com.casemodule.model.Image;
import com.casemodule.model.Like;
import com.casemodule.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AImageControllerAPI {
    @Autowired
    private ImageServiceImpl imageService;
    @GetMapping("/image")
    private ResponseEntity<List<Image>> findAll(){
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.ACCEPTED);
    }
    @PostMapping("/image")
    private ResponseEntity<?> creat(@RequestBody Image image){
        imageService.save(image);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PostMapping("image/{idImage}")
    public ResponseEntity<?> edit(@PathVariable int idImage, @RequestBody Image image){
        image.setId(idImage);
        imageService.save(image);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("image/{idImage}")
    public ResponseEntity<?> delete(@PathVariable int idImage){
        imageService.delete(idImage);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
