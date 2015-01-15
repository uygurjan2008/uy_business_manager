package com.uyghur.ruzi.resource;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ServletUpload extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        //m=servletFileUpload.isMultipartContent(request);
       // MultipartRequest m = new MultipartRequest(request, "e:/file");
        out.print("File Successfully Uploaded");
    }
}