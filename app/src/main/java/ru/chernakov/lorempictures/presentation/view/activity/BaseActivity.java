package ru.chernakov.lorempictures.presentation.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import ru.chernakov.lorempictures.R;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public abstract class BaseActivity extends MvpAppCompatActivity {

	@Inject
	protected NavigatorHolder mNavigatorHolder;

	public Navigator mNavigator = new SupportAppNavigator(this, R.id.container) {
		@Override
		protected Fragment createFragment(SupportAppScreen screen) {
			return super.createFragment(screen);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
	}

	@Override
	protected void onResumeFragments() {
		super.onResumeFragments();
		mNavigatorHolder.setNavigator(mNavigator);
	}

	@Override
	protected void onPause() {
		mNavigatorHolder.removeNavigator();
		super.onPause();
	}
}