package com.star4droid.skin.composer.utils;

import android.util.Log;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Gdx;

public class AppLogger implements ApplicationLogger {
	@Override
	public void log(String tag, String data) {
		write("log",tag+","+data);
	}

	@Override
	public void log(String tag, String message, Throwable throwable) {
		write("message",tag+", "+ message +","+Log.getStackTraceString(throwable));
	}

	@Override
	public void error(String tag, String error) {
		write("error",tag+", "+error);
	}

	@Override
	public void error(String tag, String message, Throwable throwable) {
		write("error.message",tag+", "+message+", "+Log.getStackTraceString(throwable));
	}

	@Override
	public void debug(String tag, String debug) {
		write("debug",tag+", "+debug);
	}

	@Override
	public void debug(String tag, String message, Throwable throwable) {
		write("debug.message",tag+", "+message+", "+Log.getStackTraceString(throwable));
	}
	
	private void write(String type,String data){
		Gdx.files.external("logs/"+type+".txt").writeString(data+"\n",true);
	}
}