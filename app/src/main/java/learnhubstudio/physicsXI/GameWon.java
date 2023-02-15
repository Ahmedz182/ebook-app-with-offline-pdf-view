package learnhubstudio.physicsXI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//
//import com.google.android.ads.nativetemplates.NativeTemplateStyle;
//import com.google.android.ads.nativetemplates.TemplateView;
//import com.google.android.gms.ads.AdLoader;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class GameWon extends Activity {
//    TemplateView templateView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_won);

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

    //This is onclick listener for button
    //it will navigate from this activity to MainGameActivity
    public void PlayAgain(View view) {
        Intent intent = new Intent(GameWon.this, MainGameActivity.class);
        startActivity(intent);
        finish();
    }
    public void backtohome(View view) {
        super.onBackPressed();
        finish();
    }
}
