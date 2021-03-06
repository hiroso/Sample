// 既定のヘッダ
#include <iostream> // C++標準入出力
// 独自のヘッダ
#include "view.h" // class_view

// メンバの定義
// メンバ関数set_observer
void class_view::set_observer(interface_observer *observer){

  // メンバにセット.
  observer_ = observer; // observer_にobserverをセット.

}

// メンバ関数notify
void class_view::notify(){

  // notifyが呼ばれた.
  std::cout << "class_view::notify()" << std::endl; // "class_view::notify()"と出力.

  // observer_に通知.
  observer_->changed(this); // subjectとしてthisを渡す.

}

// メンバ関数set_subject
void class_view::set_subject(interface_subject *subject){

  // メンバにセット.
  subject_ = subject; // subject_にsubjectをセット.

}

// メンバ関数changed
void class_view::changed(interface_subject *subject){

  // changedが呼ばれた.
  std::cout << "class_view::changed()" << std::endl; // "class_view::changed()"と出力.

}
