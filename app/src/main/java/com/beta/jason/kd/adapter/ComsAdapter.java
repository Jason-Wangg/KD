package com.beta.jason.kd.adapter;

/**
 * Created by Jason on 1/5/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.beta.jason.kd.R;

/**
 * {
 "resultcode":"200",
 "reason":"成功的返回","result":[
 {"com":"顺丰","no":"sf"},
 {"com":"申通","no":"sto"},
 {"com":"圆通","no":"yt"}
 ,{"com":"韵达","no":"yd"},
 {"com":"天天","no":"tt"},
 {"com":"EMS","no":"ems"},
 {"com":"中通","no":"zto"},
 {"com":"汇通","no":"ht"},
 {"com":"全峰","no":"qf"},
 {"com":"德邦","no":"db"}],
 "error_code":0
 }
 */
public class ComsAdapter extends BaseAdapter{
    private Context context;
    String[] companyCodes;
    String[] companyNames;

    public ComsAdapter(Context context, String[] companyCodes, String[] companyNames) {
        this.context = context;
        this.companyCodes = companyCodes;
        this.companyNames = companyNames;
    }

    @Override
    public int getCount() {
        if (companyCodes==null){
            return 0;
        }
        return companyCodes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_coms,null);
        TextView company_name= (TextView) itemView.findViewById(R.id.company_item_name);
        TextView company_code = (TextView) itemView.findViewById(R.id.company_item_code);
        company_name.setText(companyNames[position]);
        company_code.setText(companyCodes[position]);
        return itemView;
    }
}
