 package learnhubstudio.physicsXI;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import com.budiyev.android.circularprogressbar.CircularProgressBar;
//import com.facebook.ads.AdSize;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.File;

import static android.content.ContentValues.TAG;


public class Chapter extends AppCompatActivity implements View.OnClickListener {
    public PDFView pdfview;
    LinearLayout pdf_layout;
//    TemplateView templateView;
//    InterstitialAd mInterstitialAd;
//    InterstitialAd interstitial;
    CardView cardView1,cardView2;

    AdView adView;
//    private com.facebook.ads.AdView adViewfb;

    private final String[] chp = {
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%201.pdf?alt=media&token=c16913c0-01fa-4795-af30-4474c0c0ae90",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%202.pdf?alt=media&token=01ed2658-6509-47eb-83bf-2ea8f0d357e4",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%203.pdf?alt=media&token=5bde70d0-d7de-4b0a-a370-c4c8023d4b89",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%204.pdf?alt=media&token=24524941-a628-44c2-8149-4086de62dfde",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%205.pdf?alt=media&token=fa5ea810-23d7-4484-b464-9feb05748879",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%206.pdf?alt=media&token=f1be7a5b-6a6a-4846-a3c4-4c3b46220460",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%207.pdf?alt=media&token=ac141d1e-66a6-4ac1-ae36-1c5d8780f486",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%208.pdf?alt=media&token=b83c9960-fda2-4842-bb02-4ac9d3cc8177",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%209.pdf?alt=media&token=f3f3afb2-6db0-46c6-afdc-bfe0a4d73373",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%2010.pdf?alt=media&token=4f1d1dd2-cbac-4009-a58b-981516a7d5f3",
    "https://firebasestorage.googleapis.com/v0/b/physics-xi-9c187.appspot.com/o/physics%2011.pdf?alt=media&token=06ec3dfe-a3b0-4e97-8cb7-e2e46794c857"
    };

    private final String path = "/Android/data/learnhubstudio.physicsXI/files/Download/";

    ImageView[] downloadImage;
    CircularProgressBar[] progressBar;
    CardView[] chapter_card;

