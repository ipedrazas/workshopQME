package com.biscuits.pantone;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;

public class FileUtils {

	
	public static String getFileFromAssetsAsString(Context ctx, String filename) throws IOException{
		InputStream is = ctx.getAssets().open(filename);
		int size = is.available();
		byte[] buffer = new byte[size];
		is.read(buffer);
		is.close();
		return new String(buffer);
	}
	
}
