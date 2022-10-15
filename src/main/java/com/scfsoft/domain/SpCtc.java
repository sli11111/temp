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
public class SpCtc implements Serializable {
    private String ctcClassid;

    private String ctcTeacherid;

    private String ctcCourseid;

    private Integer ctcXueqi;

    private static final long serialVersionUID = 1L;
}