package pt.joaocruz.myproductschallenge.feed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pt.joaocruz.myproductschallenge.R;


public class FeedActivity extends AppCompatActivity implements FeedView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    }
}