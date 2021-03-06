// ヘッダファイルのインクルード
#include <windows.h>	// 標準WindowsAPI
#include <tchar.h>		// TCHAR型
#include <stdio.h>		// 標準入出力

// _tmain関数の定義
int _tmain(int argc, TCHAR *argv[]){	// main関数のTCHAR版.

	// 変数の宣言・初期化
	PROCESS_INFORMATION pi;		// プロセス情報pi
	STARTUPINFO si = {0};		// スタートアップ情報siは0で初期化.
	TCHAR tszArg[256] = {0};	// コマンドライン引数tszArgは0で初期化.
	DWORD dwExitCode = 0;		// 終了コードdwExitCodeは0で初期化.

	// スタートアップ情報の初期化.
	si.cb = sizeof(STARTUPINFO);			// si.cbにSTARTUPINFOのサイズをセット.
	_tcscpy(tszArg, _T("SubProcess.exe"));	// tszArgに"SubProcess.exe"をセット.

	// "MainProcess Start!"と出力.
	_tprintf(_T("MainProcess Start!\n"));	// "MainProcess Start!"と出力.

	// 新しいプロセスの生成.
	CreateProcess(NULL, tszArg, NULL, NULL, FALSE, NORMAL_PRIORITY_CLASS, NULL, NULL, &si, &pi);	// CreateProcessで新しいプロセス"SubProcess.exe"を実行.(第1引数はフルパスでないといけないが, そこをNULLにして第2引数を使えば, 相対パスでも実行できる.)

	// 生成された新しいプロセスのスレッドハンドルは使わないので閉じる.
	CloseHandle(pi.hThread);	// CloseHandleでpi.hThreadを閉じる.

	// 10秒休止したら新しいプロセスを強制終了.(新しいプロセスは30秒間生きているので強制的に終了させることになる.)
	Sleep(10000);	// Sleepで10000ミリ秒休止.
	TerminateProcess(pi.hProcess, 100);	// TerminateProcessでプロセスを強制終了.(終了コードは100.)

	// TerminateProcessを呼んですぐ終了コードを取りに行くと, 259(STILL_ACTIVE)が返ってくるので1秒ほど休止.
	Sleep(1000);	// Sleepで1000ミリ秒休止.

	// 新しいプロセスの終了コードを取得.(新しいプロセスはTerminateProcessで強制終了されたので, 既に終わっている状態.)
	GetExitCodeProcess(pi.hProcess, &dwExitCode);	// GetExitCodeProcessで終了コードを取得.
	_tprintf(_T("SubProcess's dwExitCode = %lu\n"), dwExitCode);	// dwExitCodeの値を出力.  

	// 新しいプロセスのプロセスハンドルを閉じる.(新しいプロセスはTerminateProcessで強制終了されたので, 既に終わっている状態.)
	CloseHandle(pi.hProcess);	// CloseHandleでpi.hProcessを閉じる.

	// "MainProcess End!"と出力.
	_tprintf(_T("MainProcess End!\n"));	// "MainProcess End!"と出力.

	// プログラムの終了
	return 0;

}