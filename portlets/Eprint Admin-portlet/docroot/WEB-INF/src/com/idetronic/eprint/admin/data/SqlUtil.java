package com.idetronic.eprint.admin.data;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class SqlUtil {
	public static String getSQL(String path) throws Exception
	{
		InputStream in =  SqlUtil.class.getResourceAsStream(path);
		Reader reader = new InputStreamReader(in, "utf-8");
		char[] buf = new char[1024];
		int numRead=0;
		StringBuilder fileData = new StringBuilder();
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
	}

}
