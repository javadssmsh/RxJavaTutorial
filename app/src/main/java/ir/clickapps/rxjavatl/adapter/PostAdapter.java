package ir.clickapps.rxjavatl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.clickapps.rxjavatl.R;
import ir.clickapps.rxjavatl.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHOlder> {

    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHOlder holder, int position) {
        Picasso.get().load(postList.get(position).getLink_img_profile()).into(holder.profilePic);
        Picasso.get().load(postList.get(position).getLink_img_post()).into(holder.postPic);
        holder.name.setText(postList.get(position).getName());
        holder.description.setText(postList.get(position).getDescription());
        holder.comments.setText(postList.get(position).getComments());
        holder.location.setText(postList.get(position).getLocation());
        holder.favorite.setText(postList.get(position).getFavorite());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHOlder extends RecyclerView.ViewHolder {

        TextView name, description, favorite, location, comments;
        ImageView postPic;
        CircleImageView profilePic;

        public PostViewHOlder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_profile);
            description = itemView.findViewById(R.id.tv_description);
            location = itemView.findViewById(R.id.tv_location);
            favorite = itemView.findViewById(R.id.tv_likes);
            comments = itemView.findViewById(R.id.tv_comments);
            postPic = itemView.findViewById(R.id.img_post);
            profilePic = itemView.findViewById(R.id.img_profile);
        }
    }
}
