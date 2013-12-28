package com.plexobject.web.service;
import javax.servlet.http.*;
import java.io.*;

public interface ProxyService {
    public void render(HttpServletRequest request,  HttpServletResponse response) throws IOException ;
    public void submit(HttpServletRequest request,  HttpServletResponse response) throws IOException ;
}
