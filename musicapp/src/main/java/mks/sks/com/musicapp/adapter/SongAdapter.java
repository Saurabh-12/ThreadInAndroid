package mks.sks.com.musicapp.adapter;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mks.sks.com.musicapp.R;
import mks.sks.com.musicapp.Songs;
import mks.sks.com.musicapp.util.Utility;

/**
 * Created by user on 5/21/2016.
 */
public class SongAdapter extends BaseAdapter {

    private ArrayList<Songs> songs;
    private LayoutInflater songInf;
    private Context mContext;



    public SongAdapter(Context c, ArrayList<Songs> theSongs){
        mContext = c;
        songs=theSongs;
        songInf=LayoutInflater.from(c);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return songs.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //map to song layout
        LinearLayout songLay = (LinearLayout)songInf.inflate(R.layout.song, parent, false);
        //get title and artist views
        TextView songView = (TextView)songLay.findViewById(R.id.song_title_tv);
        TextView artistView = (TextView)songLay.findViewById(R.id.song_artist_tv);
        TextView songSize = (TextView)songLay.findViewById(R.id.song_size_tv);
        ImageView iconView = (ImageView)songLay.findViewById(R.id.song_icon_iv);
        //get song using position
        Songs currSong = songs.get(position);
        //get title and artist strings
        songView.setText(currSong.getTitle());
        artistView.setText(currSong.getArtist());
        songSize.setText(""+ Utility.convertSecondsToHMmSs(currSong.getDuration()));
        if (null != Utility.getAlbumArt(mContext,currSong.getAlbumCover()))
        {
            Drawable drawable = new BitmapDrawable(mContext.getResources(),
                    Utility.getAlbumArt(mContext,currSong.getAlbumCover()));
            iconView.setImageDrawable(drawable);
        }else{
            Drawable drawable = new BitmapDrawable(mContext.getResources(),
                    BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher));
            iconView.setImageDrawable(drawable);
        }
        //set position as tag
        songLay.setTag(position);
        return songLay;
    }
}
