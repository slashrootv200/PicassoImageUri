package in.curium.picassotest.picassotest;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageView iv = (ImageView) findViewById(R.id.image);
    Picasso.with(this)
        .load(Uri.parse(
            "http://d3lca4hm3yw4jx.cloudfront.net/medialibrary/Empire+2/photos_thumb/Empire2.jpg"))
        .fit()
        .error(android.R.drawable.stat_notify_error)
        .centerCrop()
        .into(iv, new Callback() {
          @Override
          public void onSuccess() {

          }

          @Override
          public void onError() {
            Log.d("error", "error");
          }
        });
  }
}
