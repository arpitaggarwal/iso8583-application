package com.test.domain;

public class Message {
	
	private Integer fieldIndex;
	private String fieldValue;
	private String fieldIsoType;
	private Integer fieldLength;

	public Integer getFieldIndex() {
		return fieldIndex;
	}

	public void setFieldIndex(final Integer fieldIndex) {
		this.fieldIndex = fieldIndex;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(final String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getFieldIsoType() {
		return fieldIsoType;
	}

	public void setFieldIsoType(final String fieldIsoType) {
		this.fieldIsoType = fieldIsoType;
	}

	public Integer getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(final Integer fieldLength) {
		this.fieldLength = fieldLength;
	}

	@Override
	public String toString() {
		return "Message [fieldIndex=" + fieldIndex + ", fieldValue="
				+ fieldValue + ", fieldIsoType=" + fieldIsoType
				+ ", fieldLength=" + fieldLength + "]";
	}

}
