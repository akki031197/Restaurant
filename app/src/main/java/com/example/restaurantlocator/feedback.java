package com.example.restaurantlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {

    RatingBar mRatingBar;
    TextView mRatingScale;
    EditText mFeedback;
    Button mSendFeedback;

    DatabaseReference db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
          mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
      mRatingScale = (TextView) findViewById(R.id.tvRatingScale);
      mSendFeedback = (Button) findViewById(R.id.btnSubmit);
      mFeedback =(EditText) findViewById(R.id.gravity) ;

      db= FirebaseDatabase.getInstance().getReference("feedback info");


        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            }
        });
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        mRatingScale.setText("Very bad");
                        break;
                    case 2:
                        mRatingScale.setText("Need some improvement");
                        break;
                    case 3:
                        mRatingScale.setText("Good");
                        break;
                    case 4:
                        mRatingScale.setText("Great");
                        break;
                    case 5:
                        mRatingScale.setText("Awesome. I love it");
                        break;
                    default:
                        mRatingScale.setText("");
                }
            }
        });

        mSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  if (mFeedback.getText().toString().isEmpty()) {
                    Toast.makeText(feedback.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    mFeedback.setText("");
                    mRatingBar.setRating(0);
                    Toast.makeText(feedback.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                }*/


              add();
            }

        });



    }

    private void add() {

        String str=mRatingScale.getText().toString().trim();
        String str1=mFeedback.getText().toString().trim();
        if (!TextUtils.isEmpty(str))
        {
            String id=db.push().getKey();
            FeedbackData feedbackData=new FeedbackData(str1,str,id);
            db.child(id).setValue(feedbackData);
            Toast.makeText(feedback.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(feedback.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
        }


    }
}
