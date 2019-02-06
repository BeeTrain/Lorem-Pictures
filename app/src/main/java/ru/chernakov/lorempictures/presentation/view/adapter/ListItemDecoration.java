package ru.chernakov.lorempictures.presentation.view.adapter;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ListItemDecoration extends RecyclerView.ItemDecoration {
	private int largePadding;
	private int smallPadding;

	public ListItemDecoration(int largePadding, int smallPadding) {
		this.largePadding = largePadding;
		this.smallPadding = smallPadding;
	}

	@Override
	public void getItemOffsets(@NonNull Rect outRect,
							   @NonNull View view,
							   @NonNull RecyclerView parent,
							   @NonNull RecyclerView.State state) {
		outRect.left = smallPadding;
		outRect.right = smallPadding;
	}
}
