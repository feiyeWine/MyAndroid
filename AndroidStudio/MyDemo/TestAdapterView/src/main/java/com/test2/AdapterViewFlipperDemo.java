package com.test2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Created by YR on 2015/5/21.
 */
public class AdapterViewFlipperDemo extends Activity implements View.OnClickListener {
    private android.widget.AdapterViewFlipper flipper;
    private Button previous,next,autoPlayer;
    private int[] imagesId = new int[]{
            R.drawable.shuangzi,R.drawable.shuangyu,R.drawable.chunv,
            R.drawable.tiancheng,R.drawable.tianxie,R.drawable.sheshou,
            R.drawable.juxie,R.drawable.shuiping,R.drawable.shizi,
            R.drawable.baiyang,R.drawable.jinniu,R.drawable.mojie
    };
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_adapter_view_flipper);

        flipper = (AdapterViewFlipper)findViewById(R.id.view_flipper);

         previous = (Button)findViewById(R.id.btn_previous);
         next = (Button)findViewById(R.id.btn_next);
         autoPlayer = (Button)findViewById(R.id.btn_palyer);

         previous.setOnClickListener(this);
         next.setOnClickListener(this);
         autoPlayer.setOnClickListener(this);

         BaseAdapter adapter = new BaseAdapter() {
             @Override
             public int getCount() {
                 return imagesId.length;
             }

             @Override
             public Object getItem(int position) {
                 return position;
             }

             @Override
             public long getItemId(int position) {
                 return position;
             }

             @Override
             public View getView(int position, View convertView, ViewGroup parent) {
                 ImageView imageView = new ImageView(AdapterViewFlipperDemo.this);
                 imageView.setImageResource(imagesId[position]);
                 imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                 imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                         ViewGroup.LayoutParams.MATCH_PARENT
                         ));
                 return imageView;
             }
         };
        flipper.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_previous:
                flipper.showPrevious();
                flipper.stopFlipping();
            break;
            case R.id.btn_next:
                flipper.showNext();
                flipper.stopFlipping();
                break;
            case R.id.btn_palyer:
                flipper.startFlipping();
                break;
        }
    }
}
