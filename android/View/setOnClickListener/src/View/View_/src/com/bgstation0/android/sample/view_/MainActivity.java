package com.bgstation0.android.sample.view_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // button1���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button button1 = (Button)findViewById(R.id.button1);	// findViewById��R.id.button1���擾.
        button1.setOnClickListener(this);	// button1.setOnClickListener��this(���g)���Z�b�g.
    }
    
    // View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    	// �C�x���g�������̃{�^�����擾��, �\������"Clicked!"�ɕύX.
    	Button b1 = (Button)v;	// �C�x���g�������I�u�W�F�N�gv��View�ŕԂ����̂�Button�ɃL���X�g����b1�Ɋi�[.
		b1.setText("Clicked!");	// b1.setText�ŕ\������"Clicked!"�ɕύX.
    }
}