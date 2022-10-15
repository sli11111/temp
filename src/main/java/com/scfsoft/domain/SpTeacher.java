package com.scfsoft.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpTeacher implements Serializable {
    private String tId;

    private String tName;

    private String tPass;

    private String tSex;

    private String tNation;

    private String tPolStat;

    private String tIdcard;

    private String tAddress;

    private Date tJobTime;

    private String tEduBg;

    private String tGraIns;

    private String tPhone;

    private String tCourse;

    private String tPicPath;

    private Boolean delflag;

    private static final long serialVersionUID = 1L;
}