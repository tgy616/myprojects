package com.tgy.clouddisk.service;

import com.tgy.clouddisk.entity.Note;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public interface NoteService {
    int insertNote(Note note);

    int deleteNote(Integer id);

    int updateNote(Note note);

    Note getNote(Integer id);

    List<Note> listNote(Integer userId);
}
