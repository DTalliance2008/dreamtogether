package com.dtaliance.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.dtaliance.util.ConstantUtil;

public class fileUtil {
	
	private String SDPATH;
	
	public String getSDPATH(){
		return SDPATH;
	}
	
	public fileUtil(){
		SDPATH = ConstantUtil.FILE_SPEECH;
	}

	public fileUtil(String path){
		SDPATH = path;
	}
	//建立新文件
	public File createFile(String fileName){
		try {
			File file = new File(SDPATH + fileName); 
			file.createNewFile();
			return file;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//简历文件夹
	public File createDir(String dirName){
		File dir = new File(SDPATH + dirName);
		dir.mkdir();
		return dir; 
	}
	
	//判断文件存在
	public boolean isFileExist(String fileName){
		File file = new File(SDPATH + fileName);
		return file.exists();
	}
	
	
	//将数据写入文件中
	public boolean writeSD(String dir, String fileName, InputStream inputStream){
		boolean flag = false;
		OutputStream outputStream=null;
		File file;
		try {
			
//			createDir(dir);
			if(!isFileExist(dir+fileName)){
				file = createFile(dir+fileName);
			} else {
				file = new File(dir+fileName);
				file.delete();
				file = createFile(dir+fileName);
			}
			
			outputStream = new FileOutputStream(file);
			byte[] buffer = new byte[4*1024];
			while((inputStream.read(buffer)) != -1){
				outputStream.write(buffer);
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	//读取文件中的数据
	public String ReadFile(String path){
		String content = null;
		try{
			File file = new File(path);
			FileInputStream inStream = new FileInputStream(file);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = inStream.read(buffer)) != -1){
				byteStream.write(buffer, 0, len);
			}
			content = byteStream.toString();
			byteStream.close();
			inStream.close();
		} catch(Exception e ){
			e.printStackTrace();
		} 
		return content;
		
	}
}
