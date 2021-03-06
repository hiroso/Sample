package com.bgstation0.android.sample.batterymanager_;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	// メンバフィールドの定義.
	Context mContext = null;	// mContextをnullで初期化.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;	// mContextにthisをセット.
    }

    // バッテリー状態を受け取るレシーバー.
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){	// バッテリー状態に変化があった時.
				TextView textview1 = (TextView)((MainActivity)mContext).findViewById(R.id.textview1);	// textview1を取得.
				switch (intent.getIntExtra("status", 0)){	// status取得.
					case BatteryManager.BATTERY_STATUS_FULL:	// 満タン.
						textview1.setText("Full");
						break;
					case BatteryManager.BATTERY_STATUS_CHARGING:	// 充電中.
						textview1.setText("Charging");
						break;
					case BatteryManager.BATTERY_STATUS_DISCHARGING:	// ?.
						textview1.setText("Discharging");
						break;
					case BatteryManager.BATTERY_STATUS_NOT_CHARGING:	// 充電されていない.
						textview1.setText("Not Charging");
						break;
					case BatteryManager.BATTERY_STATUS_UNKNOWN:	// 不明.
						textview1.setText("Unknown");
						break;
				}
			}
		}
    	
    };
    
    @Override
    public void onResume(){
    	super.onResume();
    	// IntentFilterの生成.
    	IntentFilter intentFilter = new IntentFilter();	// intentFilterを生成.
    	// アクションの追加.
    	intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);	// Intent.ACTION_BATTERY_CHANGEDを追加.
    	// レシーバーの登録.
    	registerReceiver(mBroadcastReceiver, intentFilter);	// レシーバー登録.
    }
    
    @Override
    public void onPause(){
    	super.onPause();
    	// レシーバーの解除.
    	unregisterReceiver(mBroadcastReceiver);	// レシーバー解除.
    }
    
}