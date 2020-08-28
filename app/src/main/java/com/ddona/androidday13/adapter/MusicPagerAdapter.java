package com.ddona.androidday13.adapter;

import com.ddona.androidday13.fragment.AlbumFragment;
import com.ddona.androidday13.fragment.ArtistFragment;
import com.ddona.androidday13.fragment.SongFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MusicPagerAdapter extends FragmentPagerAdapter {
    private String[] titles = new String[]{"Song", "Album", "Artist"};

    public MusicPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SongFragment();
            case 1:
                return new AlbumFragment();
            case 2:
                return new ArtistFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
