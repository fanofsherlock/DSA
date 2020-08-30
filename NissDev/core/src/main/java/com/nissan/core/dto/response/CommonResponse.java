package com.nissan.core.dto.response;

import com.nissan.core.dto.Status;

public class CommonResponse<T> {

	private T data;

	private Status status;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
