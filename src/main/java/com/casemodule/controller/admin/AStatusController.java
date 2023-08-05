package com.casemodule.controller.admin;

import com.casemodule.model.Status;
import com.casemodule.service.IPostService;
import com.casemodule.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AStatusController {
    @Autowired
    private IStatusService iStatusService;
    @Autowired
    private IPostService iPostService;
    @GetMapping("/status")
    private ResponseEntity<List<Status>> getAll(){
        return new ResponseEntity<>(iStatusService.findAll(),HttpStatus.ACCEPTED);
    }

    @PostMapping("/status")
    public ResponseEntity<?> createStatus(@RequestBody Status status) {
        iStatusService.save(status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/status/{idStatus}")
    public ResponseEntity<?> edit(@PathVariable int idStatus,@RequestBody Status status) {
        status.setId(idStatus);
        iStatusService.save(status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
