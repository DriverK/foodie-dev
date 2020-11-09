package com.imooc.controller;

import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StuController {

    @Autowired
    private StuService stuService;

    @GetMapping("/getStudInfo")
    public Object getStudInfo(@RequestParam("id") int id) {
        return stuService.getStudInfo(id);
    }

    @PostMapping("/saveStud")
    public Object saveStud() {
         stuService.saveStud();
        return "succ";
    }

    @PostMapping("/deleteStud")
    public Object deleteStud(@RequestParam("id") int id) {
        stuService.deleteStud(id);
        return "succ";
    }

    @PostMapping("/updateStud")
    public Object updateStud(@RequestParam("id") int id) {
        stuService.updateStud(id);
        return "succ";
    }

}
