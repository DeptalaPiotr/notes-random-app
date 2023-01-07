package pl.deptala.piotr.notesrandomapp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import pl.deptala.piotr.notesrandomapp.repository.entity.NoteEntity;

@SpringBootTest
class NoteRepositoryTest {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void create() {

        // Given
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setText("Repository test text");
        noteEntity.setTitle("Repository test title");

        // When
        NoteEntity savedEntity = noteRepository.save(noteEntity);

        // Then
        Assertions.assertNotNull(savedEntity, "Saved Entity ist NULL");
    }

    @Test
    public void createNullEntity() {

        // Given
        NoteEntity noteEntity = null;
        // When

        // Then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> noteRepository.save(noteEntity));
    }
}