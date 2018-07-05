package com.bgstation0.android.sample.wv.wvt_;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;

public class CustomWebChromeClient extends WebChromeClient {

	// メンバフィールドの定義
	private Context mContext;	// Context型mContext
	private MainActivity mMainActivity;	// mMainActivity.
	
	// コンストラクタ
	public CustomWebChromeClient(Context context, Activity mainActivity){
		
		// メンバの初期化
		mContext = context;	// 引数のcontextをメンバのmContextにセット.
		mMainActivity = (MainActivity)mainActivity;	// mainActivityをセット.
		
	}
	
	// ウィンドウ作成時.
	@Override
	public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, Message resultMsg){
		
		// SubActivity(2)の作成.
        Intent intent2 = new Intent(mMainActivity, SubActivity.class);	// intent2の作成.
        intent2.putExtra("id", "tab2");	// "id"をキー, "tab2"を値として登録.
        intent2.putExtra("url", "");	// "url"をキー, ""を値として登録.
        mMainActivity.mWindow2 = mMainActivity.mLAM.startActivity("tab2",  intent2);
        // mainContentViewとdecorView2を取得しておく.
        FrameLayout mainContentView = (FrameLayout)mMainActivity.findViewById(android.R.id.content);	// android.R.id.contentを取得.        
        View decorView2 = mMainActivity.mWindow2.getDecorView();	// decorView2の取得.
        // WebView情報の送信.
        WebView newWebView = (WebView)decorView2.findViewById(R.id.webview);	// 新しいWebViewを取得.
        WebView.WebViewTransport transport = (WebView.WebViewTransport)resultMsg.obj;	// transportを取得.
        transport.setWebView(newWebView);	// newWebViewをセット.
        resultMsg.sendToTarget();	// 送信.
        // mainContentViewは削除して, いったんsetContentViewしなおしてから, flを取得し, そこにdecorView2を追加.
        mainContentView.removeAllViews();	// 全部削除.
        mMainActivity.setContentView(R.layout.activity_main);
        FrameLayout fl = (FrameLayout)mMainActivity.findViewById(R.id.frame_main);	// flを取得.
        fl.addView(decorView2);	// fl.addViewでdecorView2を追加.
        return false;	// falseを返す.
        
	}
	
}