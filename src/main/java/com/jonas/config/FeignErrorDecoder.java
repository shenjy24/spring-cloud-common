package com.jonas.config;

import com.alibaba.fastjson.JSON;
import com.jonas.constant.BizException;
import com.jonas.constant.SystemCode;
import com.jonas.util.logging.SystemLogger;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

/**
 * 【功能描述】
 *
 * @author yangjh  29/08/2018.
 */
@Configuration
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String s, Response response) {
		try {
			if (response.body() != null) {
				String body = Util.toString(response.body().asReader());
				ErrorResponse errorResponse = JSON.parseObject(body, ErrorResponse.class);
				String message = errorResponse.getMessage();
				if (null != message && message.startsWith("BizException")) {
					String[] msgs = message.split(":");
					return new BizException(msgs[1], msgs[2]);
				} else {
					return new BizException(SystemCode.SERVER_ERROR);
				}
			}

		} catch (Exception exception) {
			SystemLogger.getLogger().error(exception.getMessage());
		}
		return new BizException(SystemCode.PARAM_ERROR);
	}
}
