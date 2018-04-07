package com.dsmp.android.womenapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vipul on 2/20/2018.
 */

public class Service{

    private String id;
    private String serviceName;
    private String serviceInfo;
    private String serviceState;
    private String serviceMinAge;
    private String serviceCaste;

    public Service(String id, String serviceName,String serviceinfo, String serviceState, String serviceMinAge, String serviceCaste) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceInfo= serviceinfo;
        this.serviceState = serviceState;
        this.serviceMinAge = serviceMinAge;
        this.serviceCaste = serviceCaste;
    }

    public Service() {


    }

    public String getServiceInfo() {
        return serviceInfo;
    }


    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName) {

        this.serviceName = serviceName;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getServiceMinAge() {
        return serviceMinAge;
    }

    public void setServiceMinAge(String serviceMinAge) {
        this.serviceMinAge = serviceMinAge;
    }



    public String getServiceCaste() {
        return serviceCaste;
    }

    public void setServiceCaste(String serviceCaste) {

        this.serviceCaste = serviceCaste;
    }


}

