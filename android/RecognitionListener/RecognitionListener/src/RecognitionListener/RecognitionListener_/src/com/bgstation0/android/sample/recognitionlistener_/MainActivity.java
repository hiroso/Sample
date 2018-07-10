package com.bgstation0.android.sample.recognitionlistener_;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener, RecognitionListener{

	// メンバフィールドの定義.
	SpeechRecognizer mSpeechRecognizer = null;	// mSpeechRecognizerをnullで初期化.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ボタンにリスナーをセット.
        Button button1 = (Button)findViewById(R.id.button1);	// button1を取得.
        button1.setOnClickListener(this);	// thisをセット.
        
        // SpeechRecognizerの作成.
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);	// mSpeechRecognizerを作成.
        mSpeechRecognizer.setRecognitionListener(this);	// リスナーとしてthisをセット.
        
    }
    
    // クリックされた時.
    @Override
    public void onClick(View v){
    	
    	// インテント作成.
    	try{	// tryで囲む.
    		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);	// IntentのコンストラクタにRecognizerIntent.ACTION_RECOGNIZE_SPEECHを渡してintent作成.
    		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);	// 言語モデルはフリーフォーム.
    		intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());	// 呼び出すパッケージ名.
    		mSpeechRecognizer.startListening(intent);	// リスニング開始.
    	}
    	catch (Exception ex){
    		Toast.makeText(this, "ex = " + ex.toString(), Toast.LENGTH_LONG).show();	// ex.toString()を出力.
    	}
    	
    }
    
    // 音声認識の準備完了時.
    @Override
    public void onReadyForSpeech(Bundle params) {
    
    	// "onReadyForSpeech"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onReadyForSpeech");
    	
    }
    
    // 音声認識の入力開始時.
    @Override
    public void onBeginningOfSpeech(){
    	
    	// "onBeginningOfSpeech"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onBeginningOfSpeech");	// "onBeginningOfSpeech"をセット.
    	
    }
    
    // RMSチェンジ.
    @Override
    public void onRmsChanged(float rmsdB) {
    	
    	// "onRmsChanged"と表示.
    	//TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	//textview1.setText("onRmsChanged");	// "onRmsChanged"をセット.
    	
    }
    
    // イベント発生時.
    @Override
    public void onEvent(int eventType, Bundle params) {
    	
    	// "onEvent"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onEvent");	// "onEvent"をセット.
    	
    }
    
    //　バッファ受信時.
    @Override
    public void onBufferReceived(byte[] buffer) {
        
    	// "onBufferReceived"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onBufferReceived");	// "onBufferReceived"をセット.
    	
    }
    
    // エラー発生時.
    @Override
    public void onError(int error) {
    	
    	// "onError"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onError");	// "onError"をセット.
    	
    }
    
    // 音声認識の結果時.
    @Override
    public void onResults(Bundle results) {
    	
    	// "onResults"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onResults");	// "onResults"をセット.
    
    	// ArrayList<String>で返ってくる.
		ArrayList<String> aryListStrs = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);	// aryListStrsを取得.
		String result = "";	// resultを""で初期化.
		for (int i = 0; i < aryListStrs.size() - 1; i++){	// (単語の個数 - 1)回繰り返す.
			result = result + aryListStrs.get(i);	// resultにi番目を連結.
			result = result + " ";	// スペースを連結.
		}
		result = result + aryListStrs.get(aryListStrs.size() - 1);	// 最後の要素を連結.
		EditText edittext1 = (EditText)findViewById(R.id.edittext1);
		edittext1.setText(result);	// edittext1.setTextでresultをセット.
		
    }
    
    // 音声入力の終了時.
    @Override
    public void onEndOfSpeech() {
    	
    	// "onEndOfSpeech"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onEndOfSpeech");	// "onEndOfSpeech"をセット.
    	
    }
    
    // 部分的な認識結果時.
    @Override
    public void onPartialResults(Bundle partialResults) {
    	
    	// "onPartialResults"と表示.
    	TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1を取得.
    	textview1.setText("onPartialResults");	// "onPartialResults"をセット.
    	
    }
    
}