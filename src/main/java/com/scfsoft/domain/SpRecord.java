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
public class SpRecord implements Serializable {
    private String categorys;

    private Integer count;

    private static final long serialVersionUID = 1L;
}