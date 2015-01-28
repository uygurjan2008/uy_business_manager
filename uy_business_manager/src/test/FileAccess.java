package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;


public class FileAccess
{
	private static String UPLOAD_DIR="D:/video/upload/";
	
/*
 public static boolean Move(File srcFile, String destPath)
 {
        // Destination directory
        File dir = new File(destPath);
       
        // Move file to new directory
        boolean success = srcFile.renameTo(new File(dir, srcFile.getName()));
       
        return success;
    }
 */
	 
   public String my_copy(String filepath,String filename,String uploaddir) throws IOException{
	   
	   RandomAccessFile fromFile = new RandomAccessFile(filepath, "rw"); 
       FileChannel      fromChannel = fromFile.getChannel(); 
      System.out.println("fromChannel"+fromChannel.toString());
       RandomAccessFile toFile = new RandomAccessFile(uploaddir+filename+".jpg", "rw"); 
       FileChannel      toChannel = toFile.getChannel(); 
        System.out.println("toChannel:"+toChannel.toString());
       long position = 0;
       long count    = fromChannel.size();  
        
       fromChannel.transferTo(position, count,toChannel); 
       
        System.out.println();
       return "success";
       
       
   }
   
   
   
   public static void main(String[] args) throws IOException {
	   
	   FileAccess fileAccess=new FileAccess();
	   
	   
	   String result=fileAccess.my_copy("D:/video/1.jpg","aaa",UPLOAD_DIR);
	   System.out.println("result:"+result);
}
   
}