package ru.chernakov.lorempictures.presentation.view.activity;

import android.os.Bundle;

import ru.chernakov.lorempictures.App;
import ru.chernakov.lorempictures.presentation.navigation.AppScreen;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

public class AppActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		App.getInstance().getAppComponent().inject(this);
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {
			AppScreen screen = new AppScreen(AppScreen.FEED_FRAGMENT_TAG);
			mNavigator.applyCommands(new Command[]{new Replace(screen)});
		}
	}
}
