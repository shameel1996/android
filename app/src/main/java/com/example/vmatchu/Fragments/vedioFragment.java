package com.example.vmatchu.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.vmatchu.R;

public class vedioFragment extends Fragment {

    VideoView videoView;
    MediaController mControler;

    public vedioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.video_fragment, container, false);
//        videoView = (VideoView) rootView.findViewById(R.id.videoview);
//        mControler = new MediaController(getContext());
//
//
//        videoView = (VideoView) rootView.findViewById(R.id.videoview);
//        String path = "";
//        Uri uri = Uri.parse(path);
//        videoView.setMediaController(mControler);
//        mControler.setAnchorView(videoView);
//        videoView.setVideoURI(uri);
//        videoView.start();
        return rootView;
    }
}
