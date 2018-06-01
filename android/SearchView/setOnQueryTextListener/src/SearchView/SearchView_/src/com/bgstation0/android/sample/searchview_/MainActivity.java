package com.bgstation0.android.sample.searchview_;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends Activity{

	// メンバフィールドの定義.
	Context mContext = null;	// mContextをnullに初期化.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;	// mContextにthisをセット.
    }
    
    // メニューが作成された時.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// メニューの作成
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflaterでMenuItemを取得し, そのままinflateで指定されたR.menu.mainを元にmenuを作成.
    	ActionBar actionBar = getActionBar();	// getActionBarでactionBarを取得.
    	actionBar.setDisplayShowTitleEnabled(false);	// actionBar.setDisplayShowTitleEnabledをfalseにしてタイトルを非表示.
    	actionBar.setDisplayShowHomeEnabled(false);	// actionBar.setDisplayShowHomeEnabledをfalseにしてアイコンも非表示.
    	
    	// SearchViewの取得.
    	MenuItem menuItemSearch = menu.findItem(R.id.menu_item_searchview);	// menuItemSearchの取得.
    	SearchView searchView = (SearchView)menuItemSearch.getActionView();	// searchViewの取得.
    	searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
    		
    		// クエリテキストが変更された時.
    		@Override
    		public boolean onQueryTextChange(String newText){
    			
    			// テキストが変更された時, textview1を変更.
    			TextView textview1 = (TextView)((MainActivity)mContext).findViewById(R.id.textview1);	// textview1を取得.
    			textview1.setText(newText);	// textview1にnewTextをセット.
				return false;
				
    		}
    		
    		// クエリテキストが決定した時.
    		@Override
    		public boolean onQueryTextSubmit(String query){
    			return false;
    		}
    		
    	});
    	
    	return true;	// trueを返す.
    	
    }
    
}