package com.bgstation0.android.sample.view.onlongclicklistener_;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	// メンバフィールドの定義
	Context context = null;	// Context型contextをnullに初期化.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // contextの取得.
        context = this;	// contextにthisをセット.
        
        // button1オブジェクトを取得し, OnClickListenerをセット.
        Button button1 = (Button)findViewById(R.id.button1);	// findViewByIdでR.id.button1のButtonを取得し, button1に格納.
        button1.setOnClickListener(new View.OnClickListener() {	// button1.setOnClickListenerでView.OnClickListenerの匿名クラスを定義し, インスタンスを渡す.
			
        	// クリックされた時.
			@Override
			public void onClick(View v) {	// onClickの定義(オーバーライド)
				// TODO Auto-generated method stub
				Toast.makeText(context, "Clicked!", Toast.LENGTH_LONG).show();	// Toastで"Clicked!"を表示.
			}
		});
        // button1オブジェクトにOnLongClickListenerをセット.
        button1.setOnLongClickListener(new View.OnLongClickListener() {	// button1.setOnLongClickListenerでView.OnLongClickListenerの匿名クラスを定義し, インスタンスを渡す.
        	
			// 長押しされた時.
			@Override
			public boolean onLongClick(View v) {	// onLongClickの定義(オーバーライド)
				// TODO Auto-generated method stub
				Toast.makeText(context, "Long Clicked!", Toast.LENGTH_LONG).show();	// Toastで"Long Clicked!"を表示.
				return false;	// falseだとOnClickも発生.
			}
		});
    }
}