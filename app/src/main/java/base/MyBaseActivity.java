package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 */
public abstract class MyBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initListener();
        initData();
    }

    public abstract int initLayout();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();

}
