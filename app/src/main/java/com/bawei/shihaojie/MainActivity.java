package com.bawei.shihaojie;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.List;

import adapter.MyAdapter;
import app.App;
import base.MyBaseActivity;
import bean.MyContent;
import bean.MyJson;
import contract.Mycontract;
import mvp.MyPresent;
import nuli.MyNuil;
import view.SearchView;

public class MainActivity extends MyBaseActivity implements Mycontract.iView {
    private static final String TAG = "MainActivity";
    private SearchView searchView;
    private ImageView mainImage;
    private MyPresent myPresent;
    //private RecyclerView mainRecyler;

    private GridView mainGrid;
    private List<MyContent> content;

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mainImage = findViewById(R.id.main_image);
        mainGrid = findViewById(R.id.main_grid);

    }

    @Override
    public void initListener() {
        mainGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("pic_big",content.get(i).getPic_big());
                intent.putExtra("author",content.get(i).getAuthor());
                intent.putExtra("title",content.get(i).getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

        myPresent = new MyPresent(MainActivity.this);
        String path = "http://blog.zhaoliang5156.cn/baweiapi/searchmusic?kword=%E6%AC%A7%E7%BE%8E%E9%87%91%E6%9B%B2%E6%A6%9C";
        myPresent.doPresentGet(path);

        searchView = new SearchView(App.context);
        searchView.onSetSearchBack(new SearchView.SearchBack() {
            @Override
            public void onSearch(String str) {
                Log.d(TAG, "onSearch: " + str);
            }
        });

        /*GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        mainRecyler.setLayoutManager(layoutManager);*/

    }
    private MyAdapter myAdapter;
    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        MyJson myJson = gson.fromJson(json, MyJson.class);
        //顶部图片
        String pic_s192 = myJson.getPic_s192();
        MyNuil.getInstance().doImage(pic_s192, mainImage);


        content = myJson.getContent();
        myAdapter = new MyAdapter(MainActivity.this, content);
        mainGrid.setAdapter(myAdapter);


    }

    @Override
    public void onError(String mag) {

    }
}
