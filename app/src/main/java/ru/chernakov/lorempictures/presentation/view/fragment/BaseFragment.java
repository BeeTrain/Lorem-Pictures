package ru.chernakov.lorempictures.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatFragment;

import javax.inject.Inject;

import butterknife.Unbinder;
import ru.chernakov.lorempictures.R;
import ru.terrakok.cicerone.Router;

public abstract class BaseFragment extends MvpAppCompatFragment {

	@Inject
	protected Router mRouter;

	protected Bundle mParams;

	protected boolean mIsLoading;

	protected Unbinder mUnBinder;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (mParams == null) {
			mParams = new Bundle();
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		if (mUnBinder != null) {
			mUnBinder.unbind();
		}
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		setUpToolbar(view);
		super.onViewCreated(view, savedInstanceState);
	}

	private void setUpToolbar(View view) {
		Toolbar toolbar = view.findViewById(R.id.toolbar);
		AppCompatActivity activity = (AppCompatActivity) getActivity();
		if (activity != null) {
			activity.setSupportActionBar(toolbar);
		}
	}
}
