package nwHacks.finTech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

        ImageView imageViewLogo = findViewById(R.id.imageViewLogo);
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        imageViewLogo.startAnimation(animSlide);

    }
}
