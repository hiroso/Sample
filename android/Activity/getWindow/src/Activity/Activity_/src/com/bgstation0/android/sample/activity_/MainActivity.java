package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends ActivityGroup {

	// �����o�t�B�[���h�̒�`.
	LocalActivityManager lam = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // LocalActivityManager�̎擾.
        lam = getLocalActivityManager();	// lam�̎擾.
        
        // SubActivity��Intent�쐬.
        Intent intent1 = new Intent(this, SubActivity.class);	// intent1�쐬.
        intent1.putExtra("tag", "test1");	// �L�[��"tag", �l��"test1".
        // Window�̎擾.
        Window window1 = lam.startActivity("test1", intent1);	// intent1��n����, window1�̎擾.
        Toast.makeText(this, "window1.toString() = " + window1.toString(), Toast.LENGTH_LONG).show();	// window1.toString�̏o��.
        
        // SubActivity��Intent�쐬.
        Intent intent2 = new Intent(this, SubActivity.class);	// intent2�쐬.
        intent2.putExtra("tag", "test2");	// �L�[��"tag", �l��"test2".
        // Window�̎擾.
        Window window2 = lam.startActivity("test2", intent2);	// intent2��n����, window2�̎擾.
        Toast.makeText(this, "window2.toString() = " + window2.toString(), Toast.LENGTH_LONG).show();	// window2.toString�̏o��.
        
        // SubActivity��Intent�쐬.
        Intent intent1b = new Intent(this, SubActivity.class);	// intent1b�쐬.
        intent1b.putExtra("tag", "test1");	// �L�[��"tag", �l��"test1".
        // Window�̎擾.
        Window window1b = lam.startActivity("test1", intent1b);	// intent1b��n����, window1b�̎擾.

        // window1��window1b���������ǂ����`�F�b�N.
        //Toast.makeText(this, "window1.toString() = " + window1.toString(), Toast.LENGTH_LONG).show();	// window1.toString�̏o��.
        //Toast.makeText(this, "window1b.toString() = " + window1b.toString(), Toast.LENGTH_LONG).show();	// window1b.toString�̏o��.
        //if (window1 == window1b){	// window1��window1b�������Ȃ�.
        //	Toast.makeText(this, "window1 == window1b !", Toast.LENGTH_LONG).show();	// �����Ȃ�"window1 == window1b !"���o��.
        //}
        
    }
    
    // ���j���[���쐬���ꂽ��.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// ���j���[�̍쐬
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflater��MenuItem���擾��, ���̂܂�inflate�Ŏw�肳�ꂽR.menu.main������menu���쐬.
    	return true;	// true��Ԃ�.
    	
    }
    
    // ���j���[���I�����ꂽ��.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    
    	// �ǂ̃��j���[���I�����ꂽ��.
    	switch (item.getItemId()){	// �A�C�e��ID���ƂɐU�蕪��.
    	
    		// TextView1
    		case R.id.menu_textview1:
    			
    			// TextView1�u���b�N
				{
								        
				}
				
				break;
			
			// TextView1
    		case R.id.menu_textview2:
    			
    			// TextView2�u���b�N
				{
	
				}
				
				break;
				
    	}
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    	
    }
    
}