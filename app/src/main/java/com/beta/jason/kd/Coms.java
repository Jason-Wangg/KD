package com.beta.jason.kd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.beta.jason.kd.adapter.ComsAdapter;

/**
 * Created by Jason on 1/6/2016.
 */
public class Coms extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView lv;
    private ComsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initView();
    }

    private void initView() {
        setContentView(R.layout.act_coms);
        lv = (ListView) findViewById(R.id.coms_listView);
        adapter = new ComsAdapter(this,companyCodes,companyNames);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it=new Intent();
        it.putExtra("comName", companyNames[position]);
        it.putExtra("comId", companyCodes[position]);
        setResult(RESULT_OK, it);
        onBackPressed();
    }
}
