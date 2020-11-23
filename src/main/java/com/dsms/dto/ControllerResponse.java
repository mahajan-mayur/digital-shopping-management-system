package com.dsms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Mahaj
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ControllerResponse {

    private String message;

    private StatusCode statusCode;

    public static enum StatusCode {
        SUCCESS, ERROR, PASSWORD_MISMATCH, USER_NOT_FOUND

    }

}
