package com.example.evaa;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable, SectionTitleProvider {

    public ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImageNamesFull;  // for search

    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<Integer> mImagesFull;

    private ArrayList<String> mAlternative = new ArrayList<>();
    private ArrayList<String> mAlternativeFull;

    private ArrayList<String> mDisposal = new ArrayList<>();
    private ArrayList<String> mDisposalFull;

    private Fragment mFragment;

    public RecyclerViewAdapter(ArrayList<String> imageNames, ArrayList<Integer> images,  ArrayList<String> alternative, ArrayList<String> disposal, Fragment currentFragment) {
        this.mImageNames = imageNames;
        mImageNamesFull = new ArrayList<>(imageNames);  // copy of imageNames

        this.mImages = images;
        mImagesFull = new ArrayList<>(images);

        this.mAlternative = alternative;
        mAlternativeFull = new ArrayList<>(alternative);

        this.mDisposal = disposal;
        mDisposalFull = new ArrayList<>(disposal);

        this.mFragment = currentFragment;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position) {

        holder.image.setImageResource(mImages.get(position));

        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new ItemFragment();
                FragmentManager manager = mFragment.getFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putInt("image_url", mImages.get(position));
                bundle.putString("image_name", mImageNames.get(position));
                bundle.putString("image_alternative", mAlternative.get(position));
                bundle.putString("image_disposal", mDisposal.get(position));
                fragment.setArguments(bundle);
                manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    // filterable method
    @Override
    public Filter getFilter() {
        return imageNameFilter;
    }

    private Filter imageNameFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Integer> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0)
            {
                for (String item : mImageNamesFull) {
                    filteredList.add(mImageNamesFull.indexOf(item));
                }
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (String item : mImageNamesFull) {
                    if (item.toLowerCase().contains(filterPattern)) {
                        filteredList.add(mImageNamesFull.indexOf(item));
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mImageNames.clear();
            mImages.clear();
            mAlternative.clear();
            mDisposal.clear();

            for (Object i : (List) filterResults.values) {
                mImageNames.add(mImageNamesFull.get((int) i));
                mImages.add(mImagesFull.get((int) i));
                mAlternative.add(mAlternativeFull.get((int) i));
                mDisposal.add(mDisposalFull.get((int) i));
            }

            notifyDataSetChanged();
        }
    };

    // fast scroll
    @Override
    public String getSectionTitle(int position) {
        return mImageNames.get(position).substring(0, 1);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
