package com.beta.jason.kd.tools;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * Created by Jason on 1/4/2016.
 * http://v.juhe.cn/exp/index?key=key&com=sf&no=575677355677
 */

/**
 * juhe's api is no longer be supported
 */
public class ConnHelper {
    static String KEY = "eae61b766244e496073b39b7a3d9fa2d";
//    static String COM_HOST = "http://v.juhe.cn/exp/com";
    static String API_HOST = "http://avatar";
    static HttpUtils httpUtils = new HttpUtils();
    public static void search(final String com,final String no, final Handler handler){
        StringBuffer sb = new StringBuffer();
        sb.append(API_HOST).append("?key=").append(KEY).append("&com=").append(com).append("&no=").append(no);
        String url = sb.toString();
        httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> res) {
                Message msg = new Message();
                msg.what = 0;
                msg.obj = res.result;
                Log.e("RESULT",msg.obj.toString());
                handler.sendMessage(msg);
                //Log.e("errot",msg.obj.toString());
            }
            @Override
            public void onFailure(HttpException e, String s) {
                Message msg = new Message();
                msg.what = -1;
            }
        });
    }

}
