package com.uyghur.ruzi.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

public class File_Upload {
private String filename;
private String filepath;
private String savePath="upload/";
private static String UPLOAD_DIR="upload/";
public static String getUPLOAD_DIR() {
	HttpServletRequest req= ServletActionContext.getRequest();
	
	 String dir=ServletActionContext.getServletContext().getInitParameter("upload");
	 dir="d:/video/";
	 System.out.println("dir"+dir);
	
	return dir;
}
public static void setUPLOAD_DIR(String uPLOAD_DIR) {
	UPLOAD_DIR = uPLOAD_DIR;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getFilepath() {
	return filepath;
}
public void setFilepath(String filepath) {
	this.filepath = filepath;
}
public String execute() throws IOException{
	
	upload_by_txt();
	return "success";
}
public String upload_by_txt() throws IOException {
	System.out.println("getUPLOAD_DIR()"+getUPLOAD_DIR());
	String uploaddir=getUPLOAD_DIR();
	System.out.println(getFilename()+","+getFilepath());
	System.out.println("uploaddir::"+uploaddir);
	HttpServletRequest req= ServletActionContext.getRequest();
	HttpServletResponse res= ServletActionContext.getResponse();
	
	String path=req.getRealPath(getFilename());
	System.out.println("real path:"+path);
	//RandomAccessFile fromFile = new RandomAccessFile("D://video//1.jpg", "rw"); 
    
	RandomAccessFile fromFile = new RandomAccessFile(getFilepath(), "rw"); 
	
       FileChannel      fromChannel = fromFile.getChannel(); 
      System.out.println("fromChannel"+fromChannel.toString());
       RandomAccessFile toFile = new RandomAccessFile(uploaddir+getFilename()+".jpg", "rw"); 
       FileChannel      toChannel = toFile.getChannel(); 
        System.out.println("toChannel:"+toChannel.toString());
       long position = 0;
       long count    = fromChannel.size();  
        
       fromChannel.transferTo(position, count,toChannel); 
       
       JSONObject jo=new JSONObject();
       jo.put("success", true);
       jo.put("filename", path);
       jo.put("uploaddir", uploaddir);
       
       
       System.out.println("json:"+jo.toString());
       jo.write(res.getWriter());
	
	return "success";
} 

public String upload() throws IOException {
	HttpServletRequest req= ServletActionContext.getRequest();
	HttpServletResponse resp= ServletActionContext.getResponse();
	System.out.println("savePath:"+savePath+",req.getPathInfo():"+req.getPathInfo());
	
	File loadFile = new File(savePath, req.getPathInfo());
	
	String rs="";
	if(loadFile.isFile()){
		long lastModified = loadFile.lastModified();
		lastModified = lastModified - lastModified % 1000;
		String etag = String.format("W/\"%s-%s\"", loadFile.length(), lastModified);
		resp.setHeader("ETag", etag);
		resp.setDateHeader("Last-Modified", lastModified);
		long modifiedSince = req.getDateHeader("If-Modified-Since");
		String noneMatchEtag = req.getHeader("If-None-Match");
//		System.out.printf("%s==%s%n", lastModified, modifiedSince);
//		System.out.printf("%s==%s%n", etag, noneMatchEtag);
		if (etag.equals(noneMatchEtag) || modifiedSince == lastModified) {
			resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			 
		}
		
		// ª∫¥Ê¥¶¿Ì
		resp.setContentType(req.getServletContext().getMimeType(req.getPathInfo()));
		
		String uploaddir="upload/";

		String path=req.getRealPath(getFilename());
		System.out.println("real path:"+path);
		//RandomAccessFile fromFile = new RandomAccessFile("D://video//1.jpg", "rw"); 
	    
		RandomAccessFile fromFile = new RandomAccessFile(getFilepath(), "rw"); 
		
	       FileChannel      fromChannel = fromFile.getChannel(); 
	      System.out.println("fromChannel"+fromChannel.toString());
	       RandomAccessFile toFile = new RandomAccessFile(uploaddir+getFilename(), "rw"); 
	       FileChannel      toChannel = toFile.getChannel(); 
	        System.out.println("toChannel:"+toChannel.toString());
	       long position = 0;
	       long count    = fromChannel.size();  
	        
	       fromChannel.transferTo(position, count,toChannel); 
	       
	       JSONObject jo=new JSONObject();
	       jo.put("success", true);
	       jo.put("filename", path);
	       jo.put("uploaddir", uploaddir);
	       
	       
	       System.out.println("json:"+jo.toString());
	       jo.write(resp.getWriter());
		
		 rs="success";
		 
	}else{
		rs="fail";
	}
	System.out.println("rs:"+rs);
	return rs;
	
  


}
}

