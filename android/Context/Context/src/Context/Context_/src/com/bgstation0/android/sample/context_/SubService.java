/**
 * 
 */
package com.bgstation0.android.sample.context_;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * @author B.G
 *
 */
public class SubService extends Service {

	// タグの定義
	private final String TAG = "SubService";	// TAGは"SubService"
		
	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	// サービスが生成されたとき
	@Override
	public void onCreate(){	// onCreateの定義
		
		// 親クラスの既定処理
		super.onCreate();	// super.onCreateで親クラスの既定処理.
		
		// Toastでthisの内容を文字列にしたものを表示.
     	Toast.makeText(this, this.toString(), Toast.LENGTH_LONG).show();
     	
		// ログの表示
		Log.v(TAG, "onCreate()");	// Log.vで"onCreate()"を表示.
		
	}
			
	// サービスの開始要求を受けたとき
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){	// onStartCommandの定義
		
		// ログの表示
		Log.v(TAG, "onStartCommand()");	// Log.vで"onStartCommand()"を表示.
		
		// 戻り値を返す.
		return START_STICKY;	// 戻り値にSTART_STICKYを指定.(サービスが強制終了した時, 再起動する設定.)

	}
			
	// サービスが破棄されたとき
	@Override
	public void onDestroy(){	// onDestroyの定義
		
		// 親クラスの既定処理
		super.onDestroy();	// super.onDestroyで親クラスの既定処理.
				
		// ログの表示
		Log.v(TAG, "onDestroy()");	// Log.vで"onDestroy()"を表示.
		
	}
		
}
