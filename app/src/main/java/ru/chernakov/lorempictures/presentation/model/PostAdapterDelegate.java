package ru.chernakov.lorempictures.presentation.model;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.chernakov.lorempictures.R;

public class PostAdapterDelegate extends AdapterDelegate<List<PostItem>> {

	private LayoutInflater mInflater;

	private Activity mActivity;

	public PostAdapterDelegate(Activity activity) {
		this.mActivity = activity;
		this.mInflater = activity.getLayoutInflater();
	}

	@Override
	protected boolean isForViewType(@NonNull List<PostItem> items, int position) {
		return items.get(position) instanceof PostItem;
	}

	@NonNull
	@Override
	protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
		return new PostViewHolder(mInflater.inflate(R.layout.list_item_post, parent, false));
	}

	@Override
	protected void onBindViewHolder(@NonNull List<PostItem> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
		PostViewHolder viewHolder = (PostViewHolder) holder;
		PostItem item = items.get(position);

		if (item != null) {
			Random r = new Random();
			int id = r.nextInt(1000);
			Glide.with(mActivity)
					.load("https://picsum.photos/400/225/?image=" + id)
					.into(viewHolder.picture);
		}
	}

	class PostViewHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.iv_picture)
		ImageView picture;

		public PostViewHolder(@NonNull View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
