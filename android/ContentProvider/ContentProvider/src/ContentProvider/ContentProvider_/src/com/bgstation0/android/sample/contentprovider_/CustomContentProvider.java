package com.bgstation0.android.sample.contentprovider_;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class CustomContentProvider extends ContentProvider {
	
	// �쐬���ꂽ��.
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "onCreate");	// Log.d��"onCreate"��\��.
		//return false;
		return true;	// true��Ԃ�.
	}

	// �₢���킹��.
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "query");	// Log.d��"query"��\��.
		return null;
	}

	// �^�̎擾��.
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "getType");	// Log.d��"getType"��\��.
		return null;
	}

	// �}�����鎞.
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "insert");	// Log.d��"insert"��\��.
		return null;
	}

	// �X�V���鎞.
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "update");	// Log.d��"update"��\��.
		return 1;	// 1��Ԃ�.
	}
	
	// �폜���鎞.
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "delete");	// Log.d��"delete"��\��.
		//return 0;
		return -1;	// -1��Ԃ�.
	}

}