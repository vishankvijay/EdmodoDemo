package com.example.edmododemo;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liferay.mobile.screens.base.list.BaseListAdapter;
import com.liferay.mobile.screens.base.list.BaseListAdapterListener;
import com.liferay.mobile.screens.context.LiferayScreensContext;
import com.liferay.mobile.screens.context.LiferayServerContext;
import com.liferay.mobile.screens.ddl.model.Record;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by 1305166 on 15-01-2016.
 */


public class Poll_CustomDDLListAdapter
        extends BaseListAdapter<Record, Poll_CustomDDLListAdapter.ImageViewHolder> {

    Context context;

    public Poll_CustomDDLListAdapter(
            int layoutId, int progressLayoutId, BaseListAdapterListener listener) {


        super(layoutId, progressLayoutId, listener);
    }


    public void setLabelFields(List<String> labelFields) {
        _labelFields = labelFields;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        context = parent.getContext();
        View view;


        if (viewType == LAYOUT_TYPE_DEFAULT) {
            view = inflater.inflate(getLayoutId(), parent, false);
        } else {
            view = inflater.inflate(getProgressLayoutId(), parent, false);
        }


        return new ImageViewHolder(view, getListener());
    }


    @Override
    protected void fillHolder(Record entry, ImageViewHolder holder) {
        StringBuilder builder = new StringBuilder();


        // String titleField = (String) entry.getServerValue(_labelFields.get(0));


       /* for (int i = 1; i < _labelFields.size(); ++i) {
            String field = _labelFields.get(i);
            Object value = entry.getServerValue(field);
            if (value != null) {
                builder.append(value.toString());
                builder.append(" ");
            }
        }*/

        try {
            if (entry.getServerValue("Send_to___") != null) {
                holder.from.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Send_to___");

                String normalText = questionString;
                String colorText = "<font color='#276bb0'>Me</font>";

                holder.from.setText(Html.fromHtml(colorText +" to "+ normalText));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (entry.getServerValue("Type_your_question_here___") != null) {
                holder.question.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Type_your_question_here___");
                holder.question.setText(questionString.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (entry.getServerValue("Answer__1") != null) {
                holder.answer_1.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Answer__1");
                holder.answer_1.setText(questionString.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (entry.getServerValue("Answer__2") != null) {
                holder.answer_2.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Answer__2");
                holder.answer_2.setText(questionString.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (entry.getServerValue("Answer__3") != null) {
                holder.answer_3.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Answer__3");
                holder.answer_3.setText(questionString.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (entry.getServerValue("Answer__4") != null) {
                holder.answer_4.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Answer__4");
                holder.answer_4.setText(questionString.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private List<String> _labelFields;


    public static class ImageViewHolder extends BaseListAdapter.ViewHolder {


        public TextView question;
        public TextView answer_1;
        public TextView answer_2;
        public TextView answer_3;
        public TextView answer_4;
        public TextView from;


        public ImageViewHolder(View view, BaseListAdapterListener listener) {
            super(view, listener);


            this.textView = (TextView) view.findViewById(R.id.title);
            this.question = (TextView) view.findViewById(R.id.poll_question);
            this.answer_1 = (TextView) view.findViewById(R.id.poll_answer1);
            this.answer_2 = (TextView) view.findViewById(R.id.poll_answer2);
            this.answer_3 = (TextView) view.findViewById(R.id.poll_answer3);
            this.answer_4 = (TextView) view.findViewById(R.id.poll_answer4);
            this.from = (TextView) view.findViewById(R.id.poll_from_textview);

        }


    }


}