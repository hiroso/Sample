package com.bgstation0.android.sample.r.attr_;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    // ���j���[���쐬���ꂽ��.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// ���j���[�̍쐬
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflater��MenuItem���擾��, ���̂܂�inflate�Ŏw�肳�ꂽR.menu.main������menu���쐬.
    	ActionBar actionBar = getActionBar();	// getActionBar��actionBar���擾.
    	actionBar.setDisplayShowTitleEnabled(false);	// actionBar.setDisplayShowTitleEnabled��false�ɂ��ă^�C�g�����\��.
    	actionBar.setDisplayShowHomeEnabled(false);	// actionBar.setDisplayShowHomeEnabled��false�ɂ��ăA�C�R������\��.
    	return true;	// true��Ԃ�.
    	
    }
    
    // ���j���[���I�����ꂽ��.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    
    	// �ǂ̃��j���[���I�����ꂽ��.
    	switch (item.getItemId()){	// �A�C�e��ID���ƂɐU�蕪��.
    	
    		// Always
    		case R.id.menu_always:
    			
    			// Always�u���b�N
    			{
    				
    				// "Always"�ƕ\��.
    				Toast.makeText(this, "Always", Toast.LENGTH_LONG).show();	// Toast��"Always"�ƕ\��.
    				
    			}
    			
    			break;
 
    		// Never
    		case R.id.menu_never:
    			
    			// Never�u���b�N
    			{
    			
    				// "Never"�ƕ\��.
    				Toast.makeText(this, "Never", Toast.LENGTH_LONG).show();	// Toast��"Never"�ƕ\��.
    				
    			}
    			
    			break;
    			
    	}
    		    	
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    	
    }
    
}