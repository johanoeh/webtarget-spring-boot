/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero.sater.wiremock.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import se.havero.sater.wiremock.Application;
import se.havero.sater.wiremock.model.Note;

/**
 *
 * @author johan
 */

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class,Controller.class})
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")*/
public class ControllerIT {
    
    public ControllerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNote method, of class Controller.
     */
    @Test
    public void testGetNote() {

    }
    String test = "{\n" +
"  \"noteId\": 1,\n" +
"  \"name\": \"Linux how to list tcp connections\",\n" +
"  \"format\": \"md\",\n" +
"  \"content\": \"# Linux commands\\n\\nLIst  TCP connections with portnumbers\\n\\n```bash\\n$ sudo lsof -i -n -P | grep TCP | more\\n```\",\n" +
"  \"tags\": [\n" +
"    \"Linux\",\n" +
"    \"port\",\n" +
"    \"connection\"\n" +
"  ]\n" +
"}";
    
}
