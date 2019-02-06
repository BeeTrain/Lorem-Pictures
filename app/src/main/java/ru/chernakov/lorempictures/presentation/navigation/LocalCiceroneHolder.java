package ru.chernakov.lorempictures.presentation.navigation;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Router;

public class LocalCiceroneHolder {
	Cicerone<Router> mFlowRouter;

	public Cicerone<Router> getFlowRouter() {
		if (mFlowRouter == null) {
			mFlowRouter = Cicerone.create();
		}
		return mFlowRouter;
	}
}
