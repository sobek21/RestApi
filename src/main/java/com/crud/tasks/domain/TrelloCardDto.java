package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrelloCardDto {

    private String name;
    private String descrition;
    private String pos;
    private String listId;



    }

