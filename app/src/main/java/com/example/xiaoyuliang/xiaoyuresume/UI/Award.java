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

public class Award extends Activity{
    private ImageView aw;
    private TextView awards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = this.getIntent().getExtras().getString("url");
        String award = this.getIntent().getExtras().getString("award");

        setContentView(R.layout.menu_awards);
        aw = (ImageView) findViewById(R.id.aw);
        Picasso.with(this)
                .load(url)
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(aw);
        awards = (TextView) findViewById(R.id.awards);
        awards.setText(award);
    }
}
