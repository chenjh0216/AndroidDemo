package com.jyh.androiddemo.presenters;

public interface IBasePresenter extends IBaseLogger {

	void onCreate();

	void onStart();

	void onResume();

	void onPause();

	void onStop();

	void onRestart();

	void onDestroy();

}
