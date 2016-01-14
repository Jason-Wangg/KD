package com.beta.jason.kd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.beta.jason.kd.adapter.ResultAdapter;
import com.beta.jason.kd.tools.ResultBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jason on 1/5/2016.
 */
public class ShowResult extends AppCompatActivity {
    private ListView lv;
    private ResultAdapter adapter;
    private List<ResultBean.ListEntity> rs = new ArrayList<ResultBean.ListEntity>();
    private boolean sort_up = true;
    private int status = 0;
    private static final int STATU_ON_PASSAGE=0;
    private static final int STATU_RECEIVED=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_show_result);
        initView();
    }

    public void initView(){
        lv = (ListView) findViewById(R.id.list_result);
        lv.setAdapter(adapter);
        parse(getIntent().getExtras().getString("jsonstr"));

    }

    private void parse(String jsonStr) {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<ResultBean.ListEntity>>(){}.getType();
            JSONObject re= new JSONObject(jsonStr);
            JSONObject obj = re.getJSONObject("result");
            if (re.get("resultcode").equals("200")){
                rs=gson.fromJson(obj.getString("list"),type);
                Log.e("RS",rs.toString());
                Collections.reverse(rs);
                status = Integer.parseInt(obj.get("status").toString());
                adapter= new ResultAdapter(ShowResult.this,rs,sort_up,status);
                lv.setAdapter(adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
