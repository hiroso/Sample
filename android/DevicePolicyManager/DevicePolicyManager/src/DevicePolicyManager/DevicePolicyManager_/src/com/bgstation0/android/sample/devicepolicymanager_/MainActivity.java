package com.bgstation0.android.sample.devicepolicymanager_;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	// メンバフィールドの定義.
	Context mContext = null;	// mContextをnullで初期化.
	DevicePolicyManager mDevicePolicyManager = null;	// mDevicePolicyManagerをnullで初期化.
	ComponentName mComponentName = null;	// mComponentNameをnullで初期化.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // mContextの初期化.
        mContext = this;	// mContextにthisをセット.
        
        // mDevicePolicyManagerの取得.
        mDevicePolicyManager = (DevicePolicyManager)getSystemService(DEVICE_POLICY_SERVICE);	// mDevicePolicyManagerを取得.
        
        // mComponentNameの初期化.
        mComponentName = new ComponentName(this, Admin.class);	// mComponentNameを生成.
        
        // button1の初期化.
        Button button1 = (Button)findViewById(R.id.button1);	// button1を取得.
        button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == R.id.button1){
				
					// 管理者権限かどうか.
					if (mDevicePolicyManager.isAdminActive(mComponentName)){
						// 端末画面をロック.
						mDevicePolicyManager.lockNow();	// mDevicePolicyManager.lockNowでロック.
					}
					else{
						// 管理者権限取得インテント.
						Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);	// intent作成.
						intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);	// mComponentNameを渡す.
						intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,  "Lock OK?");	// "Lock OK?".
						((MainActivity)mContext).startActivityForResult(intent, 1);	// intentを起動.
					}
					
				}
			}
			
        });

    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	
    	// 許可されたかどうか.
    	if (requestCode == 1){	// 1の時.
    		if (resultCode == RESULT_OK){	// OK
    			Toast.makeText(mContext, "Admin OK", Toast.LENGTH_LONG).show();	// "OK".
    		}
    		else{
    			Toast.makeText(mContext, "Admin NG", Toast.LENGTH_LONG).show();	// "NG".
    		}
    	}
    	
    }
    
}