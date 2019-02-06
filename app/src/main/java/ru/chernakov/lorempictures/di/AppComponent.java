package ru.chernakov.lorempictures.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.chernakov.lorempictures.di.module.ApplicationModule;
import ru.chernakov.lorempictures.di.module.GlobalNavigationModule;
import ru.chernakov.lorempictures.di.module.LocalNavigationModule;
import ru.chernakov.lorempictures.domain.executor.PostExecutionThread;
import ru.chernakov.lorempictures.domain.executor.ThreadExecutor;
import ru.chernakov.lorempictures.presentation.view.activity.AppActivity;
import ru.chernakov.lorempictures.presentation.view.fragment.AboutFragment;
import ru.chernakov.lorempictures.presentation.view.fragment.FavoritesFragment;
import ru.chernakov.lorempictures.presentation.view.fragment.FeedFragment;
import ru.chernakov.lorempictures.presentation.view.fragment.FlowFragment;
import ru.terrakok.cicerone.Router;

@Singleton
@Component(modules = {
		ApplicationModule.class,
		LocalNavigationModule.class,
		GlobalNavigationModule.class
})
public interface AppComponent {

	void inject(AppActivity activity);

	void inject(FlowFragment fragment);

	void inject(FeedFragment fragment);

	void inject(AboutFragment fragment);

	void inject(FavoritesFragment fragment);

	Router router();

	ThreadExecutor threadExecutor();

	PostExecutionThread postExecutionThread();
}
