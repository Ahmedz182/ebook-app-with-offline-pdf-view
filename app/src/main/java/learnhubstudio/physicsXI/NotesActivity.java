package learnhubstudio.physicsXI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class NotesActivity extends AppCompatActivity  {

    LinearLayout linearLayout1,lineardwnldpdf,pdfshow;
    ImageView imageView;

    AdView adView;
    TextView textView;
//    TemplateView templateView;
    public PDFView pdf;
CardView cardView1,cardView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
//        loadBanner();
//        loadInterstitialAd();
        pdf = findViewById(R.id.pdfView);
        linearLayout1 = findViewById(R.id.linerpdf);
        pdfshow=findViewById(R.id.pdfshow);
cardView1 =findViewById(R.id.cardad1);
        cardView2 =findViewById(R.id.cardad2);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch sb = new Switch(this);
        sb.setTextOff("OFF");
        sb.setTextOn("ON");
        sb.setChecked(false);
        pdf = findViewById(R.id.pdfView);
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pdf.setNightMode(true);
                } else {
                    pdf.setNightMode(false);
                }
            }
        });

        adView = findViewById(R.id.adView);

        AdRequest adg = new AdRequest.Builder().build();
        adView.loadAd(adg);
        cardView1.setVisibility(View.VISIBLE);
        adView = findViewById(R.id.adView1);
        AdRequest ad2 = new AdRequest.Builder().build();
        adView.loadAd(ad2);
        cardView2.setVisibility(View.VISIBLE);

//Native ad
//        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
//                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//                    @Override
//                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                        NativeTemplateStyle styles = new
//                                NativeTemplateStyle.Builder().build();
//                        templateView = findViewById(R.id.my_template);
//                        templateView.setStyles(styles);
//                        templateView.setNativeAd(unifiedNativeAd);
//
//
//                    }
//                }).build();
//        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public void chpt1(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 1.pdf").pages(1,2,3,4,5,6)
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();


    }
    public void chptr2(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 2.pdf")
                .pages(1,2,3,4,5,6,7,8,9,10,11,12)
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();

    }

    public void chptr3(View view) {
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 3.pdf")
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    public void chptr4(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 4.pdf")
                .pages(1,2,3,4,5,6,7,8)
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    public void chptr5(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 5.pdf")
                .pages(1,2,3,4,5,6)
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    public void chptr6(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 6.pdf")
                .pages(1,2,3,4,5)
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    public void chptr7(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 7.pdf")
                .pages(1,2,3,4,5,6,7)
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    public void chpt8(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 8.pdf")
                .pages(1,2,3,4,5)
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    public void chpt9(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 9.pdf")
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    public void chpt10(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 10.pdf")
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();    }

    public void chpt11(View view) {
        linearLayout1.setVisibility(View.GONE);
        pdfshow.setVisibility(View.VISIBLE);
        pdf.fromAsset("chapter 11.pdf")
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                .load();
    }

    @Override
    public void onBackPressed() {
        if (pdfshow.isShown()){
            linearLayout1.setVisibility(View.VISIBLE);
            pdfshow.setVisibility(View.GONE);
        }else {
        super.onBackPressed();
        }
    }
//    public void loadBanner() {
//        adViewfb = new com.facebook.ads.AdView(this, getResources().getString(R.string.banner_ad), AdSize.BANNER_HEIGHT_50);
//
//        // Find the Ad Container
//        LinearLayout adContainer = findViewById(R.id.banner_container);
//
//        // Add the ad view to your activity layout
//        adContainer.addView(adViewfb);
//
//        // Request an ad
//        adViewfb.loadAd();
//
//    }
//    private void loadInterstitialAd() {
//        interstitialAd = new InterstitialAd(this, getResources().getString(R.string.INTERSTITIAL_PLACEMENT_ID));
//        interstitialAd.setAdListener((InterstitialAdListener) NotesActivity.this);
//        interstitialAd.loadAd();
//    }


}

