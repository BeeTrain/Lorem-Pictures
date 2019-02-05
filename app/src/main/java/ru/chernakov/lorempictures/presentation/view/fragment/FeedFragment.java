package ru.chernakov.lorempictures.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.chernakov.lorempictures.App;
import ru.chernakov.lorempictures.R;
import ru.chernakov.lorempictures.presentation.model.PostItem;
import ru.chernakov.lorempictures.presentation.presenter.FeedPresenter;
import ru.chernakov.lorempictures.presentation.view.FeedView;
import ru.chernakov.lorempictures.presentation.view.adapter.BaseAdapter;

public class FeedFragment extends BaseFragment implements FeedView {

	@BindView(R.id.rv_feed)
	RecyclerView mList;

	@InjectPresenter
	FeedPresenter mPresenter;

	private BaseAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		App.getInstance().getAppComponent().inject(this);
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_feed, container, false);
		mUnBinder = ButterKnife.bind(this, v);

		List<PostItem> images = new ArrayList<>();
		images.add(new PostItem());
		images.add(new PostItem());
		images.add(new PostItem());
		images.add(new PostItem());
		images.add(new PostItem());

		mAdapter = new BaseAdapter(getActivity(), images);

		mList.setLayoutManager(new LinearLayoutManager(getContext()));
		mList.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();

		return v;
	}

	@ProvidePresenter
	FeedPresenter providePresenter() {
		return new FeedPresenter(mRouter);
	}
}
