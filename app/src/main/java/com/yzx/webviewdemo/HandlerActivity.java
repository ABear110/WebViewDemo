package com.yzx.webviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.yzx.webviewdemo.util.DialogUtil;

public class HandlerActivity extends Activity {

    private Button handle1, handle2;
    private Handler handler = new Handler();
    private Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.arg1){

                case 0:
                    handlerMessage(0);
                    break;
                case 1:
                    handlerMessage(1);
                    break;
            }
        }
    };

    private void handlerMessage(final int i) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                new DialogUtil(HandlerActivity.this).showDialog("message显示数据" + i);
            }
        };
        handler1.post(runnable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);

        initView();
        initData();
    }

    private void initData() {

        // post 更新UI
        handle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handlerPost();
            }
        });

        // ma 消息传递
        handle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int random = (int) (Math.random() * 100);
                Message message = new Message();
                if(random % 2 != 0)
                    message.arg1 = 0;
                else
                    message.arg1 = 1;
                handler1.sendMessage(message);
            }
        });
    }

    private void handlerPost() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                new DialogUtil(HandlerActivity.this).showDialog("post显示数据");
            }
        };
        handler.post(runnable);
    }

    private void initView() {

        handle1 = findViewById(R.id.handle1);
        handle2 = findViewById(R.id.handle2);
    }



}
