package pl.deptala.piotr.notesrandomapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.notesrandomapp.repository.entity.NoteEntity;
import pl.deptala.piotr.notesrandomapp.web.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NoteMapperTest {

    @Autowired
    private NoteMapper noteMapper;

    @Test
    void fromNoteModel() {

        // Given
        NoteModel noteModel= new NoteModel();
        noteModel.setTitle("Mapped NoteModel");
        noteModel.setText("To NoteEntity");

        // When
        NoteEntity mappedEntity = noteMapper.from(noteModel);

        // Then
        Assertions.assertNotNull(mappedEntity, "mappedEntity is NULL");
    }

    @Test
    void testFromNoteEntity() {

        // Given
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setTitle("Mapped NoteEntity");
        noteEntity.setText("To NoteModel");

        // When
        NoteModel mappedModel = noteMapper.from(noteEntity);

        // Then
        Assertions.assertNotNull(mappedModel, "mappedModel is NULL");
    }

    @Test
    void fromNoteModelList() {

        // Given
        List<NoteModel> notesModels = new ArrayList<>();

        // When
        List<NoteEntity> mappedNoteEntities = noteMapper.fromModels(notesModels);

        // Then
        Assertions.assertNotNull(mappedNoteEntities, "converted List is NULL");
    }

    @Test
    void fromNoteEntityList() {

        // Given
        List<NoteEntity> noteEntities = new ArrayList<>();

        // When
        List<NoteModel> mappedNoteModels = noteMapper.fromEntities(noteEntities);

        // Then
        Assertions.assertNotNull(mappedNoteModels, "converted List is NULL");
    }
}