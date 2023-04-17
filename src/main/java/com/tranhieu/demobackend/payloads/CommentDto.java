package com.tranhieu.demobackend.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class CommentDto {
    private Integer id;
    private String content;
}
