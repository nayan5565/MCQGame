package com.techienerd.questiongame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.activity.CheckBoxOptionActivity;
import com.techienerd.questiongame.model.MCategory;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/12/2017.
 */
public class CheckBoxCategoryAdapter extends RecyclerView.Adapter<CheckBoxCategoryAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MCategory> allQuestionArrayList;
    private MCategory mAllQuestion;
    View view;


    public CheckBoxCategoryAdapter(Context context) {
        this.context = context;
        allQuestionArrayList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setQues(ArrayList<MCategory> allQuestionArrayList) {
        this.allQuestionArrayList = allQuestionArrayList;
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
        mAllQuestion = allQuestionArrayList.get(position);
        holder.textView.setText(mAllQuestion.getType());

    }

    @Override
    public int getItemCount() {
        return allQuestionArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAllQuestion = allQuestionArrayList.get(getAdapterPosition());
                    Intent intent = new Intent(context, CheckBoxOptionActivity.class);
                    intent.putExtra("index", getAdapterPosition());
                    intent.putExtra("parentId", mAllQuestion.getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
