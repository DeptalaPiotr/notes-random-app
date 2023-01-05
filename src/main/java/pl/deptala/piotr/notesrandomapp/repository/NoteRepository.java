package pl.deptala.piotr.notesrandomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deptala.piotr.notesrandomapp.repository.entity.NoteEntity;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity,Long> {
}
