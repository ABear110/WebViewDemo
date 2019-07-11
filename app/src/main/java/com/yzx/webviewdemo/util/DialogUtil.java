package com.yzx.webviewdemo.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.yzx.webviewdemo.R;

import static android.content.ContentValues.TAG;

/**
 * @author bear
 * @time 2019/7/9 18:49
 * @project WebViewDemo
 * @class name：com.yzx.webviewdemo.util
 */
public class DialogUtil {

    private Context context;
    private AlertDialog.Builder builder = null;

    public DialogUtil(){

    }
    public DialogUtil(Context context){

        this.context = context;
        builder = new AlertDialog.Builder(context);
    }


    public void showDialog(String str){

        if(builder != null){

            builder.setIcon(R.drawable.ic_launcher_background)
                .setTitle("Handle弹窗")
                .setMessage(str)
                .setPositiveButton("确定", null).show();
        } else {

            Log.w(TAG, "showDialog: 弹窗对象为空");
        }

    }
}
