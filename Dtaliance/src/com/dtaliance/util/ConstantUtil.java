package com.dtaliance.util;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;

@SuppressLint("SdCardPath")
public class ConstantUtil {
	public static final String ENCODING_UTF = "UTF-8";
	
	public static final String LOGIN_REQUEST = "/cnpc/system/exeCheck_login.action";
	public static final String REGIST_REQUEST = "/cnpc/system/exeAddUser_regist.action";
	public static final String CHANGEINFO_REQUEST = "/cnpc/system/exeChangeInfo_regist.action";
	//
	public static final String EXTRA_FIRST = "extraFirst";
	public static final String EXTRA_SECOND = "extraSecond";
	public static final Map<String, String> TEAM_CONTENT = new HashMap<String, String>();
	public static final Map<String, String> MY_CONTENT = new HashMap<String, String>();
	
	//数据库表
	public static final String TABLE_NAME = "tb_persist";//
	public static final String TYPE_MUSIC = "music";//
	public static final String TYPE_WORD = "word";
	public static final String TYPE_SPEECH = "speech";
	public static final String TYPE_VIDEO = "video";
	public static final String TABLE_SHARE = "tb_share";//
	public static final String TABLE_REMIND = "remind";
	public static final String DB_NAME = "yiqimengDB";
	public static final String TABLE_FRIEND = "tb_friend";
	public static final String TABLE_USERINFO = "tb_userInfo";
	public static final String TABLE_GROUP = "tb_group";
	
	//文件路径
	public static final String FILE_PATH = "/data/data/com.dtaliance/files/";
	public static final String FILE_SPEECH = "/data/data/com.dtaliance/files/";
	public static final String SD_PATH = "files/";
	public static final String DATA_PATH = "/data/data/com.dtaliance/databases/";

	//应用程序名称
	public static final String APP_NAME = "dreamtogether";
	
	//
	public static final String SUCCESS = "success";
	public static final String FAILED = "failed";
	
	//server 地址
	public static final String URLPATH = "http://192.168.0.237:8080/cloudMarket/system/";

	public static final String FRIST_LEVEL = "firstLevel"; 
	public static final String MIDDLE_LEVEL = "middleLevel"; 
	public static final String TERMINAL_LEVEL = "terminalLevel";
	
	public static final String TASK_ONE = "one";
	public static final String TASK_ONE_PRORITY = "onePrority";
	public static final String TASK_TWO = "two";
	public static final String TASK_TWO_PRORITY = "twoPrority";
	public static final String TASK_THREE = "threePrority";
	public static final String TASK_THREE_PRORITY = "threePrority";

	public static final String DREAM_LEVEL = "dreamLevel";
	public static final String TASK_LEVEL = "taskLevel";
	public static final String TASK_COUNT = "taskCount";
	public static final String FRIST_TITLE = "最初梦想";
	public static final String MIDDLE_TITLE = "中期梦想";
	public static final String TERMINAL_TITLE = "最终梦想";
	
	//颜色
	 public static final String RED = "red";
	 public static final String BLUE = "blue";
	 public static final String TIME_ADD = "timeAdd";
	 public static final String DAY_COLOR = "dayColor";

	 public static final String REMIND_TITLE = "remindTitle";
	 public static final String REMIND_TIME = "remindTime";

	// 
	public static final String TEAM_DREAM = "teamDream";
	public static final String TEAM_FIRST_LEVEL = "teamFirstLevel";
	public static final String TEAM_MIDDLE_LEVEL = "teamMiddleLevel";
	public static final String TEAM_TERMINAL_LEVEL = "teamTerminalLevel";
	public static final String TEAM_NAME = "teamName";
	
	//task
	public static final String TASK_TITLE = "taskTitle";
	//team
	public static final String TEAM_INFO = "teamInfo";
	public static final String TEAM_LEAGUER = "teamLeaguer";	
}
