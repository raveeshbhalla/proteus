package in.raveesh.proteusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

import in.raveesh.proteus.ImageButton;
import in.raveesh.proteus.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        final ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int s = random.nextInt(3 - 0);
                switch (s){
                    case 0:
                        imageView.setPaintResource(android.R.color.holo_blue_bright);
                        imageButton.setPaintResource(android.R.color.holo_green_light);
                        break;
                    case 1:
                        imageView.setPaintResource(android.R.color.holo_green_light);
                        imageButton.setPaintResource(android.R.color.holo_orange_light);
                        break;
                    case 2:
                        imageView.setPaintResource(android.R.color.holo_orange_light);
                        imageButton.setPaintResource(android.R.color.holo_purple);
                        break;
                    case 3:
                        imageView.setPaintResource(android.R.color.holo_purple);
                        imageButton.setPaintResource(android.R.color.holo_red_light);
                        break;
                }
            }
        });
    }
}
