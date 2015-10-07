package com.dtaliance.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.Environment;
import android.util.Log;

import com.dtaliance.file.StoreFileToSD;

public class HttpDownloader {
	
	public String download(String httpUrl, String upString){
		HttpClient httpClient = new DefaultHttpClient();
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("param", upString));
		
		String param = URLEncodedUtils.format(params, "utf-8");
		
		try {
			HttpPost postMethod = new HttpPost(httpUrl + upString);
			postMethod.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			HttpResponse httpResponse = httpClient.execute(postMethod);
			Log.i("test", "resCode = " + httpResponse.getStatusLine().getStatusCode());
			Log.i("test", "res = " + EntityUtils.toString(httpResponse.getEntity(), "utf-8"));
			return EntityUtils.toString(httpResponse.getEntity(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public String DownloadString(String httpUrl, String uploadString) {
		String downString = "";
		try {
			URL url = new URL(httpUrl);
			byte[] upBytes = uploadString.getBytes();
			byte[] downBytes = DownloadBytes(url, upBytes);
			downString = new String(downBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return downString;
	}

	public byte[] DownloadBytes(URL httpUrl, byte[] upBytes) {
		int TimeOut = 250;
		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) httpUrl.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setConnectTimeout(TimeOut * 10 * 10);
			urlConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			urlConnection.setRequestProperty("Content-Length",
					String.valueOf(upBytes.length));

			BufferedOutputStream out = new BufferedOutputStream(
					urlConnection.getOutputStream());
			out.write(upBytes);
			out.flush();
			out.close();

			InputStream in = new BufferedInputStream(
					urlConnection.getInputStream());
			int Size = 1024;
			int len = 0;
			byte[] downBytes;

			if (in instanceof ByteArrayInputStream) {
				Size = in.available();
				downBytes = new byte[Size];
				len = in.read(downBytes, 0, Size);
			} else {
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				downBytes = new byte[Size];
				while ((len = in.read(downBytes, 0, Size)) != -1) {
					byteOut.write(downBytes, 0, len);
				}
				downBytes = byteOut.toByteArray();
			}

			in.close();
			return downBytes;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			urlConnection.disconnect();
		}

		return null;
	}

	public String downloadFile(String urlStr, String fileName) {
		String line = "";
		StringBuffer sb = new StringBuffer();

		try {
			URL url = new URL(urlStr);

			// 建立一个http链接
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setConnectTimeout(250 * 10 * 10);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			
			// IO读取数据
			InputStream inputStream = connection.getInputStream();
			
			
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
				StoreFileToSD fileToSD = new StoreFileToSD();
//				fileToSD.writeSD("txt/", fileName, inputStream);
				
				File fileNameNew = Environment.getExternalStorageDirectory();
				int length;
				int size = 1024;
				byte[] buffer = new byte[size];
				
				File writeFileNew = new File(fileNameNew, "1.txt");
				FileOutputStream outputStream = new FileOutputStream(writeFileNew);
				
				while((length = inputStream.read(buffer, 0, size)) != -1){
					outputStream.write(buffer, 0, size);
				}
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				line = "success";
			} else {
				StoreFileToSD fileToSD = new StoreFileToSD();
				fileToSD.writeSD("", fileName, inputStream);
				line = "error";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			sb.append("error");
		} finally {
		}
		return line;
	}
}
