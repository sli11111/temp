package com.scfsoft.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpClasses implements Serializable {
    private String csId;

    private Integer csDate;

    private Integer csClass;

    private String csAdviser;

    private Boolean delflag;

    private static final long serialVersionUID = 1L;
}