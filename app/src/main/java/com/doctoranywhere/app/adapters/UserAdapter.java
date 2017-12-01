package com.doctoranywhere.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doctoranywhere.app.R;
import com.doctoranywhere.app.models.UserResult;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final Context mContext;
    private ArrayList<UserResult> mDataset = new ArrayList<>(50);

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ImageView mUserImage;
        public ImageView mImage1;
        public ImageView mImage2;
        public ImageView mImage3;
        public ImageView mImage4;
        public ImageView mImage5;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.name);
            mUserImage = (ImageView) v.findViewById(R.id.user_image);
            mImage1 = (ImageView) v.findViewById(R.id.image1);
            mImage2 = (ImageView) v.findViewById(R.id.image2);
            mImage3 = (ImageView) v.findViewById(R.id.image3);
            mImage4 = (ImageView) v.findViewById(R.id.image4);
            mImage5 = (ImageView) v.findViewById(R.id.image5);

        }
    }

    public UserAdapter(Context context, ArrayList<UserResult> myDataset) {
        mDataset.addAll(myDataset);
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item, parent, false);
        final ViewHolder vh = new ViewHolder(v);


        return vh;
    }

    ArrayList<String> itemImageList = new ArrayList<>(5);

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).getUser());
        Glide.with(mContext).load(mDataset.get(position).getImageUrl()).override(100, 100).into(holder.mUserImage);
        itemImageList.clear();
        itemImageList.addAll(mDataset.get(position).getItemUrlList());
        switch (itemImageList.size()) {
            case 1:
                holder.mImage1.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(itemImageList.get(0)).override(500, 500).into(holder.mImage1);
                holder.mImage2.setVisibility(View.GONE);
                holder.mImage3.setVisibility(View.GONE);
                holder.mImage4.setVisibility(View.GONE);
                holder.mImage5.setVisibility(View.GONE);

                break;
            case 2:
                holder.mImage1.setVisibility(View.GONE);
                holder.mImage2.setVisibility(View.VISIBLE);
                holder.mImage3.setVisibility(View.VISIBLE);
                holder.mImage4.setVisibility(View.GONE);
                holder.mImage5.setVisibility(View.GONE);
                Glide.with(mContext).load(itemImageList.get(0)).override(500, 500).into(holder.mImage2);
                Glide.with(mContext).load(itemImageList.get(1)).override(500, 500).into(holder.mImage3);
                break;
            case 3:
                holder.mImage1.setVisibility(View.VISIBLE);
                holder.mImage2.setVisibility(View.VISIBLE);
                holder.mImage3.setVisibility(View.VISIBLE);
                holder.mImage4.setVisibility(View.GONE);
                holder.mImage5.setVisibility(View.GONE);
                Glide.with(mContext).load(itemImageList.get(0)).override(500, 500).into(holder.mImage1);
                Glide.with(mContext).load(itemImageList.get(1)).override(500, 500).into(holder.mImage2);
                Glide.with(mContext).load(itemImageList.get(2)).override(500, 500).into(holder.mImage3);
                break;
            case 4:
                holder.mImage1.setVisibility(View.GONE);
                holder.mImage2.setVisibility(View.VISIBLE);
                holder.mImage3.setVisibility(View.VISIBLE);
                holder.mImage4.setVisibility(View.VISIBLE);
                holder.mImage5.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(itemImageList.get(0)).override(500, 500).into(holder.mImage2);
                Glide.with(mContext).load(itemImageList.get(1)).override(500, 500).into(holder.mImage3);
                Glide.with(mContext).load(itemImageList.get(2)).override(500, 500).into(holder.mImage4);
                Glide.with(mContext).load(itemImageList.get(3)).override(500, 500).into(holder.mImage5);
                break;
            case 5:
                holder.mImage1.setVisibility(View.VISIBLE);
                holder.mImage2.setVisibility(View.VISIBLE);
                holder.mImage3.setVisibility(View.VISIBLE);
                holder.mImage4.setVisibility(View.VISIBLE);
                holder.mImage5.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(itemImageList.get(0)).override(500, 500).into(holder.mImage1);
                Glide.with(mContext).load(itemImageList.get(1)).override(500, 500).into(holder.mImage2);
                Glide.with(mContext).load(itemImageList.get(2)).override(500, 500).into(holder.mImage3);
                Glide.with(mContext).load(itemImageList.get(3)).override(500, 500).into(holder.mImage4);
                Glide.with(mContext).load(itemImageList.get(4)).override(500, 500).into(holder.mImage5);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


