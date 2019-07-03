/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero.sater.wiremock.activity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.havero.sater.wiremock.model.Note;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import org.springframework.boot.test.context.SpringBootTest;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.matching.UrlPattern;
import junit.framework.Assert;
import org.json.JSONException;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author johan
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Import({NoteActivity.class, NoteClient.class})
@ActiveProfiles("it")
public class NoteActivityIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteActivity.class);

    @Value("${random.wiremock.port}")
    private Integer wireMockPort;
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private NoteActivity noteActivity;

    @Rule
    public WireMockRule wireMockRule;

    @Before
    public void setUp() {

        Assert.assertNotNull(wireMockPort);
        Assert.assertNotNull(noteActivity);

        wireMockRule = new WireMockRule(wireMockConfig()
                .port(wireMockPort)
                .notifier(new ConsoleNotifier(true)));
        
         Assert.assertNotNull(wireMockRule);

        wireMockRule.stubFor(any(UrlPattern.ANY).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody(createResponse())));

        if (!wireMockRule.isRunning()) {
            wireMockRule.start();
        }

        Assert.assertTrue(wireMockRule.isRunning());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNote method, of class NoteActivity.
     */
    @Test
    public void testGetNote() throws JsonProcessingException, JSONException {
        
        Note note = noteActivity.getNote("1");
        String response = createResponse();
        JSONAssert.assertEquals(
                response, 
                objectMapper.writeValueAsString(note), 
                JSONCompareMode.STRICT);

    }

    private String createResponse() {
        return "{\n"
                + "  \"noteId\": 1,\n"
                + "  \"name\": \"Linux how to list tcp connections\",\n"
                + "  \"format\": \"md\",\n"
                + "  \"content\": \"# Linux commands\\n\\nLIst  TCP connections with portnumbers\\n\\n```bash\\n$ sudo lsof -i -n -P | grep TCP | more\\n```\",\n"
                + "  \"tags\": [\n"
                + "    \"Linux\",\n"
                + "    \"port\",\n"
                + "    \"connection\"\n"
                + "  ]\n"
                + "}";
    }

}
