package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.talizorah.finalapp.Command.CommandController;
import com.example.talizorah.finalapp.Command.CreatingCommand;
import com.example.talizorah.finalapp.Command.EditingCommand;
import com.example.talizorah.finalapp.Command.NoteCreateCommand;
import com.example.talizorah.finalapp.Command.NoteDeleteCommand;
import com.example.talizorah.finalapp.Command.NoteOpenCommand;
import com.example.talizorah.finalapp.R;
import com.example.talizorah.finalapp.enums.ListViewAdapters;
import com.example.talizorah.finalapp.factoryMethod.AdapterFactory;
import com.example.talizorah.finalapp.notes.NoteHandler;


/**
 * Created by talizorah on 16.8.4.
 */
public class NoteAdapterController{

    private AdapterFactory factory;
    private NoteHandler handler;
    private Activity activity;
    private ListView listView;
    private Button button;
    private Switch aSwitch;
    private BaseAdapter adapter;
    private CommandController commandController;

    private NoteAdapterController(final Activity activity, ListView listView, Button button, Switch aSwitch){
        this.activity = activity;
        this.listView = listView;
        this.button = button;
        this.aSwitch = aSwitch;
        this.factory = AdapterFactory.createAdapterFactory();
        setListeners();
        createCommands();
    }

    public void setListeners(){
        setOnClickListener();
        setOnCheckChanged();
        setOnItemClickListenerForListView();
    }

    private void createCommands(){
        EditingCommand deleteCommand = new NoteDeleteCommand(activity, handler);
        EditingCommand showCommand = new NoteOpenCommand(activity, handler);
        CreatingCommand createCommand = new NoteCreateCommand(activity);
        commandController = CommandController.createCommandController();
        commandController.setDeleteCommand(deleteCommand);
        commandController.setCreatingCommand(createCommand);
        commandController.setOpenCommand(showCommand);
    }

    public void setAdapter(){
        adapter = getAdapter(ListViewAdapters.SimpleListView);
        this.listView.setAdapter(adapter);
    }
    public static NoteAdapterController createNoteAdapterController
            (Activity activity, ListView listView, Button button, Switch aSwitch){
        return new NoteAdapterController(activity, listView, button, aSwitch);
    }

    private BaseAdapter getAdapter(ListViewAdapters adapter){
        return factory.getAdapter(adapter, activity, handler.getNotes());
    }
    private void setOnCheckChanged(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    aSwitch.setText(R.string.note_list_switch_detail);
                    adapter = getAdapter(ListViewAdapters.DetailListView);
                    listView.setAdapter(adapter);
                } else {
                    aSwitch.setText(R.string.note_list_switch_simple);
                    adapter = getAdapter(ListViewAdapters.SimpleListView);
                    listView.setAdapter(adapter);
                }
            }
        });
    }
    private void setOnItemClickListenerForListView(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
                alertDialog.setTitle(R.string.dialog_title);
                alertDialog.setMessage(R.string.dialog_question);
                alertDialog.setNegativeButton(R.string.dialog_delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        commandController.deleteTheNote(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                alertDialog.setPositiveButton(R.string.dialog_show, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        commandController.openTheNote(position);
                        commandController.openTheNote(position);
                    }
                });
                alertDialog.setNeutralButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });
    }
    private void setOnClickListener(){
        handler = NoteHandler.createNoteHandler(activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commandController.createNote();
            }
        });
    }
    public NoteHandler getNoteHandler(){
        return this.handler;
    }
}
