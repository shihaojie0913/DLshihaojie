package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shihaojie.R;

import java.util.List;

import bean.MyContent;
import nuli.MyNuil;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 */
public class MyAdapter_two extends BaseAdapter {

   private Context context;
   private List<MyContent> list;

    public MyAdapter_two(Context context, List<MyContent> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHand hand;
        if (view == null){
            hand = new ViewHand();
            view = View.inflate(context,R.layout.recycle_layout,null);
            hand.imageView = view.findViewById(R.id.recyler_image);
            hand.textView1 = view.findViewById(R.id.recyler_text1);
            hand.textView2 = view.findViewById(R.id.recyler_text2);
            view.setTag(hand);
        }else {
            hand = (ViewHand) view.getTag();
        }

        hand.textView1.setText(list.get(i).getTitle());
        hand.textView2.setText(list.get(i).getAuthor());
        MyNuil.getInstance().doImage(list.get(i).getPic_big(),hand.imageView);
        return view;
    }

    class ViewHand{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }

}
