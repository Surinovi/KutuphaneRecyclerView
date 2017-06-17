package com.gyk2017.kutuphanerecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookAdapter.AdapterListener {

    List<Book> bookList = new ArrayList<>();
    BookAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new BookAdapter(bookList,this,this);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        fillMyBookList();

    }


    private void fillMyBookList() {
        bookList.add(new Book("LOTR: Two Towers", "J.R.R. Tolkien","1982",R.drawable.twotowers,"https://www.amazon.co.uk/d/cka/Two-Towers-Lord-Rings-Part-2/0007488335"));
        bookList.add(new Book("Hunger Games", "Suzanne Collins","2010",R.drawable.hungergames,"https://www.amazon.com/Hunger-Games-Book-1/dp/0439023521"));
        bookList.add(new Book("Alchemist", "Paulo Coelho","1993",R.drawable.alchemist,"https://www.amazon.com/Alchemist-Paulo-Coelho/dp/0061122416"));
        bookList.add(new Book("Harry Potter", "J.K. Rowling","2009",R.drawable.harrypotter,"https://www.amazon.com/gp/bookseries/B00CJG28U8"));
        bookList.add(new Book("Foundation", "Isaac Asimov","1991",R.drawable.foundation,"https://www.amazon.com/Foundation-Isaac-Asimov/dp/0553293354"));
        bookList.add(new Book("Stone Council", "J.C. Grange","2002",R.drawable.stonecouncil,"https://www.amazon.com/Stone-Council-Jean-Christophe-Grange-Monk/dp/1860468640"));

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickImage(Book book) {
        Toast.makeText(this, book.getName(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickName(Book book) {

        Intent newIntent=new Intent(MainActivity.this,WebViewActivity.class);
        newIntent.putExtra("url",book.getUrl());
        startActivity(newIntent);

    }
}