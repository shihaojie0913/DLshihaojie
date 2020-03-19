package view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.shihaojie.R;

import app.App;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 */
public class SearchView extends LinearLayout {

    private EditText editText;
    private Button button;
    public SearchView(Context context) {
        super(context);
        init(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       init(context);
    }
    public void init(Context context){
        View view = View.inflate(context, R.layout.search_view_layout,null);
        editText = view.findViewById(R.id.search_edit);
        button = view.findViewById(R.id.search_button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (searchBack!=null){
                    searchBack.onSearch(text);
                }
            }
        });
        addView(view);
    }


    public interface SearchBack{
        void onSearch(String str);
    }

    private SearchBack searchBack;

    public void onSetSearchBack(SearchBack SetsearchBack){
        searchBack = SetsearchBack;
    }


}
