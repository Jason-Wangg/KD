package com.beta.jason.kd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.beta.jason.kd.adapter.HistoryAdapter;
import com.beta.jason.kd.tools.ConnHelper;

/**
 * Created by Jason on 1/5/2016.
 */
public class History extends BaseActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{
    private TextView count;
    private ListView lv;
    private Handler hd;
    private Vibrator vibrator =null;
    private HistoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_history);
        initView();
    }

    private void initView() {
        adapter =new HistoryAdapter(this,KDAPP.logs);
        lv = (ListView) findViewById(R.id.list_history);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
        count = (TextView)findViewById(R.id.count);
        hd=getHandler();
    }
    private Handler getHandler(){
        return new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0){
                    Intent it = new Intent(History.this,ShowResult.class);
                    it.putExtra("jsonstr",msg.obj.toString());
                    startActivity(it);
                }
                if (msg.what==-1){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                }
            }
        };
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ConnHelper.search(KDAPP.logs.get(position).getComId(),KDAPP.logs.get(position).getNo(),hd);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        vibrator= (Vibrator) getApplication().getSystemService(VIBRATOR_SERVICE);
        AlertDialog.Builder builder = new AlertDialog.Builder(History.this);
        builder.setTitle("确认删除？");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                KDAPP.removeLog(KDAPP.logs.get(position));
                adapter.notifyDataSetChanged();
                count.setText("" + KDAPP.logs.size());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
