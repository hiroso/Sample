// インポート
import rx.Observer;	// オブザーバー

// カスタムオブザーバー
public class CustomObserver implements Observer<String>{

	@Override
	public void onCompleted() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onError(Throwable arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onNext(String arg0) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("onNext: " + arg0);	// arg0を出力.
	}

}