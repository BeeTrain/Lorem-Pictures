package ru.chernakov.lorempictures;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import ru.chernakov.lorempictures.di.AppComponent;
import ru.chernakov.lorempictures.di.DaggerAppComponent;

public class App extends Application {

	/**
	 * Dagger App Component
	 */
	private AppComponent mAppComponent;

	/**
	 * App instance
	 */
	private static App instance;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		FlowManager.init(new FlowConfig.Builder(this).build());
	}

	public static App getInstance() {
		return instance;
	}

	public AppComponent getAppComponent() {
		if (mAppComponent == null) {
			mAppComponent = DaggerAppComponent.builder().build();
		}
		return mAppComponent;
	}
}
