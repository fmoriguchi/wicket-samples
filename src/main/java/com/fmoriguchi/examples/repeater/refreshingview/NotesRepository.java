/**
 * 
 */
package com.fmoriguchi.examples.repeater.refreshingview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



/**
 * @author fabio 
 *
 */
public final class NotesRepository {
	
	private final static NotesRepository INSTANCE = new NotesRepository();
	
	private final Map<String, Note> notes = new HashMap<String, Note>();
	
	/**
	 * 
	 */
	private NotesRepository() {
		
		loadInitialNotes();
	}
	
	/**
	 * 
	 * @return
	 */
	public static NotesRepository get() {
		
		return INSTANCE;
	}
	
	/**
	 * 
	 * @param note
	 */
	public void addNote(Note note) {
	
		note.setId(UUID.randomUUID().toString());
		
		notes.put(note.getId(), note);
	}
	
	/**
	 * 
	 * @param note
	 */
	public void removeNote(Note note) {
		
		notes.remove(note.getId());
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<Note> allNotes() {
		
		return new ArrayList<Note>(notes.values());
	}

	/**
	 * 
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	public Collection<Note> allNotes(Integer pageStart, Integer pageSize) {
		
		try {
			
			List<Note> values = new ArrayList<Note>(notes.values());
			
			return values.subList(pageStart, pageSize);
		}
		catch(Exception e) {

			return Collections.emptyList();
		}
	}
	
	/**
	 * 
	 */
	private void loadInitialNotes() {
		
		for (int i = 0; i < 100; i++) {
			
			Note note = new Note(UUID.randomUUID().toString(), String.valueOf(i));
			
			addNote(note);
		}
	}
}
