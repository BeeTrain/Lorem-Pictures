package ru.chernakov.lorempictures.presentation.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import ru.terrakok.cicerone.Router;

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {
	protected Router mRouter;

	public BasePresenter(Router router) {
		this.mRouter = router;
	}
}
