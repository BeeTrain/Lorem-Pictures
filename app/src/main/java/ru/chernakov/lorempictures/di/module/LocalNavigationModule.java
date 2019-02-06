package ru.chernakov.lorempictures.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.chernakov.lorempictures.presentation.navigation.LocalCiceroneHolder;

@Module
public class LocalNavigationModule {

	@Provides
	@Singleton
	LocalCiceroneHolder provideLocalNavigationHolder() {
		return new LocalCiceroneHolder();
	}
}
