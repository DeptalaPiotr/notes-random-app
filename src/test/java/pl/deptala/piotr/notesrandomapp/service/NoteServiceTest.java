package pl.deptala.piotr.notesrandomapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.notesrandomapp.repository.NoteRepository;
import pl.deptala.piotr.notesrandomapp.web.model.NoteModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @Test
    void create() {

        // Given
        NoteModel noteModel = new NoteModel();

        // When
        NoteModel createdNoteModel = noteService.create(noteModel);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdNoteModel, "createdNoteModel is NULL"),
                () -> Assertions.assertNotNull(createdNoteModel.getId(), "createdNoteModel ID is NULL"));
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void list() {
    }

    @Test
    void random() {
    }
}