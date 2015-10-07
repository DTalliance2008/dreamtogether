package com.dtaliance.jsonObject.response;

import com.dtaliance.jsonObject.detail.PersistDetail;
import com.dtaliance.jsonObject.global.Response;

public class PersistResponse extends Response{
	private PersistDetail detail;

	public PersistDetail getDetail() {
		return detail;
	}

	public void setDetail(PersistDetail detail) {
		this.detail = detail;
	}

}
