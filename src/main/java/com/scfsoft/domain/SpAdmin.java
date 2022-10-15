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
public class SpAdmin implements Serializable {
    private String adminId;

    private String adminName;

    private String adminPass;

    private String regIp;

    private String regTime;

    private String relTId;

    private static final long serialVersionUID = 1L;
}