package ru.chernakov.lorempictures.data.network;

import android.content.Context;
import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.chernakov.lorempictures.data.utils.Constant;

public class PicturesApiClient {

	private static Retrofit retrofit = null;
	private static int REQUEST_TIMEOUT = 60;
	private static OkHttpClient okHttpClient;

	public static Retrofit getClient(Context context) {

		if (okHttpClient == null)
			initOkHttp(context);

		if (retrofit == null) {
			retrofit = new Retrofit.Builder()
					.baseUrl(Constant.DEFAULT_URL)
					.client(okHttpClient)
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.addConverterFactory(GsonConverterFactory.create())
					.build();
		}
		return retrofit;
	}

	private static void initOkHttp(final Context context) {
		OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
				.connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
				.writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
		okHttpClient = httpClient.build();
	}
}
