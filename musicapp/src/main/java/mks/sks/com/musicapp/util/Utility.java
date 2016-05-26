package mks.sks.com.musicapp.util;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

import mks.sks.com.musicapp.R;

/**
 * Created by user on 5/22/2016.
 */
public class Utility {

    private static final String TAG = "Utility";

    public static String convertSecondsToHMmSs(long seconds) {
        long s = (seconds/1000) % 60;
        long m = ((seconds/1000) / 60) % 60;
        long h = ((seconds/1000) / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h,m,s);
    }


    public static Bitmap getAlbumArt(Context context, Long album_id) {
        Uri sArtworkUri = Uri
                .parse("content://media/external/audio/albumart");
        Uri albumArtUri = ContentUris.withAppendedId(sArtworkUri, album_id);

        Log.d(TAG,"CodeFlow "+albumArtUri.toString());
        Bitmap bitmap = null;
        try {
            bitmap = android.provider.MediaStore.Images.Media.getBitmap(
                    context.getContentResolver(), albumArtUri);
            bitmap = Bitmap.createScaledBitmap(bitmap, 80, 80, true);

        } catch (FileNotFoundException exception) {
            Log.d(TAG,"CodeFlow Exception "+exception.getMessage());
            exception.printStackTrace();
            bitmap = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher);
        } catch (IOException e) {
            Log.d(TAG,"CodeFlow Exception "+e.getMessage());
            e.printStackTrace();
        }
            return bitmap;
    }
}
