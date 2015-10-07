package com.dtaliance.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources.NotFoundException;

import com.dtaliance.R;

public class DBUtil {
	
	public static boolean getDataBasePath(Context context){
		try {
			String dbPath = ConstantUtil.DATA_PATH + ConstantUtil.DB_NAME;
			
			int size = 1024;
			if(!(new File(dbPath)).exists()){
				File file = new File(ConstantUtil.DATA_PATH);
				file.mkdir();
				InputStream is = context.getResources().openRawResource(R.raw.yiqimeng);
				FileOutputStream fos = new FileOutputStream(dbPath);
				byte[] buffer = new byte[size];
				int count = 0;
				while((count = is.read(buffer)) > 0){
					fos.write(buffer, 0, count);
				}
				
				fos.flush();
				fos.close();
				is.close();
				return true;
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
