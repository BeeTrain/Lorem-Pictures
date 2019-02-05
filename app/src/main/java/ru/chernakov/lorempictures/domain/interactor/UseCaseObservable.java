package ru.chernakov.lorempictures.domain.interactor;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ru.chernakov.lorempictures.domain.executor.PostExecutionThread;
import ru.chernakov.lorempictures.domain.executor.ThreadExecutor;

public abstract class UseCaseObservable<T, Params> {

	private final ThreadExecutor threadExecutor;
	private final PostExecutionThread postExecutionThread;
	private final CompositeDisposable disposables;

	public UseCaseObservable(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
		this.threadExecutor = threadExecutor;
		this.postExecutionThread = postExecutionThread;
		this.disposables = new CompositeDisposable();
	}

	public abstract Observable<T> buildUseCaseObservable(Params params);

	public void execute(DisposableObserver<T> observer, Params params) {
		Preconditions.checkNotNull(observer);
		final Observable<T> observable = this.buildUseCaseObservable(params)
				.subscribeOn(Schedulers.from(threadExecutor))
				.observeOn(postExecutionThread.getScheduler());
		addDisposable(observable.subscribeWith(observer));
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
