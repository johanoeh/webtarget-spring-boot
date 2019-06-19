/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero.sater.wiremock.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author johan
 */
@Data
@ApiModel
public class Note {

    private static final String CONTENT_EXAMPLE
            = "# Linux commands\n"
            + "\n"
            + "LIst  TCP connections with portnumbers\n"
            + "\n"
            + "```bash\n"
            + "$ sudo lsof -i -n -P | grep TCP | more\n"
            + "```";

    @ApiModelProperty(example = "2399")
    private Long noteId;
    @ApiModelProperty(example = "Linux how to list tcp connections")
    private String name;
    @ApiModelProperty(example = "md")
    private String format;
    @ApiModelProperty(example = CONTENT_EXAMPLE)
    private String content;
    @ApiModelProperty(example = "[\"Linux\", \"port\", \"connection\"]")
    private List<String> tags;

    public Note() {
    }
    

    public Note(String name, String format, String content, List<String> tags) {
        this.name = name;
        this.format = format;
        this.content = content;
        this.tags = tags;
    }

    public List<String> getTags() {
        if (tags == null) {
            tags = new ArrayList<>();
        }
        return tags;
    }

}
