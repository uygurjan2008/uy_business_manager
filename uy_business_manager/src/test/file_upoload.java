package test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class file_upoload_a
 */
@WebServlet("/file_upoload")
public class file_upoload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String UPLOAD_DIR="D:/video/upload/";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public file_upoload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filepath=request.getParameter("filepath");
		String filename=request.getParameter("filename");
		String uploaddir=UPLOAD_DIR;
		System.out.println(filename+","+filepath);
		RandomAccessFile fromFile = new RandomAccessFile(filepath, "rw"); 
	       FileChannel      fromChannel = fromFile.getChannel(); 
	      System.out.println("fromChannel"+fromChannel.toString());
	       RandomAccessFile toFile = new RandomAccessFile(uploaddir+filename+".jpg", "rw"); 
	       FileChannel      toChannel = toFile.getChannel(); 
	        System.out.println("toChannel:"+toChannel.toString());
	       long position = 0;
	       long count    = fromChannel.size();  
	        
	       fromChannel.transferTo(position, count,toChannel); 
	       
	       
	      
	       
	       
		
		
		
		
	}

}
