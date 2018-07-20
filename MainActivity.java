package com.example.khangit.project_group3.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.khangit.project_group3.R;
import com.example.khangit.project_group3.adapter.ModelProductAdapter;
import com.example.khangit.project_group3.model.ModelProduct;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewMain;
    NavigationView navigationView;
    ListView listViewMain;
    DrawerLayout drawerLayoutMain;
    ArrayList<ModelProduct> arrayListmodlePro;
    ModelProductAdapter modelProductAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initEvent();
        ActionBar();
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://cellphones.com.vn/media/ltsoft/promotion/hn-banner-xiaomi-mi-mix-2-800x300-px-_1_.jpg");
        mangquangcao.add("http://toidangtin.com/data/images/484901_binh-duong-ban-tra-gop-xiaomi-redmi-note-4x-3gb-32gb-gia-sieu-re_1.jpg");
        for(int i  = 0; i < mangquangcao.size(); i ++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
            viewFlipper.setFlipInterval(5000);
            viewFlipper.setAutoStart(true);

            // animation slide right(activity main)
            Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
            Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
            viewFlipper.setAnimation(animation_slide_in);
            viewFlipper.setAnimation(animation_slide_out);
        }
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);

    }

    private void initControl() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper_activity_main);
        recyclerViewMain = (RecyclerView) findViewById(R.id.recyclerview_activity_main);
        navigationView = (NavigationView) findViewById(R.id.navigationview_activity_main);
        listViewMain = (ListView) findViewById(R.id.listview_activity_main);
        drawerLayoutMain = (DrawerLayout) findViewById(R.id.drawerlayout_activity_main);
        arrayListmodlePro = new ArrayList<>();
        modelProductAdapter = new ModelProductAdapter(arrayListmodlePro, getApplicationContext());
        listViewMain.setAdapter(modelProductAdapter);
    }


    private void initEvent() {
        toolbar.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_activity_main:
                drawerLayoutMain.openDrawer(GravityCompat.START);
                break;
        }
    }
}
