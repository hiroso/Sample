package com.bgstation0.android.sample.viewgroup_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SubActivity extends Activity {

	// Activity���쐬���ꂽ��.
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        
        // "onCreate"��tag�̕\��.
        Intent intent = getIntent();	// intent���擾.
        String tag = intent.getStringExtra("tag");	// "tag"�̒l���擾.
        TextView tv = (TextView)findViewById(R.id.textview1);	// tv���擾.
        tv.setText(tag);	// tag���Z�b�g.
        //Toast.makeText(this, "onCreate(" + tag + ")", Toast.LENGTH_LONG).show();	// Toast��"onCreate"��tag��\��.
        
        // WebView�̃��[�h.
        WebView webView = (WebView)findViewById(R.id.webview);	// webView���擾.
        webView.setWebViewClient(new WebViewClient(){
        	// ���[�h����URL���ς������.
        	@Override
        	public boolean shouldOverrideUrlLoading(WebView view, String url){
        		
        		// false��Ԃ���, �K������WebView�ŏ�������悤�ɂȂ�.
        		return false;	// false��Ԃ�.
        		
        	}
        });
        if (tag.equals("test1")){	// "test1"�Ȃ�.
        	webView.loadUrl("https://m.yahoo.co.jp/");	// webView.loadUrl��"https://m.yahoo.co.jp/"���[�h.
        }
        else{	// "test2"�Ȃ�.
        	webView.loadUrl("https://www.google.co.jp/");	// webView.loadUrl��"https://www.google.co.jp/"���[�h.
        }
        
	}
	
	// Activity���J�n���ꂽ�Ƃ�.
	@Override
    protected void onStart(){
    	super.onStart();
    	
    	// "onStart"��tag�̕\��.
        Intent intent = getIntent();	// intent���擾.
        String tag = intent.getStringExtra("tag");	// "tag"�̒l���擾.
        //Toast.makeText(this, "onStart(" + tag + ")", Toast.LENGTH_LONG).show();	// Toast��"onStart"��tag��\��.
        
    }
	
	// Activity���j�����ꂽ�Ƃ�.
	@Override
    protected void onDestroy() {	// onDestroy�̒�`
    	
    	// �e�N���X�̏���
    	super.onDestroy();	// super.onDestroy�Őe�N���X�̊��菈��.
    	
    	// "onDestroy"�̕\��.
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();	// Toast��"onDestroy"��\��.
        
    }
    
    @Override
    protected void onNewIntent(Intent intent){
    	super.onNewIntent(intent);
    	
    	// "onNewIntent"��tag�̕\��.
        String tag = intent.getStringExtra("tag");	// "tag"�̒l���擾.
        //Toast.makeText(this, "onNewIntent(" + tag + ")", Toast.LENGTH_LONG).show();	// Toast��"onNewIntent"��tag��\��.
        
    }
	
}