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
public class SpCourse implements Serializable {
    private String cId;

    private String cName;

    private Boolean delflag;

    private static final long serialVersionUID = 1L;
}