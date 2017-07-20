package com.techienerd.questiongame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.activity.ListViewOptionActivity;
import com.techienerd.questiongame.model.MCategory;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/19/2017.
 */
public class ListViewCategoryAdapter extends RecyclerView.Adapter<ListViewCategoryAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MCategory> categoryArrayList;
    private MCategory mCategory;
    View view;


    public ListViewCategoryAdapter(Context context) {
        this.context = context;
        categoryArrayList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setQues(ArrayList<MCategory> allQuestionArrayList) {
        this.categoryArrayList = allQuestionArrayList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.question_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mCategory = categoryArrayList.get(position);
        holder.textView.setText(mCategory.getType());

    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCategory = categoryArrayList.get(getAdapterPosition());
                    Intent intent = new Intent(context, ListViewOptionActivity.class);
                    intent.putExtra("index", getAdapterPosition());
                    intent.putExtra("parentId", mCategory.getId());
                    context.startActivity(intent);

                }
            });
        }
    }
}
