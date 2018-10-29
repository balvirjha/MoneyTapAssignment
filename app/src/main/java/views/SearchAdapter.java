package views;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.moneytap.moneytapassignment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import modal.Page;

/**
 * Created by BalvirJha on 29-10-2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private List<Page> pageList;

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, pageId;
        public ImageView titleImage;

        public SearchViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textTitle);
            description = (TextView) view.findViewById(R.id.textDescription);
            pageId = (TextView) view.findViewById(R.id.textPageId);
            titleImage = (ImageView) view.findViewById(R.id.titleImage);
        }
    }

    public SearchAdapter(List<Page> pageList) {
        this.pageList = pageList;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_result_list_row, parent, false);

        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        Page page = pageList.get(position);
        holder.title.setText(page.getTitle());
        if (page.getTerms() != null && !TextUtils.isEmpty(page.getTerms().getDescription().toString())) {
            holder.description.setText(page.getTerms().getDescription().toString());
        }
        if (!TextUtils.isEmpty(page.getIndex().toString())) {
            holder.pageId.setText(page.getIndex().toString());
        }
        if (page.getThumbnail() != null && page.getThumbnail().getSource() != null && !TextUtils.isEmpty(page.getThumbnail().toString())) {
            String thumbnailUrl = page.getThumbnail().getSource().toString();
            Log.e("bvc", thumbnailUrl);
            Picasso.get().load(thumbnailUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.titleImage);
        }
    }

    @Override
    public int getItemCount() {
        return pageList.size();
    }
}
