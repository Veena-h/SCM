package com.scm.scmproject.helpers;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message
{
    private String content;
    @Builder.Default
    private MessageType type =MessageType.blue;
}
