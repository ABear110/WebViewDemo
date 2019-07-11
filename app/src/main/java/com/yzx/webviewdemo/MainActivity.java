package com.yzx.webviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button webBtn, aboutBtn, handlerBtn;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {

        // 按钮点击事件
        // 跳转到自带（第三方）浏览器中
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                web.loadUrl("http://www.baidu.com");
                web.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return false;
                    }
                });
            }
        });

        // 在WebView控件中显示
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                web.loadUrl("http://www.baidu.com");
                web.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
            }
        });

        handlerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setClass(MainActivity.this, HandlerActivity.class));
            }
        });
    }

    // 获取控件
    private void initView() {

        webBtn = findViewById(R.id.webviewbtn);
        aboutBtn = findViewById(R.id.aboutbtn);
        web = findViewById(R.id.web);
        handlerBtn = findViewById(R.id.handler_btn);
    }
}
