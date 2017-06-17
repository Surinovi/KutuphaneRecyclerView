package com.gyk2017.kutuphanerecyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by neval on 18/06/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {
    private List<Book> bookList;
    private AdapterListener listener;
    private Context context;

    public BookAdapter(List<Book> bookList, AdapterListener listener, Context context) {
        this.bookList = bookList;
        this.listener = listener;
        this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, author,publishYear;
        public ImageView coverImage;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTv);
            author = (TextView) view.findViewById(R.id.authorTv);
            publishYear = (TextView) view.findViewById(R.id.yearTv);
            coverImage = (ImageView) view.findViewById(R.id.coverImg);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
       final Book book = bookList.get(position);
        holder.name.setText(book.getName());
        holder.author.setText(book.getAuthor());
        holder.publishYear.setText(book.getPublishYear());
        holder.coverImage.setImageResource(book.getCoverImage());

        holder.coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickImage(book);
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickName(book);
            }
        });

        holder.coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setMessage("Kitabı okudun mu?");
                builder.setCancelable(true);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.name.setTextColor(Color.RED);
                    }
                });

                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.name.setTextColor(Color.BLACK);
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public interface AdapterListener {
        public void onClickImage(Book book);

        public void onClickName(Book book);
    }
}

