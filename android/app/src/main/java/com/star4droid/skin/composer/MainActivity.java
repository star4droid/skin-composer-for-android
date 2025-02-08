package com.star4droid.skin.composer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.ray3k.skincomposer.Main;
import com.star4droid.skin.composer.utils.AppLogger;

public class MainActivity extends AndroidApplication {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Main.desktopWorker = new Worker();
	initialize(new Main(new String[]{}));
	Gdx.app.setApplicationLogger(new AppLogger());
  }
}
