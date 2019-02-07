package ru.chernakov.lorempictures.data.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import ru.chernakov.lorempictures.data.utils.Constant;

public interface PicturesApi {

	@GET(Constant.DEFAULT_LIST_URL)
	Single<String> loadPosts();
}
