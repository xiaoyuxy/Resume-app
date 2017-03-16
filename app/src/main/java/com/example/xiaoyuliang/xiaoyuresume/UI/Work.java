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

public class Work extends Activity{
    private ImageView nasa;
    private TextView works;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = this.getIntent().getExtras().getString("url");
        String work = this.getIntent().getExtras().getString("work");

        setContentView(R.layout.menu_work);
        nasa = (ImageView) findViewById(R.id.nasa);
        Picasso.with(this)
                .load(url)
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(nasa);
        works = (TextView) findViewById(R.id.works);
        works.setText(work);
    }
}
