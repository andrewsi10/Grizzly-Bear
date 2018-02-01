package com.grizzlybear;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Andrew on 1/31/2018.
 */

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {

    public class GuideViewHolder extends RecyclerView.ViewHolder {

        TextView startDate, objType, endDate, name, loginRequired, url, icon;

        public GuideViewHolder(View itemView) {
            super(itemView);
            startDate = itemView.findViewById(R.id.startDate);
            objType = itemView.findViewById(R.id.objType);
            endDate = itemView.findViewById(R.id.endDate);
            name = itemView.findViewById(R.id.name);
            loginRequired = itemView.findViewById(R.id.loginRequired);
            url = itemView.findViewById(R.id.url);
            icon = itemView.findViewById(R.id.icon);
        }

        public void bind(Guide guide) {
            startDate.setText(guide.startDate);
            objType.setText(guide.objType);
            endDate.setText(guide.endDate);
            name.setText(guide.name);
            if (guide.loginRequired) {
                loginRequired.setText(R.string.login_required_true);
            } else {
                loginRequired.setText(R.string.login_required_false);
            }
            url.setText(guide.url);
            icon.setText(guide.icon);
        }
    }

    List<Guide> guides;
    Context context;

    public GuideAdapter(List<Guide> guides, Context context) {
        this.guides = guides;
        this.context = context;
    }

    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View guideView = LayoutInflater.from(context).inflate(R.layout.guide_view, parent, false);
        return new GuideViewHolder(guideView);
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, int position) {
        if (position < guides.size()) {
            holder.bind(guides.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return guides.size();
    }
}
