package ru.chernakov.lorempictures.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.chernakov.lorempictures.UIThread;
import ru.chernakov.lorempictures.data.executor.JobExecutor;
import ru.chernakov.lorempictures.domain.executor.PostExecutionThread;
import ru.chernakov.lorempictures.domain.executor.ThreadExecutor;


@Module
public class ApplicationModule {

	@Provides
	@Singleton
	ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
		return jobExecutor;
	}

	@Provides
	@Singleton
	PostExecutionThread providePostExecutionThread(UIThread uiThread) {
		return uiThread;
	}
}
