package pl.deptala.piotr.notesrandomapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/notes";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") Long id,
            ModelMap modelMap)
            throws NoteNotFoundException {
        LOGGER.info("read()");
        NoteModel readNote = noteService.read(id);
        modelMap.addAttribute("readNote", readNote);
        LOGGER.info("read(...)" + readNote);
        return "read-note";
    }


    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable(name = "id") Long id, ModelMap modelMap) throws NoteNotFoundException {
        LOGGER.info("updateView() ID: " + id);
        NoteModel readNoteModel = noteService.read(id);
        modelMap.addAttribute("readNoteModel", readNoteModel);
        return "update-note";
    }

    @PostMapping(value = "/update")
    public String update(NoteModel noteModel) throws NoteNotFoundException {
        LOGGER.info("update()");
        NoteModel updateModel = noteService.update(noteModel);
        LOGGER.info("update(...)" + updateModel);
        return "redirect:/notes";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws NoteNotFoundException {
        LOGGER.info("delete()" + id);
        noteService.delete(id);
        LOGGER.info("delete(...)" + id);
        return "redirect:/notes";
    }

    // L - list
    @GetMapping
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
