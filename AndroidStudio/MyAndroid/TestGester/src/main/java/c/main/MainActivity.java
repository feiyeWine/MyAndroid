package c.main;

import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
    private GestureOverlayView gesture;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gesture = (GestureOverlayView)findViewById(R.id.gesture);
        image =(ImageView)findViewById(R.id.image);


    }
}
