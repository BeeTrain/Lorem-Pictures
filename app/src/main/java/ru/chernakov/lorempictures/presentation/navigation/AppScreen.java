package ru.chernakov.lorempictures.presentation.navigation;

import android.support.v4.app.Fragment;

import ru.chernakov.lorempictures.presentation.view.fragment.FeedFragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class AppScreen extends SupportAppScreen {

	public static final String FEED_FRAGMENT_TAG = "feed_fragment";

	private Object mReturned;

	public AppScreen(String tag) {
		switch (tag) {
			case FEED_FRAGMENT_TAG:
				mReturned = new FeedFragment();

				break;
			default:
				mReturned = new FeedFragment();

				break;
		}
	}


	@Override
	public Fragment getFragment() {
		return (Fragment) mReturned;
	}
}
