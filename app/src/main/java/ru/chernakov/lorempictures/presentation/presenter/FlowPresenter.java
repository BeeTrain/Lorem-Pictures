package ru.chernakov.lorempictures.presentation.presenter;

import ru.chernakov.lorempictures.presentation.navigation.AppScreen;
import ru.chernakov.lorempictures.presentation.view.FlowView;
import ru.terrakok.cicerone.Router;

public class FlowPresenter extends BasePresenter<FlowView> {

	public FlowPresenter(Router router) {
		super(router);
	}

	public void openFavorites() {
		AppScreen screen = new AppScreen(AppScreen.FAVORITES_FRAGMENT_TAG);
		mRouter.newRootScreen(screen);
	}

	public void openFeed() {
		AppScreen screen = new AppScreen(AppScreen.FEED_FRAGMENT_TAG);
		mRouter.navigateTo(screen);
	}

	public void openAbout() {
		AppScreen screen = new AppScreen(AppScreen.ABOUT_FRAGMENT_TAG);
		mRouter.navigateTo(screen);
	}

}
