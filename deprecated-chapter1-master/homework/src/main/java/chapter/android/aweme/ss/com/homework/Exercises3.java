package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        ListView listView = findViewById(R.id.rv_list);
        listView.setAdapter(new ListViewAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(Exercises3.this, "当前位置" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Exercises3.this, Newpage.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }


    public static class ListViewAdapter extends BaseAdapter{
        private int[] args =
                new int[] {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 7, 8, 9,
                        10,
                        11, 12, 13, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5,
                        7,
                        8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13};


        private Context mContext;

        public ListViewAdapter(Context context) {
            mContext = context;
        }

        @Override public int getCount() {
            return args.length;
        }

        @Override public Object getItem(int position) {
            return null;
        }

        @Override public long getItemId(int position) {
            return 0;
        }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            View view = inflater.inflate(R.layout.activity_tips,null);
//            TextView textView = view.findViewById(R.id.);
            TextView textView;
            if(convertView == null){
            textView = new TextView(mContext);
            }else{
                textView = (TextView) convertView;
            }
            textView.setText(String.valueOf(args[position]));
            textView.setHeight(100);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(18);


            return textView;
        }
    }
}

