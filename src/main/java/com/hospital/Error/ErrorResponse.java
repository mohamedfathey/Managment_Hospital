package com.hospital.Error;

import java.time.LocalDate;
import java.util.List;

public class ErrorResponse {

    private Boolean success;
    private String massage;
    private LocalDate dateTime;
    private List<String>details;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String massage, List<String> details) {
        this.massage = massage;
        this.details = details;
        this.success=Boolean.FALSE;
        this.dateTime=LocalDate.now();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
