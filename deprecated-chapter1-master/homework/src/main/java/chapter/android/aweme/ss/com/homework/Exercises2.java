package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int)每个数量的类型 #getChildCount()：获得所有数量}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_chatroom,null);
        setContentView(inflate);

        TextView tv1 = findViewById(R.id.tv_content_info);
        tv1.setText("View个数为"+getViewCount(inflate));
    }

    public static int getViewCount(View view) {
        int viewCount = 1;
        if(!(view instanceof ViewGroup)){
            return viewCount;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int total = viewGroup.getChildCount();
        for(int i = 0; i < total; i++) {
            viewCount = viewCount + getViewCount(viewGroup.getChildAt(i));
        }
        return viewCount;
    }
}
