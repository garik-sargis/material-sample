package com.gs.android.materialsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class PageFragment extends Fragment {

    public static final String ARG_PAGE_NUMBER = "page_number";

    public static PageFragment create(int pageNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, pageNumber);

        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public static List<String> genList(String prefix, int size) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            strings.add(String.format("%s-item-%d", prefix, i));
        }

        return strings;
    }

    private int mPageNumber;

    @Bind(R.id.grid)
    protected RecyclerView mGrid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mPageNumber = args.getInt(ARG_PAGE_NUMBER, 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page, container, false);

        ButterKnife.bind(this, rootView);

        String prefix = String.format("#%d", mPageNumber);
        List<String> strings = genList(prefix, 50);

        mGrid.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mGrid.setLayoutManager(layoutManager);

        int spacing = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
        mGrid.addItemDecoration(new GridSpacingItemDecoration(2, spacing, true));

        SampleGridAdapter adapter = new SampleGridAdapter(strings);
        mGrid.setAdapter(adapter);

        return rootView;
    }
}
