package ru.chernakov.lorempictures.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class GlobalNavigationModule {

	private Cicerone<Router> mCicerone;

	public GlobalNavigationModule() {
		mCicerone = Cicerone.create();
	}

	@Provides
	@Singleton
	Router provideRouter() {
		return mCicerone.getRouter();
	}

	@Provides
	@Singleton
	NavigatorHolder provideNavigatorHolder() {
		return mCicerone.getNavigatorHolder();
	}
}
