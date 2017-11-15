package com.hornet.nepalidateconverter;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2/2/2017.
 */

public class NotesAdapter extends ArrayAdapter {
    List list1= new ArrayList();
    public NotesAdapter(Context context, int resource) {
        super(context, resource);
    }
    public void add(notesgetter object) {
        super.add(object);
        list1.add(object);
    }


    public int getCount() {
        return list1.size();
    }


    @Override
    public Object getItem(int position) {
        return list1.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        View row;
//        row=convertView;
        Book bookshow;
        if(convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.adapterview_layout,parent,false);
            bookshow =new Book();
            bookshow.date=(TextView)convertView.findViewById(R.id.textView);
            //bookshow.bookpdf=(TextView)convertView.findViewById(R.id.pdf1);
            bookshow.Place=(TextView)convertView.findViewById(R.id.textView3);
            bookshow.Person=(TextView)convertView.findViewById(R.id.textView2);
            bookshow.Task=(TextView)convertView.findViewById(R.id.textView4);

            //subjectshow.credit=(TextView)row.findViewById(R.id.credit);
            //subjectshow.syllabus=(TextView)row.findViewById(R.id.syllabus);

            convertView.setTag(bookshow);


        }
        else{
            bookshow=(Book)convertView.getTag();
        }
        final notesgetter notes=(notesgetter) this.getItem(position);
//        System.out.println(bookdisplay.getPdf());
//        System.out.println("<<here<<<<<<<<<<<<<<<<,");
//        System.out.println(bookdisplay.getBookName());
//        String name=bookdisplay.getBookName();

       // bookshow..setText(name);
        bookshow.date.setText(notes.getDate());
        bookshow.Person.setText(notes.getPerson());
        bookshow.Place.setText(notes.getPlace());
        bookshow.Task.setText(notes.getTask());





        return convertView;
    }

    static class Book{

        TextView date;
        TextView Person;
        TextView Place;
        TextView Task;



    }

}
