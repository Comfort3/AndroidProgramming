package com.balbrilabs.notepad.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.balbrilabs.notepad.dao.NotePadDao;
import com.balbrilabs.notepad.entities.NotePad;

@Database(entities = NotePad.class, version = 1, exportSchema = false)
public abstract class NotepadDatabase extends RoomDatabase {

    private static NotepadDatabase notepadDatabase;
    public static synchronized NotepadDatabase getDatabase(Context context){
        if (notepadDatabase == null){
            notepadDatabase = Room.databaseBuilder(
                    context,
                    NotepadDatabase.class,
                    "notepad_db"
            ).build();
        }
        
        return notepadDatabase;
    }

    public abstract NotePadDao notePadDao();
}
