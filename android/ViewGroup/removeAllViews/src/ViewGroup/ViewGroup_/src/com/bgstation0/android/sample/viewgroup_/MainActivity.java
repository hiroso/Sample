package com.bgstation0.android.sample.viewgroup_;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends ActivityGroup {

	// �����o�t�B�[���h�̒�`.
	LocalActivityManager lam = null;
	FrameLayout mFrameMain = null;
	ViewGroup mVGFrameMain = null;
	LinearLayout mLinearSub1 = null;
	LinearLayout mLinearSub2 = null;
	View mDecorView1 = null;
	View mDecorView2 = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // LocalActivityManager�̎擾.
        lam = getLocalActivityManager();	// lam�̎擾.
        
        // MainActivity�̑}������r���[���擾.
        View mainDecorView = getWindow().getDecorView();	// MainActivity��DecorView�擾.
        ViewGroup vgDecorView = (ViewGroup)mainDecorView;	// vgDecorView�ɃL���X�g.
        View linear = vgDecorView.getChildAt(0);	// 0�Ԗڂ�linear��.
        ViewGroup vgLinear = (ViewGroup)linear;	// vgLinear�ɃL���X�g.
        if (vgLinear == null){
        	Log.d("ViewGroup", "0");
        	Toast.makeText(this, "0", Toast.LENGTH_LONG).show();
        	return;
        }
        // �K������1�Ԗڂ�FrameLayout�Ƃ͌���Ȃ�.
        String s = vgLinear.getChildAt(0).getClass().getName();
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        View mainContentView;
        if (s.equals("android.widget.FrameLayout")){
        	Toast.makeText(this, "A", Toast.LENGTH_LONG).show();
        	mainContentView = vgLinear.getChildAt(0);	// 0�Ԗڂ�mainContentView.
        }
        else{
        	Toast.makeText(this, "B", Toast.LENGTH_LONG).show();
        	mainContentView = vgLinear.getChildAt(1);	// 1�Ԗڂ�mainContentView.
        }
        if (mainContentView == null){
        	Log.d("ViewGroup", "1");
        	Toast.makeText(this, "1", Toast.LENGTH_LONG).show();
        	return;
        }
        ViewGroup vgMainContentView = (ViewGroup)mainContentView;	// vgMainContentView�ɃL���X�g.
        if (vgMainContentView == null){
        	Log.d("ViewGroup", "2");
        	Toast.makeText(this, "2", Toast.LENGTH_LONG).show();
        	return;
        }
        
        int c = vgMainContentView.getChildCount();
        
        Toast.makeText(this, "c = " + c, Toast.LENGTH_LONG).show();
        for (int i = 0; i < vgMainContentView.getChildCount(); i++){
        	Toast.makeText(this, vgMainContentView.getChildAt(i).toString(), Toast.LENGTH_LONG).show();
        }
        //return;
        mFrameMain = (FrameLayout)vgMainContentView.getChildAt(0);	// 0�Ԗڂ�frame_main.
        if (mFrameMain == null){
        	Log.d("ViewGroup", "3");
        	Toast.makeText(this, "3", Toast.LENGTH_LONG).show();
        	return;
        }
        mVGFrameMain = mFrameMain;	// mVGFrameMain�ɃL���X�g.
        if (mVGFrameMain == null){
        	Log.d("ViewGroup", "4");
        	Toast.makeText(this, "4", Toast.LENGTH_LONG).show();
        	return;
        }
        Log.d("ViewGroup", "5");
        Toast.makeText(this, "5", Toast.LENGTH_LONG).show();
        
        // SubActivity��Intent�쐬.
        Intent intent1 = new Intent(this, SubActivity.class);	// intent1�쐬.
        intent1.putExtra("tag", "test1");	// �L�[��"tag", �l��"test1".
        // Window�̎擾.
        Window window1 = lam.startActivity("test1", intent1);	// intent1��n����, window1�̎擾.
        mDecorView1 = window1.getDecorView();	// window1.getDecorView��mDecorView1���擾.
        //Toast.makeText(this, "decorView1 = " + decorView1.toString(), Toast.LENGTH_LONG).show();	// decorView1���o��.
        ViewGroup vg1 = (ViewGroup)mDecorView1;	// ViewGroup��vg1�ɃL���X�g.
        //Toast.makeText(this, "vg1.getChildCount() = " + vg1.getChildCount(), Toast.LENGTH_LONG).show();	// vg1.getChildCount���o��.
        View childView1 = vg1.getChildAt(0);	// vg1.getChildAt(0)�Ŏq�r���[���擾.
        //Toast.makeText(this, "childView1.toString() = " + childView1.toString(), Toast.LENGTH_LONG).show();	// childView1.toString()���o��.
        ViewGroup vgChild1 = (ViewGroup)childView1;	// ViewGroup��vgChild1�ɃL���X�g.
        //Toast.makeText(this, "vgChild1.getChildCount() = " + vgChild1.getChildCount(), Toast.LENGTH_LONG).show();	// vgChild1.getChildCount()���o��.
        View contentView1 = null;	// contentView1��null�ŏ�����.    
        ViewGroup vgContentView1 = null;	// vgContentView1��null�ŏ�����.
        for (int i = 0; i < vgChild1.getChildCount(); i++){	// vgChild1.getChildCount���J��Ԃ�.
        	Toast.makeText(this, vgChild1.getChildAt(i).toString(), Toast.LENGTH_LONG).show();	// vgChild1.getChildAt(i)���o��.
        	if (vgChild1.getChildAt(i).getId() == android.R.id.content){
        		Toast.makeText(this, "android.R.id.content", Toast.LENGTH_LONG).show();	// "android.R.id.content"�Əo��.
        		contentView1 = vgChild1.getChildAt(i);	// contentView1�Ɋi�[.
        		vgContentView1 = (ViewGroup)contentView1;	// vgOntentView1�ɃL���X�g.
        		if (vgContentView1.getChildAt(0).getId() == R.id.linear_sub){
        			Toast.makeText(this, "R.id.linear_sub", Toast.LENGTH_LONG).show();	// "R.id.linear_sub"�Əo��.
        			mLinearSub1 = (LinearLayout)vgContentView1.getChildAt(0);	// mLinearSub�Ɋi�[.
        		}
        	}
        }
        
        // SubActivity��Intent�쐬.
        Intent intent2 = new Intent(this, SubActivity.class);	// intent2�쐬.
        intent2.putExtra("tag", "test2");	// �L�[��"tag", �l��"test2".
        // Window�̎擾.
        Window window2 = lam.startActivity("test2", intent2);	// intent2��n����, window2�̎擾.
        mDecorView2 = window2.getDecorView();	// window2.getDecorView��mDecorView2���擾.
        //Toast.makeText(this, "decorView2 = " + decorView2.toString(), Toast.LENGTH_LONG).show();	// decorView2���o��.
        ViewGroup vg2 = (ViewGroup)mDecorView2;	// ViewGroup��vg2�ɃL���X�g.
        //Toast.makeText(this, "vg2.getChildCount() = " + vg2.getChildCount(), Toast.LENGTH_LONG).show();	// vg2.getChildCount���o��.
        View childView2 = vg2.getChildAt(0);	// vg2.getChildAt(0)�Ŏq�r���[���擾.
        //Toast.makeText(this, "childView2.toString() = " + childView2.toString(), Toast.LENGTH_LONG).show();	// childView2.toString()���o��.
        ViewGroup vgChild2 = (ViewGroup)childView2;	// ViewGroup��vgChild2�ɃL���X�g.
        //Toast.makeText(this, "vgChild2.getChildCount() = " + vgChild2.getChildCount(), Toast.LENGTH_LONG).show();	// vgChild2.getChildCount()���o��.
        View contentView2 = null;	// contentView2��null�ŏ�����.    
        ViewGroup vgContentView2 = null;	// vgContentView2��null�ŏ�����.
        for (int i = 0; i < vgChild2.getChildCount(); i++){	// vgChild2.getChildCount���J��Ԃ�.
        	Toast.makeText(this, vgChild2.getChildAt(i).toString(), Toast.LENGTH_LONG).show();	// vgChild2.getChildAt(i)���o��.
        	if (vgChild2.getChildAt(i).getId() == android.R.id.content){
        		Toast.makeText(this, "android.R.id.content", Toast.LENGTH_LONG).show();	// "android.R.id.content"�Əo��.
        		contentView2 = vgChild2.getChildAt(i);	// contentView2�Ɋi�[.
        		vgContentView2 = (ViewGroup)contentView2;	// vgOntentView2�ɃL���X�g.
        		if (vgContentView2.getChildAt(0).getId() == R.id.linear_sub){
        			Toast.makeText(this, "R.id.linear_sub", Toast.LENGTH_LONG).show();	// "R.id.linear_sub"�Əo��.
        			mLinearSub2 = (LinearLayout)vgContentView2.getChildAt(0);	// mLinearSub�Ɋi�[.
        		}
        	}
        }
        
        // 1�������\��.
        mVGFrameMain.removeAllViews();	// mVGFrameMain.removeAllViews�ł�������N���A.
        mFrameMain.addView(mDecorView1);	// �ǉ�����Ƃ���, mDecorView1��ǉ�.
        //mVGFrameMain.addView(mLinearSub1);	// mVGFrameMain.addView��mLinearSub1��ǉ�.
        
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
					
					// 1��\��.
			        mVGFrameMain.removeAllViews();	// mVGFrameMain.removeAllViews�ł�������N���A.
			        mFrameMain.addView(mDecorView1);	// �ǉ�����Ƃ���, mDecorView1��ǉ�.
			        
				}
				
				break;
			
			// TextView1
    		case R.id.menu_textview2:
    			
    			// TextView2�u���b�N
				{
	
					// 2��\��.
			        mVGFrameMain.removeAllViews();	// mVGFrameMain.removeAllViews�ł�������N���A.
			        mFrameMain.addView(mDecorView2);	// �ǉ�����Ƃ���, mDecorView2��ǉ�.
			        
				}
				
				break;
				
    	}
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    	
    }
    
}