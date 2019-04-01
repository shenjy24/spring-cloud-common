package com.jonas.config;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 【功能描述】
 *
 * @author yangjh  29/08/2018.
 */
@Data
@NoArgsConstructor
public class ErrorResponse {

	private String status;

	private String error;

	private String message;

	private String path;


}
