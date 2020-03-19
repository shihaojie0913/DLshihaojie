package com.bawei.shihaojie;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import adapter.MyAdapter;
import adapter.MyAdapter_two;
import base.MyBaseActivity;
import bean.MyContent;
import bean.MyJson;
import contract.Mycontract;
import nuli.MyNuil;

public class Main2Activity extends MyBaseActivity implements Mycontract.iView {

    private String pic_big;
    private String title;
    private String author;
    private ImageView main2Image;
    private TextView main2Text1;
    private TextView main2Text2;
    private MyAdapter_two myAdapter_two;
    @Override
    public int initLayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {

        main2Image = findViewById(R.id.main2_image);
        main2Text1 = findViewById(R.id.main2_text1);
        main2Text2 = findViewById(R.id.main2_text2);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        pic_big = intent.getStringExtra("pic_big");
        title = intent.getStringExtra("title");
        author = intent.getStringExtra("author");

        MyNuil.getInstance().doImage(pic_big,main2Image);
        main2Text1.setText(title);
        main2Text2.setText(author);
    }

    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onError(String mag) {

    }
}
