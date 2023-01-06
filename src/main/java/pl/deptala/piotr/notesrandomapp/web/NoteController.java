package pl.deptala.piotr.notesrandomapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.notesrandomapp.api.exception.NoteNotFoundException;
import pl.deptala.piotr.notesrandomapp.service.NoteService;
import pl.deptala.piotr.notesrandomapp.web.model.NoteModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/notes")
public class NoteController {
    private static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        return "create-note";
    }

    @PostMapping
    public String create(NoteModel noteModel) {
        LOGGER.info("create(" + noteModel + ")");
        NoteModel createdModel = noteService.create(noteModel);
        LOGGER.info("create(...)" + createdModel);
        return "note-list";
    }

    // R - read
    public void read(Long id) throws NoteNotFoundException {
        LOGGER.info("read()");
        NoteModel read = noteService.read(id);
        LOGGER.info("read(...)" + read);
    }

    // U - update
    public void update(NoteModel noteModel) {
        LOGGER.info("update()");
        NoteModel updateModel = noteService.update(noteModel);
        LOGGER.info("update(...)" + updateModel);
    }

    // D - delete
    public void delete(Long id) throws NoteNotFoundException {
        LOGGER.info("delete()" + id);
        noteService.delete(id);
        LOGGER.info("delete(...)" + id);
    }

    // L - list
    @GetMapping(value = "/list")
//    public String listView() {
//        LOGGER.info("listView()");
//        return "note-list";
//    }
//
//    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        List<NoteModel> noteModels = noteService.list();
        modelMap.addAttribute("notes", noteModels);
        LOGGER.info("list(...)" + noteModels);
        return "note-list";
    }

    // Random
    @GetMapping(value = "/random")
    public String random(ModelMap modelMap) {
        LOGGER.info("random()");
        List<NoteModel> randomList = noteService.list();
        NoteModel randomModel = noteService.random(randomList);
        modelMap.addAttribute("randomModel", randomModel);
        LOGGER.info("random(...)" + randomModel);
        return "random";
    }
}
