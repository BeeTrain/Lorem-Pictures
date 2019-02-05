package ru.chernakov.lorempictures.presentation.view.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.List;

import ru.chernakov.lorempictures.presentation.model.PostAdapterDelegate;
import ru.chernakov.lorempictures.presentation.model.PostItem;

public class BaseAdapter extends RecyclerView.Adapter {

	private AdapterDelegatesManager<List<PostItem>> delegatesManager;
	private List<PostItem> items;

	public BaseAdapter(Activity activity, List<PostItem> list) {
		this.items = list;

		delegatesManager = new AdapterDelegatesManager<>();
		delegatesManager.addDelegate(new PostAdapterDelegate(activity));
	}

	@Override
	public int getItemViewType(int position) {
		return delegatesManager.getItemViewType(items, position);
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return delegatesManager.onCreateViewHolder(viewGroup, i);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
		delegatesManager.onBindViewHolder(items, i, viewHolder);
	}

	@Override
	public int getItemCount() {
		return items.size();
	}
}
