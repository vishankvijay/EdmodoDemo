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


public class Assignment_CustomDDLListAdapter
        extends BaseListAdapter<Record, Assignment_CustomDDLListAdapter.ImageViewHolder> {

    Context context;

    public Assignment_CustomDDLListAdapter(
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

                String normalText = questionString.toString();
                String colorText = "<font color='#276bb0'>Me</font>";

                holder.from.setText(Html.fromHtml(colorText + " to " + normalText));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (entry.getServerValue("Assignment_Title") != null) {
                holder.assignment_title.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Assignment_Title");
                holder.assignment_title.setText(questionString.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (entry.getServerValue("Describe_the_assignment") != null) {
                holder.assignment_description.setVisibility(View.VISIBLE);
                String questionString = (String) entry.getServerValue("Describe_the_assignment");
                holder.assignment_description.setText(questionString.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* try {
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
        }*/


    }


    private List<String> _labelFields;


    public static class ImageViewHolder extends BaseListAdapter.ViewHolder {


        public TextView assignment_title;
        public TextView assignment_description;
        public ImageView assignment_image;
  /*      public TextView answer_3;
        public TextView answer_4;*/
        public TextView from;


        public ImageViewHolder(View view, BaseListAdapterListener listener) {
            super(view, listener);


            this.textView = (TextView) view.findViewById(R.id.title);
            this.assignment_title = (TextView) view.findViewById(R.id.assignment_title);
            this.assignment_description = (TextView) view.findViewById(R.id.assignment_description);
            this.assignment_image = (ImageView) view.findViewById(R.id.assignment_image);
            /*this.answer_3 = (TextView) view.findViewById(R.id.poll_answer3);
            this.answer_4 = (TextView) view.findViewById(R.id.poll_answer4);*/
            this.from = (TextView) view.findViewById(R.id.assignment_from_textview);

        }


    }


}