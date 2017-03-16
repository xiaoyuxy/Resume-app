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

public class Project  extends Activity{
    private ImageView pro;
    private TextView projects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = this.getIntent().getExtras().getString("url");
        String project = this.getIntent().getExtras().getString("project");

        setContentView(R.layout.menu_project);
        pro = (ImageView) findViewById(R.id.pro);
        Picasso.with(this)
                .load(url)
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(pro);
        projects = (TextView) findViewById(R.id.projects);
        projects.setText(project);
    }
}
