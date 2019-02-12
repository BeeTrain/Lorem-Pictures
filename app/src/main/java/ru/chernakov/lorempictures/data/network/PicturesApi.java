package ru.chernakov.lorempictures.data.network;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import ru.chernakov.lorempictures.data.dto.ImagePostDto;
import ru.chernakov.lorempictures.data.utils.Constant;

public interface PicturesApi {

	@GET(Constant.DEFAULT_LIST_URL)
	Single<List<ImagePostDto>> loadPosts();
}
