package com.bgstation0.android.sample.wv.wvt_;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class SubActivity extends Activity {

	// Activityが作成された時.
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
       
        // URLなどを取得.
        Intent intent = getIntent();	// intentを取得.
        Bundle bundle = intent.getExtras();	// bunfleを取得.
        String url = null;	// urlをnullで初期化.
        if (bundle != null){	// bundleがnullでない.
        	url = bundle.get("url").toString();	// urlを取得.
        }
        // urlが指定されていればWebViewでロード.
        WebView webView = (WebView)findViewById(R.id.webview);	// webViewを取得.
        Activity mainActivity = getParent();	// LocalActivityManagerによる埋め込みの場合だけかしれないが, getParentで呼び出し元というか埋め込み元のmainActivityが取れる.
        webView.setWebViewClient(new CustomWebViewClient(this, mainActivity));	// CustomWebViewClientをセット.
        webView.setWebChromeClient(new CustomWebChromeClient(this, mainActivity));	// CustomWebChromeClientをセット.
        webView.getSettings().setJavaScriptEnabled(true);	// JavaScriptを有効.
        webView.getSettings().setSupportMultipleWindows(true);	// 複数ウィンドウを有効.
        if (url != null && !url.equals("")){	// urlがnullでない, かつ, urlが""でない.
        	webView.loadUrl(url);	// webView.loadUrlでurlをロード.
        }
        
	}
	
}