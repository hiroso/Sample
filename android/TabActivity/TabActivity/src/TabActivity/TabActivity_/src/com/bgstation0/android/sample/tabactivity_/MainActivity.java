package com.bgstation0.android.sample.tabactivity_;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // tabHostの取得.
        TabHost tabHost = getTabHost();	// getTabHostでtabHostを取得.
        
        // tabSpecの作成.
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("MainTab");	// tabSpec作成.        
        // テキストのセット.
        tabSpec.setIndicator("MainTab");	// テキストは"MainTab".
        // コンテンツのセット.
        tabSpec.setContent(R.id.main_content);	// R.id.main_contentをセット.
        // タブの追加.
        tabHost.addTab(tabSpec);	// tabSpecを追加.
        
        // tabSpec2の作成.(これで追加すると, 最初のタブのテキストMainContentが表示されない.)
        /*
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("MainTab2");	// tabSpec2作成.      
        // テキストのセット.
        tabSpec2.setIndicator("MainTab2");	// テキストは"MainTab2".
        // コンテンツのセット.
        View v = (View)findViewById(R.id.main_content);	// vを取得.
        TextView tv = (TextView)v.findViewById(R.id.textview1);	// tvを取得.
        tv.setText("MainContent2");	// テキストを変更.
        tabSpec2.setContent(R.id.main_content);	// R.id.main_contentをセット.
        // タブの追加.
        tabHost.addTab(tabSpec2);	// tabSpec2を追加.
        */
        
        // tabSpec2の作成.(IntentでActivityを追加.)
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("MainTab2");	// tabSpec2作成.
        // テキストのセット.
        tabSpec2.setIndicator("MainTab2");	// テキストは"MainTab2".
        // コンテンツのセット.
        tabSpec2.setContent(new Intent(this, SubActivity.class));	// SubActivityをセット.
        // タブの追加.
        tabHost.addTab(tabSpec2);	// tabSpec2を追加.
        
        // tabSpec3の作成.(IntentでActivityを追加.)
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("MainTab3");	// tabSpec3作成.
        // テキストのセット.
        tabSpec3.setIndicator("MainTab3");	// テキストは"MainTab3".
        // コンテンツのセット.
        Intent intent = new Intent(this, SubActivity.class);	// intentを生成.
        Bundle args = new Bundle();	// args作成.
        args.putString("tag", "Activity3");	// ("tag", "Activity3")で登録.
        intent.putExtras(args);	// args登録.
        tabSpec3.setContent(intent);	// intentをセット.
        // タブの追加.
        tabHost.addTab(tabSpec3);	// tabSpec3を追加.
        
    }
    
}