package com.ishani.isanjaalwebservice.dto;

/**
 * Created by Pujan on 3/12/19.
 *
 * Class used for standardizing response obtained from the web service.
 */
public class Response<T> {
    private T data;
    private int currentNo;
    private int startNo;
    private int endNo;
    private int status;
    private String message;

    /**
     *
     * @param data of type T for generic object
     * @param currentNo current page required for paging
     * @param startNo starting page number for paging
     * @param endNo end page number for paging
     * @param status status of response e.g 200 for OK
     * @param message human understandable message opposed to machine generated
     * @param <T> Generic Type to accommodate objects
     * @return Response<T>
     */

    public static <T> Response<T> ok(T data, int currentNo, int startNo, int endNo, int status, String message) {
        Response<T> response = new Response<T>();
        response.data = data;
        response.currentNo = currentNo;
        response.startNo = startNo;
        response.endNo = endNo;
        response.status = status;
        response.message = message;
        return response;
    }

    public static <T> Response<T> ok (T data, int status, String message){
        Response<T> response = new Response<T>();
        response.status = status;
        response.data = data;
        response.message = message;
        return response;
    }

    /**
     *
     * @param status status in case of fail eg: 404
     * @param message human understandable message
     * @param <T> generic type
     * @return Response<T>
     */

    public static <T> Response<T> fail(int status, String message){
        Response<T> response = new Response<T>();
        response.status = status;
        response.message = message;
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(int currentNo) {
        this.currentNo = currentNo;
    }

    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getEndNo() {
        return endNo;
    }

    public void setEndNo(int endNo) {
        this.endNo = endNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

