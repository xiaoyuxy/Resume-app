package com.example.xiaoyuliang.xiaoyuresume.UI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaoyuliang.xiaoyuresume.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


/**
 * Created by xiaoyuliang on 3/10/17.
 */


public class Education extends Activity {
    private ImageView schoolImage;
    private TextView edu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = this.getIntent().getExtras().getString("url");
        String text = this.getIntent().getExtras().getString("edu");

        setContentView(R.layout.menu_education);
        schoolImage = (ImageView) findViewById(R.id.schoolImage);
        Picasso.with(this)
                .load(url)
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(schoolImage);
        edu = (TextView) findViewById(R.id.edu);
        edu.setText(text);
    }


}
