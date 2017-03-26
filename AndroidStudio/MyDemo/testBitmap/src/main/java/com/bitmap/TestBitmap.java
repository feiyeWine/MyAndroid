package com.bitmap;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.canvas.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by YR on 2015/6/4.
 *查看原生资源下的图片查看器
 * //android studio 徐创建assets文件夹
 */
public class TestBitmap extends Activity{
    String images[] = null;
    AssetManager asset = null;
    int currentImg = 0;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_testbitmap);
        image = (ImageView) findViewById(R.id.image_bitmap);
        asset = getAssets();
        try {
            //获取assets目录下所有文件
            images = asset.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Button btn_next = (Button) findViewById(R.id.btn_bitmap);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentImg>=images.length){
                    currentImg = 0;
                }
                while(!images[currentImg].endsWith(".png")&&!images[currentImg].endsWith(".jpg")&&!images[currentImg].endsWith(".gif")){
                    currentImg++;
                    if(currentImg>=images.length){
                        currentImg = 0;
                    }
                }
                InputStream assetStreawm = null;
                try {
                    assetStreawm = asset.open(images[currentImg++]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
                //若未回收，先强制回收
                if(bitmapDrawable!=null&&!bitmapDrawable.getBitmap().isRecycled()){
                    bitmapDrawable.getBitmap().recycle();
                }
                image.setImageBitmap(BitmapFactory.decodeStream(assetStreawm));
            }
        });
    }
}
