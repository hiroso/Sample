// 二重インクルード防止
#pragma once	// VisualC++独自のプリプロセッサ#pragma onceで二重インクルード防止.

// ヘッダファイルのインクルード
// 既定のヘッダファイル
#include <afxwin.h>	// MFC標準
#include <tchar.h>	// TCHAR型

// CFrameWndの派生クラスCFrameWnd_の定義
class CFrameWnd_ : public CFrameWnd{	// フレームウィンドウクラス

	// publicメンバ
	public:

		// publicメンバ関数
		// コンストラクタ
		CFrameWnd_();	// コンストラクタ(引数なし)

		// ハンドラ
		virtual BOOL OnCommand(WPARAM wParam, LPARAM lParam);	// メニュー項目が選択されたり, ボタンなどのコントロールが押されたりした時.
		void OnUpdateItem1_1(CCmdUI* pCmdUI);	// メニュー項目Item1_1のUI更新ハンドラ

		// メッセージマップ
		DECLARE_MESSAGE_MAP()	// メッセージマップの利用を宣言.

};