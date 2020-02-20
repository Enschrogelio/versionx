package com.androidcss.jsonexample1.activity;

import com.androidcss.jsonexample1.R;
import com.bumptech.glide.Glide;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    private Context context;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String s = getIntent().getStringExtra("key");
        TextView tv = (TextView)findViewById(R.id.image_description);
        tv.setText(s);

        //Intent intent= getIntent();
        String a = getIntent().getStringExtra("image1");
        ImageView imageView = (ImageView) findViewById(R.id.image);


        Glide.with(this)
                .load(a)
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(imageView);
/*
        ImageView tv1 = (ImageView) findViewById(R.id.image);

        Glide.with(DetailsActivity.this).load(getIntent().getStringExtra("IMAGE_URL"))
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(tv1);



        ImageView i = (ImageView) findViewById(R.id.image);
        String imageUrl = getIntent().getStringExtra("IMAGE_URL");
        Glide.with(DetailsActivity.this).load(imageUrl).into(i);
*/


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorAccent)));
        actionBar.setTitle("Postre");



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}






