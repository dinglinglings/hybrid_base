package com.ygs.hybrid_base;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    WebView uiweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiweb = findViewById(R.id.uiWeb);//嵌入对象
        uiweb.addJavascriptInterface(this, "android");//将当前的方法封装成js对象
        // 设置与Js交互的权限
        uiweb.getSettings().setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        uiweb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        uiweb.getSettings().setDomStorageEnabled(true);
        uiweb.getSettings().setAllowFileAccess(true);
        uiweb.loadUrl("http://192.168.3.27:8080/#/historyWeb");
    }

    @JavascriptInterface
    public void toast(String str){
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }
}
