package com.example.zyh.mediastore;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,3);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
          if(resultCode==RESULT_OK)
          {
              System.out.println(data.getData());
              Uri uri=data.getData();
              if(DocumentsContract.isDocumentUri(this,uri)){
                  System.out.print("ttt");
              }
              System.out.println(uri.getAuthority());
              System.out.println(uri.getScheme());
              System.out.println(uri.getPath());
              System.out.println(MediaStore.MediaColumns.DATA);
              System.out.println(MediaStore.Images.Media.DATA);
              System.out.println(MediaStore.Files.FileColumns.DATA);
              System.out.println(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
              System.out.println(MediaStore.Files.getContentUri("external"));
              System.out.println(MediaStore.Images.Media.getContentUri("external"));
              System.out.println(MediaStore.Audio.Media.getContentUri("external"));



              Cursor cursor=getContentResolver().query(MediaStore.Files.getContentUri("external"),null, MediaStore.Images.Media.DATA +"=?",new String[]{"/storage/emulated/0/shumei.txt"},null);

              if(cursor!=null)
              {
                  if(cursor.moveToFirst())
                  {
                      String path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                      System.out.println("hello ");
                      System.out.println(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.SIZE)));
                      System.out.println(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.SIZE)));
                      System.out.println(path);
                  }
              }
              if(cursor==null)
              {
                  System.out.println("null cursor");
              }

          }
    }
}
