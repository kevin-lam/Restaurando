package com.kevinlamcs.android.restaurando.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing user's filter option choices.
 */
public class FilterOptions implements Parcelable {

    private boolean isSelectAllFiltered;
    private List<String> filteredCategories;
    private List<String> allCategories;
    private boolean isFilterFinished;
    private String sortBy;

    public FilterOptions() {
        this.filteredCategories = new ArrayList<>();
        this.allCategories = new ArrayList<>();
        this.isFilterFinished = true;
        this.sortBy = "Category";
    }

    public boolean isSelectAllFiltered() {
        return isSelectAllFiltered;
    }

    public void setIsSelectAllFiltered(boolean isSelectAllFiltered) {
        this.isSelectAllFiltered = isSelectAllFiltered;
    }

    public List<String> getFilteredCategories() {
        return filteredCategories;
    }

    public void setIsFilterFinished(boolean isFilterFinished) {
        this.isFilterFinished = isFilterFinished;
    }

    public void clearFilteredCategories() {
        this.filteredCategories.clear();
    }

    public void setFilteredCategories(List<String> filteredCategories) {
        this.filteredCategories = filteredCategories;
    }

    public List<String> getAllCategories() {
        return allCategories;
    }

    public void setAllCategories(List<String> allCategories) {
        this.allCategories = allCategories;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    private FilterOptions(Parcel in) {
        this.filteredCategories = new ArrayList<>();
        this.allCategories = new ArrayList<>();

        boolean[] booleanArray = new boolean[2];
        in.readBooleanArray(booleanArray);
        this.isSelectAllFiltered = booleanArray[0];
        this.isFilterFinished = booleanArray[1];

        in.readStringList(filteredCategories);
        in.readStringList(allCategories);

        this.sortBy = in.readString();
    }

    public static final Creator<FilterOptions> CREATOR = new Creator<FilterOptions>() {
        @Override
        public FilterOptions createFromParcel(Parcel in) {
            return new FilterOptions(in);
        }

        @Override
        public FilterOptions[] newArray(int size) {
            return new FilterOptions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBooleanArray(new boolean[] {this.isSelectAllFiltered, this.isFilterFinished});
        dest.writeStringList(filteredCategories);
        dest.writeStringList(allCategories);
        dest.writeString(sortBy);
    }
}
