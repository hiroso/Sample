package com.bgstation0.android.sample.cursoradapter_;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomCursorAdapter extends CursorAdapter {

	// �����o�t�B�[���h�̒�`.
	private LayoutInflater mInflater = null;	// mInflater��null���Z�b�g.
	private Context mContext = null;	// mContext��null���Z�b�g.
	private SearchableInfo mSearchable = null;	// mSearchable��null���Z�b�g.
	private Cursor mCursor = null;	// mCursor��null���Z�b�g.
	
	// �T�u�N���X�̒�`.
	private class ViewHolder{
		TextView text1;	// �e�L�X�gtext1.
	}
	
	// �R���X�g���N�^.
	public CustomCursorAdapter(Context context, boolean autoRequery, SearchableInfo searchable){
		super(context, null, autoRequery);	// �e�R���X�g���N�^���Ă�.
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	// mInflater�̐���.
		mContext = context;	// mContext��context���Z�b�g.
		mSearchable = searchable;	// mSearchable��searchable���Z�b�g.
	}
	
	// �o�b�N�O���E���h�X���b�h�ŃN�G�������s.
	@Override  
    public Cursor runQueryOnBackgroundThread(CharSequence constraint){
		
		// �N�G���ɕϊ�.
		String query = constraint.toString();	// query�ɕϊ�.
		if (query != null){	// query��null�łȂ�.
			
			// query�����O�o��.
			Log.d("CursorAdapter_: ", "runQueryOnBackgroundThread : query = " + query);	// query�����O�o��.
			
			try{	// try�ň͂�.
				mCursor = getSuggestions(query, 10);	// getSuggestions�ŃJ�[�\���擾.
				String s0 = mCursor.toString();	// s0�Ɋi�[.
				//Toast.makeText(mContext, "s0 = " + s0, Toast.LENGTH_LONG).show();	// s0��\��.
				Log.d("CursorAdapter_", "s0 = " + s0);	// s0�����O�o��.
				return mCursor;	// mCursor��Ԃ�.
			}
			catch (Exception ex){	// ��O.
				Log.d("CursorAdapter_: ", ex.toString());	// ex�����O�ɏo��.
			}
		}
		
		// null.
		return null;	// null��Ԃ�.
		
	}
	
	// Suggestions�̎擾.
	public Cursor getSuggestions(String query, int limit){
		
		// Authoriy�̎擾.
		String authority = mSearchable.getSuggestAuthority();	// authoriy�̎擾.
		if (authority == null){	// null�Ȃ�.
			return null;	// null��Ԃ�.
		}
		
		// uriBuilder�̎擾.
		Uri.Builder uriBuilder = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(authority);	// uriBuilder�̎擾.
		
		// suggestPath�̎擾.
		String suggestPath = mSearchable.getSuggestPath();	// suggestPath�̎擾.
		if (suggestPath != null){	// null�łȂ����.
			uriBuilder.appendEncodedPath(suggestPath);	// suggestPath��ǉ�.
		}
		
		// �N�G���p�X�̒ǉ�.
		uriBuilder.appendPath(SearchManager.SUGGEST_URI_PATH_QUERY);	// SUGGEST_URI_PATH_QUERY��ǉ�.
		
		// �Z���N�V�����̎擾.
		String selection = mSearchable.getSuggestSelection();	// selection�̎擾.
		
		// �Z���N�V�����̗L��.
		String[] selArgs = null;	// selArgs��null���Z�b�g.
		if (selection != null){	// selection��null�łȂ��Ȃ�.
			selArgs = new String[]{query};	// query��selArgs�ɃZ�b�g.
		}
		else{
			uriBuilder.appendPath(query);	// uriBuilder��query��ǉ�.
		}
		
		// limit�̒ǉ�.
		if (limit > 0){	// 0���傫��.
			uriBuilder.appendQueryParameter(SearchManager.SUGGEST_PARAMETER_LIMIT, String.valueOf(limit));	// limit��ǉ�.
		}
		
		// Uri�̐���.
		Uri uri = uriBuilder.build();	// uri�𐶐�.
		
		// �N�G�����s����, ���ʂ�Ԃ�.
		return mContext.getContentResolver().query(uri, null, selection, selArgs, null);	// uri��n���ăN�G�����s.
		
	}
	
	// View�̐���.
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		
		// TODO Auto-generated method stub
		// View�̐���.
		final View view = mInflater.inflate(R.layout.auto_complete_list_item, null);	// view����.
		
		// ViewHolder�̐���.
		ViewHolder viewHolder = new ViewHolder();	// viewHolder�̐���.
		viewHolder.text1 = (TextView)view.findViewById(R.id.list_item_text1);	// list_item_text1�ŕ\�����TextView��viewHolder.text1�ɃZ�b�g.
		
		// ViewHolder���^�O�ɃZ�b�g.
		view.setTag(viewHolder);	// viewHolder���Z�b�g.
		
		// view��Ԃ�.
		return view;	// view��Ԃ�.
		
	}

	// View�̍ė��p.
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		
		// TODO Auto-generated method stub
		// �^�O����ViewHolder�̎擾.
		ViewHolder viewHolder = (ViewHolder)view.getTag();	// viewHolder�̎擾.
		
		// Cursor����l�����o��.
		final String text1 = cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));	// SUGGEST_COLUMN_TEXT_1���擾.
		
		// View�ɃZ�b�g.
		viewHolder.text1.setText(text1);	// text1���Z�b�g.

	}
	
	// �J�[�\���̕ύX.
	@Override
	public void changeCursor(Cursor cursor){
	
		// Cursor�I�u�W�F�N�g�̕\��.
		String s1 = cursor.toString();	// cursor.toString�ŕ�������擾.
		String s2 = mCursor.toString();	// mCursor.toString�ŕ�������擾.
		//Toast.makeText(mContext, "s1 = " + s1, Toast.LENGTH_LONG).show();	// s1��\��.
		Log.d("CursorAdapter_", "s1 = " + s1);	// s1�����O�o��.
		//Toast.makeText(mContext, "s2 = " + s2, Toast.LENGTH_LONG).show();	// s2��\��.
		Log.d("CursorAdapter_", "s2 = " + s2);	// s2�����O�o��.
		
		// Cursor�̕ύX.
		super.changeCursor(cursor);	// super.changeCursor��cursor��ύX.
		
	}
	
	// ����.
	public void close(){
		
		// �J�[�\�������.
		if (mCursor != null){	// mCursor��null�łȂ�.
			mCursor.close();	// close.
			mCursor = null;	// mCursor��null���Z�b�g.
		}
		
	}

}