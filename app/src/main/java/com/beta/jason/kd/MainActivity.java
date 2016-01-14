package com.beta.jason.kd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.beta.jason.kd.tools.ConnHelper;

public class MainActivity extends BaseActivity implements OnClickListener{
    private boolean isBack=false;
    private long downTime;
    private Button search;
    private int com_req = 99;
    private String comName = "";
    private String comId = "";
    private EditText no;
    private Button currCom;
    private ImageButton history;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==com_req){
                currCom.setText(data.getExtras().getString("comName"));
                comId=data.getExtras().getString("comId");
                comName=data.getExtras().getString("comName");
            }
        }
    }

    private Handler hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        comName = companyNames[0];
        comId = companyCodes[0];
        no = (EditText) findViewById(R.id.editText);
        currCom= (Button) findViewById(R.id.currCom);
        history = (ImageButton) findViewById(R.id.history);

        search=(Button)findViewById(R.id.button);
        currCom.setOnClickListener(this);
        search.setOnClickListener(this);
        history.setOnClickListener(this);
        currCom.setText(comName);
//        Log.i("current", currCom.getText().toString());
//        Log.i("currID",comId);
        hd=getHandler();

    }
    @Override
    public void onClick(View v){
        if(v==currCom){
            startActivityForResult(new Intent(MainActivity.this, Coms.class), com_req);

        }
        if(v==search){
            ConnHelper.search(comId,no.getText().toString(), hd);
            Log.i("SEARCH", comId + no.getText().toString());
        }
        if (v == history){
            startActivity(new Intent(MainActivity.this,History.class));
        }
    }

    private Handler getHandler(){
        return new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0){
//                    KDLog log = new KDLog();
//                    log.setComName(comName);
//                    log.setComId(comId);
//                    log.setNo(no.getText().toString());
//                  new KDAPP().addLog(log);
                    Intent it = new Intent(MainActivity.this,ShowResult.class);
                    it.putExtra("jsonstr",msg.obj.toString());
                    startActivity(it);
                }
                if (msg.what==-1){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                }
            }
        };
    }


}
