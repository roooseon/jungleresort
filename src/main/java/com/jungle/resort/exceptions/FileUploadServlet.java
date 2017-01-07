package com.jungle.resort.exceptions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "fileUploadServlet", urlPatterns = {"/addroom"})
@MultipartConfig(location= "/tmp",
                 fileSizeThreshold=0,    
                 maxFileSize=5242880,       // 5 MB
                 maxRequestSize=20971520)   // 20 MB
public class FileUploadServlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //handle file upload
    } 
    
}