    private int[] n = {0,1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        cardView1 =findViewById(R.id.cardad1);
        cardView2 =findViewById(R.id.cardad2);
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        cardView1.setVisibility(View.VISIBLE);
        adView = findViewById(R.id.adView1);
        AdRequest ad2 = new AdRequest.Builder().build();
        adView.loadAd(ad2);
        cardView2.setVisibility(View.VISIBLE);

//        InterstitialAd.load(this, getString(R.string.admob_interstetial_ad), adRequest, new InterstitialAdLoadCallback() {
//            @Override
//            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                // The mInterstitialAd reference will be null until
//                // an ad is loaded.
////                mInterstitialAd = interstitialAd;
//                displayInterstitial();
//                Log.i(TAG, "onAdLoaded");
//            }
//
//            @Override
//            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                // Handle the error
//                Log.i(TAG, loadAdError.getMessage());
////                mInterstitialAd = null;
//            }
//        });
//        loadBanner();
//        AdRequest adRequest1 = new AdRequest.Builder().build();
//        // Prepare the Interstitial Ad
//        interstitial = new InterstitialAd(this) {
//        };
//// Insert the Ad Unit ID
//        interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
//
//        interstitial.loadAd(adRequest1);

//        MobileAds.initialize(this, "ca-app-pub-8622346357576754~3184307592");
//        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/1044960115")
//                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//                    @Override
//                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                        NativeTemplateStyle styles = new
//                                NativeTemplateStyle.Builder().build();
//
//                        templateView = findViewById(R.id.my_template);
//                        templateView.setStyles(styles);
//                        templateView.setNativeAd(unifiedNativeAd);
//
//
//
//                    }
//                })
//                .build();
//
//        adLoader.loadAd(new AdRequest.Builder().build());

        Switch sb = new Switch(this);
        sb.setTextOff("OFF");
        sb.setTextOn("ON");
        sb.setChecked(false);
        pdfview = findViewById(R.id.pdfView);
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pdfview.setNightMode(true);
                } else {
                    pdfview.setNightMode(false);
                }
            }
        });
        pdf_layout = findViewById(R.id.pdfshow);

        downloadImage = new ImageView[11];

        downloadImage[0] = findViewById(R.id.imgdwnld1);
        downloadImage[1] = findViewById(R.id.imgdwnld2);
        downloadImage[2] = findViewById(R.id.imgdwnld3);
        downloadImage[3] = findViewById(R.id.imgdwnld4);
        downloadImage[4] = findViewById(R.id.imgdwnld5);
        downloadImage[5] = findViewById(R.id.imgdwnld6);
        downloadImage[6] = findViewById(R.id.imgdwnld7);
        downloadImage[7] = findViewById(R.id.imgdwnld8);
        downloadImage[8] = findViewById(R.id.imgdwnld9);
        downloadImage[9] = findViewById(R.id.imgdwnld10);
        downloadImage[10] = findViewById(R.id.imgdwnld11);

        progressBar = new CircularProgressBar[11];

        progressBar[0] = findViewById(R.id.progress_bar1);
        progressBar[1] = findViewById(R.id.progress_bar2);
        progressBar[2] = findViewById(R.id.progress_bar3);
        progressBar[3] = findViewById(R.id.progress_bar4);
        progressBar[4] = findViewById(R.id.progress_bar5);
        progressBar[5] = findViewById(R.id.progress_bar6);
        progressBar[6] = findViewById(R.id.progress_bar7);
        progressBar[7] = findViewById(R.id.progress_bar8);
        progressBar[8] = findViewById(R.id.progress_bar9);
        progressBar[9] = findViewById(R.id.progress_bar10);
        progressBar[10] = findViewById(R.id.progress_bar11);

        chapter_card = new CardView[11];

        chapter_card[0] = findViewById(R.id.chpt1_card);
        chapter_card[1] = findViewById(R.id.chpt2_card);
        chapter_card[2] = findViewById(R.id.chpt3_card);
        chapter_card[3] = findViewById(R.id.chpt4_card);
        chapter_card[4] = findViewById(R.id.chpt5_card);
        chapter_card[5] = findViewById(R.id.chpt6_card);
        chapter_card[6] = findViewById(R.id.chpt7_card);
        chapter_card[7] = findViewById(R.id.chpt8_card);
        chapter_card[8] = findViewById(R.id.chpt9_card);
        chapter_card[9] = findViewById(R.id.chpt10_card);
        chapter_card[10] = findViewById(R.id.chpt11_card);


        for(int i = 0 ; i<11 ; i++){
            String strn = String.valueOf(i+1);
            String chapter = "Chapter "+strn+".pdf";
            Log.d("chapter___ ",chapter);
            File ch_file = new File(Environment.getExternalStorageDirectory(),path + chapter);
            if (ch_file.canRead()) {
                downloadImage[i].setVisibility(View.GONE);
                progressBar[i].setVisibility(View.GONE);
                chapter_card[i].setClickable(true);
            }
            else{
                chapter_card[i].setClickable(false);
                progressBar[i].setVisibility(View.GONE);
                downloadImage[i].setVisibility(View.VISIBLE);
            }

        }

        for(int i = 0 ;i<11 ; i++){
            downloadImage[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imgdwnld1:
                downloadFile1();
                break;
            case R.id.imgdwnld2:
                downloadFile2();
                break;
            case R.id.imgdwnld3:
                downloadFile3();
                break;
            case R.id.imgdwnld4:
                downloadFile4();
                break;
            case R.id.imgdwnld5:
                downloadFile5();
                break;
            case R.id.imgdwnld6:
                downloadFile6();
                break;
            case R.id.imgdwnld7:
                downloadFile7();
                break;
            case R.id.imgdwnld8:
                downloadFile8();
                break;
            case R.id.imgdwnld9:
                downloadFile9();
                break;
            case R.id.imgdwnld10:
                downloadFile10();
                break;
            case R.id.imgdwnld11:
                downloadFile11();
                break;
        }
    }

    @SuppressLint("StaticFieldLeak")
    public void downloadFile1() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[0]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[0]].setVisibility(View.GONE);
                progressBar[n[0]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[0]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor
                            .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[0]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[0]].setVisibility(View.GONE);
                chapter_card[n[0]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile2() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[1]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[1]].setVisibility(View.GONE);
                progressBar[n[1]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[1]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor
                            .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[1]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[1]].setVisibility(View.GONE);
                chapter_card[n[1]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile3() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[2]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[2]].setVisibility(View.GONE);
                progressBar[n[2]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[2]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor
                            .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[2]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[2]].setVisibility(View.GONE);
                chapter_card[n[2]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile4() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[3]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[3]].setVisibility(View.GONE);
                progressBar[n[3]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[3]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[3]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[3]].setVisibility(View.GONE);
                chapter_card[n[3]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile5() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[4]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[4]].setVisibility(View.GONE);
                progressBar[n[4]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[4]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[4]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[4]].setVisibility(View.GONE);
                chapter_card[n[4]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile6() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[5]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[5]].setVisibility(View.GONE);
                progressBar[n[5]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[5]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[5]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[5]].setVisibility(View.GONE);
                chapter_card[n[5]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile7() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[6]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[6]].setVisibility(View.GONE);
                progressBar[n[6]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[6]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[6]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[6]].setVisibility(View.GONE);
                chapter_card[n[6]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile8() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[7]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[7]].setVisibility(View.GONE);
                progressBar[n[7]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[7]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[7]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[7]].setVisibility(View.GONE);
                chapter_card[n[7]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile9() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[8]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[8]].setVisibility(View.GONE);
                progressBar[n[8]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[8]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[8]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[8]].setVisibility(View.GONE);
                chapter_card[n[8]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile10() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[9]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[9]].setVisibility(View.GONE);
                progressBar[n[9]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[9]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[9]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[9]].setVisibility(View.GONE);
                chapter_card[n[9]].setClickable(true);
            }
        }.execute(uri);


    }
    @SuppressLint("StaticFieldLeak")
    public void downloadFile11() {


        final DownloadManager downloadmanager = (DownloadManager) this.
                getSystemService(Context.DOWNLOAD_SERVICE);
        final Uri uri = Uri.parse(chp[n[10]]);

        new AsyncTask<Uri, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getApplicationContext(),"Downloading Start..",Toast.LENGTH_SHORT).show();
                downloadImage[n[10]].setVisibility(View.GONE);
                progressBar[n[10]].setVisibility(View.VISIBLE);
            }

            @SuppressLint("Range")
            @Override
            protected Integer doInBackground(Uri... uris) {
                String strn = String.valueOf(n[10]+1);
                String chapter = "Chapter "+strn+".pdf";

                DownloadManager.Request request = new DownloadManager.Request(uris[0]);

//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, chapter);
                Log.d("Ahmed _ path", Environment.DIRECTORY_DOWNLOADS+ chapter );

                Long downloadId = downloadmanager.enqueue(request);
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);

                    Cursor cursor = downloadmanager.query(q);

                    cursor.moveToFirst();

                    @SuppressLint("Range") int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));

                    @SuppressLint("Range") int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    final int dl_progress = (int) ((bytes_downloaded * 100L) / bytes_total);
                    Log.d("progressbar value>>>> ",String.valueOf(dl_progress));
                    publishProgress(dl_progress);

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    cursor.close();

                }

                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar[n[10]].setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"Downloading Complete..",Toast.LENGTH_LONG).show();
                progressBar[n[10]].setVisibility(View.GONE);
                chapter_card[n[10]].setClickable(true);
            }
        }.execute(uri);


    }


    public void openchapter(String name){

        pdf_layout.setVisibility(View.VISIBLE);

        try {
            File pdffile = new File(Environment.getExternalStorageDirectory(),path + name);

            pdfview.fromFile(pdffile).onError(new OnErrorListener() {
                @Override
                public void onError(Throwable t) {
                    Log.d("Ahmed _ error :  ___  ", t.toString());
                }
            })
                    .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                    .pageFitPolicy(FitPolicy.WIDTH)
                    .pageSnap(true) // snap pages to screen boundaries
                    .pageFling(true) // make a fling change only a single page like ViewPager
                    .nightMode(false) // toggle night mode
                    .enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true))
                    .load();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Something wrong to load Chapter...",Toast.LENGTH_LONG).show();
        }
