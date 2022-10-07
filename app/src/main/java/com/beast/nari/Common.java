package com.beast.nari;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Common {

    public static String getBaseUrl(){
        return "https://biochemical-damping.000webhostapp.com/nari/";
    }

    public static String ConvertToString(Uri uri, ContentResolver resolver, Context context) {

        String Document = "xyz";
        try {

            InputStream in = resolver.openInputStream(uri);
            byte[] bytes = getBytes(in);

            Document = Base64.encodeToString(bytes, Base64.DEFAULT);

        } catch (Exception e) {
            Toast.makeText(context, "Please select a image\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return Document;

    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }



}
