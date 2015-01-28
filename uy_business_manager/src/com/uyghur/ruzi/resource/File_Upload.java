package com.uyghur.ruzi.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class File_Upload {
private String filename;
private String filepath;
private static String UPLOAD_DIR="D:/video/upload/";
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
	
	String uploaddir=UPLOAD_DIR;
	System.out.println(getFilename()+","+getFilepath());
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
       //jo.put("success", true);
       //jo.put("filename", getFilename());
       //jo.write(arg0)
       
	return "succes";
}
}
