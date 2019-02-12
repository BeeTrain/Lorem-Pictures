package ru.chernakov.lorempictures.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import ru.chernakov.lorempictures.App;
import ru.chernakov.lorempictures.R;
import ru.chernakov.lorempictures.data.dto.ImagePostDto;
import ru.chernakov.lorempictures.data.network.PicturesApi;
import ru.chernakov.lorempictures.data.network.PicturesApiClient;
import ru.chernakov.lorempictures.presentation.presenter.FavoritesPresenter;
import ru.chernakov.lorempictures.presentation.view.FavoritesView;

public class FavoritesFragment extends BaseFragment implements FavoritesView {

	@InjectPresenter
	FavoritesPresenter mPresenter;

	PicturesApi mApiService;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		App.getInstance().getAppComponent().inject(this);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_base, container, false);
		mUnBinder = ButterKnife.bind(this, v);

		mApiService = PicturesApiClient.getClient(getContext()).create(PicturesApi.class);

		CompositeDisposable disposable = new CompositeDisposable();

		disposable.add(
				mApiService.loadPosts()
						.subscribeOn(Schedulers.io())
						.observeOn(AndroidSchedulers.mainThread())
						.subscribeWith(new DisposableSingleObserver<List<ImagePostDto>>() {
							@Override
							public void onSuccess(List<ImagePostDto> imagePostDtos) {
								int size = imagePostDtos.size();
								Toast.makeText(getContext(), String.valueOf(size), Toast.LENGTH_SHORT).show();
							}

							@Override
							public void onError(Throwable e) {
								Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
							}
						})
		);

		return v;
	}

	@ProvidePresenter
	FavoritesPresenter providePresenter() {
		return new FavoritesPresenter(mRouter);
	}
}
