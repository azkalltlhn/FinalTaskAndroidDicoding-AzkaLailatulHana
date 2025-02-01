package com.example.tugasandroiddicoding_azkalailatulhana;

import android.os.Parcel;
import android.os.Parcelable;

public class Info implements Parcelable {
    private String name;
    private String detail;
    private String shortDescription;  // Deskripsi singkat
    private int photo;

    // Constructor default (tanpa parameter)
    public Info() {
    }

    // Constructor dengan parameter
    public Info(String name, String detail, String shortDescription, int photo) {
        this.name = name;
        this.detail = detail;
        this.shortDescription = shortDescription;
        this.photo = photo;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    // Implementasi Parcelable
    protected Info(Parcel in) {
        name = in.readString();
        detail = in.readString();
        shortDescription = in.readString();  // Membaca deskripsi singkat dari Parcel
        photo = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeString(shortDescription);  // Menyimpan deskripsi singkat ke Parcel
        dest.writeInt(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };
}