//        // Prepare an Interstitial Ad Listener
//        interstitial.setAdListener(new AdListener() {
//            public void onAdLoaded() {
//                // Call displayInterstitial() function
//                displayInterstitial();
//            }
//        });

    }

    public void chpt1(View view) {
        openchapter("chapter 1.pdf");
    }

    public void chptr2(View view) {
        openchapter("Chapter 2.pdf");
    }

    public void chptr3(View view) {
        openchapter("Chapter 3.pdf");
    }

    public void chptr4(View view) {
        openchapter("Chapter 4.pdf");
    }

    public void chptr5(View view) {
        openchapter("Chapter 5.pdf");
    }

    public void chptr6(View view) {
        openchapter("Chapter 6.pdf");
    }

    public void chptr7(View view) {
        openchapter("Chapter 7.pdf");
    }

    public void chpt8(View view) {
        openchapter("Chapter 8.pdf");
    }

    public void chpt9(View view) {
        openchapter("chapter 9.pdf");
    }

    public void chpt10(View view) {
        openchapter("chapter 10.pdf");
    }

    public void chpt11(View view) {
        openchapter("Chapter 11.pdf");
    }

    @Override
    public void onBackPressed() {
        if (pdf_layout.isShown()) {
            pdf_layout.setVisibility(View.GONE);
        }
        else
            super.onBackPressed();
    }
//    public void displayInterstitial() {
//// If Ads are loaded, show Interstitial else show nothing.
//        if (interstitial.isLoaded()) {
//            interstitial.show();
//        }
//
//
//    }
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
//public void displayInterstitial() {
//// If Ads are loaded, show Interstitial else show nothing.
//    if (mInterstitialAd != null) {
//        mInterstitialAd.show(Chapter.this);
//    }


}


