/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero.sater.wiremock.activity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import se.havero.sater.wiremock.model.Note;

/**
 *
 * @author johan
 */
@Component
class NoteClient {

    private WebTarget webTarget;
    @Value("${note.service.url}")
    String noteServiceUrl;
    private static final Logger LOG = LoggerFactory.getLogger(NoteClient.class);

    public Note getNote(String id) {
        LOG.info("Making call to url: {}",noteServiceUrl);
        LOG.info("Got request for note with id {}", id);
      
        Response response = ClientBuilder
                .newClient()
                .target("http://localhost:8080/note/{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON).get();
        
        Note note = null;
        
        if(response.getStatus()== 200){
            note= response.readEntity(Note.class);     
        }
        LOG.info(write(note));
        return note;
    }
    
    public static String write(Object object){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }

}
