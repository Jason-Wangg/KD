package com.beta.jason.kd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.beta.jason.kd.R;
import com.beta.jason.kd.tools.KDLog;

import java.util.List;

/**
 * Created by Jason on 1/5/2016.
 */
public class HistoryAdapter extends BaseAdapter {
    private Context context;
    private List<KDLog> datalist;

    public HistoryAdapter(Context context, List<KDLog> list) {
        this.context = context;
        this.datalist = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_history,null);
        TextView company_name = (TextView) itemView.findViewById(R.id.company_name);
        TextView number = (TextView) itemView.findViewById(R.id.item_number);
        TextView company_code = (TextView)itemView.findViewById(R.id.company_code);
        number.setText(datalist.get(position).getId());
        company_code.setText(datalist.get(position).getComId());
        company_name.setText(datalist.get(position).getComName());
        return itemView;
    }
    @Override
    public int getCount() {
        if (datalist == null){
            return 0;
        }
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public void setDatalist(List<KDLog> datalist){
        this.datalist = datalist;
    }


}
