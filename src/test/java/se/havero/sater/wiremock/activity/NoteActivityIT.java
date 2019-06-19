/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero.sater.wiremock.activity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.havero.sater.wiremock.model.Note;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import org.springframework.boot.test.context.SpringBootTest;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;

/**
 *
 * @author johan
 */
@SpringBootTest
public class NoteActivityIT {
    
    

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8080).httpsPort(8443));

    public NoteActivityIT() {
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
     * Test of getNote method, of class NoteActivity.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        String id = "";
        NoteActivity instance = new NoteActivity();
        Note expResult = null;
        Note result = instance.getNote(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
