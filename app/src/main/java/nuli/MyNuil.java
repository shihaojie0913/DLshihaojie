package nuli;

import android.os.Handler;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.Map;

import app.App;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 */
public class MyNuil {

    private static MyNuil instance;
    private final RequestQueue requestQueue;
    //volley
    private MyNuil(){
        requestQueue = Volley.newRequestQueue(App.context);
    }
    //单例
    public static MyNuil getInstance() {
        if (instance ==null){
            synchronized (MyNuil.class){
                if (instance==null){
                    instance = new MyNuil();
                }
            }
        }
        return instance;
    }

    public interface MyCallBack{
        void onSuccess(String path);
        void onError(String mag);
    }
    public void doGet(String path, final MyCallBack myCallBack){
        StringRequest request = new StringRequest(0,path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.onError(error.getMessage());
            }
        });
        requestQueue.add(request);
    }

    public void doPost(String path, final Map<String,String> map, final MyCallBack myCallBack){
        StringRequest request = new StringRequest(1,path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(request);
    }


    public void doImage(String path, ImageView imageView){
        Glide.with(App.context).load(path).into(imageView);
    }
}
