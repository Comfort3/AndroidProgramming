package com.balbrilabs.notepad.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.balbrilabs.notepad.entities.NotePad;

import java.util.List;

@Dao
public interface NotePadDao {

    @Query("SELECT * FROM notepad ORDER BY id DESC")
    List<NotePad>getAllNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NotePad notePad);

    @Delete
    void deleteNote(NotePad notePad);


}
