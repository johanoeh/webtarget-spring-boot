
package se.havero.sater.wiremock.controller;

import se.havero.sater.wiremock.model.Note;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import se.havero.sater.wiremock.activity.NoteActivity;
import se.havero.sater.wiremock.model.ErrorDetails;


/**
 *
 * @author johan
 */
@RestController
@Api(tags = "note", description = "Manages notes")
public class Controller {

    @Autowired
    NoteActivity noteActivity;
    
    @ApiOperation(value = "get a note by note id", notes = "get a note by it's id")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Note.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal error", response = ErrorDetails.class)
    })

    //@CrossOrigin(origins = "http://localhost:8089")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/note/{id}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody Note getNote(@ApiParam(value = "id", example = "1000", required = true) @PathVariable("id") Long id) {
        return noteActivity.getNote(String.valueOf(id));
    }
    
    
}
