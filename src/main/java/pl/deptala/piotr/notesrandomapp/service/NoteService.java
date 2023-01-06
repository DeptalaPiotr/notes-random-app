package pl.deptala.piotr.notesrandomapp.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.notesrandomapp.exception.NoteNotFoundException;
import pl.deptala.piotr.notesrandomapp.repository.NoteRepository;
import pl.deptala.piotr.notesrandomapp.repository.entity.NoteEntity;
import pl.deptala.piotr.notesrandomapp.service.mapper.NoteMapper;
import pl.deptala.piotr.notesrandomapp.web.model.NoteModel;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

@Service
public class NoteService {



        private static final Logger LOGGER = Logger.getLogger(NoteService.class.getName());
        private NoteRepository noteRepository;
        private NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    // C - create
        public NoteModel create(NoteModel carModel) {
            LOGGER.info("create(" + carModel + ")");
            NoteEntity noteEntity = noteMapper.from(carModel);
            NoteEntity savedNoteEntity = noteRepository.save(noteEntity);
            NoteModel mappedNoteModel = noteMapper.from(savedNoteEntity);
            LOGGER.info("create(...) = " + mappedNoteModel);
            return mappedNoteModel;
        }


        // R - read
        public NoteModel read(Long id) throws NoteNotFoundException {
            LOGGER.info("read(" + id + ")");
            Optional<NoteEntity> optionalNoteEntity = noteRepository.findById(id);
            NoteEntity noteEntity = optionalNoteEntity.orElseThrow(
                    () -> new NoteNotFoundException("Nie znaleziono notatki o ID " + id));
            NoteModel noteModel = noteMapper.from(noteEntity);
            LOGGER.info("read(...)" + noteModel);
            return noteModel;
        }

        // U - update
        public NoteModel update(NoteModel note) {
            LOGGER.info("update(" + note + ")");
            NoteEntity updateNote = noteMapper.from(note);
            NoteEntity saveNoteEntity = noteRepository.save(updateNote);
            NoteModel noteModel = noteMapper.from(saveNoteEntity);
            LOGGER.info("update(...)" + noteModel);
            return noteModel;
        }

        // D - delete
        public void delete(Long id) throws NoteNotFoundException {
            LOGGER.info("delete(" + id + ")");
            Optional<NoteEntity> optionalNoteEntity = noteRepository.findById(id);
            NoteEntity noteEntity = optionalNoteEntity.orElseThrow(
                    () -> new NoteNotFoundException("Nie znaleziono samochodu o ID " + id));
            noteRepository.delete(noteEntity);
            LOGGER.info("delete(...)" + noteEntity);
        }
    }
