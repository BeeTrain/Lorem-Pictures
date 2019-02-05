package ru.chernakov.lorempictures.domain.interactor;

import dagger.internal.Preconditions;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import ru.chernakov.lorempictures.domain.executor.PostExecutionThread;
import ru.chernakov.lorempictures.domain.executor.ThreadExecutor;


public abstract class UseCaseCompletable<Params> {

	private final ThreadExecutor threadExecutor;

	private final PostExecutionThread postExecutionThread;

	private final CompositeDisposable disposables;

	public UseCaseCompletable(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
		this.threadExecutor = threadExecutor;
		this.postExecutionThread = postExecutionThread;
		this.disposables = new CompositeDisposable();
	}

	public abstract Completable buildUseCaseCompletable(Params params);

	public void execute(DisposableCompletableObserver observer, Params params) {
		Preconditions.checkNotNull(observer);
		final Completable completable = this.buildUseCaseCompletable(params)
				.subscribeOn(Schedulers.from(threadExecutor))
				.observeOn(postExecutionThread.getScheduler());
		addDisposable(completable.subscribeWith(observer));
	}

	public void dispose() {
		if (!disposables.isDisposed()) {
			disposables.dispose();
		}
	}

	private void addDisposable(Disposable disposable) {
		Preconditions.checkNotNull(disposable);
		Preconditions.checkNotNull(disposables);
		disposables.add(disposable);
	}
}
