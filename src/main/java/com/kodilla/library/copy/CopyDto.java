package com.kodilla.library.copy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CopyDto {

    private Long id;
    private String status;

    private Long bookId;
}
