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
public class SpScoreRecord implements Serializable {
    private Integer srStuid;

    private String srCourseid;

    private String srExamtime;

    private String srGradeid;

    private String srExamtype;

    private Integer srXueqi;

    private Double srScore;

    private static final long serialVersionUID = 1L;
}