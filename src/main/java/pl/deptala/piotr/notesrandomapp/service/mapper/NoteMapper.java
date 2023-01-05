package pl.deptala.piotr.notesrandomapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.notesrandomapp.repository.entity.NoteEntity;
import pl.deptala.piotr.notesrandomapp.web.model.NoteModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class NoteMapper {
    private static final Logger LOGGER = Logger.getLogger(NoteMapper.class.getName());

    public NoteEntity from(NoteModel carModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        NoteEntity carEntity = modelMapper.map(carModel, NoteEntity.class);
        LOGGER.info("from(...)" + carEntity);
        return carEntity;
    }

    public NoteModel from(NoteEntity noteEntity) {
        LOGGER.info("from(" + noteEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        NoteModel noteModel = modelMapper.map(noteEntity, NoteModel.class);
        LOGGER.info("from(...) = " + noteModel);
        return noteModel;
    }

    public List<NoteModel> fromEntities(List<NoteEntity> noteEntities) {
        LOGGER.info("fromEntities(" + noteEntities + ")");
        List<NoteModel> noteModels = noteEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromEntities(...) = " + noteModels);
        return noteModels;
    }

    public List<NoteEntity> fromModels(List<NoteModel> noteModels) {
        LOGGER.info("fromModels(" + noteModels + ")");
        List<NoteEntity> noteEntities = noteModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromModels(...) = " + noteEntities);
        return noteEntities;
    }
}
