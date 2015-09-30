package in.raveesh.proteusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import in.raveesh.proteus.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        final TextView textView = (TextView)findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int s = random.nextInt(4 - 0);
                switch (s) {
                    case 0:
                        imageView.setPaintedDrawableFromResource(R.drawable.ic_action_thumbs_up,
                                android.R.color.holo_blue_bright);
                        textView.setText("Blue");
                        break;
                    case 1:
                        imageView.setPaintedDrawableFromResource(R.drawable.ic_action_thumbs_up,
                                android.R.color.holo_green_light);
                        textView.setText("Green");
                        break;
                    case 2:
                        imageView.setPaintedDrawableFromResource(R.drawable.ic_action_thumbs_up,
                                android.R.color.holo_orange_light);
                        textView.setText("Orange");
                        break;
                    case 3:
                        imageView.setPaintedDrawableFromResource(R.drawable.ic_action_thumbs_up,
                                android.R.color.holo_purple);
                        textView.setText("Purple");
                        break;
                }
            }
        });
    }
}
