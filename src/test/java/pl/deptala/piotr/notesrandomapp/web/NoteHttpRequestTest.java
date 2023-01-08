package pl.deptala.piotr.notesrandomapp.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoteHttpRequestTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void given_when_then() {
        // Given
        String url = "http://localhost:" + port + "/notes/list";
        String listNotesHtmlFragment = "List Notes";

        // When
        String forObject = testRestTemplate.getForObject(url, String.class);

        // Then
        Assertions
                .assertThat(forObject)
                .contains(listNotesHtmlFragment);
    }

    @Test
    void create(){

        // Given
        String url = "http://localhost:" + port + "/notes/create";
        String createdNoteHtmlFragment = "Create Note";

        // When
        String forObject = testRestTemplate.getForObject(url, String.class);

        // Then
        Assertions
                .assertThat(forObject)
                .contains(createdNoteHtmlFragment);
    }
}
