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
import com.techienerd.questiongame.model.MAllQuestion;
import com.techienerd.questiongame.model.MOption;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/19/2017.
 */
public class ListViewCategoryAdapter extends RecyclerView.Adapter<ListViewCategoryAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MOption> mItems;
    private ArrayList<MAllQuestion> allQuestionArrayList;
    private MAllQuestion mAllQuestion;
    private MOption mItem;
    public static int wa, ca;
    View view;


    public ListViewCategoryAdapter(Context context) {
        this.context = context;
//        mItems = new ArrayList<>();
        allQuestionArrayList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MOption> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    public void setQues(ArrayList<MAllQuestion> allQuestionArrayList) {
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
//        mItem = mItems.get(position);
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
                    Intent intent = new Intent(context, ListViewOptionActivity.class);
                    intent.putExtra("index", getAdapterPosition());
                    intent.putExtra("parentId", mAllQuestion.getId());
                    context.startActivity(intent);

                }
            });
        }
    }
}
