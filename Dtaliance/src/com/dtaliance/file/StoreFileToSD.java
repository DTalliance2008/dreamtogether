package com.dtaliance.file;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import android.os.Environment;

import com.dtaliance.util.ConstantUtil;

public class StoreFileToSD {

	private String SDPATH;
	
	public StoreFileToSD(){
		SDPATH = Environment.getExternalStorageDirectory().toString() + "/";
	}
	
	//创建文件
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
	
	//创建文件夹
	public File createDir(String dirName){
		File dir = new File(SDPATH + dirName);
		dir.mkdir();
		return dir; 
	}
	
	//判断文件存在
	public boolean isFileExist(String fileName){
		return new File(SDPATH + fileName).exists();
	}
	
	public boolean deleteFile(String fileName){
		if(isFileExist(fileName)){
			File file = new File(SDPATH + fileName);
			file.delete();
			return true;
		}
		return false;
	}
	
	public boolean writeFileToSD(String fileName, String inputString){
		return writeSD(ConstantUtil.SD_PATH, fileName, new ByteArrayInputStream(inputString.getBytes()));
	}
	
	public boolean writeSD(String dir, String fileName, InputStream inputStream){
		boolean flag = false;
		OutputStream outputStream=null;
		File file;
		try {
			createDir(dir);
			String sdcFileName = dir + fileName; 
			if(isFileExist(sdcFileName)){
				file = new File(SDPATH + sdcFileName);
				file.delete();
			}
			file = createFile(sdcFileName);
			//写入文件内容
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
	
	public String readSD(String fileName){
		StringBuffer content = new StringBuffer(); 
		if(isFileExist(fileName)){
			try {
				FileInputStream fis = new FileInputStream(SDPATH + fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				String line = null;
				while((line = br.readLine()) != null){
					content.append(line);
				}		
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content.toString();
	}
}
