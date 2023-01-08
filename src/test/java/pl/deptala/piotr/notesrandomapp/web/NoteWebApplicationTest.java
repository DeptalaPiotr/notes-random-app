package pl.deptala.piotr.notesrandomapp.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.deptala.piotr.notesrandomapp.web.model.NoteModel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class NoteWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void note() throws Exception {
        // Given
        String endPoint = "/notes";

        // When
        ResultActions resultActions = mockMvc.perform(get(endPoint));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        // Given
        String endPoint = "/notes/create";

        NoteModel noteModel = new NoteModel();
        noteModel.setTitle("WebApplicationTest");
        noteModel.setText("Tested set Text");


        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("title", noteModel.getTitle());
        params.add("text", noteModel.getText());

        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post(endPoint)
                .params(params)
                .accept(MediaType.APPLICATION_JSON));

        // Then
        resultActions
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void read() throws Exception {

        // Given
        String readUrl = "/notes/{id}";

        // When
        ResultActions resultActions = mockMvc.perform(get(readUrl,1));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        // Given
        String updateUrl = "/notes/update/{id}";

        // When
        ResultActions resultActions = mockMvc.perform(get(updateUrl, 1));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        // Given
        String deleteUrl = "/notes/delete/{id}";

        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get(deleteUrl, "1")
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void list() throws Exception {

        // Given
        String listUrl = "/notes/list";

        // When
        ResultActions resultActions = mockMvc.perform(get(listUrl)
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void random() throws Exception {

        // Given
        String randomUrl = "/notes/list";

        // When
        ResultActions resultActions = mockMvc.perform(get(get(randomUrl)
                .contentType(MediaType.APPLICATION_JSON).toString()));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }
}