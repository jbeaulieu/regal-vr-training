package com.regal.training;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class AssemblyFragment extends Fragment {


    public AssemblyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_assembly, container, false);

        // Need to explore savedInstanceState
        super.onCreate(savedInstanceState);

        // initialize vid 1 parameters
        String vid1_View = "vidView1";
        String vid1_Name = "connections";

        // initialize vid 2 parameters
        String vid2_View = "vidView2";
        String vid2_Name = "end_bell_and_rotor";

        // initialize Video instances
        Video(v, vid1_View, vid1_Name);
        Video(v, vid2_View, vid2_Name);

        return v;
    }

    public void Video(View v, String vidViewName, String vidName){
        VideoView videoView;
        MediaController mediaController;

        int vid_ID = retrieveID(vidViewName, "id");
        videoView = (VideoView) v.findViewById(vid_ID);
        mediaController = new MediaController(getActivity());

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // set video path
        int vid_Raw = retrieveID(vidName, "raw");
        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName()+"/"+vid_Raw));
    }

    public int retrieveID(String name, String type){
        return getResources().getIdentifier(name, type, getActivity().getPackageName());
    }
}
