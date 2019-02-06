package ru.chernakov.lorempictures.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.ButterKnife;
import ru.chernakov.lorempictures.App;
import ru.chernakov.lorempictures.R;
import ru.chernakov.lorempictures.presentation.presenter.FavoritesPresenter;
import ru.chernakov.lorempictures.presentation.view.FavoritesView;

public class FavoritesFragment extends BaseFragment implements FavoritesView {

	@InjectPresenter
	FavoritesPresenter mPresenter;

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

		return v;
	}

	@ProvidePresenter
	FavoritesPresenter providePresenter() {
		return new FavoritesPresenter(mRouter);
	}
}
