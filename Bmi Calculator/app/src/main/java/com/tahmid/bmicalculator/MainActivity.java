package com.tahmid.bmicalculator;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    AdView mAdView;
    EditText ed1, ed2, ed3;
    Button but1;
    TextView text1;

    private InterstitialAd mInterstitialAd;
    ImageButton next1, next2, next3, next4;
    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        but1 = findViewById(R.id.but1);
        text1 = findViewById(R.id.text1);
        next1 = findViewById(R.id.next1);
        next2 = findViewById(R.id.next2);
        next3 = findViewById(R.id.next3);
        next4 = findViewById(R.id.next4);

        textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edd1 = ed1.getText().toString();
                String edd2 = ed2.getText().toString();
                String edd3 = ed3.getText().toString();
                if (edd1.length() > 0 && edd2.length() > 0 && edd3.length() > 0) {
                    int eddd1 = Integer.parseInt(edd1);
                    int eddd2 = Integer.parseInt(edd2);
                    double height1 = eddd2 * 0.3048;
                    int eddd3 = Integer.parseInt(edd3);
                    double height2 = eddd3 * 0.0254;
                    double myheight = height1 + height2;
                    int bmi = (int) (eddd1 / (myheight * myheight));
                    text1.setText("YOUR BMI IS: " + bmi);
                    textToSpeech.speak("Your BMI Is:" + bmi, TextToSpeech.QUEUE_FLUSH, null, null);

                    if (bmi >= 18 && bmi <= 24) {
                        Toast.makeText(MainActivity.this, "Your Weight Is Normal", Toast.LENGTH_SHORT).show();

                    } else {
                        if (bmi < 18) {
                            Toast.makeText(MainActivity.this, "You Are Underweight", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "You Are Overweight", Toast.LENGTH_SHORT).show();
                        }

                    }

                } else {
                    if (edd1.length() <= 0) {
                        ed1.setError("Enter a Number");
                        Toast.makeText(MainActivity.this, "Please Enter Your Weight", Toast.LENGTH_SHORT).show();
                        textToSpeech.speak("Please Enter Your Weight", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (edd2.length() <= 0) {
                        ed2.setError("Enter A Number");
                        Toast.makeText(MainActivity.this, "Please Enter Your Height", Toast.LENGTH_SHORT).show();
                        textToSpeech.speak("Please Enter Your Height", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (edd3.length() <= 0) {
                        ed3.setError("Enter a Number");
                        Toast.makeText(MainActivity.this, "Please Enter Your Height", Toast.LENGTH_SHORT).show();
                        textToSpeech.speak("Please Enter Your Height", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else {
                        Toast.makeText(MainActivity.this, "Something is Wrong", Toast.LENGTH_SHORT).show();
                        textToSpeech.speak("Something is wrong", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }

            }
        });

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVIT Y_SERVICE);
//NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
                //if(network!=null){
                // }
                // else{
// new AlertDialog.Builder(MainActivity.this) // .setTitle("ReConnect Internet")

// .setMessage("Please check your Internet Connection")
// .show();
                loadFullScreenAds();
                MainActivity2.collect = "https://www.youtube.com/embed/R30JGe23A24";
                Intent game = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(game);
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFullScreenAds();
                MainActivity2.collect = "https://www.youtube.com/embed/o20sLxinfwc";
                Intent game = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(game);
            }
        });

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFullScreenAds();
                MainActivity2.collect = "https://www.youtube.com/embed/bW9GFg8NUDE";
                Intent game = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(game);
            }
        });

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFullScreenAds();
                MainActivity2.collect = "https://www.youtube.com/embed/9o0UPuDBM8M";
                Intent game = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(game);
            }
        });

    }

    private void loadFullScreenAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        InterstitialAd.load(this, "ca-app-pub-8931936554324369/2116324038", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                Log.d(TAG, "Ad was clicked.");
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d(TAG, "Ad dismissed fullscreen content.");
                                mInterstitialAd = null;
                                loadFullScreenAds();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                Log.e(TAG, "Ad failed to show fullscreen content.");
                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                Log.d(TAG, "Ad recorded an impression.");

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                Log.d(TAG, "Ad showed fullscreen content.");
                            }
                        });

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit?")
                .setMessage("Are You Want To Exit?")
                .setIcon(R.drawable.bmi)
                .setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAndRemoveTask();
                    }
                })
                .show();
    }


}
