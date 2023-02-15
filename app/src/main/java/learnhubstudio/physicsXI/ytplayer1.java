package learnhubstudio.physicsXI;

import android.os.Bundle;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ytplayer1 extends  YouTubeFailureRecoveryActivity {

    private YouTubePlayerView playerView;
    private String youtube_url;
    public videoid videos;

    // IMPORTANT : CHANGE THIS
    String DEVELOPER_KEY = "AIzaSyAncq52MFh-iDubXtg-Nkmg3dJp_ka1YyQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ytplayer1);

        videos = new videoid();
        // The unique video id of the youtube video (can be obtained from video url)
        youtube_url = videos.getVideourl() ;

        playerView =  findViewById(R.id.player);
        playerView.initialize(DEVELOPER_KEY, this);



    }



    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setShowFullscreenButton(false);
        player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

        if (!wasRestored) {
            player.loadVideo(youtube_url);
        }

    }
}