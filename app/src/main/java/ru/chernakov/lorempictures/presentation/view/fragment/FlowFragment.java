package ru.chernakov.lorempictures.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.chernakov.lorempictures.App;
import ru.chernakov.lorempictures.R;
import ru.chernakov.lorempictures.presentation.navigation.LocalCiceroneHolder;
import ru.chernakov.lorempictures.presentation.presenter.FlowPresenter;
import ru.chernakov.lorempictures.presentation.view.FlowView;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class FlowFragment extends BaseFragment implements FlowView {

	@BindView(R.id.navigation)
	BottomNavigationView mBottomNavigation;

	@InjectPresenter
	FlowPresenter mPresenter;

	@Inject
	LocalCiceroneHolder mLocalHolder;

	private Navigator mNavigator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		App.getInstance().getAppComponent().inject(this);
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_flow, container, false);

		mUnBinder = ButterKnife.bind(this, v);
		mBottomNavigation.setOnNavigationItemSelectedListener(getBottomNavigationListener());

		if (savedInstanceState == null) {
			mPresenter.openFeed();
			mBottomNavigation.setSelectedItemId(R.id.navigation_feed);
		}

		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
		mLocalHolder.getFlowRouter().getNavigatorHolder().setNavigator(getNavigator());
	}

	@Override
	public void onPause() {
		mLocalHolder.getFlowRouter().getNavigatorHolder().removeNavigator();
		super.onPause();
	}

	@ProvidePresenter
	FlowPresenter providePresenter() {
		return new FlowPresenter(mLocalHolder.getFlowRouter().getRouter());
	}

	private Navigator getNavigator() {
		if (mNavigator == null) {
			mNavigator = new SupportAppNavigator(getActivity(), getChildFragmentManager(), R.id.container_flow);
		}
		return mNavigator;
	}

	private BottomNavigationView.OnNavigationItemSelectedListener getBottomNavigationListener() {
		return menuItem -> {
			if (!menuItem.isChecked()) {
				menuItem.setChecked(true);
				switch (menuItem.getItemId()) {
					case R.id.navigation_favorites:
						mPresenter.openFavorites();

						break;
					case R.id.navigation_feed:
						mPresenter.openFeed();

						break;
					case R.id.navigation_about:
						mPresenter.openAbout();

						break;
				}
			}

			return false;
		};
	}
}
