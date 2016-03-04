package com.example.edmododemo;


import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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


public class CustomDDLListAdapter
        extends BaseListAdapter<Record, CustomDDLListAdapter.ImageViewHolder> {

    Context context;

    public CustomDDLListAdapter(
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


        for (int i = 1; i < _labelFields.size(); ++i) {
            String field = _labelFields.get(i);
            Object value = entry.getServerValue(field);
            if (value != null) {
                builder.append(value.toString());
                builder.append(" ");
            }
        }


        try {
            if (entry.getServerValue("Documents___") != null) {
                holder.ddlListImage.setVisibility(View.VISIBLE);

                //Documents_and_Media3286


                JSONObject imagePath = new JSONObject((String) entry.getServerValue("Documents___"));


                String uri = LiferayServerContext.getServer() + "/documents/" + LiferayServerContext.getGroupId() + "/" + imagePath.getString("uuid");


                RequestCreator requestCreator = Picasso.with(LiferayScreensContext.getContext())
                        .load(uri);
                requestCreator.into(holder.ddlListImage);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            if (entry.getServerValue("Send_to___") != null)
            {

               // String normalText = " to Vishank Vijay's Higher Education...";
                String colorText = "<font color='#276bb0'>Me</font>";

               // holder.answer_1.setVisibility(View.VISIBLE);
                String normalText = (String) entry.getServerValue("Send_to___");
                //holder.answer_1.setText(questionString.toString());

                holder.fromTextView.setText(Html.fromHtml(colorText + " to " +  normalText));


            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }


        try {
            if (entry.getServerValue("Type_your_note_here___") != null)
            {
                holder.textView.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Type_your_note_here___");
                holder.textView.setText(questionString.toString());

            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }


        //holder.textView.setText(titleField);
        //holder.subtitleTextView.setText(builder.toString());
       /* holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        /*holder.*/
    }


    private List<String> _labelFields;


    public static class ImageViewHolder extends BaseListAdapter.ViewHolder {


        public TextView subtitleTextView;
        public TextView fromTextView;


        public ImageViewHolder(View view, BaseListAdapterListener listener) {
            super(view, listener);


            this.textView = (TextView) view.findViewById(R.id.main_text);
            this.subtitleTextView = (TextView) view.findViewById(R.id.subtitle);
            this.ddlListImage = (ImageView) view.findViewById(R.id.ddl_list_image);
            this.fromTextView = (TextView) view.findViewById(R.id.from_textview);
           /* String normalText = " to Vishank Vijay's Higher Education...";
            String colorText = "<font color='#276bb0'>Me</font>";

            this.fromTextView.setText(Html.fromHtml(colorText + normalText));*/
            //this.root = (LinearLayout) view.findViewById(R.id.root);
          /*  //root.setOnClickList;
            listener = new BaseListAdapterListener() {
                @Override
                public void onPageNotFound(int row) {

                }

                @Override
                public void onItemClick(int position, View view) {

                }
            };


            this.ddlListImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("subha", "Working");

                }
                            });*/

        }


        private ImageView ddlListImage;
        private LinearLayout root;

    }


}