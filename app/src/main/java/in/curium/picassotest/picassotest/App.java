package in.curium.picassotest.picassotest;

import android.app.Application;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    init();
  }

  private void init() {
    OkHttpClient client = new OkHttpClient();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    client.interceptors().add(logging);
    Picasso.setSingletonInstance(new Picasso.Builder(this).downloader(new OkHttpDownloader(client))
        .memoryCache(new LruCache(50 * 1024 * 1024))
        .indicatorsEnabled(true)
        .loggingEnabled(true)
        .build());
  }
}
