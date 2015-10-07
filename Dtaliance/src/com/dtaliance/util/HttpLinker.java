package com.dtaliance.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpLinker {
	public String postString(String httpUrl, String uploadString){
		return postString(httpUrl, uploadString,0);
	}
	
	public String postString(String httpUrl, String uploadString, int flag){
		String downloadString = null;
		try {
			URL url = new URL(httpUrl);
			uploadString = "?userName=pit&passwd=123";
			byte[] uploadBytes = uploadString.getBytes();
			byte[] downloadBytes = postByteArray(url, uploadBytes, flag);
			downloadString = downloadBytes.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return downloadString;
	}

	public byte[] postByteArray(URL url, byte[] uploadBytes, int flag) {
		byte[] downloadBytes=null;
		final int TIMELIMIT = 250;
		HttpURLConnection urlConnection = null;
		
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestProperty("content-type", "text/html"); 
			
			if (flag == 0) {
				urlConnection.setConnectTimeout(TIMELIMIT * 100);
			} else {
				urlConnection.setConnectTimeout(TIMELIMIT * 500);
			}
			urlConnection.connect();

			// output data
//			BufferedOutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
//			outputStream.write(uploadBytes);
//			outputStream.flush();
//			outputStream.close();
			
			//input data 
			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
			int size = 1024;
			int len;
			
			if(in instanceof ByteArrayInputStream){ 
				size = in.available();
				downloadBytes = new byte[size];
				len = in.read(downloadBytes, 0, size);
			} else {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				downloadBytes = new byte[size];
				while((len = in.read(downloadBytes, 0, size)) != -1){
					bos.write(downloadBytes, 0, len);
				}
				downloadBytes = bos.toByteArray();
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			urlConnection.disconnect();
		}
		return downloadBytes;
	}
}
