package com.example.xiaoyuliang.xiaoyuresume;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaoyuliang.xiaoyuresume.UI.Award;
import com.example.xiaoyuliang.xiaoyuresume.UI.Education;
import com.example.xiaoyuliang.xiaoyuresume.UI.Project;
import com.example.xiaoyuliang.xiaoyuresume.UI.Work;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imgNavHeaderBg, imgProfile, myPhoto, schoolImage;
    private View navHeader;
    private TextView Name, Website,introduce;
    private ArrayList<HashMap<String, String>> resume = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        resume = Resume.getResumeFromFile("resume.json", this) ;

        myPhoto = (ImageView) findViewById(R.id.myPhoto);
        introduce = (TextView) findViewById(R.id.introduction);
        loadHomePage();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navHeader = navigationView.getHeaderView(0);
        Name = (TextView) navHeader.findViewById(R.id.name);
        Website = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        loadNavHeader();
    }

    private void loadHomePage() {

        Picasso.with(this)
                .load(resume.get(0).get("avatar"))
                .resize(128, 128)
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(myPhoto);
        introduce.setText(resume.get(0).get("content"));
    }

    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader() {

        Name.setText(resume.get(1).get("writer"));
        Website.setText(resume.get(1).get("web"));

        Picasso.with(this)
                .load(resume.get(0).get("avatar"))
                .resize(128, 128)
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imgProfile);
        Picasso.with(this)
                .load(resume.get(1).get("background"))
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imgNavHeaderBg);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_education) {
            Intent in=new Intent(MainActivity.this,Education.class);
            in.putExtra("url", resume.get(2).get("url"));
            in.putExtra("edu", resume.get(2).get("detail"));
            startActivity(in);
            return true;
        } else if (id == R.id.nav_work) {
            Intent n=new Intent(MainActivity.this, Work.class);
            n.putExtra("url", resume.get(3).get("url"));
            n.putExtra("work", resume.get(3).get("detail"));
            startActivity(n);
            return true;
        } else if (id == R.id.nav_project) {
            Intent n=new Intent(MainActivity.this, Project.class);
            n.putExtra("url", resume.get(4).get("url"));
            n.putExtra("project", resume.get(4).get("detail"));
            startActivity(n);
            return true;

        } else if (id == R.id.nav_award) {
            Intent n=new Intent(MainActivity.this, Award.class);
            n.putExtra("url", resume.get(5).get("url"));
            n.putExtra("award", resume.get(5).get("detail"));
            startActivity(n);
            return true;

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_email) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
