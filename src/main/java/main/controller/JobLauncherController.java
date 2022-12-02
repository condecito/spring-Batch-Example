package main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class JobLauncherController {
    @Autowired
    private DefaultLinker linker;

    @GetMapping("/start")
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // linker = new DefaultLinker();

       return (linker.executeJob());
    }
}
