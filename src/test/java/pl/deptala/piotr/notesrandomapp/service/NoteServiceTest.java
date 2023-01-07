package pl.deptala.piotr.notesrandomapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.notesrandomapp.api.exception.NoteNotFoundException;
import pl.deptala.piotr.notesrandomapp.repository.NoteRepository;
import pl.deptala.piotr.notesrandomapp.web.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

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
    void read() throws NoteNotFoundException {

        // Given
        NoteModel noteModel = new NoteModel();

        // When
        NoteModel readNoteModel = noteService.read(noteModel.getId());

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readNoteModel, "readNoteModel is NULL"),
                () -> Assertions.assertNotNull(readNoteModel.getId(), "readNoteModel ID is NULL"));
    }

    @Test
    void update() {

        // Given
        NoteModel noteModel = new NoteModel();
        noteModel.setTitle("Update Test");
        noteModel.setText("Updated note text");

        // When
        NoteModel updateNoteModel = noteService.update(noteModel);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updateNoteModel, "updateNoteModel is NULL"),
                () -> Assertions.assertNotNull(updateNoteModel.getId(), "updateNoteModel ID is NULL"));
    }

    @Test
    void delete() throws NoteNotFoundException {

        // Given
        NoteModel noteModel = new NoteModel();

        // When
        noteService.delete(noteModel.getId());
        // Then
    }

    @Test
    void list() {

        // Given
        NoteModel noteModel1 = new NoteModel();
        NoteModel noteModel2 = new NoteModel();
        NoteModel noteModel3 = new NoteModel();
        List<NoteModel> noteModelsList = new ArrayList<>();
        noteModelsList.add(noteModel1);
        noteModelsList.add(noteModel2);
        noteModelsList.add(noteModel3);

        // When
        List<NoteModel> testedList = noteService.list();

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(testedList, "list is NULL"));
    }

    @Test
    void random() {

        // Given
        NoteModel noteModel1 = new NoteModel();
        NoteModel noteModel2 = new NoteModel();
        NoteModel noteModel3 = new NoteModel();
        List<NoteModel> noteModelsList = new ArrayList<>();
        noteModelsList.add(noteModel1);
        noteModelsList.add(noteModel2);
        noteModelsList.add(noteModel3);

        // When
        NoteModel randomModel = noteService.random(noteModelsList);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(randomModel, "random Model is NULL"));
    }
}