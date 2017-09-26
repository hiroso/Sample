// インポート
import rx.Observable;	// オブザーバブル

// メインクラス
class MainClass {	// MainClassクラスの定義

	// Javaのエントリポイント
	public static void main(String[] args) {	// mainメソッドの定義

		// String配列
		String[] sarray = {"ABC", "XYZ"};	// sarrayを定義.

		// オブザーバブルの生成.
		Observable<String> observable = Observable.from(sarray);	// 配列のオブザーバブル.
		
		// カスタムオブザーバーの生成.
		CustomObserver observer1 = new CustomObserver();
		CustomObserver observer2 = new CustomObserver();
		
		// 登録.
		observable.subscribe(observer1);	// 登録とともにonNextが実行される.(あれ?こういうもんなのか.)
		observable.subscribe(observer2);	// 登録とともにonNextが実行される.(あれ?こういうもんなのか.)
		
	}

}