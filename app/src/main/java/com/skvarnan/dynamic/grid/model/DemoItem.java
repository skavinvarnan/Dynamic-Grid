package com.skvarnan.dynamic.grid.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

import java.util.Random;


public class DemoItem implements AsymmetricItem {

    private int columnSpan;
    private int rowSpan;
    private int position;

    public String getImageUrl() {
        return imageUrl;
    }

    private String imageUrl;
    private final static String imageUrlList[] = {
            "http://www.skyhdwallpaper.com/wp-content/uploads/2014/10/Garden-Wallpaper.jpg",
            "http://3.bp.blogspot.com/-skljk_nQeDY/Uk5vU_gsk2I/AAAAAAAABW8/AzjlmknCNTc/s1600/desktop+backgrounds+%25283%2529.jpg",
            "http://2.bp.blogspot.com/_7wdfsw0zScg/TIXJ6NdEhXI/AAAAAAAADZA/5lGkNjS5cZM/s1600/Beautiful+Examples+of+Green+Photography+(12).jpg",
            "http://farm2.static.flickr.com/1234/1477263188_0c8305442a_b.jpg",
            "http://www.ilikewallpaper.net/ipad-air-wallpapers/download/23345/Cute-Fish-Ocean-Sea-Animal-Nature-ipad-air-wallpaper-ilikewallpaper_com_1024.jpg",
            "http://1.bp.blogspot.com/-eHgDxOUpjQU/U6vhJDRlcFI/AAAAAAAA5I8/q246P6rqUcE/s1600/2014-05-05-09-58-29_photo.jpg",
            "http://www.urwallpapers.com/download/6345/Funny/funny_animal_wallpaper-1024x1024.jpg",
            "http://tourstokerala.org/wp-content/uploads/2014/02/23-TOURS-TO-KERALA-16.jpg",
            "http://2.bp.blogspot.com/_7wdfsw0zScg/TIXJ6NdEhXI/AAAAAAAADZA/5lGkNjS5cZM/s1600/Beautiful+Examples+of+Green+Photography+(12).jpg"};

    public DemoItem() {
        this(1, 1, 0);
    }

    public DemoItem(int columnSpan, int rowSpan, int position) {
        this.columnSpan = columnSpan;
        this.rowSpan = rowSpan;
        this.position = position;
        this.imageUrl = generateImageUrl();
    }

    private String generateImageUrl() {
        return getRandom(imageUrlList);
    }

    public DemoItem(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int getColumnSpan() {
        return columnSpan;
    }

    @Override
    public int getRowSpan() {
        return rowSpan;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("%s: %sx%s", position, rowSpan, columnSpan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private void readFromParcel(Parcel in) {
        columnSpan = in.readInt();
        rowSpan = in.readInt();
        position = in.readInt();
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(columnSpan);
        dest.writeInt(rowSpan);
        dest.writeInt(position);
    }

    /* Parcelable interface implementation */
    public static final Parcelable.Creator<DemoItem> CREATOR = new Parcelable.Creator<DemoItem>() {

        @Override
        public DemoItem createFromParcel(@NonNull Parcel in) {
            return new DemoItem(in);
        }

        @Override
        @NonNull
        public DemoItem[] newArray(int size) {
            return new DemoItem[size];
        }
    };

    public static String getRandom(String array[]) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
