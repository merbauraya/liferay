package com.plexobject.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class IoUtil {
    public static String readUrl(String uri) throws IOException {
        URL url = new URL(uri);
        InputStream in = url.openConnection().getInputStream();
        return read(in);
    }

    public static String read(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        in.close();
        return sb.toString();
    }

    private IoUtil() {
    }
}
