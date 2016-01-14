package com.beta.jason.kd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.beta.jason.kd.R;
import com.beta.jason.kd.tools.ResultBean;

import java.util.List;

/**
 * Created by Jason on 1/5/2016.
 */
public class ResultAdapter extends BaseAdapter {
    private Context context;
    private TextView time;
    private TextView info;
    private List<ResultBean.ListEntity> followList;
    boolean sort_up =true;
    int statu;

    public ResultAdapter(Context context, List<ResultBean.ListEntity> List, boolean f, int s) {
        this.context = context;
        this.followList = List;
        this.sort_up = f;
        this.statu = s;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_result,null);
        ResultBean.ListEntity map = followList.get(position);
        time = (TextView) itemView.findViewById(R.id.item_time);
        time.setText(map.getDatetime());
        info = (TextView) itemView.findViewById(R.id.item_info);
        info.setText(map.getRemark());

        return itemView;
    }

    @Override
    public int getCount() {
        return followList.size();
    }

    @Override
    public Object getItem(int position) {
        return followList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setFollowList(List<ResultBean.ListEntity> followList) {
        this.followList = followList;
    }

    public void setSort_up(boolean sort_up) {
        this.sort_up = sort_up;
    }
}
