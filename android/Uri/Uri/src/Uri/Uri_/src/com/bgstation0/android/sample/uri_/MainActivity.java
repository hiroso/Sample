package com.bgstation0.android.sample.uri_;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // parsebutton���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button parseButton = (Button)findViewById(R.id.parsebutton);	// parseButton���擾.
        parseButton.setOnClickListener(this);	// parseButton.setOnClickListener��this���Z�b�g.
    }
    
    // View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    	
    	// �{�^����id�����Ƃɏ�����U�蕪����.
    	switch (v.getId()) {	// v.getId��View(Button)��id���擾.
    		
    		case R.id.parsebutton:	// R.id.parsebutton�̎�.
    			
    			// parseButton�u���b�N
				{
					
					// urlBar��url���擾.
    				EditText urlBar = (EditText)findViewById(R.id.urlbar);	// urlBar���擾.
    				String url = urlBar.getText().toString();	// urlBar.getText().toString()��url���擾.
    				
    				// url���p�[�X.
    				Uri uri = Uri.parse(url);	// Uri.parse��url���p�[�X����, Uri�I�u�W�F�N�guri�Ɋi�[.
    				
    				// parseedittext�ɃZ�b�g.
    				EditText parseedittext = (EditText)findViewById(R.id.parseedittext);	// parseedittext���擾.
    				parseedittext.setText(uri.getScheme());	// parseedittext��uri.getScheme�Ŏ擾�����X�L�[�}���Z�b�g.
    				
    				// ������.
    				break;	// break�Ŕ�����.
    				
				}
				
    	}
    	
    }
    
}