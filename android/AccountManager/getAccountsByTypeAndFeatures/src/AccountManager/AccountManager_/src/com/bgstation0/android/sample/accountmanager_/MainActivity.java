package com.bgstation0.android.sample.accountmanager_;

import java.util.ArrayList;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// メンバフィールドの定義.
	Context mContext = null;	// mContextをnullで初期化.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // コンテキストのセット.
        mContext = this;	// thisをセット.
        
        // AccountManagerオブジェクトを取得して, それを表示.
        AccountManager accountManager = AccountManager.get(this);	// accountManagerに格納.
        
        // アカウントリストの取得.
        ArrayList<ListItem> list = new ArrayList<ListItem>();	// listを生成.
        //Account[] accounts = accountManager.getAccounts();	// accountManager.getAccountsでaccountsを取得.
        /*
        Account[] accounts = accountManager.getAccountsByType("com.google");	// accountManager.getAccountsByTypeでtypeが"com.google"なaccountsを取得.
        for (Account account : accounts){	// accountsからaccountを取り出すのを要素分繰り返す.
        	ListItem item = new ListItem();	// itemを生成.
        	item.name = account.name;	// item.nameにaccount.nameをセット.
        	item.type = account.type;	// item.typeにaccount.typeをセット.
        	list.add(item);	// list.addでitemを追加.
        }*/
        accountManager.getAccountsByTypeAndFeatures("com.google", new String[]{"service_mail"}, new AccountManagerCallback(){

			@Override
			public void run(AccountManagerFuture future) {
				// TODO Auto-generated method stub
				try{
					Toast.makeText(mContext, "run", Toast.LENGTH_LONG).show();
				}
				catch (Exception ex){
					Toast.makeText(mContext, "ex = " + ex.toString(), Toast.LENGTH_LONG).show();
				}
			}
        	
        }, null);
        
        /*
        // listView1の取得.
        ListView listView1 = (ListView)findViewById(R.id.listview1);	// listView1を取得.
        
        // ListItemAdapterの生成.
        ListItem[] array = new ListItem[list.size()];	// arrayを生成.
        ListItemAdapter listItemAdapter = new ListItemAdapter(this, R.layout.list_item, list.toArray(array));	// arrayAdapterを生成.
        listView1.setAdapter(listItemAdapter);	// listItemAdapterをセット.
        */
        
    }
    
}