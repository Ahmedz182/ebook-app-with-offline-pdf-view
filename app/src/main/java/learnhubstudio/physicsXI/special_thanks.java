package learnhubstudio.physicsXI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import static android.content.ContentValues.TAG;

public class special_thanks extends AppCompatActivity {
//    TemplateView templateView;
    InterstitialAd mInterstitialAd;
    InterstitialAd interstitial;
    AdView adView;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_thanks);
        cardView=findViewById(R.id.cardad2);
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        cardView.setVisibility(View.VISIBLE);
        adView.loadAd(adRequest);

        InterstitialAd.load(this, getString(R.string.admob_interstetial_ad),
                adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                displayInterstitial();
                Log.i(TAG, "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.i(TAG, loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });
//        MobileAds.initialize(this, "ca-app-pub-8622346357576754~3184307592");
//        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-8622346357576754/6857007722")
//                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//                    @Override
//                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                        NativeTemplateStyle styles = new
//                                NativeTemplateStyle.Builder().build();
//
//                        templateView = findViewById(R.id.my_template);
//                        templateView.setStyles(styles);
//                        templateView.setNativeAd(unifiedNativeAd);
//                        templateView.setVisibility(View.VISIBLE);
//
//
//                    }
//                })
//                .build();
//
//        adLoader.loadAd(new AdRequest.Builder().build());
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd != null) {
            mInterstitialAd.show(special_thanks.this);
        }


    }
}