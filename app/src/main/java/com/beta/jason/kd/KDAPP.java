package com.beta.jason.kd;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.beta.jason.kd.tools.KDLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 1/5/2016.
 */
public class KDAPP extends Application{

    public static List<KDLog> logs=new ArrayList<KDLog>();
    Type type = new TypeToken<List<com.beta.jason.kd.tools.KDLog>>(){}.getType();

    SharedPreferences.Editor editor;
    SharedPreferences sp=getSharedPreferences("log", MODE_PRIVATE);
    editor = sp.edit();
    @Override
    public void onCreate() {
        super.onCreate();

        List<KDLog> list = new Gson().fromJson(sp.getString("logs",""),type);
        if (null!=list){
            logs.addAll(list);
        }
    }
    public  void addLog(KDLog log){
        boolean contains = false;
        for (KDLog l:logs){
            if (l.getNo().equals(log.getNo())){
                contains = true;
                break;
            }
        }
        if (!contains){
                logs.add(log);
            Context context = null;
                Log.e("LOGGG", new Gson().toJson(logs));
                editor.putString("logs", new Gson().toJson(logs) );
                editor.commit();
                Log.e("LOGGGG","AAADDDDD");
            }
    }
    public static void removeLog(KDLog log){
        logs.remove(log);
        editor.putString("logs",new Gson().toJson(logs));
        editor.commit();
    }
}
