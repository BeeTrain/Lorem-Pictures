package ru.chernakov.lorempictures.presentation.navigation;

import android.support.v4.app.Fragment;

import ru.chernakov.lorempictures.presentation.view.fragment.AboutFragment;
import ru.chernakov.lorempictures.presentation.view.fragment.FavoritesFragment;
import ru.chernakov.lorempictures.presentation.view.fragment.FeedFragment;
import ru.chernakov.lorempictures.presentation.view.fragment.FlowFragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class AppScreen extends SupportAppScreen {

	public static final String FLOW_FRAGMENT_TAG = "flow_fragment_tag";

	public static final String FAVORITES_FRAGMENT_TAG = "favorites_fragment";

	public static final String FEED_FRAGMENT_TAG = "feed_fragment";

	public static final String ABOUT_FRAGMENT_TAG = "about_fragment_tag";

	private Object mReturned;

	public AppScreen(String tag) {
		switch (tag) {
			case FLOW_FRAGMENT_TAG:
				mReturned = new FlowFragment();

				break;
			case FEED_FRAGMENT_TAG:
				mReturned = new FeedFragment();

				break;
			case FAVORITES_FRAGMENT_TAG:
				mReturned = new FavoritesFragment();

				break;
			case ABOUT_FRAGMENT_TAG:
				mReturned = new AboutFragment();

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
