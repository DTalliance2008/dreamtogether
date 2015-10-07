package com.dtaliance.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.dtaliance.AsyncTaskWithProgressDialog;
import com.dtaliance.DTActivity;
import com.dtaliance.OutputNoteActivity;
import com.dtaliance.R;
import com.dtaliance.file.StoreFileToSD;
import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.TimeUtil;

public class NoteFragment extends Fragment{

	private ListView listViewNote;
	private File[] fileList;
	private File filePath;
	private int count;
	
    private SimpleAdapter adapterNote = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_note, container, false);
		
		listViewNote = (ListView) view.findViewById(R.id.lv_note_content);
		
		refreshItemView();
		
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
				Dialog dialog = new AlertDialog.Builder(getActivity())
								.setTitle("文件操作")
								.setNegativeButton("取消", new DialogInterface.OnClickListener(){
									public void onClick(DialogInterface dialog, int arg){
//											Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();
									}
								})
								.setItems(R.array.option, new DialogInterface.OnClickListener(){
									public void onClick(DialogInterface dialog, int arg){
										
//											File delFile = new File(ConstantUtil.FILE_PATH+fileList[count].getName());
//											delFile.delete();
//											SetFileListViewItem(ConstantUtil.FILE_PATH);
										StoreFileToSD storeFileToSD = new StoreFileToSD();
										storeFileToSD.deleteFile(ConstantUtil.SD_PATH + fileList[count].getName());
										Toast.makeText(getActivity(), "on option click", Toast.LENGTH_SHORT).show();
										refreshItemView();
									}
								}).create();
				dialog.show();
				
				return true;
			}
		});
		return view;
		
	}
	
	public void refreshItemView(){
		new NoteBackground(getActivity()).execute();
	}
	
	public void goOutputNote(String filename){
		Intent intent = new Intent(getActivity(), OutputNoteActivity.class);
		intent.putExtra("filename", filename);
		startActivity(intent);
	}
	
	public String ReadFile(String path){
		String content = null;
		try{
//			FileInputStream inStream = this.openFileInput(path);
//			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//			byte[] buffer = new byte[1024];
//			int len = 0;
//			while((len = inStream.read(buffer)) != -1){
//				byteStream.write(buffer, 0, len);
//			}
//			content = byteStream.toString();
//			byteStream.close();
//			inStream.close();
		} catch(Exception e ){
			e.printStackTrace();
		} 
		return content;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			goMain();
		}
		return false;
	}
	
	public void goMain(){
		Intent intent = new Intent(getActivity(), DTActivity.class);
		startActivity(intent);
	}
	
	//后台进城
	private class NoteBackground extends AsyncTaskWithProgressDialog {

		public NoteBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@SuppressLint("CommitPrefEdits")
		@Override
		protected String doInBackground2(String... params) {
			
			filePath = new File(Environment.getExternalStorageDirectory() + "/files");
			fileList = filePath.listFiles();
			
			List<HashMap<String, Object>> listItemNoteNew = new ArrayList<HashMap<String,Object>>();
			
			List<String> list = new ArrayList<String>();
			if(fileList != null && fileList.length != 0){
				for(int i=0; i<fileList.length; i++){
					list.add(fileList[i].getName());
					String[] array = TimeUtil.getFileName(fileList[i].getName());
					HashMap<String, Object> map = new HashMap<String, Object>();
					
					if(array != null){
						if(array.length > 1){
							map.put("itemText1", array[1]);
						}
						map.put("itemTitle", array[0]);
					}
					listItemNoteNew.add(map);
				}
			}
			
			adapterNote = new SimpleAdapter(getActivity(), (List<HashMap<String,Object>>)listItemNoteNew, 
				R.drawable.notelist,new String[] {"itemText1","itemTitle"}, new int[] {R.id.tv_notelist_note1,R.id.tv_notelist_title1});
			return ConstantUtil.SUCCESS;
			
		}

		@Override
		protected void onPostExecute2(String result) {
			if (result.equals("success")) {
				Log.d("success", result);
				listViewNote.setAdapter(adapterNote);
			} else {
				Toast.makeText(getActivity(), "打开文件失败", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
}
