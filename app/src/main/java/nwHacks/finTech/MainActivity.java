package nwHacks.finTech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("mmmmmmmmmmmmcofe");
        myRef.setValue("Hello, World!");

        Button buttonEnter = findViewById(R.id.buttonEnter);
        buttonEnter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intentMenu);
            }
        });


//        ImageView imageViewLogo = findViewById(R.id.imageViewLogo);
//        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
//        imageViewLogo.startAnimation(animSlide);

    }
}
