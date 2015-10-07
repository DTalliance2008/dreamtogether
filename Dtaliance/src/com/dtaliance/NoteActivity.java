package com.dtaliance;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dtaliance.util.ConstantUtil;

public class NoteActivity extends Activity{

	private ListView listViewNote;
	private File[] fileList;
	private File filePath;
	private int count;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notelist);
		
		listViewNote = (ListView) findViewById(R.id.lv_note_list);
		
		filePath = new File(ConstantUtil.FILE_PATH);
		if(filePath.length() !=0 ){
			
			fileList = filePath.listFiles();
			List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
			for(int i=0;i < fileList.length;i++){
				HashMap<String, Object> hap= new HashMap<String, Object>();
				hap.put("itemText1","记录于："+fileList[i].getName());
				hap.put("itemTitle","笔记");
				listItem.add(hap);
			}
		
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, 
					(List<HashMap<String,Object>>)listItem, 
					R.drawable.notelist,
					new String[] {"itemText1","itemTitle"}, 
					new int[] {R.id.tv_notelist_note1,R.id.tv_notelist_title1});
		
			listViewNote.setAdapter(listItemAdapter);
			listViewNote.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					goOutputNote(fileList[arg2].getName());
				}
			});
			
			listViewNote.setOnItemLongClickListener(new OnItemLongClickListener(){

				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					count = arg2;
					Dialog dialog = new AlertDialog.Builder(NoteActivity.this)
									.setTitle("选择操作")
									.setNegativeButton("取消", new DialogInterface.OnClickListener(){
										public void onClick(DialogInterface dialog, int arg){
											
										}
									})
									.setItems(R.array.option, new DialogInterface.OnClickListener(){
										public void onClick(DialogInterface dialog, int arg){
											File delFile = new File(ConstantUtil.FILE_PATH+fileList[count].getName());
											delFile.delete();
											SetFileListViewItem(ConstantUtil.FILE_PATH);
										}
									}).create();
					dialog.show();
				
					return true;
				}
				
			});
			
		}
		
	}
	
	
	public void SetFileListViewItem(String path){
		
		File filePath = new File(path);
		if(filePath.length() !=0 ){
			fileList = filePath.listFiles();
			for(int i=0;i<fileList.length;i++){
				Log.d("fileName",fileList[i].getName());
			}
			List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
			for(int i=0;i < fileList.length;i++){
				HashMap<String, Object> hap= new HashMap<String, Object>();
				hap.put("itemText1","记录于："+fileList[i].getName());
				hap.put("itemTitle","笔记");
				listItem.add(hap);
			}
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, 
					(List<HashMap<String,Object>>)listItem, 
					R.drawable.notelist,
					new String[] {"itemText1","itemTitle"}, 
					new int[] {R.id.tv_notelist_note1,R.id.tv_notelist_title1});
	
			listViewNote.setAdapter(listItemAdapter);	
		} else {
			
		}
	}
	
	
	
	public void goOutputNote(String filename){
		Intent intent = new Intent(this, OutputNoteActivity.class);
		intent.putExtra("filename", filename);
		startActivity(intent);
		finish();
	}
	
	public String ReadFile(String path){
		String content = null;
		try{
			FileInputStream inStream = this.openFileInput(path);
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
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			Log.d("code","code");
			goMain();
		}
		return false;
	}
	
	public void goMain(){
		Intent intent = new Intent(this, PagerActivity.class);
		startActivity(intent);
		finish();
	}
	
}
