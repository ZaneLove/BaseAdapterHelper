package com.zanelove.BaseAdapterHelper;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.zanelove.BaseAdapterHelper.Adapter.CommonAdapter;
import com.zanelove.BaseAdapterHelper.ViewHolder.CommonViewHolder;
import com.zanelove.BaseAdapterHelper.bean.MyBean;

public class MyActivity extends Activity {
	private ListView mListView;
    protected List<MyBean> mDatas = new ArrayList<MyBean>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initData();

        mListView = (ListView) findViewById(R.id.lv);

        //设置适配器
        mListView.setAdapter(new CommonAdapter<MyBean>(getApplicationContext(),mDatas,R.layout.item_single_text) {
            @Override
            protected void convert(CommonViewHolder viewHolder, MyBean item) {
            	viewHolder.setImageByUrl(R.id.user_head, item.img_url);
            	viewHolder.setText(R.id.username_tv, item.user_name);
            	viewHolder.setText(R.id.reply_time, item.time);
            	viewHolder.setText(R.id.reply_title, item.content);
            	viewHolder.setText(R.id.reply_from, item.from);
            }
        });
    }

    private void initData() {
        mDatas.add(new MyBean("http://img.wdjimg.com/mms/icon/v1/a/37/a98ed1450b2780da6b85dc87470ae37a_256_256.png","春雨天下","3月16日","春雨医生提供100%真实公立医院医生的在线医疗健康咨询服务。","春雨天下"));
        mDatas.add(new MyBean("http://img13.wealinkcdn.com/photo/company_album/54/90/sbrl9fey2t6bcwf8_750x375.jpg","春雨悦读","3月17日","春雨医生提供100%真实公立医院医生的在线医疗健康咨询服务。","春雨天下"));
        mDatas.add(new MyBean("http://img1.imgtn.bdimg.com/it/u=1474999303,1182434472&fm=21&gp=0.jpg","春雨医生","3月18日","春雨医生提供100%真实公立医院医生的在线医疗健康咨询服务。","春雨天下"));
        mDatas.add(new MyBean("http://img.wdjimg.com/mms/icon/v1/a/37/a98ed1450b2780da6b85dc87470ae37a_256_256.png","春雨育儿医生","3月19日","春雨医生提供100%真实公立医院医生的在线医疗健康咨询服务。","春雨天下"));
        mDatas.add(new MyBean("http://img13.wealinkcdn.com/photo/company_album/54/90/sbrl9fey2t6bcwf8_750x375.jpg","春雨育期医生","3月20日","春雨医生提供100%真实公立医院医生的在线医疗健康咨询服务。","春雨天下"));
    }
}
